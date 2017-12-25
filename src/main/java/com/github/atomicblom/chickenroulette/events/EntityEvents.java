package com.github.atomicblom.chickenroulette.events;

import com.github.atomicblom.chickenroulette.ItemLibrary;
import com.github.atomicblom.chickenroulette.Reference;
import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.List;

@Mod.EventBusSubscriber
public class EntityEvents
{
	@SubscribeEvent
	public static void onEntityDeath(LivingDropsEvent event) {
		final Entity entity = event.getEntity();
		if (entity instanceof EntityChicken) {
			final IExplodingChickenCapability capability = entity.getCapability(Reference.EXPLODING_CHICKEN, null);
			if (capability != null && capability.getItemsConsumed() > 0) {

				final List<EntityItem> drops = event.getDrops();

				for (EntityItem entityItem : drops) {
					final ItemStack itemStack = entityItem.getItem();
					final Item item = itemStack.getItem();
					if (item == Items.CHICKEN) {
						final ItemStack replacedChickenStack = new ItemStack(
								getChickenItem(capability.getItemsConsumed(), false),
								itemStack.getCount()
						);
						entityItem.setItem(
								replacedChickenStack
						);
					} else if (item == Items.COOKED_CHICKEN) {
						final ItemStack replacedChickenStack = new ItemStack(
								getChickenItem(capability.getItemsConsumed(), true),
								itemStack.getCount()
						);
						entityItem.setItem(replacedChickenStack);
					}
				}
			}
		}
	}

	private static Item getChickenItem(int itemsConsumed, boolean dropCooked)
	{
		if (itemsConsumed > 5) itemsConsumed = 5;

		switch (itemsConsumed) {
			case 5:
				return dropCooked ? ItemLibrary.unbelievable_chicken_cooked : ItemLibrary.unbelievable_chicken_raw;
			case 4:
				return dropCooked ? ItemLibrary.amazeballs_chicken_cooked : ItemLibrary.amazeballs_chicken_raw;
			case 3:
				return dropCooked ? ItemLibrary.incredible_chicken_cooked : ItemLibrary.incredible_chicken_raw;
			case 2:
				return dropCooked ? ItemLibrary.super_chicken_cooked : ItemLibrary.super_chicken_raw;
			case 1:
			default:
				return dropCooked ? ItemLibrary.wonder_chicken_cooked : ItemLibrary.wonder_chicken_raw;
		}
	}
}
