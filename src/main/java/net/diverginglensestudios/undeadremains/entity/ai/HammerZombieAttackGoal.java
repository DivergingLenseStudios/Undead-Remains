/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;

import net.diverginglensestudios.undeadremains.entity.custom.Zombies.HammerZombieEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.Level;

public class HammerZombieAttackGoal extends MeleeAttackGoal {
	private final HammerZombieEntity entity;
	private int attackDelay = 10;
	private int ticksUntilNextAttack = 16;
	private boolean shouldCountTillNextAttack = false;

	public HammerZombieAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
		entity = ((HammerZombieEntity) pMob);
	}

	@Override
	public void start() {
		super.start();
		attackDelay = 14;
		ticksUntilNextAttack = 16;
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
		if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
			shouldCountTillNextAttack = true;

			if(isTimeToStartAttackAnimation()) {
				entity.setAttacking(true);
			}

			if(isTimeToAttack()) {
				this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
				performAttack(pEnemy);
			}
		} else {
			resetAttackCooldown();
			shouldCountTillNextAttack = false;
			entity.setAttacking(false);
			entity.attackAnimationTimeout = 0;
		}
	}

	private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
		return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
	}

	protected void resetAttackCooldown() {
		this.ticksUntilNextAttack = this.adjustedTickDelay(31);
	}

	protected boolean isTimeToAttack() {
		return this.ticksUntilNextAttack <= 0;
	}

	protected boolean isTimeToStartAttackAnimation() {
		return this.ticksUntilNextAttack <= attackDelay;
	}

	protected int getTicksUntilNextAttack() {
		return this.ticksUntilNextAttack;
	}


	protected void performAttack(LivingEntity pEnemy) {
		this.resetAttackCooldown();
		this.mob.swing(InteractionHand.MAIN_HAND);
		this.mob.doHurtTarget(pEnemy);

		// 1 in 10 chance to explode
		if (this.mob.level().random.nextInt(10) == 0) {
			this.mob.level().explode(
					this.mob,                             // the source entity
					this.mob.getX(), this.mob.getY(), this.mob.getZ(), // explosion position
					2.0F,                                 // explosion strength (adjust as needed)
					Level.ExplosionInteraction.MOB        // explosion type
			);
		}
	}

	@Override
	public void tick() {
		super.tick();
		if(shouldCountTillNextAttack) {
			this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
		}
	}

	@Override
	public void stop() {
		entity.setAttacking(false);
		super.stop();
	}
}