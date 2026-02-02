/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.tree.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.diverginglensestudios.undeadremains.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class CreeperTrunkPlacer extends TrunkPlacer {
	public static final Codec<CreeperTrunkPlacer> CODEC = RecordCodecBuilder.create(creeperTrunkPlacerInstance ->
			trunkPlacerParts(creeperTrunkPlacerInstance).apply(creeperTrunkPlacerInstance, CreeperTrunkPlacer::new));

	public CreeperTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
		super(pBaseHeight, pHeightRandA, pHeightRandB);
	}

	@Override
	protected boolean validTreePos(LevelSimulatedReader level, BlockPos pos) {
		return IntStream.range(3, 4).allMatch(offset ->
				level.isStateAtPosition(pos.below(offset), state ->
						state.isAir() || state.is(BlockTags.REPLACEABLE_BY_TREES)
				)
		);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return ModTrunkPlacerTypes.CREEPER_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(
			LevelSimulatedReader level,
			BiConsumer<BlockPos, BlockState> replacer,
			RandomSource random,
			int height,
			BlockPos pos,
			TreeConfiguration config
	) {
		List<FoliagePlacer.FoliageAttachment> attachments = new ArrayList<>();
		BlockPos.MutableBlockPos current = pos.mutable();

		for (int i = 0; i < height; ++i) {
			replacer.accept(current, config.trunkProvider.getState(random, current));
			current.move(Direction.DOWN);
		}

		// Add foliage at the bottom
		attachments.add(new FoliagePlacer.FoliageAttachment(current.above(), 0, false));
		return attachments;
	}
}