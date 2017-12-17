package com.github.atomicblom.chickenroulette.events;

import com.github.atomicblom.chickenroulette.ChickenRoulette;
import com.github.atomicblom.chickenroulette.Logger;
import com.github.atomicblom.chickenroulette.Reference;
import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import com.github.atomicblom.chickenroulette.networking.ChickenFedMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class InteractionEvent
{

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event) {
		if (event.getSide() != Side.SERVER) return;
		final Entity target = event.getTarget();
		if (!(target instanceof EntityChicken)) return;
		EntityChicken chicken = (EntityChicken)target;
		if (!chicken.isBreedingItem(event.getItemStack())) return;

		final IExplodingChickenCapability capability = chicken.getCapability(Reference.EXPLODING_CHICKEN, null);
		if (capability != null) {
			capability.incrementItemsConsumed();
			ChickenRoulette.CHANNEL.sendToAll(new ChickenFedMessage(chicken));
		}

		final World world = event.getWorld();
		final double randomValue = world.rand.nextDouble();
		final float explosionChance = capability.getExplosionChance();

		if (randomValue < explosionChance) {
			Logger.info("boom - %f/%f", randomValue, explosionChance);
			chicken.setDead();
			world.createExplosion(null, target.posX, target.posY, target.posZ, capability.getItemsConsumed(), true);

		} else {
			Logger.info("Click - %f/%f", randomValue, explosionChance);
		}

	}
}
