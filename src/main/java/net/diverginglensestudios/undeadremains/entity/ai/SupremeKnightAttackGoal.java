/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;


import java.util.Random;

import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SupremeKnightEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SupremeKnightEntity.AttackType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SupremeKnightAttackGoal extends MeleeAttackGoal {
	private final SupremeKnightEntity entity;

	public SupremeKnightAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
		entity = ((SupremeKnightEntity) pMob);
	}

	@Override
	public void start() {
		super.start();
	}

	@SuppressWarnings("null")
	@Override
	protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
		if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) { //if the enemy is in reach

			if(isTimeToStartAttackAnimation()){ //if both tickers are at 0
				//System.out.println("Choosing attack");
				Random random = new Random();
				int choice = random.nextInt(4) + 1; // Number of events
				if (choice==1){//////////Slash1//////////
					//System.out.println("Attack 1 has been chosen");
					this.performSlash1();
				}else if (choice==2){//////////Slash2//////////
					//System.out.println("Attack 2 has been chosen");
					this.performSlash2();
				}else if (choice==3){//////////FLOOR_STAB//////////
					//System.out.println("Attack 3 has been chosen");
					this.performFloorStab();
				}else if (choice==4){//////////FLOOR_STAB//////////
					//System.out.println("Attack 4 has been chosen");
					this.performSlam();
				}
			}
			if(isTimeToAttack()) {// if the ticker is at the point where the damage  should happen
				this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
				performAttack(pEnemy);
			}

		}   /*else if (entity.getAttackTicker() >0 || entity.getTicksUntilHit()<0 || entity.getAttackType()!=AttackType.NONE){//if the enemy is not in reach, tickers are reset
            System.out.println("Stopping Attack");
            entity.setAttackTicker(0);
            entity.setTicksUntilHit(0);
            entity.setAttackType(AttackType.NONE);
            } */
	}

	public void performSlash1() {
		//System.out.println("Performing slash 1");
		entity.setAttackType(AttackType.SLASH1);
		entity.setAttackTicker(32);//Lengh of animation +2
		entity.setTicksUntilHit(17);//Ticks until the hit of the animation +1
	}

	public void performSlash2() {
		//System.out.println("Performing slash 2");
		entity.setAttackType(AttackType.SLASH2);
		entity.setAttackTicker(47);//Lengh of animation +2
		entity.setTicksUntilHit(24);//Ticks until the hit of the animation +1
	}

	public void performFloorStab() {
		entity.setAttackType(AttackType.FLOOR_STAB);
		entity.setAttackTicker(67);//Lengh of animation +2
		entity.setTicksUntilHit(24);//Ticks until the hit of the animation +1
	}

	public void performSlam() {
		//System.out.println("Performing slash 1");
		entity.setAttackType(AttackType.SLAM);
		entity.setAttackTicker(56);//Lengh of animation +2
		entity.setTicksUntilHit(27);//Ticks until the hit of the animation +1
	}

	protected void performAttack(LivingEntity pEnemy) {
		//System.out.println("Performing attack");
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