package com.github.atomicblom.chickenroulette;

import com.github.atomicblom.chickenroulette.capability.ExplodingChickenCapability;
import com.github.atomicblom.chickenroulette.capability.ExplodingChickenCapabilityStorage;
import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import com.github.atomicblom.chickenroulette.events.RegisterChickenRendererEvent;
import com.github.atomicblom.chickenroulette.networking.ChickenFedMessage;
import com.github.atomicblom.chickenroulette.networking.ChickenFedMessageHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION)
public class ChickenRoulette
{
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CHANNEL.registerMessage(ChickenFedMessageHandler.class, ChickenFedMessage.class, 1, Side.CLIENT);

        CapabilityManager.INSTANCE.register(IExplodingChickenCapability.class, ExplodingChickenCapabilityStorage.instance, ExplodingChickenCapability::new);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        MinecraftForge.EVENT_BUS.post(new RegisterChickenRendererEvent());
    }

    public static float getExplosionChance(int itemsConsumed)
    {
        if (ChickenRouletteConfiguration.explosionAlgorithm == ExplosionAlgorithm.LINEAR)
        {
            //94.9475% chance of it exploding before getting to "Unbelievable" size
            return 0.98f / 2.0f;
        } else {
            return (float)(0.037 * Math.pow(itemsConsumed, 2));
        }
    }
}
