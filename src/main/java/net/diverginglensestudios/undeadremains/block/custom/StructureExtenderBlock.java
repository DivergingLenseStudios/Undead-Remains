package net.diverginglensestudios.undeadremains.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class StructureExtenderBlock extends Block {

	private static final int MAX_DISTANCE = 300;

	public StructureExtenderBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!level.isClientSide) {
			level.scheduleTick(pos, this, 1);
		}
		super.onPlace(state, level, pos, oldState, isMoving);
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

		BlockState aboveState = level.getBlockState(pos.above());
		BlockState belowState = level.getBlockState(pos.below());

		if (level.hasNeighborSignal(pos)){
			return;
		}
		else if (isSolid(level, pos.above())) {
			extend(level, pos, Direction.DOWN, aboveState);
		}
		else if (isSolid(level, pos.below())) {
			extend(level, pos, Direction.UP, belowState);
		}
	}

	private void extend(ServerLevel level, BlockPos startPos, Direction direction, BlockState fillState) {

		BlockPos.MutableBlockPos checkPos = startPos.mutable();
		int distance = 0;

		while (distance < MAX_DISTANCE) {
			checkPos.move(direction);
			distance++;

			if (level.getBlockState(checkPos).isSolid()) {
				break;
			}
		}

		if (distance >= MAX_DISTANCE) {
			return;
		}

		BlockPos.MutableBlockPos placePos = startPos.mutable();

		for (int i = 0; i < distance; i++) {
			level.setBlock(placePos, fillState, 3);
			placePos.move(direction);
		}
	}

	private boolean isSolid(Level level, BlockPos pos) {
		return level.getBlockState(pos).isSolid();
	}
}