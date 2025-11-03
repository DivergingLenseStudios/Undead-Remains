package net.diverginglensestudios.undeadremains.entity.custom.Zombies;

import net.diverginglensestudios.undeadremains.entity.ai.SupremeZombieAttackGoal;
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

public class SupremeZombieEntity extends ModAbstractZombie {
    public SupremeZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
;

private static final EntityDataAccessor<Boolean> ATTACKING =
SynchedEntityData.defineId(SupremeZombieEntity.class, EntityDataSerializers.BOOLEAN);

            public final AnimationState idleAnimationState = new AnimationState();
            private int idleAnimationTimeout = 0;
        
            public final AnimationState attackAnimationState = new AnimationState();
            public int attackAnimationTimeout = 0;
       
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
        
                if(this.isAttacking() && attackAnimationTimeout <= 0) {
                    attackAnimationTimeout = 16; // Length in ticks of your animation
                    attackAnimationState.start(this.tickCount);
                } else {
                    --this.attackAnimationTimeout;
                }
        
                if(!this.isAttacking()) {
                    attackAnimationState.stop();
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
       
    @Override
    protected void registerGoals() {
       super.registerGoals();
    this.goalSelector.addGoal(2, new SupremeZombieAttackGoal(this, 1D, true));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
        .add(Attributes.FOLLOW_RANGE, 35.0D)
        .add(Attributes.MOVEMENT_SPEED, (double)0.23F)
        .add(Attributes.ATTACK_DAMAGE, 5.0D)
        .add(Attributes.ARMOR, 10.0D)
        .add(Attributes.MAX_HEALTH, 50.0D)
        .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
@Override
public boolean isSunSensitive() {
    return false;
}
}