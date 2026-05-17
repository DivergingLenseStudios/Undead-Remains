package net.diverginglensestudios.undeadremains.recipe;

import com.google.gson.JsonObject;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.util.ItemSkinUtil;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ItemSkinRecipe implements Recipe<Container> {

	public static final ResourceLocation ID =
			new ResourceLocation("undeadremains", "item_skinning");

	private final Ingredient base;
	private final Ingredient addition;

	public ItemSkinRecipe(Ingredient base, Ingredient addition) {
		this.base = base;
		this.addition = addition;
	}

	@Override
	public boolean matches(Container container, Level level) {

		return base.test(container.getItem(0))
				&& addition.test(container.getItem(1));
	}

	@Override
	public ItemStack assemble(Container container, RegistryAccess registryAccess) {

		ItemStack result = container.getItem(0).copy();

		ItemSkinUtil.setSkin(result, "low_pixel");

		return result;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return new ItemStack(ModItems.HARVESTER.get());
	}

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.ITEM_SKIN_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ItemSkinRecipeType.TYPE;
	}

	public static class Serializer implements RecipeSerializer<ItemSkinRecipe> {

		@Override
		public ItemSkinRecipe fromJson(ResourceLocation id, JsonObject json) {

			Ingredient base =
					Ingredient.fromJson(json.get("base"));

			Ingredient addition =
					Ingredient.fromJson(json.get("addition"));

			return new ItemSkinRecipe(base, addition);
		}

		@Override
		public ItemSkinRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {

			Ingredient base = Ingredient.fromNetwork(buf);
			Ingredient addition = Ingredient.fromNetwork(buf);

			return new ItemSkinRecipe(base, addition);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, ItemSkinRecipe recipe) {

			recipe.base.toNetwork(buf);
			recipe.addition.toNetwork(buf);
		}
	}
}