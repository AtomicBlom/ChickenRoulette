package com.github.atomicblom.chickenroulette;

import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * Created by codew on 4/10/2016.
 */
public final class Reference
{
    public static final String MOD_ID = "chickenroulette";
    public static final String MOD_NAME = "Chicken Roulette";
    public static final String VERSION = "@MOD_VERSION@";

    @CapabilityInject(IExplodingChickenCapability.class)
    public static final net.minecraftforge.common.capabilities.Capability<IExplodingChickenCapability> EXPLODING_CHICKEN;

    static {
        EXPLODING_CHICKEN = null;
    }

    private Reference() {}
}
