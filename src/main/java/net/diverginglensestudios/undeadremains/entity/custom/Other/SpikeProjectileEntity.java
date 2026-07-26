/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Other;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SpikeEntity;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SpikeProjectileEntity extends ThrowableItemProjectile {

    public SpikeProjectileEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public SpikeProjectileEntity(Level level) {
        super(ModEntities.SPIKE_PROJECTILE.get(), level);
    }

    public SpikeProjectileEntity(Level level, LivingEntity shooter) {
        super(ModEntities.SPIKE_PROJECTILE.get(), shooter, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPIKE.get();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 100) { // 5 seconds
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        Entity target = result.getEntity();
        Entity owner = this.getOwner();

        if ((target instanceof LivingEntity living) && !(target instanceof SpikeEntity)) {
            living.hurt(this.damageSources().thrown(this, owner), 4.0F);
        }
        this.discard();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        this.discard();
    }
}
