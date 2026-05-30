/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;

import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.HornedXanarianEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

import java.util.Random;

public class HornedXanarianAttackGoal extends MeleeAttackGoal {
	private final HornedXanarianEntity entity;

	public HornedXanarianAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
		entity = ((HornedXanarianEntity) pMob);
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
		if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) { //if the enemy is in reach

			if(isTimeToStartAttackAnimation()){ //if both tickers are at 0
				Random random = new Random();
				int choice = random.nextInt(3) + 1; // Number of events
				if(choice == 1) {//selects one attack randomly
					entity.setHitTicker(15);//length of animation (this starts the anim.)
				} else if (choice == 2) {
					entity.setThrowTicker(15);
				} else if (choice == 3) {
					entity.setSlamTicker(25);
				}

			}
			if(isTimeToAttack()) {// if the ticker is at the point where the damage should happen
				this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
				performAttack(pEnemy);
			}
		}
	}

	private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
		return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy); //if enemy is within reach
	}

	protected boolean isTimeToAttack() {
		return (entity.getHitTicker() == 9 || entity.getThrowTicker() == 11 || entity.getSlamTicker() == 12);//moment where damage should happen
	}

	protected boolean isTimeToStartAttackAnimation() {
		return entity.getHitTicker()<=0 && entity.getSlamTicker()<=0 && entity.getThrowTicker()<=0; //new animation can only start if the others are over
	}

	protected void performAttack(LivingEntity pEnemy) {
		this.mob.swing(InteractionHand.MAIN_HAND);
		this.mob.doHurtTarget(pEnemy);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void stop() {
		super.stop();
	}
}
