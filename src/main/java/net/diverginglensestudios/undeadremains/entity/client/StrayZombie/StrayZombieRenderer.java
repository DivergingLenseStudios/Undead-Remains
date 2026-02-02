/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.StrayZombie;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.StrayZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StrayZombieRenderer extends MobRenderer<StrayZombieEntity, StrayZombieModel<StrayZombieEntity>> {
	public StrayZombieRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new StrayZombieModel<>(pContext.bakeLayer(ModModelLayers.STRAY_ZOMBIE_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StrayZombieEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/stray_zombie.png");
	}

	@Override
	public void render(StrayZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}