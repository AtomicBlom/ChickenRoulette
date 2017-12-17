package com.github.atomicblom.chickenroulette.networking;

import com.github.atomicblom.chickenroulette.Reference;
import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ChickenFedMessageHandler implements IMessageHandler<ChickenFedMessage, IMessage>
{
    @SuppressWarnings({"ReturnOfNull", "ConstantConditions"})
    @Override
    public IMessage onMessage(ChickenFedMessage message, MessageContext ctx)
    {
        final int sheepId = message.getChickenId();
        final Entity entity = Minecraft.getMinecraft().world.getEntityByID(sheepId);

        if (entity == null)
        {
            return null;
        }
        final IExplodingChickenCapability capability = entity.getCapability(Reference.EXPLODING_CHICKEN, null);
        if (capability == null)
        {
            return null;
        }
        final int itemsConsumed = message.getItemsConsumed();
        capability.setItemsConsumed(itemsConsumed);
        entity.height = 1 + (1 - (1.0f / itemsConsumed));
        entity.width = 0.5f + (1 - (1.0f / itemsConsumed));

        return null;
    }
}
