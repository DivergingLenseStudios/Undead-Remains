/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Bosses;


import net.diverginglensestudios.undeadremains.entity.ai.FourEyedXanarianAttackGoal;
import net.diverginglensestudios.undeadremains.entity.ai.SupremeKnightAttackGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

public class SupremeKnightEntity extends Monster {
	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	private static final EntityDataAccessor<Boolean> ATTACKING =
			SynchedEntityData.defineId(SupremeKnightEntity.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Boolean> SLEEPING =
			SynchedEntityData.defineId(SupremeKnightEntity.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Integer> ATTACKTICKER =
			SynchedEntityData.defineId(SupremeKnightEntity.class, EntityDataSerializers.INT);

	private static final EntityDataAccessor<Integer> TICKSUNTILHIT =
			SynchedEntityData.defineId(SupremeKnightEntity.class, EntityDataSerializers.INT);

	private static final EntityDataAccessor<Integer> ATTACK_TYPE =
			SynchedEntityData.defineId(SupremeKnightEntity.class, EntityDataSerializers.INT);


	public SupremeKnightEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	public enum AttackType {
		NONE,
		SLASH1,
		SLASH2,
		FLOOR_STAB,
		SLAM
	}
	public final AnimationState idleAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;
	public final AnimationState slash1AnimationState = new AnimationState();
	public final AnimationState slash2AnimationState = new AnimationState();
	public final AnimationState floorStabAnimationState = new AnimationState();
	public final AnimationState slamAnimationState = new AnimationState();
	public final AnimationState slamSlashAnimationState = new AnimationState();
	public final AnimationState chargeUpAnimationState = new AnimationState();

	public Integer getAttackTicker() {
		return this.entityData.get(ATTACKTICKER);
	}

	public void setAttackTicker(Integer ticks) {
		this.entityData.set(ATTACKTICKER, ticks);
	}

	public AttackType getAttackType() {
		return AttackType.values()[this.entityData.get(ATTACK_TYPE)];
	}

	public void setAttackType(AttackType type) {
		this.entityData.set(ATTACK_TYPE, type.ordinal());
	}

	public Integer getTicksUntilHit() {
		return this.entityData.get(TICKSUNTILHIT);
	}

	public void setTicksUntilHit(Integer ticks) {
		this.entityData.set(TICKSUNTILHIT, ticks);
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
	}

	public void setCustomName(@Nullable Component pName) {
		super.setCustomName(pName);
		this.bossEvent.setName(this.getDisplayName());
	}

	public void startSeenByPlayer(ServerPlayer pPlayer) {
		super.startSeenByPlayer(pPlayer);
		this.bossEvent.addPlayer(pPlayer);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getHealth() < this.getMaxHealth() && this.getHealth() > 0){ //checks if boss health is smaller than Max and larger than 1
			this.heal(1);
			//this.setHealth(this.getHealth()+0.5f); //Heals the boss by 0.5 health every tick
			this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth()); //Updates the bossbar every tick

		}
		if(this.level().isClientSide()) {
			setupAnimationStates();
			this.slash1AnimationState.animateWhen(this.getAttackTicker() > 0& this.getAttackType() == AttackType.SLASH1, this.tickCount);
			this.slash2AnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.SLASH2, this.tickCount);
			this.floorStabAnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.FLOOR_STAB, this.tickCount);
			this.slamAnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.SLAM, this.tickCount);
		}else {
			if (this.getAttackTicker()>0){
				this.setAttackTicker(getAttackTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
				if (this.getTicksUntilHit()>0){
					this.setTicksUntilHit(getTicksUntilHit()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
				}
			}
		}
	}

	private void setupAnimationStates() { //I dont really understand this part but it works
		if(this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = this.random.nextInt(40) + 80;
			this.idleAnimationState.start(this.tickCount);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public void setAttacking(boolean attacking) { //command to set entity to attacking state
		this.entityData.set(ATTACKING, attacking);
	}

	public boolean isAttacking() {  //command to check if entity is attacking
		return this.entityData.get(ATTACKING);
	}

	@Override
	protected void defineSynchedData() { //Sets default values for entity data
		super.defineSynchedData();
		this.entityData.define(ATTACKING, false);
		this.entityData.define(ATTACKTICKER, 0);
		this.entityData.define(TICKSUNTILHIT, 0);
		this.entityData.define(ATTACK_TYPE, AttackType.NONE.ordinal());
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.goalSelector.addGoal(3, new SupremeKnightAttackGoal(this, 1.25D, true));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 250D)
				.add(Attributes.FOLLOW_RANGE, 24D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.ARMOR_TOUGHNESS, 1f)
				.add(Attributes.ATTACK_KNOCKBACK, 2f)
				.add(Attributes.KNOCKBACK_RESISTANCE, 2f)
				.add(Attributes.ATTACK_DAMAGE, 2f);
	}

	public void stopSeenByPlayer(ServerPlayer pPlayer) {    //Add the given player to the list of players tracking
		super.stopSeenByPlayer(pPlayer);                    //this entity. For instance, a player may track a
		this.bossEvent.removePlayer(pPlayer);               //boss in order to view its associated boss bar.
	}
	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.HOGLIN_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return SoundEvents.RAVAGER_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.DOLPHIN_DEATH;
	}
}