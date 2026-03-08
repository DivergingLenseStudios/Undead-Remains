/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.Sucker;

import com.mojang.blaze3d.vertex.PoseStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.SuckerEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuckerRenderer extends MobRenderer<SuckerEntity, SuckerModel<SuckerEntity>> {
	public SuckerRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SuckerModel<>(pContext.bakeLayer(ModModelLayers.SUCKER_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SuckerEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/sucker.png");
	}

	@Override
	public void render(SuckerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
	                   MultiBufferSource pBuffer, int pPackedLight) {

		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}