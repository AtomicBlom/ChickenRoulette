package com.github.atomicblom.chickenroulette;

import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID)
public class ChickenRouletteConfiguration
{
	@Config.Comment("You will not be able to feed a chicken six times.")
	public static boolean safetyNet = false;

	@Config.Comment("LINEAR or Exponential chance of explosion")
	public static ExplosionAlgorithm explosionAlgorithm = ExplosionAlgorithm.EXPONENTIAL;
}
