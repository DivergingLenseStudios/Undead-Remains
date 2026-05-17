package net.diverginglensestudios.undeadremains.recipe;

import net.minecraft.world.item.crafting.RecipeType;

public class ItemSkinRecipeType {
	public static final ItemSkinRecipeType INSTANCE = new ItemSkinRecipeType();

	public static final RecipeType<ItemSkinRecipe> TYPE =
			RecipeType.simple(ItemSkinRecipe.ID);
}