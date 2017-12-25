package com.github.atomicblom.chickenroulette.events;

import com.github.atomicblom.chickenroulette.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber
public class RegisterItems
{

	@SuppressWarnings("NestedAssignment")
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		Item cooked;
		Item raw;

		///// Wonder
		registry.register(
				raw = new ItemFood(3, 0.4F, true)
						.setPotionEffect(
								new PotionEffect(
										MobEffects.HUNGER,
										800,
										0),
								0.4F
						)
						.setRegistryName(Reference.Items.wonderChickenRaw)
						.setUnlocalizedName(Reference.Items.wonderChickenRaw.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		registry.register(
				cooked = new ItemFood(7, 0.7F, true)
						.setRegistryName(Reference.Items.wonderChickenCooked)
						.setUnlocalizedName(Reference.Items.wonderChickenCooked.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		FurnaceRecipes.instance().addSmelting(raw, new ItemStack(cooked), 0.35F);

		///// Super
		registry.register(
				raw = new ItemFood(4, 0.5F, true)
						.setPotionEffect(
								new PotionEffect(
										MobEffects.HUNGER,
										900,
										0),
								0.5F
						)
						.setRegistryName(Reference.Items.superChickenRaw)
						.setUnlocalizedName(Reference.Items.superChickenRaw.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		registry.register(
				cooked = new ItemFood(8, 0.8F, true)
						.setRegistryName(Reference.Items.superChickenCooked)
						.setUnlocalizedName(Reference.Items.superChickenCooked.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);
		FurnaceRecipes.instance().addSmelting(raw, new ItemStack(cooked), 0.35F);

		///// Incredible
		registry.register(
				raw = new ItemFood(5, 0.6F, true)
						.setPotionEffect(
								new PotionEffect(
										MobEffects.HUNGER,
										1000,
										0),
								0.6F
						)
						.setRegistryName(Reference.Items.incredibleChickenRaw)
						.setUnlocalizedName(Reference.Items.incredibleChickenRaw.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		registry.register(
				cooked = new ItemFood(9, 0.9F, true)
						.setRegistryName(Reference.Items.incredibleChickenCooked)
						.setUnlocalizedName(Reference.Items.incredibleChickenCooked.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);
		FurnaceRecipes.instance().addSmelting(raw, new ItemStack(cooked), 0.35F);

		registry.register(
				raw = new ItemFood(6, 0.7F, true)
						.setPotionEffect(
								new PotionEffect(
										MobEffects.HUNGER,
										1200,
										0),
								0.7F
						)
						.setRegistryName(Reference.Items.amazeballsChickenRaw)
						.setUnlocalizedName(Reference.Items.amazeballsChickenRaw.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		registry.register(
				cooked = new ItemFood(10, 1.0F, true)
						.setRegistryName(Reference.Items.amazeballsChickenCooked)
						.setUnlocalizedName(Reference.Items.amazeballsChickenCooked.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		FurnaceRecipes.instance().addSmelting(raw, new ItemStack(cooked), 0.35F);

		//Unbelievable
		registry.register(
				raw = new ItemFood(10, 1.2F, true)
						.setPotionEffect(
								new PotionEffect(
										MobEffects.HUNGER,
										2400,
										0),
								0.8F
						)
						.setRegistryName(Reference.Items.unbelievableChickenRaw)
						.setUnlocalizedName(Reference.Items.unbelievableChickenRaw.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);

		registry.register(
				cooked = new ItemFood(15, 1.8F, true)
						.setRegistryName(Reference.Items.unbelievableChickenCooked)
						.setUnlocalizedName(Reference.Items.unbelievableChickenCooked.toString())
						.setCreativeTab(CreativeTabs.FOOD)
		);
		FurnaceRecipes.instance().addSmelting(raw, new ItemStack(cooked), 0.35F);

	}
}
