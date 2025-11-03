package net.diverginglensestudios.undeadremains.worldgen.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class ModFossilTeleporter implements ITeleporter {
    private final BlockPos portalBase;
    private Block portalBlock;

    public ModFossilTeleporter(BlockPos portalBase, Block portalBlock) {
        this.portalBase = portalBase;
        this.portalBlock =portalBlock;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(true);

        BlockPos targetPos = new BlockPos(portalBase.getX(), portalBase.getY() + 1, portalBase.getZ());

        // Clear space for the player
        destinationWorld.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
        destinationWorld.setBlock(targetPos.above(), Blocks.AIR.defaultBlockState(), 3);
        destinationWorld.setBlock(targetPos.below(), this.portalBlock.defaultBlockState(), 3);

        entity.setPos(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5);

        return entity;
    }
}

//public class ModFossilTeleporter implements ITeleporter {
//    public static BlockPos thisPos = BlockPos.ZERO;
//    public static boolean insideDimension = true;
//
//    public ModFossilTeleporter(BlockPos pos, boolean insideDim) {
//        thisPos = pos;
//        insideDimension = insideDim;
//    }
//
//    @Override
//    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
//                              float yaw, Function<Boolean, Entity> repositionEntity) {
//        entity = repositionEntity.apply(true);
//        int y = 61;
//
//        if (!insideDimension) {
//            y = thisPos.getY();
//        }
//
//        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());
//
//        int tries = 0;
//        while ((destinationWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
//                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
//                (destinationWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
//                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 100)) {
//            destinationPos = destinationPos.above(2);
//            tries++;
//        }
//
//        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());
//
//        if (insideDimension) {
//            boolean doSetBlock = true;
//            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
//                    destinationPos.above(10).east(10))) {
//                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof FossilAltarBlock) {
//                    doSetBlock = false;
//                    break;
//                }
//            }
//            if (doSetBlock) {
//                destinationWorld.setBlock(destinationPos, ModBlocks.FOSSIL_ALTAR.get().defaultBlockState(), 3);
//            }
//        }
//
//        return entity;
//    }
//}