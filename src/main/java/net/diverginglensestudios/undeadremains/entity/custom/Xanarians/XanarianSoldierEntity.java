/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Xanarians;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.ai.XanarianSoldierAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class XanarianSoldierEntity extends AbstractXanarian {
	public XanarianSoldierEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);

	}
	public XanarianSoldierEntity(Level pLevel) {
		this(ModEntities.XANARIAN_SOLDIER.get(), pLevel);
	}

	private static final EntityDataAccessor<Integer> SLASHTICKER =
			SynchedEntityData.defineId(XanarianCannibalEntity.class, EntityDataSerializers.INT); //define ticker

	private static final EntityDataAccessor<Integer> SLAMTICKER =
			SynchedEntityData.defineId(XanarianCannibalEntity.class, EntityDataSerializers.INT); //define ticker


	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState slashAnimationState = new AnimationState();
	public final AnimationState slamAnimationState = new AnimationState();

	public void tick() {
		super.tick();

		if(this.level().isClientSide()) {
			this.idleAnimationState.animateWhen(this.getSlashTicker() <= 0 && this.getSlamTicker() <= 0, this.tickCount);//Idle animation plays when attack animations aren't playing
			this.slashAnimationState.animateWhen(this.getSlashTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays
			this.slamAnimationState.animateWhen(this.getSlamTicker() > 0, this.tickCount);//when the ticker is above 0, the respective animation plays

		} else {
			if (this.getSlashTicker()>0){
				this.setSlashTicker(getSlashTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
			if (this.getSlamTicker()>0){
				this.setSlamTicker(getSlamTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
			}
		}
	}

	public Integer getSlashTicker() {
		return this.entityData.get(SLASHTICKER);//command to get the current value of the ticker
	}

	public void setSlashTicker(Integer ticks) {
		this.entityData.set(SLASHTICKER, ticks);//command to set the value of the ticker
	}

	public Integer getSlamTicker() {
		return this.entityData.get(SLAMTICKER);//command to get the current value of the ticker
	}

	public void setSlamTicker(Integer ticks) {
		this.entityData.set(SLAMTICKER, ticks);//command to set the current value of the ticker
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SLASHTICKER, 0);
		this.entityData.define(SLAMTICKER, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(2, new XanarianSoldierAttackGoal(this, 1.25D, true));

	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 150.0D)
				.add(Attributes.FOLLOW_RANGE, 70.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.35F)
				.add(Attributes.ATTACK_DAMAGE, 10.0D)
				.add(Attributes.ARMOR, 7.0D);
	}
}