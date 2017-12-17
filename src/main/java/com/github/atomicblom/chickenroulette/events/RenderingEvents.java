package com.github.atomicblom.chickenroulette.events;

import com.github.atomicblom.chickenroulette.RenderDangerChicken;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RenderingEvents
{
	@SubscribeEvent
	public static void onEntityRenderingOverridesReady(RegisterChickenRendererEvent event) {
		final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		renderManager.entityRenderMap.remove(EntityChicken.class);
		renderManager.entityRenderMap.put(EntityChicken.class, new RenderDangerChicken(renderManager));
	}
}
