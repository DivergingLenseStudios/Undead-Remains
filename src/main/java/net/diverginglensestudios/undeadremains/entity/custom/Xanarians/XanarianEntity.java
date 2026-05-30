/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Xanarians;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.ai.XanarianAttackGoal;
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

public class XanarianEntity extends AbstractXanarian {
	public XanarianEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);

	}

	public XanarianEntity(Level pLevel) {
		this(ModEntities.XANARIAN.get(), pLevel);
	}
	private static final EntityDataAccessor<Integer> ATTACKTICKER =
			SynchedEntityData.defineId(XanarianEntity.class, EntityDataSerializers.INT); //define ticker

	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState attackAnimationState = new AnimationState();

	public void tick() {
		super.tick();

		if(this.level().isClientSide()) {
			this.idleAnimationState.animateWhen(this.getAttackTicker() <= 0, this.tickCount);//Idle animation plays when attack animations aren't playing
			this.attackAnimationState.animateWhen(this.getAttackTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays

		} else {
			if (this.getAttackTicker()>0){
				this.setAttackTicker(getAttackTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
		}
	}
	public void setAttackTicker(Integer ticks) {
		this.entityData.set(ATTACKTICKER, ticks);//command to set the value of the ticker
	}

	public Integer getAttackTicker() {
		return this.entityData.get(ATTACKTICKER);//command to get the current value of the ticker
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACKTICKER, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new XanarianAttackGoal(this, 1.25D, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 75.0D)
				.add(Attributes.FOLLOW_RANGE, 50.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.28F)
				.add(Attributes.ATTACK_DAMAGE, 5.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 4);
	}
}