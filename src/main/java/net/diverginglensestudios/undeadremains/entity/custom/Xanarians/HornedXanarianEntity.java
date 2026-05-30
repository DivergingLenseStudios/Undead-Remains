/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Xanarians;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.ai.HornedXanarianAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class HornedXanarianEntity extends AbstractXanarian {
	public HornedXanarianEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);

	}

	public HornedXanarianEntity(Level pLevel) {
		this(ModEntities.HORNED_XANARIAN.get(), pLevel);
	}


	private static final EntityDataAccessor<Integer> HITTICKER =
			SynchedEntityData.defineId(HornedXanarianEntity.class, EntityDataSerializers.INT); //define ticker

	private static final EntityDataAccessor<Integer> THROWTICKER =
			SynchedEntityData.defineId(HornedXanarianEntity.class, EntityDataSerializers.INT); //define ticker

	private static final EntityDataAccessor<Integer> SLAMTICKER =
			SynchedEntityData.defineId(HornedXanarianEntity.class, EntityDataSerializers.INT); //define ticker


	public final AnimationState hitAnimationState = new AnimationState();
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState throwAnimationState = new AnimationState();
	public final AnimationState slamAnimationState = new AnimationState();

	public void tick() {
		super.tick();

		if(this.level().isClientSide()) {
			this.idleAnimationState.animateWhen(this.getHitTicker() <= 0 && this.getSlamTicker() <= 0 && this.getThrowTicker() <= 0, this.tickCount);//Idle animation plays when attack animations aren't playing
			this.hitAnimationState.animateWhen(this.getHitTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays
			this.slamAnimationState.animateWhen(this.getSlamTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays
			this.throwAnimationState.animateWhen(this.getThrowTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays

		} else {
			if (this.getHitTicker()>0){
				this.setHitTicker(getHitTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
			if (this.getSlamTicker()>0){
				this.setSlamTicker(getSlamTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
			if (this.getThrowTicker()>0){
				this.setThrowTicker(getThrowTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
		}
	}

	public Integer getHitTicker() {
		return this.entityData.get(HITTICKER);//command to get the current value of the ticker
	}

	public void setHitTicker(Integer ticks) {
		this.entityData.set(HITTICKER, ticks);//command to set the value of the ticker
	}

	public Integer getSlamTicker() {
		return this.entityData.get(SLAMTICKER);//command to get the current value of the ticker
	}

	public void setSlamTicker(Integer ticks) {
		this.entityData.set(SLAMTICKER, ticks);//command to set the current value of the ticker
	}

	public Integer getThrowTicker() {
		return this.entityData.get(THROWTICKER);//command to get the current value of the ticker
	}

	public void setThrowTicker(Integer ticks) {
		this.entityData.set(THROWTICKER, ticks);//command to set the current value of the ticker
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HITTICKER, 0);
		this.entityData.define(SLAMTICKER, 0);
		this.entityData.define(THROWTICKER, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new HornedXanarianAttackGoal(this, 1.25D, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 90.0D)
				.add(Attributes.FOLLOW_RANGE, 65.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.35F)
				.add(Attributes.ATTACK_DAMAGE, 7.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 4.5)
				.add(Attributes.ARMOR, 5.0D);
	}
}