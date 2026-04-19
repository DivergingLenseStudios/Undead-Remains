/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class AnchoredEffect extends MobEffect {
	public AnchoredEffect(MobEffectCategory category, int color) {
		super(category, color);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (!entity.onGround()) {
			double gravityStrength = 0.08D * (amplifier + 1); // tweak this
			entity.setDeltaMovement(
					entity.getDeltaMovement().x,
					entity.getDeltaMovement().y - gravityStrength,
					entity.getDeltaMovement().z);
		}

		super.applyEffectTick(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
