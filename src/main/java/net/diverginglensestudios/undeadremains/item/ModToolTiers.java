/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
	public static final Tier FOSSIL = TierSortingRegistry.registerTier(
			// numbers mean level,uses,speed,attaackdamagebonus,enchantmentvalue
			new ForgeTier(2, 200, 5f, 0f, 15,
					ModTags.Blocks.NEEDS_FOSSIL_TOOL, () -> Ingredient.of(ModItems.FOSSIL.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "fossil"), List.of(Tiers.IRON), List.of());
	public static final Tier RARE_FOSSIL = TierSortingRegistry.registerTier(
			new ForgeTier(5, 2000, 12f, 0f, 25,
					ModTags.Blocks.NEEDS_FOSSIL_TOOL,
					() -> Ingredient.of(ModItems.RARE_FOSSIL.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "rare_fossil"), List.of(Tiers.NETHERITE), List.of());
	public static final Tier METATORBERNITE = TierSortingRegistry.registerTier(
			new ForgeTier(3, 1200, 7f, 0f, 25,
					ModTags.Blocks.NEEDS_METATORBERNITE_TOOL,
					() -> Ingredient.of(ModItems.METATORBERNITE.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite"), List.of(Tiers.IRON), List.of());
	public static final Tier LANGRITE = TierSortingRegistry.registerTier(
			new ForgeTier(4, 1750, 10f, 0, 13,
					ModTags.Blocks.NEEDS_LANGRITE_TOOL,
					() -> Ingredient.of(ModItems.LANGRITE_INGOT.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "langrite"), List.of(Tiers.NETHERITE), List.of());
	public static final Tier SPIKE = TierSortingRegistry.registerTier(
			new ForgeTier(2, 500, 4f, 0, 10,
					ModTags.Blocks.NEEDS_SPIKE_TOOL, () -> Ingredient.of(ModItems.SPIKE.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "spike"), List.of(Tiers.STONE), List.of());
	public static final Tier MODIFIED_FOSSIL = TierSortingRegistry.registerTier(
			new ForgeTier(2, 500, 6f, 0, 10,
					ModTags.Blocks.NEEDS_MODIFIED_FOSSIL_TOOL,
					() -> Ingredient.of(ModItems.FOSSIL.get())),
			new ResourceLocation(UndeadRemains.MOD_ID, "modified_fossil"), List.of(Tiers.DIAMOND),
			List.of());
}
