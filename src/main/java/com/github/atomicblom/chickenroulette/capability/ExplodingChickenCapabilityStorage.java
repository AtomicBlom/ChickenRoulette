package com.github.atomicblom.chickenroulette.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ExplodingChickenCapabilityStorage implements IStorage<IExplodingChickenCapability>
{
    public static final IStorage<IExplodingChickenCapability> instance = new ExplodingChickenCapabilityStorage();

    @Override
    public NBTBase writeNBT(Capability<IExplodingChickenCapability> capability, IExplodingChickenCapability instance, EnumFacing side)
    {
        final NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("ItemsConsumed", instance.getItemsConsumed());
        return compound;
    }

    @Override
    public void readNBT(Capability<IExplodingChickenCapability> capability, IExplodingChickenCapability instance, EnumFacing side, NBTBase nbt)
    {
        final NBTTagCompound compound = (NBTTagCompound) nbt;
        final int itemsConsumed = compound.getInteger("ItemsConsumed");
        instance.setItemsConsumed(itemsConsumed);
    }
}
