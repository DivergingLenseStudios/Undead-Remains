package net.diverginglensestudios.undeadremains.block.custom;

import net.diverginglensestudios.undeadremains.block.entity.BubbleBlockBlockEntity;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.entity.StructureExtenderBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BubbleBlock extends BaseEntityBlock {

	public BubbleBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new BubbleBlockBlockEntity(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (pLevel.isClientSide) {
			return null;
		}
		return createTickerHelper(pBlockEntityType, ModBlockEntities.BUBBLE_BLOCK_BE.get(),
				(pLevel1, pPos, pState1, pBlockEntity) -> BubbleBlockBlockEntity
						.tick((net.minecraft.server.level.ServerLevel) pLevel1, pPos, pState1, pBlockEntity));
	}

		@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

}