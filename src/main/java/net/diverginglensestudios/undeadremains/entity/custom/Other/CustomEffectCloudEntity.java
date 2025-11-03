package net.diverginglensestudios.undeadremains.entity.custom.Other;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

public class CustomEffectCloudEntity extends AreaEffectCloud{

    private float customHeight;
    
        public CustomEffectCloudEntity(EntityType<? extends AreaEffectCloud> pEntityType, Level pLevel) {
            super(pEntityType, pLevel);
        }
        public CustomEffectCloudEntity(Level pLevel, double pX, double pY, double pZ) {
            this(ModEntities.CUSTOMEFFECTCLOUD.get(), pLevel);
            this.setPos(pX, pY, pZ);
        }
    
        @Override
        protected void defineSynchedData() {
            super.defineSynchedData();
            customHeight= 0.5f;
    }
    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        return EntityDimensions.scalable(this.getRadius() * 2.0F, customHeight);
    }

    // Method to set custom dimensions
    public void setDimensions(float radius, float height) {
        this.setRadius(radius);
        this.customHeight = height;
        this.refreshDimensions(); // Ensures the hitbox updates properly
    }

}