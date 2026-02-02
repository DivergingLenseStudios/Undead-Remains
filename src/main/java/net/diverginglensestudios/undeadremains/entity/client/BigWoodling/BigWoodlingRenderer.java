/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.BigWoodling;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.BigWoodlingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BigWoodlingRenderer extends MobRenderer<BigWoodlingEntity, BigWoodlingModel<BigWoodlingEntity>> {
	public BigWoodlingRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new BigWoodlingModel<>(pContext.bakeLayer(ModModelLayers.BIG_WOODLING_LAYER)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(BigWoodlingEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/tree_zombie.png");
	}

	@Override
	public void render(BigWoodlingEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}