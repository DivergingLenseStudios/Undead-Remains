/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.worldgen.dimension.ModDimensions;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

	public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
			ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper,
				List.of(new ModAdvancementProvider.UndeadremainsAdvancementGenerator()));
	}

	public static class UndeadremainsAdvancementGenerator implements AdvancementGenerator {

		@Override
		public void generate(HolderLookup.Provider registries,
				Consumer<Advancement> saver,
				ExistingFileHelper existingFileHelper) {

			Advancement root = Advancement.Builder.advancement()
					.display(
							ModItems.FOSSIL.get(),
							Component.translatable("advancement.undeadremains.root.title"),
							Component.translatable("advancement.undeadremains.root.desc"),
							new ResourceLocation(UndeadRemains.MOD_ID, "textures/block/fossil_block.png"),
							FrameType.TASK,
							true,
							true,
							false)
					.addCriterion("entered_world", PlayerTrigger.TriggerInstance.tick())
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "root"), existingFileHelper);

			//↓////////FOSSIL////////↓//
			Advancement fossil = Advancement.Builder.advancement()
					.parent(root)
					.display(
							ModItems.FOSSIL.get(),
							Component.translatable("advancement.undeadremains.fossil.title"),
							Component.translatable("advancement.undeadremains.fossil.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)
					.addCriterion("has_fossil", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "fossil"), existingFileHelper);

			//↓////////FOSSIL_TOOLS////////↓//
			Advancement fossil_tools = Advancement.Builder.advancement()
					.parent(fossil) // your Fossil advancement reference
					.display(
							ModItems.FOSSIL_SWORD.get(),
							Component.translatable("advancement.undeadremains.fossil_tools.title"),
							Component.translatable("advancement.undeadremains.fossil_tools.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)
					.addCriterion("craft_sword",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_SWORD.get()))

					.addCriterion("craft_pickaxe",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_PICKAXE.get()))

					.addCriterion("craft_axe",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_AXE.get()))

					.addCriterion("craft_shovel",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_SHOVEL.get()))

					.addCriterion("craft_hoe",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_HOE.get()))

					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "fossil_tools"),
							existingFileHelper);

			//↓////////MODIFIED_FOSSIL_TOOLS////////↓//
			Advancement modified_fossil_tools = Advancement.Builder.advancement()
					.parent(fossil_tools) // your Fossil advancement reference
					.display(
							ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get(),
							Component.translatable("advancement.undeadremains.modified_fossil_tools.title"),
							Component.translatable("advancement.undeadremains.modified_fossil_tools.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("craft_modified_sword",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get()))

					.addCriterion("craft_modified_pickaxe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get()))

					.addCriterion("craft_modified_axe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE.get()))

					.addCriterion("craft_modified_shovel",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL.get()))

					.addCriterion("craft_modified_hoe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE.get()))

					.requirements(RequirementsStrategy.OR)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "modified_fossil_tools"),
							existingFileHelper);
			//↑//////// MODIFIED_FOSSIL_TOOLS////////↑//
			//↑//////// FOSSIL_TOOLS////////↑//

			//↓//////// FOSSIL_ARMOR//////////
			Advancement fossil_armor = Advancement.Builder.advancement()
					.parent(fossil) // your Fossil advancement reference
					.display(
							ModItems.FOSSIL_CHESTPLATE.get(),
							Component.translatable("advancement.undeadremains.fossil_armor.title"),
							Component.translatable("advancement.undeadremains.fossil_armor.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)
					.addCriterion("craft_helmet",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_HELMET.get()))

					.addCriterion("craft_chestplate",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_CHESTPLATE.get()))

					.addCriterion("craft_leggings",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_LEGGINGS.get()))

					.addCriterion("craft_boots",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOSSIL_BOOTS.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "fossil_armor"),
							existingFileHelper);

			//↓//////// MODIFIED_FOSSIL_ARMOR////////↓//
			Advancement modified_fossil_armor = Advancement.Builder.advancement()
					.parent(fossil_armor) // your Fossil advancement reference
					.display(
							ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get(),
							Component.translatable("advancement.undeadremains.modified_fossil_armor.title"),
							Component.translatable("advancement.undeadremains.modified_fossil_armor.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("craft_modified_helmet",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET.get()))

					.addCriterion("craft_modified_chestplate",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get()))

					.addCriterion("craft_modified_leggings",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get()))

					.addCriterion("craft_modified_boots",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.ECHO_SHARD_MODIFIED_FOSSIL_BOOTS.get()))
					.requirements(RequirementsStrategy.OR)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "modified_fossil_armor"),
							existingFileHelper);
			//↑//////// MODIFIED_FOSSIL_ARMOR////////↑//
			//↑//////// FOSSIL_ARMOR//////////

			//↓//////// MASTER_MODIFIER//////////
			Advancement master_modifier = Advancement.Builder.advancement()
					.parent(fossil) // your Fossil advancement reference
					.display(
							ModItems.THE_QUARTZ_MODIFIED_FOSSILS_EYE.get(),
							Component.translatable("advancement.undeadremains.master_modifier.title"),
							Component.translatable("advancement.undeadremains.master_modifier.desc"),
							null,
							FrameType.CHALLENGE,
							true,
							true,
							false)
					.addCriterion("craft_modified_helmet",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET.get()))
					.addCriterion("craft_modified_chestplate",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get()))
					.addCriterion("craft_modified_leggings",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get()))
					.addCriterion("craft_modified_boots",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.ECHO_SHARD_MODIFIED_FOSSIL_BOOTS.get()))
					.addCriterion("craft_modified_sword",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get()))
					.addCriterion("craft_modified_pickaxe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get()))
					.addCriterion("craft_modified_axe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE.get()))
					.addCriterion("craft_modified_shovel",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL.get()))
					.addCriterion("craft_modified_hoe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE.get()))
					.addCriterion("craft_modified_fossils_eye",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.THE_QUARTZ_MODIFIED_FOSSILS_EYE.get()))
					.addCriterion("craft_modified_drumstick",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK.get()))

					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "master_modifier"),
							existingFileHelper);
			//↑//////// MASTER_MODIFIER////////↑//

			//↓//////// RARE_FOSSIL////////↓//
			Advancement rare_fossil = Advancement.Builder.advancement()
					.parent(fossil)
					.display(
							ModItems.RARE_FOSSIL.get(),
							Component.translatable("advancement.undeadremains.rare_fossil.title"),
							Component.translatable("advancement.undeadremains.rare_fossil.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)

					.addCriterion("get_rare_fossil",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL.get()))
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "rare_fossil"),
							existingFileHelper);

			//↓//////// FOSSIL_LUCKY_BLOCK////////↓//
			Advancement fossil_lucky_block = Advancement.Builder.advancement()
					.parent(rare_fossil)
					.display(
							ModBlocks.FOSSIL_LUCKY_BLOCK.get(),
							Component.translatable("advancement.undeadremains.fossil_lucky_block.title"),
							Component.translatable("advancement.undeadremains.fossil_lucky_block.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)

					.addCriterion("get_fossil_lucky_block",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModBlocks.FOSSIL_LUCKY_BLOCK.get()))
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "fossil_lucky_block"),
							existingFileHelper);
			//↓//////// RARE_FOSSIL_ARMOR////////↓//
			Advancement rare_fossil_armor = Advancement.Builder.advancement()
					.parent(fossil_lucky_block) 
					.display(
							ModItems.RARE_FOSSIL_CHESTPLATE.get(),
							Component.translatable("advancement.undeadremains.rare_fossil_armor.title"),
							Component.translatable("advancement.undeadremains.rare_fossil_armor.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("get_rare_fossil_helmet",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_HELMET.get()))

					.addCriterion("get_rare_fossil_chestplate",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_CHESTPLATE.get()))

					.addCriterion("get_rare_fossil_leggings",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_LEGGINGS.get()))

					.addCriterion("get_rare_fossil_boots",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_BOOTS.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "rare_fossil_armor"),
							existingFileHelper);
			//↑//////// RARE_FOSSIL_ARMOR////////↑//
			
			//↓//////// RARE_FOSSIL_TOOLS////////↓//
			Advancement rare_fossil_tools = Advancement.Builder.advancement()
					.parent(fossil_lucky_block) 
					.display(
							ModItems.RARE_FOSSIL_SWORD.get(),
							Component.translatable("advancement.undeadremains.rare_fossil_tools.title"),
							Component.translatable("advancement.undeadremains.rare_fossil_tools.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("get_rare_fossil_sword",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_SWORD.get()))

					.addCriterion("get_rare_fossil_axe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_AXE.get()))

					.addCriterion("get_rare_fossil_pickaxe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_PICKAXE.get()))

					.addCriterion("get_rare_fossil_hoe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_HOE.get()))

					.addCriterion("get_rare_fossil_shovel",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.RARE_FOSSIL_SHOVEL.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "rare_fossil_tools"),
							existingFileHelper);
			//↑//////// RARE_FOSSIL_TOOLS////////↑//
			//↑//////// FOSSIL_LUCKY_BLOCK////////↑//
			//↑//////// RARE_FOSSIL////////↑//
			//↑//////// FOSSIL////////↑//

			//↓//////// METATORBERNITE////////↓//
			Advancement metatorbernite = Advancement.Builder.advancement()
					.parent(root)
					.display(
							ModItems.METATORBERNITE.get(),
							Component.translatable("advancement.undeadremains.metatorbernite.title"),
							Component.translatable("advancement.undeadremains.metatorbernite.desc"),
							null,
							FrameType.TASK,
							true,
							true,
							false)
					.addCriterion("has_metatorbernite",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METATORBERNITE.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite"), existingFileHelper);
			//↓//////// METATORBERNITE_ARMOR////////↓//
			Advancement metatorbernite_armor = Advancement.Builder.advancement()
					.parent(metatorbernite) 
					.display(
							ModItems.METATORBERNITE_CHESTPLATE.get(),
							Component.translatable("advancement.undeadremains.metatorbernite_armor.title"),
							Component.translatable("advancement.undeadremains.metatorbernite_armor.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)
					.addCriterion("craft_metatorbernite_helmet",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_HELMET.get()))

					.addCriterion("craft_metatorbernite_chestplate",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_CHESTPLATE.get()))

					.addCriterion("craft_metatorbernite_leggings",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_LEGGINGS.get()))

					.addCriterion("craft_metatorbernite_boots",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_BOOTS.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite_armor"),
							existingFileHelper);
			//↑//////// METATORBERNITE_ARMOR////////↑//

			//↓//////// METATORBERNITE_TOOLS////////↓//
			Advancement metatorbernite_tools = Advancement.Builder.advancement()
					.parent(metatorbernite) 
					.display(
							ModItems.METATORBERNITE_SWORDAXE.get(),
							Component.translatable("advancement.undeadremains.metatorbernite_tools.title"),
							Component.translatable("advancement.undeadremains.metatorbernite_tools.desc"),
							null,
							FrameType.TASK,
							true,
							false,
							false)

					.addCriterion("craft_metatorbernite_swordaxe",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_SWORDAXE.get()))

					.addCriterion("craft_metatorbernite_tool",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_TOOL.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite_tools"),
							existingFileHelper);
			//↑//////// METATORBERNITE_TOOLS////////↑//
			
			//↓//////// GAS_MASK//////////↓//
			Advancement gas_mask = Advancement.Builder.advancement()
					.parent(metatorbernite)
					.display(
							ModItems.GAS_MASK.get(),
							Component.translatable("advancement.undeadremains.gas_mask.title"),
							Component.translatable("advancement.undeadremains.gas_mask.desc"),
							null,
							FrameType.TASK,
							true,
							true,
							false)
					.addCriterion("has_gas_mask",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GAS_MASK.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "gas_mask"), existingFileHelper);
			//↓//////// METATORBERNITE_GAS_MASK////////↓//
			Advancement metatorbernite_gas_mask = Advancement.Builder.advancement()
					.parent(gas_mask)
					.display(
							ModItems.METATORBERNITE_GAS_MASK.get(),
							Component.translatable("advancement.undeadremains.metatorbernite_gas_mask.title"),
							Component.translatable("advancement.undeadremains.metatorbernite_gas_mask.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("has_metatorbernite_gas_mask",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METATORBERNITE_GAS_MASK.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite_gas_mask"), existingFileHelper);
			//↑//////// METATORBERNITE_GAS_MASK////////↑//
			//↑//////// GAS_MASK////////↑//

			//↓//////// METATORBERNITE_ENRICHER////////↓//
			Advancement metatorbernite_enricher = Advancement.Builder.advancement()
					.parent(metatorbernite) 
					.display(
							ModItems.METATORBERNITE_ENRICHER_CONTROLLER_ITEM.get(),
							Component.translatable("advancement.undeadremains.metatorbernite_enricher.title"),
							Component.translatable("advancement.undeadremains.metatorbernite_enricher.desc"),
							null,
							FrameType.TASK,
							true,
							true,
							false)
					.addCriterion("craft_metatorbernite_enricher_controller",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_ENRICHER_CONTROLLER_ITEM.get()))

					.addCriterion("craft_metatorbernite_enricher_part",
							InventoryChangeTrigger.TriggerInstance
									.hasItems(ModItems.METATORBERNITE_ENRICHER_PART_ITEM.get()))
					.requirements(RequirementsStrategy.AND)
					.save(saver,
							new ResourceLocation(UndeadRemains.MOD_ID, "metatorbernite_enricher"),
							existingFileHelper);
			//↓//////// METATURBONITE////////↓//
			Advancement metaturbonite = Advancement.Builder.advancement()
					.parent(metatorbernite_enricher)
					.display(
							ModItems.METATURBONITE.get(),
							Component.translatable("advancement.undeadremains.metaturbonite.title"),
							Component.translatable("advancement.undeadremains.metaturbonite.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("has_metaturbonite",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METATURBONITE.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "metaturbonite"), existingFileHelper);
			//↓//////// XANARIAN_GATEWAY////////↓//
			Advancement xanarian_gateway = Advancement.Builder.advancement()
					.parent(metaturbonite)
					.display(
							ModBlocks.FOSSIL_ALTAR.get(),
							Component.translatable("advancement.undeadremains.xanarian_gateway.title"),
							Component.translatable("advancement.undeadremains.xanarian_gateway.desc"),
							null,
							FrameType.TASK,
							true,
							true,
							false)
					.addCriterion("has_xanarian_gateway",
							InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FOSSIL_ALTAR.get()))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "xanarian_gateway"), existingFileHelper);
			//↓//////// XANAS////////↓//
			Advancement xanas = Advancement.Builder.advancement()
					.parent(xanarian_gateway)
					.display(
							ModBlocks.LIVING_LANGSTONE.get(),
							Component.translatable("advancement.undeadremains.xanas.title"),
							Component.translatable("advancement.undeadremains.xanas.desc"),
							null,
							FrameType.GOAL,
							true,
							true,
							false)
					.addCriterion("reach_xanas",
					ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(ModDimensions.FOSSILDIM_LEVEL_KEY))
					.save(saver, new ResourceLocation(UndeadRemains.MOD_ID, "xanas"), existingFileHelper);
			//↑//////// XANAS////////↑//
			//↑//////// XANARIAN_GATEWAY////////↑//
			//↑//////// METATURBONITE////////↑//
			//↑//////// METATORBERNITE_ENRICHER////////↑//
			//↑////////METATORBERNITE////////↑//
		}
	}
}
