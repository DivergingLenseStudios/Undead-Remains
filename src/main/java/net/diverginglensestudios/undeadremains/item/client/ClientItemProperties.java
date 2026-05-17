package net.diverginglensestudios.undeadremains.item.client;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.util.ItemSkinUtil;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class ClientItemProperties {

	public static void register() {

		ItemProperties.register(
				ModItems.HARVESTER.get(),
				new ResourceLocation(UndeadRemains.MOD_ID, "skin"),

				(stack, level, entity, seed) -> {

					String skin = ItemSkinUtil.getSkin(stack);

					return switch (skin) {

						case "low_pixel" -> 1f;
						default -> 0f;
					};
				});
	}
}