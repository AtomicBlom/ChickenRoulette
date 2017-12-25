package com.github.atomicblom.chickenroulette.events;

import com.github.atomicblom.chickenroulette.ItemLibrary;
import com.github.atomicblom.chickenroulette.Reference;
import com.github.atomicblom.chickenroulette.RenderDangerChicken;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class RenderingEvents
{
	@SubscribeEvent
	public static void onEntityRenderingOverridesReady(RegisterChickenRendererEvent event) {
		final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		renderManager.entityRenderMap.remove(EntityChicken.class);
		renderManager.entityRenderMap.put(EntityChicken.class, new RenderDangerChicken(renderManager));
	}

	@SubscribeEvent
	public static void onRenderingReady(ModelRegistryEvent evt) {
		final int DEFAULT_ITEM_SUBTYPE = 0;

		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.wonder_chicken_cooked,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.wonderChickenCooked, "inventory")
		);
		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.wonder_chicken_raw,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.wonderChickenRaw, "inventory")
		);

		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.super_chicken_cooked,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.superChickenCooked, "inventory")
		);
		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.super_chicken_raw,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.superChickenRaw, "inventory")
		);

		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.incredible_chicken_cooked,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.incredibleChickenCooked, "inventory")
		);
		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.incredible_chicken_raw,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.incredibleChickenRaw, "inventory")
		);

		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.amazeballs_chicken_cooked,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.amazeballsChickenCooked, "inventory")
		);
		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.amazeballs_chicken_raw,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.amazeballsChickenRaw, "inventory")
		);

		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.unbelievable_chicken_raw,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.unbelievableChickenRaw, "inventory")
		);
		ModelLoader.setCustomModelResourceLocation(
				ItemLibrary.unbelievable_chicken_cooked,
				DEFAULT_ITEM_SUBTYPE,
				new ModelResourceLocation(Reference.Items.unbelievableChickenCooked, "inventory")
		);
	}
}
