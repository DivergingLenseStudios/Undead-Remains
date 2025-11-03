package net.diverginglensestudios.undeadremains.entity.custom.Other;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.particles.ModParticles;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class MetatorberniteGrenadeProjectileEntity extends ThrowableItemProjectile {
   public MetatorberniteGrenadeProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
       super(pEntityType, pLevel);
   }

   public MetatorberniteGrenadeProjectileEntity(Level pLevel) {
       super(ModEntities.METATORBERNITE_GRENADE_PROJECTILE.get(), pLevel);
   }

   public MetatorberniteGrenadeProjectileEntity(Level pLevel, LivingEntity livingEntity) {
       super(ModEntities.METATORBERNITE_GRENADE_PROJECTILE.get(), livingEntity, pLevel);
   }

   @Override
   protected Item getDefaultItem() {
       return ModItems.METATORBERNITE_GRENADE.get();
   }

   @Override
   protected void onHitBlock(BlockHitResult pResult) {
  CustomEffectCloudEntity areaEffectCloud = new CustomEffectCloudEntity(this.level(),
        this.getX(),
        this.getY(),
        this.getZ());

        areaEffectCloud.setRadius(3.0F);
        areaEffectCloud.setRadiusOnUse(-0.5F);
        areaEffectCloud.setWaitTime(10);
        areaEffectCloud.setDuration(200); // Duration in ticks (10 seconds)
        areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / areaEffectCloud.getDuration());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
        areaEffectCloud.setParticle(ModParticles.METATORBERNITE_PARTICLES.get());
        areaEffectCloud.setDimensions(3F, 2F);
        this.level().addFreshEntity(areaEffectCloud);
        this.level().playSound(null, areaEffectCloud, SoundEvents.GLASS_BREAK, getSoundSource(), 1f, 1f);

       this.discard();
       super.onHitBlock(pResult);
   }
}
