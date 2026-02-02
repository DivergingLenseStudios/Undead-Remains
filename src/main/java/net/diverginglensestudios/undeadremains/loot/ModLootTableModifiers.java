/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.loot;

import com.mojang.serialization.Codec;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.loot.modifiers.AddSusSandItemModifier;
import net.diverginglensestudios.undeadremains.loot.modifiers.SmeltModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTableModifiers {
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UndeadRemains.MOD_ID);

	public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_SUS_SAND_ITEM = LOOT_MODIFIER_SERIALIZERS
			.register("add_sus_sand_item", AddSusSandItemModifier.CODEC);
	public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SMELT_BLOCK_DROPS = LOOT_MODIFIER_SERIALIZERS
			.register("smelt_modifier", () -> SmeltModifier.CODEC);

	public static void register(IEventBus eventBus) {
		LOOT_MODIFIER_SERIALIZERS.register(eventBus);
	}
}
