package com.github.atomicblom.chickenroulette.capability;

import com.google.common.base.MoreObjects;
import mcp.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ExplodingChickenCapability implements IExplodingChickenCapability
{

    private int _itemsConsumed;

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("ItemsConsumed", _itemsConsumed)
                .toString();
    }

    @Override
    public int getItemsConsumed()
    {
        return _itemsConsumed;
    }

    @Override
    public void incrementItemsConsumed()
    {
        _itemsConsumed++;
    }

    @Override
    public float getExplosionChance(int itemsConsumed)
    {
        return (float)(0.0172 * Math.pow(itemsConsumed, 2));
        //return (float)Math.pow(0.08 * _itemsConsumed, 2);
        //return (_itemsConsumed / 16.0f);
    }

    @Override
    public void setItemsConsumed(int itemsConsumed)
    {
        _itemsConsumed = itemsConsumed;
    }
}

