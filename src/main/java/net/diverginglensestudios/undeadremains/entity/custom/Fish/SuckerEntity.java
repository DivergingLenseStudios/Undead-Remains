/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Fish;

import net.diverginglensestudios.undeadremains.entity.ai.EntityAINearestTarget3D;
import net.diverginglensestudios.undeadremains.entity.ai.SuckerAttachToPlayerGoal;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.AbstractXanarian;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.level.NoteBlockEvent;

import javax.annotation.Nullable;

public class SuckerEntity extends AbstractFish {
	public SuckerEntity(EntityType<? extends AbstractFish> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(SuckerEntity.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ATTACHED = SynchedEntityData.defineId(SuckerEntity.class,
			EntityDataSerializers.BOOLEAN);

	public void setAttacking(boolean attacking) {
		this.entityData.set(ATTACKING, attacking);
	}

	public void setAttached(boolean attached) {
		this.entityData.set(ATTACHED, attached);
	}

	public boolean isAttacking() {
		return this.entityData.get(ATTACKING);
	}

	public boolean isAttached() {
		return this.entityData.get(ATTACHED);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACKING, false);
		this.entityData.define(ATTACHED, false);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.isAttached()) {
			if (this.getPassengers().isEmpty() && this.getTarget() instanceof Player player) {
				player.startRiding(this, true);
			}
			if (!this.getPassengers().isEmpty()) {
				this.setDeltaMovement(
						this.getDeltaMovement().x,
						-0.2,
						this.getDeltaMovement().z);

				this.hasImpulse = true;
			}
		}
		if (this.isAttached() && this.getPassengers().isEmpty()) {
			this.setAttached(false);
		}
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {

		if (passenger.getVehicle() instanceof SuckerEntity) {
			return false;
		}

		return super.canAddPassenger(passenger);
	}

	@Override
	public void positionRider(Entity passenger, MoveFunction moveFunction) {
		moveFunction.accept(passenger, this.getX(), this.getY() - 0.3, this.getZ());
	}

	@Override
	protected void updateWalkAnimation(float pPartialTick) {
		float f;
		if (this.getPose() == Pose.STANDING) {
			f = Math.min(pPartialTick * 6F, 1f);
		} else {
			f = 0f;
		}
		this.walkAnimation.update(f, 0.2f);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, AbstractFish.class, 10.0F, 1.5D, 1.2D));
		this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new EntityAINearestTarget3D<>(this, LivingEntity.class, true));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this, SuckerEntity.class));
		this.goalSelector.addGoal(3, new SuckerAttachToPlayerGoal(this, 3D, true));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1D, 10));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 60.0D)
				.add(Attributes.MOVEMENT_SPEED, 2.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D)
				.add(ForgeMod.SWIM_SPEED.get(), 2.0D)
				.add(Attributes.ARMOR, 2.0D);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ZOMBIE_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return SoundEvents.ZOMBIE_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ZOMBIE_DEATH;
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.COD_FLOP;
	}

	@Override
	public ItemStack getBucketItemStack() {
		return ItemStack.EMPTY;
	}

}