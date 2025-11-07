/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.util;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_FOSSIL_TOOL = tag("needs_fossil_tool");
        public static final TagKey<Block> NEEDS_METATORBERNITE_TOOL = tag("needs_metatorbernite_tool");
        public static final TagKey<Block> NEEDS_LANGRITE_TOOL = tag("needs_langrite_tool");
        public static final TagKey<Block> LANGSTONE_REPLACEABLES = tag("langstone_replaceables");
        public static final TagKey<Block> NEEDS_SPIKE_TOOL = tag("needs_spike_tool");
        public static final TagKey<Block> NEEDS_RABBIT_FOOT_MODIFIED_FOSSIL_TOOL = tag("needs_rabbit_foot_modified_tool");
        public static final TagKey<Block> NEEDS_BLAZE_ROD_MODIFIED_FOSSIL_TOOL = tag("needs_blaze_rod_modified_tool");
        public static final TagKey<Block> NEEDS_NAUTILUS_SHELL_MODIFIED_FOSSIL_TOOL = tag("needs_nautilus_shell_modified_tool");
        public static final TagKey<Block> NEEDS_SLIME_BALL_MODIFIED_FOSSIL_TOOL = tag("needs_slime_ball_modified_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(UndeadRemains.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> GAS_MASK = tag("gas_mask");
        public static final TagKey<Item> ASH_WOOD = tag("ash_wood");
        public static final TagKey<Item> CALIPO_WOOD = tag("calipo_wood");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(UndeadRemains.MOD_ID, name));
        }
    }

}
