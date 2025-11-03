package net.diverginglensestudios.undeadremains.entity.custom.Fish;

import javax.annotation.Nullable;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class XanaranhaEntity extends AbstractFish {
public XanaranhaEntity(EntityType<? extends AbstractFish> pEntityType, Level pLevel) {
    super(pEntityType, pLevel);
}
   private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(XanaranhaEntity.class, EntityDataSerializers.BOOLEAN);
            
public final AnimationState idleAnimationState = new AnimationState();
private int idleAnimationTimeout = 0;


@Override
public void tick() {
    super.tick();
    if(this.level().isClientSide()) {
        setupAnimationStates();
    }
}

private void setupAnimationStates() {
    if(this.idleAnimationTimeout <= 0) {
        this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        this.idleAnimationState.start(this.tickCount);
    } else {
        --this.idleAnimationTimeout;
    }
}

@Override
protected void updateWalkAnimation(float pPartialTick) {
    float f;
    if(this.getPose() == Pose.STANDING) {
        f = Math.min(pPartialTick * 6F, 1f);
    } else {
        f = 0f;
    }
    this.walkAnimation.update(f, 0.2f);
}

@Override
protected void registerGoals() {
    super.registerGoals();
    this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false,  false));
    this.goalSelector.addGoal(4, new XanaranhaEntity.FishSwimGoal(this));
}


    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }


public static AttributeSupplier.Builder createAttributes() {
    return Monster.createMonsterAttributes()
    .add(Attributes.FOLLOW_RANGE, 35.0D)
    .add(Attributes.MOVEMENT_SPEED, (double)0.23F)
    .add(Attributes.ATTACK_DAMAGE, 3.0D)
    .add(Attributes.ARMOR, 2.0D);
}

@Override
public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
    return super.causeFallDamage(pFallDistance, pMultiplier*0.2f, pSource);
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
    static class FishSwimGoal extends RandomSwimmingGoal {
    private final AbstractFish fish;

    public FishSwimGoal(AbstractFish pFish) {
        super(pFish, 1.0D, 40);
        this.fish = pFish;
    }

    /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
    public boolean canUse() {
        return this.canRandomSwim() && super.canUse();
    }
private boolean canRandomSwim() {
    return true;
}
}
@Override
public ItemStack getBucketItemStack() {
    return ItemStack.EMPTY;
}

}