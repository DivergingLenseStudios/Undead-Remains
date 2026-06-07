package net.diverginglensestudios.undeadremains.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

public class GuardGoal extends Goal {
	private final PathfinderMob mob;
	private final Block targetBlock;
	private final double speedModifier;
	private final int searchRadius;

	private BlockPos targetPos;

	public GuardGoal(PathfinderMob pMob, Block pTargetBlock, double pSpeedModifier, int pSearchRadius) {
		this.mob = pMob;
		this.targetBlock = pTargetBlock;
		this.speedModifier = pSpeedModifier;
		this.searchRadius = pSearchRadius;
	}

	@Override
	public boolean canUse() {
		if (mob.getTarget() != null) {
			return false;
		}
		targetPos = findNearestBlock();
		if (targetPos == null) {
			return false;
		}
		return !targetPos.closerToCenterThan(mob.position(), 0.0);
	}

	@Override
	public boolean canContinueToUse() {
		if (mob.getTarget() != null) {
			return false;
		}
		if (targetPos == null) {
			return false;
		}
		return !targetPos.closerToCenterThan(mob.position(), 0.0);
	}

	@Override
	public void start() {
		moveToTarget();
	}

	@Override
	public void tick() {
		if (targetPos == null) {
			return;
		}

		double distanceSq = mob.distanceToSqr(
				targetPos.getX() + 0.5,
				targetPos.getY(),
				targetPos.getZ() + 0.5
		);

		// Re-path if necessary
		if (distanceSq > 4 && mob.getNavigation().isDone()) {
			moveToTarget();
		}

		// Stop moving once close enough
		if (distanceSq <= 4) {
			mob.getNavigation().stop();
		}
	}

	@Override
	public void stop() {
		mob.getNavigation().stop();
		targetPos = null;
	}

	private void moveToTarget() {
		mob.getNavigation().moveTo(
				targetPos.getX() + 0.5,
				targetPos.getY(),
				targetPos.getZ() + 0.5,
				speedModifier
		);
	}

	private BlockPos findNearestBlock() {
		BlockPos mobPos = mob.blockPosition();

		BlockPos nearest = null;
		double nearestDistance = Double.MAX_VALUE;

		BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

		for (int x = -searchRadius; x <= searchRadius; x++) {
			for (int y = -searchRadius; y <= searchRadius; y++) {
				for (int z = -searchRadius; z <= searchRadius; z++) {

					mutable.set(
							mobPos.getX() + x,
							mobPos.getY() + y,
							mobPos.getZ() + z
					);

					if (mob.level().getBlockState(mutable).is(targetBlock)) {
						double dist = mutable.distSqr(mobPos);

						if (dist < nearestDistance) {
							nearestDistance = dist;
							nearest = mutable.immutable();
						}
					}
				}
			}
		}

		return nearest;
	}
}

