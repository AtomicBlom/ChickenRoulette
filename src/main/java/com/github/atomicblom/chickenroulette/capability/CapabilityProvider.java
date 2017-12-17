package com.github.atomicblom.chickenroulette.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.github.atomicblom.chickenroulette.Reference.EXPLODING_CHICKEN;

@SuppressWarnings({"ObjectEquality", "ConstantConditions", "ClassHasNoToStringMethod"})
@ParametersAreNonnullByDefault
public class CapabilityProvider implements ICapabilityProvider, INBTSerializable<NBTBase>
{
    private final IExplodingChickenCapability capability;

    public CapabilityProvider()
    {
        capability = new ExplodingChickenCapability();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == EXPLODING_CHICKEN;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (capability == EXPLODING_CHICKEN)
        {
            return EXPLODING_CHICKEN.cast(this.capability);
        }
        //noinspection ReturnOfNull
        return null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return ExplodingChickenCapabilityStorage.instance.writeNBT(EXPLODING_CHICKEN, capability, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        ExplodingChickenCapabilityStorage.instance.readNBT(EXPLODING_CHICKEN, capability, null, nbt);
    }
}

