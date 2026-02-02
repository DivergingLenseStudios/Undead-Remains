/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.phys.AABB;

public class BetterHurtByTargetGoal extends TargetGoal {
	private static final TargetingConditions HURT_BY_TARGETING = TargetingConditions.forCombat().ignoreLineOfSight().ignoreInvisibilityTesting();
	private static final int ALERT_RANGE_Y = 10; //Range in which mobs will be alerted if alert is used
	private boolean alertSameType;
	private int timestamp;
	@Nullable
	private List<EntityType<?>> alertEntityTypes;

	public BetterHurtByTargetGoal(PathfinderMob pMob) {
		super(pMob, true);
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	@Override
	public boolean canUse() {
		int i = this.mob.getLastHurtByMobTimestamp();
		LivingEntity livingentity = this.mob.getLastHurtByMob();
		if (i != this.timestamp && livingentity != null) {
			if (livingentity.getType() == EntityType.PLAYER && this.mob.level().getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER)) {
				return false;
			}
			return this.canAttack(livingentity, HURT_BY_TARGETING);
		}
		return false;
	}

	public BetterHurtByTargetGoal setAlertOthers(@Nullable List<EntityType<?>> alertEntityTypes) {
		this.alertSameType = true;
		this.alertEntityTypes = alertEntityTypes;
		return this;
	}

	@Override
	public void start() {
		this.mob.setTarget(this.mob.getLastHurtByMob());
		this.targetMob = this.mob.getTarget();
		this.timestamp = this.mob.getLastHurtByMobTimestamp();
		this.unseenMemoryTicks = 300;
		if (this.alertSameType) {
			this.alertOthers();
		}
		super.start();
	}

	@SuppressWarnings("null")
	protected void alertOthers() {
		double d0 = this.getFollowDistance();
		AABB aabb = AABB.unitCubeFromLowerCorner(this.mob.position()).inflate(d0, ALERT_RANGE_Y, d0);
		List<Mob> list = this.mob.level().getEntitiesOfClass(Mob.class, aabb, EntitySelector.NO_SPECTATORS);

		for (Mob mob : list) {
			if (this.mob != mob && mob.getTarget() == null && !mob.isAlliedTo(this.mob.getLastHurtByMob())) {
				if (this.alertEntityTypes != null && !this.alertEntityTypes.contains(mob.getType())) {
					continue;
				}
				this.alertOther(mob, this.mob.getLastHurtByMob());
			}
		}
	}

	protected void alertOther(Mob pMob, LivingEntity pTarget) {
		pMob.setTarget(pTarget);
	}
}
