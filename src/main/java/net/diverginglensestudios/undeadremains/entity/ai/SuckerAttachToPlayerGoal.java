/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;

import net.diverginglensestudios.undeadremains.entity.custom.Fish.SuckerEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;

public class SuckerAttachToPlayerGoal extends MeleeAttackGoal {
	private final SuckerEntity entity;

	public SuckerAttachToPlayerGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
		entity = ((SuckerEntity) pMob);
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
		if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
			this.performAttack(pEnemy);
		} else {
			entity.setAttached(false);
		}
	}

	private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
		return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
	}

	protected void performAttack(LivingEntity pEnemy) {
			pEnemy.startRiding(entity, true);
			entity.setAttached(true);

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