package net.diverginglensestudios.undeadremains.entity.custom.Zombies;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.ai.SpikeAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SpikeEntity extends ModAbstractZombie {
    // „Dornen-Level“ frei wählbar (1..3 fühlte sich immer gut an)
    private static final int THORNS_LEVEL = 2;   // Vanilla-ähnliche Chance: 15% * Level
    private static final int THORNS_COOLDOWN_TICKS = 5; // gegen Mehrfachauslösung pro Hit-Tick
    private long lastThornsTick = -1000;
    public SpikeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        
    }
   private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(SpikeEntity.class, EntityDataSerializers.BOOLEAN);
            
    public SpikeEntity(Level pLevel) {
        this(ModEntities.SPIKE.get(), pLevel);
     }


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
             attackAnimationTimeout = 20; // Length in ticks of your animation
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
        this.goalSelector.addGoal(2, new SpikeAttackGoal(this, 1.5D, true));

    }
    //Rework later and look at guardian code
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean took = super.hurt(source, amount);
        if (!level().isClientSide && took && amount > 0.0F) {
            var attacker = source.getEntity();
            if (attacker instanceof LivingEntity livingAttacker) {

                // kleiner Cooldown, um Schleifen zu vermeiden
                long now = this.level().getGameTime();
                if (now - lastThornsTick >= THORNS_COOLDOWN_TICKS) {

                        // Schaden 1–4 (wie Thorns)
                        int dmg = 1 + this.getRandom().nextInt(4);
                        livingAttacker.hurt(this.level().damageSources().thorns(this), dmg);
                        lastThornsTick = now;
                        // Optional: Sound/Partikel
                        this.playHurtSound(source);
                    
                }
            }
        }

        return took;
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
        .add(Attributes.FOLLOW_RANGE, 35.0D)
        .add(Attributes.MOVEMENT_SPEED, (double)0.23F)
        .add(Attributes.ATTACK_DAMAGE, 3.0D)
        .add(Attributes.ARMOR, 3.0D)
        .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
     
}