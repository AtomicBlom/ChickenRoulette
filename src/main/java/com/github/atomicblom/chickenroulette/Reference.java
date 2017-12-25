package com.github.atomicblom.chickenroulette;

import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import net.minecraft.util.ResourceLocation;
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

    public static class Items {


        public static ResourceLocation wonderChickenRaw = resource("wonder_chicken_raw");
        public static ResourceLocation wonderChickenCooked = resource("wonder_chicken_cooked");

        public static ResourceLocation superChickenRaw = resource("super_chicken_raw");
        public static ResourceLocation superChickenCooked = resource("super_chicken_cooked");

        public static ResourceLocation incredibleChickenRaw = resource("incredible_chicken_raw");
        public static ResourceLocation incredibleChickenCooked = resource("incredible_chicken_cooked");

        public static ResourceLocation amazeballsChickenRaw = resource("amazeballs_chicken_raw");
        public static ResourceLocation amazeballsChickenCooked = resource("amazeballs_chicken_cooked");

        public static ResourceLocation unbelievableChickenRaw = resource("unbelievable_chicken_raw");
        public static ResourceLocation unbelievableChickenCooked = resource("unbelievable_chicken_cooked");

        private Items() { }
    }

    private static ResourceLocation resource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private Reference() {}
}
