package com.github.atomicblom.chickenroulette.capability;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IExplodingChickenCapability
{
    int getItemsConsumed();
    void incrementItemsConsumed();
    float getExplosionChance();
    void setItemsConsumed(int itemsConsumed);
}
