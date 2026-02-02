/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.tree.custom;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.diverginglensestudios.undeadremains.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class ModStraightTrunkPlacer extends TrunkPlacer{
	private final BlockStateProvider pFloorBlock;
	public static final Codec<ModStraightTrunkPlacer> CODEC = RecordCodecBuilder.create(ModStraightTrunkPlacerInstance ->
			trunkPlacerParts(ModStraightTrunkPlacerInstance).and(BlockStateProvider.CODEC.fieldOf("extra_block").forGetter(p -> p.pFloorBlock)).apply(ModStraightTrunkPlacerInstance, ModStraightTrunkPlacer::new));

	public ModStraightTrunkPlacer(int pBaseHeight, int pRandHeightA, int pRandHeightB, BlockStateProvider pFloorBlock) {
		super(pBaseHeight, pRandHeightA, pRandHeightB );
		this.pFloorBlock = pFloorBlock;
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return ModTrunkPlacerTypes.MOD_STRAIGHT_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pHeight, BlockPos pPos, TreeConfiguration p_226152_) {
		setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), p_226152_);
		for(int i = 0; i < pHeight; ++i) {
			this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), p_226152_);
		}
		/*pBlockSetter.accept(pPos.below(), this.pFloorBlock.getState(pRandom, pPos));*/
		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(pHeight), 0, false));
	}

}
