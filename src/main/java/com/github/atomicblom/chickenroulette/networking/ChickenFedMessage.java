package com.github.atomicblom.chickenroulette.networking;

import com.github.atomicblom.chickenroulette.Reference;
import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import com.google.common.base.MoreObjects;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ChickenFedMessage implements IMessage
{
    private int _itemsConsumed;
    private int _chickenId;

    @SuppressWarnings("unused")
    public ChickenFedMessage() { }

    public ChickenFedMessage(Entity chicken)
    {
        _chickenId = chicken.getEntityId();
        final IExplodingChickenCapability capability = chicken.getCapability(Reference.EXPLODING_CHICKEN, null);
        assert capability != null;
        _itemsConsumed = capability.getItemsConsumed();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        _chickenId = buf.readInt();
        _itemsConsumed = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(_chickenId);
        buf.writeInt(_itemsConsumed);
    }

    int getChickenId()
    {
        return _chickenId;
    }


    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("chickenId", _chickenId)
                .add("ItemsConsumed", _itemsConsumed)
                .toString();
    }

    public int getItemsConsumed()
    {
        return _itemsConsumed;
    }
}