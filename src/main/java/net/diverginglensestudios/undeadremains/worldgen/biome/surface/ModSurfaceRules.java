/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.biome.surface;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
	private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
	private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource LIVING_LANGSTONE = makeStateRule(ModBlocks.LIVING_LANGSTONE.get());
	private static final SurfaceRules.RuleSource LANGSTONE = makeStateRule(ModBlocks.LANGSTONE.get());


	public static SurfaceRules.RuleSource makeRules() {
		SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

		SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
		SurfaceRules.RuleSource langstoneSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LIVING_LANGSTONE), LANGSTONE);

		return SurfaceRules.sequence(

				// Default to a grass and dirt surface
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface),
				SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CALIPO_FOREST), langstoneSurface)
		);
	}

	private static SurfaceRules.RuleSource makeStateRule(Block block) {
		return SurfaceRules.state(block.defaultBlockState());
	}
}