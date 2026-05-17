package net.diverginglensestudios.undeadremains.util;

import net.minecraft.world.item.ItemStack;

public class ItemSkinUtil {
	public static void setSkin(ItemStack stack, String skin) {
		stack.getOrCreateTag().putString("Skin", skin);
	}

	public static String getSkin(ItemStack stack) {

		if (stack.hasTag() && stack.getTag().contains("Skin")) {
			return stack.getTag().getString("Skin");
		}

		return "default";
	}
}
