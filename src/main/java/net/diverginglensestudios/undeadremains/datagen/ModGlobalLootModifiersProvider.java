/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.loot.modifiers.AddItemModifier;
import net.diverginglensestudios.undeadremains.loot.modifiers.AddSusSandItemModifier;
import net.diverginglensestudios.undeadremains.loot.modifiers.SmeltModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, UndeadRemains.MOD_ID);
    }

    @Override
    protected void start() {

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build() },
                ModItems.FOSSIL.get()));

        this.add("smelt", new SmeltModifier(new LootItemCondition[0]));

    }
}
