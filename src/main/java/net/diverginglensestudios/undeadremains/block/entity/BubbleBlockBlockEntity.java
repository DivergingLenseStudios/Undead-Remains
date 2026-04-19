package net.diverginglensestudios.undeadremains.block.entity;

import java.util.List;

import net.diverginglensestudios.undeadremains.entity.custom.Other.BubbleBlockBubbleProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class BubbleBlockBlockEntity extends BlockEntity {

    private int cooldown = 0;

    public BubbleBlockBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BUBBLE_BLOCK_BE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BubbleBlockBlockEntity be) {
        if (level.isClientSide)
            return;

        if (be.cooldown > 0) {
            be.cooldown--;
            return;
        }

        // Area: directly above block (10 blocks high)
        AABB box = new AABB(
                pos.getX(), pos.getY() + 1, pos.getZ(),
                pos.getX() + 1, pos.getY() + 11, pos.getZ() + 1);

        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, box);

        if (!targets.isEmpty()) {
            LivingEntity target = targets.get(0); // pick first

            // Create projectile
            BubbleBlockBubbleProjectileEntity projectile = new BubbleBlockBubbleProjectileEntity(level);

            projectile.setPos(
                    pos.getX() + 0.5,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5);

            // Direction toward target
            double dx = target.getX() - projectile.getX();
            double dy = target.getY(0.5) - projectile.getY();
            double dz = target.getZ() - projectile.getZ();

            projectile.shoot(dx, dy, dz, 1.5F, 0F);

            level.addFreshEntity(projectile);

            be.cooldown = 20;
        }
    }
}