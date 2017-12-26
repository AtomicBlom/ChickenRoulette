package com.github.atomicblom.chickenroulette.capability;

import mcp.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IExplodingChickenCapability
{
    int getItemsConsumed();
    int incrementItemsConsumed();
    void setItemsConsumed(int itemsConsumed);
}
