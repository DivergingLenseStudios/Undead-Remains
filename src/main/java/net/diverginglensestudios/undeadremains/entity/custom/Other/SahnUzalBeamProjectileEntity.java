package net.diverginglensestudios.undeadremains.entity.custom.Other;

/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SahnUzalBeamProjectileEntity extends ThrowableItemProjectile {

	public SahnUzalBeamProjectileEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
		super(type, level);
	}

	public SahnUzalBeamProjectileEntity(Level level) {
		super(ModEntities.BUBBLE_BLOCK_BUBBLE_PROJECTILE.get(), level);
	}

	public SahnUzalBeamProjectileEntity(Level level, LivingEntity shooter) {
		super(ModEntities.BUBBLE_BLOCK_BUBBLE_PROJECTILE.get(), shooter, level);
	}

	@Override
	protected Item getDefaultItem() {
		return ModItems.BEAM.get();
	}

	@Override
	public boolean isNoGravity() {
		return true;
	}

	@Override
	protected float getGravity() {
		return 0.0F;
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

		if (target instanceof LivingEntity living) {
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
