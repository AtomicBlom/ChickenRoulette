package com.github.atomicblom.chickenroulette;

import com.github.atomicblom.chickenroulette.capability.IExplodingChickenCapability;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;

public class RenderDangerChicken extends RenderLiving<EntityChicken>
{
	private static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");

	public RenderDangerChicken(RenderManager p_i47211_1_)
	{
		super(p_i47211_1_, new ModelChicken(), 0.3F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityChicken entity)
	{
		return CHICKEN_TEXTURES;
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityChicken livingBase, float partialTicks)
	{
		float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
		float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
		return (MathHelper.sin(f) + 1.0F) * f1;
	}

	@Override
	public float prepareScale(EntityChicken entitylivingbaseIn, float partialTicks)
	{
		final IExplodingChickenCapability capability = entitylivingbaseIn.getCapability(Reference.EXPLODING_CHICKEN, null);
		float scaleY = -1.0f;
		float scaleX = -1.0f;
		float scaleZ = 1.0f;
		if (capability != null) {
			final int itemsConsumed = capability.getItemsConsumed();
			if (itemsConsumed > 0)
			{
				//scaleY -= (1 - (1.0f / itemsConsumed));
				//scaleX -= (1 - (1.0f / itemsConsumed));
				final double growthFactor = Math.pow(itemsConsumed, 1.004) * .2;
				scaleX -= growthFactor;
				scaleY -= growthFactor * 0.6;
				scaleZ += growthFactor;
			}
		}

		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(scaleX, scaleY, scaleZ);
		preRenderCallback(entitylivingbaseIn, partialTicks);
		float f = 0.0625F;
		GlStateManager.translate(0.0F, -1.501F, 0.0F);
		return f;
	}
}
