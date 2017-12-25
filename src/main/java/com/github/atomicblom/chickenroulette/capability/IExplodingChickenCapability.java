package com.github.atomicblom.chickenroulette.capability;

import mcp.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IExplodingChickenCapability
{
    int getItemsConsumed();
    void incrementItemsConsumed();
    float getExplosionChance(int itemsConsumed);
    void setItemsConsumed(int itemsConsumed);
}
