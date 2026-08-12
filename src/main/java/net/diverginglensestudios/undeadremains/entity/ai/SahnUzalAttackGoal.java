/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;


import java.util.Random;

import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SahnUzalEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SahnUzalEntity.AttackType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SahnUzalAttackGoal extends MeleeAttackGoal {
	private final SahnUzalEntity entity;

	public SahnUzalAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
		entity = ((SahnUzalEntity) pMob);
	}


	@Override
	public void start() {
		super.start();
	}

	@SuppressWarnings("null")
	@Override
	protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
		boolean inMeleeRange = isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr);
		double rangedRangeSqr = 16 * 16;
		boolean inRangedRange = pDistToEnemySqr <= rangedRangeSqr;
		if (isTimeToStartAttackAnimation()) {
			Random random = new Random();
			if (inMeleeRange) {
				int roll = random.nextInt(100);//weighted random
				if (roll < 30) {
					performSlash1();
				}
				else if (roll < 60) {
					performSlash2();
				}
				else if (roll < 90) {
					performSlam();
				}
				else {
					performFloorStab();
				}
			} else if (inRangedRange){
				int choice = random.nextInt(2);
				switch (choice) {
					case 0 -> performFloorStab();
					case 1 -> performBeam();
				}
			}
		}
		if (inMeleeRange && isTimeToAttack()) {
			this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
			performAttack(pEnemy);
		}
		if (entity.getAttackType() == AttackType.FLOOR_STAB && entity.getTicksUntilHit() == 1 && !entity.SahnUzalStabQuakeTriggered) {
			entity.doEarthquake(entity.level(), entity.blockPosition(), 15);
			entity.SahnUzalStabQuakeTriggered = true;
		}
	}

	public void performSlash1() {
		entity.setAttackType(AttackType.SLASH1);
		entity.setAttackTicker(32);//Lengh of animation +2
		entity.setTicksUntilHit(17);//Ticks until the hit of the animation +1
	}

	public void performSlash2() {
		entity.setAttackType(AttackType.SLASH2);
		entity.setAttackTicker(47);
		entity.setTicksUntilHit(24);
	}

	public void performFloorStab() {
		entity.setAttackType(AttackType.FLOOR_STAB);
		entity.setAttackTicker(67);
		entity.setTicksUntilHit(24);
		entity.SahnUzalStabQuakeTriggered = false;
	}

	public void performSlam() {
		entity.setAttackType(AttackType.SLAM);
		entity.setAttackTicker(56);
		entity.setTicksUntilHit(27);
	}

	public void performBeam() {
		entity.setAttackType(AttackType.BEAM);
		entity.setAttackTicker(142);
		entity.setTicksUntilHit(0);
	}

	protected void performAttack(LivingEntity pEnemy) {
		entity.setTicksUntilHit(0);
		this.mob.swing(InteractionHand.MAIN_HAND);
		this.mob.doHurtTarget(pEnemy);
	}

	private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
		return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
	}

	protected boolean isTimeToAttack() {
		return entity.getTicksUntilHit()==1;
	}

	protected boolean isTimeToStartAttackAnimation() {
		return entity.getAttackTicker()<=0;
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void stop() {
		entity.setAttacking(false);
		super.stop();
	}
}