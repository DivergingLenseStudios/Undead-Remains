package net.diverginglensestudios.undeadremains.worldgen.dimension;

import java.util.List;
import java.util.OptionalLong;
import com.mojang.datafixers.util.Pair;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;


public class ModDimensions {
    public static final ResourceKey<LevelStem> FOSSILDIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
    new ResourceLocation(UndeadRemains.MOD_ID, "fossildim"));
public static final ResourceKey<Level> FOSSILDIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
    new ResourceLocation(UndeadRemains.MOD_ID, "fossildim"));
public static final ResourceKey<DimensionType> FOSSIL_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
    new ResourceLocation(UndeadRemains.MOD_ID, "fossildim_type"));


public static void bootstrapType(BootstapContext<DimensionType> context) {
context.register(FOSSIL_DIM_TYPE, new DimensionType(
        OptionalLong.of(12000), // fixedTime
        false, // hasSkylight
        true, // hasCeiling
        false, // ultraWarm
        false, // natural
        1.0, // coordinateScale
        true, // bedWorks
        false, // respawnAnchorWorks
        -64, // minY
        256, // height
        256, // logicalHeight
        BlockTags.INFINIBURN_OVERWORLD, // infiniburn
        BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
        0.1f, // ambientLight
        new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
}

public static void bootstrapStem(BootstapContext<LevelStem> context) {
HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);


NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
        MultiNoiseBiomeSource.createFromList(
                new Climate.ParameterList<>(List.of(
                        Pair.of(
                                Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CALIPO_FOREST))

                ))),
        noiseGenSettings.getOrThrow(NoiseGeneratorSettings.CAVES));

LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.FOSSIL_DIM_TYPE), noiseBasedChunkGenerator);

context.register(FOSSILDIM_KEY, stem);
}
}
