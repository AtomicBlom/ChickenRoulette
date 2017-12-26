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
    public int incrementItemsConsumed()
    {
        return ++_itemsConsumed;
    }

    @Override
    public void setItemsConsumed(int itemsConsumed)
    {
        _itemsConsumed = itemsConsumed;
    }
}

