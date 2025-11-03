package net.diverginglensestudios.undeadremains.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.diverginglensestudios.undeadremains.worldgen.tree.ModFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class CalipoFoliagePlacer extends FoliagePlacer {
    public static final Codec<CalipoFoliagePlacer> CODEC = RecordCodecBuilder.create(calipoFoliagePlacerInstance
            -> foliagePlacerParts(calipoFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(calipoFoliagePlacerInstance, CalipoFoliagePlacer::new));
    private final int height;

    public CalipoFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.CALIPO_FOLIAGE_PLACER.get();
    }

    @Override
protected void createFoliage(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                             TreeConfiguration config, int maxTreeHeight, FoliageAttachment attachment,
                             int foliageHeight, int foliageRadius, int offset) {

    BlockPos basePos = attachment.pos().above(offset);
    boolean doubleTrunk = attachment.doubleTrunk();

    for (int y = 0; y < this.height; y++) {
        BlockPos layerPos = basePos.above(y);
        int patternLayer = y % 4;

        switch (patternLayer) {
            case 0 -> placeSquareLayer(level, setter, random, config, layerPos);
            case 1 -> placeDiamondLayer(level, setter, random, config, layerPos);
            case 2 -> placeSquareLayer(level, setter, random, config, layerPos);
            case 3 -> placeCrossLayer(level, setter, random, config, layerPos);
        }
    }
}
 private void placeSquareLayer(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                              TreeConfiguration config, BlockPos center) {
    for (int dx = -1; dx <= 1; dx++) {
        for (int dz = -1; dz <= 1; dz++) {
            tryPlaceLeaf(level, setter, random, config, center.offset(dx, -(height-2), dz));
        }
    }
}

   private void placeDiamondLayer(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                               TreeConfiguration config, BlockPos center) {
    for (int dx = -2; dx <= 2; dx++) {
        for (int dz = -2; dz <= 2; dz++) {
            if (Math.abs(dx) + Math.abs(dz) <= 2) {
                tryPlaceLeaf(level, setter, random, config, center.offset(dx, -(height-2), dz));
            }
        }
    }
}

    private void placeCrossLayer(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                             TreeConfiguration config, BlockPos center) {
    tryPlaceLeaf(level, setter, random, config, center.offset( 1, -(height-2),  0));
    tryPlaceLeaf(level, setter, random, config, center.offset(-1, -(height-2),  0));
    tryPlaceLeaf(level, setter, random, config, center.offset(0, -(height-2),  0));
    tryPlaceLeaf(level, setter, random, config, center.offset( 0, -(height-2),  1));
    tryPlaceLeaf(level, setter, random, config, center.offset( 0, -(height-2), -1));
}

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
            return pLocalX == 0 && pLocalZ == 0;
    }
}