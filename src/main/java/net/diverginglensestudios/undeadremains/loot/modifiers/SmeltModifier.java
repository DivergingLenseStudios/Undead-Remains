/***********************************************************/
/*       This file was copied from Kapitencraft            */
/*          https://github.com/Kapitencraft                */
/***********************************************************/

package net.diverginglensestudios.undeadremains.loot.modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.diverginglensestudios.undeadremains.helpers.LootTableHelper;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.loot.IConditional;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class SmeltModifier extends ModLootModifier implements IConditional {
	public static final Codec<SmeltModifier> CODEC = LootTableHelper.simpleCodec(SmeltModifier::new);
	private LootContext context = null;

	public SmeltModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
														  LootContext context) {
		LivingEntity source = LootTableHelper.getLivingSource(context);
		if (source != null && source.getMainHandItem().is(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get())) {
			context.getLevel().getProfiler().push("smelt modifier");
			this.context = context;
			generatedLoot = new ObjectArrayList<>(generatedLoot.stream().map(this::run).toList());
			this.context = null;
			context.getLevel().getProfiler().pop();
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	private ItemStack run(ItemStack unSmelt) {
		if (!unSmelt.isEmpty()) {
			Optional<SmeltingRecipe> optional = context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING,
					new SimpleContainer(unSmelt), context.getLevel());
			if (optional.isPresent()) {
				ItemStack itemstack = optional.get().getResultItem(context.getLevel().registryAccess());
				if (!itemstack.isEmpty()) {
					ItemStack itemstack1 = itemstack.copy();
					itemstack1.setCount(unSmelt.getCount() * itemstack.getCount());
					return itemstack1;
				}
			}
		}
		return unSmelt;
	}

}