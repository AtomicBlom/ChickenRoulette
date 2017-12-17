package com.github.atomicblom.chickenroulette;

import com.github.atomicblom.chickenroulette.capability.CapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CapabilityEventHandler
{
	@SubscribeEvent
	public static void onCapabilityAttaching(AttachCapabilitiesEvent<Entity> event)
	{
		if (event.getObject().getClass().equals(EntityChicken.class))
		{
			event.addCapability(new ResourceLocation(Reference.MOD_ID, "exploding_chicken"), new CapabilityProvider());
		}
	}
}
