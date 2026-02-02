/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.FourEyedXanarian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.FourEyedXanarianEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FourEyedXanarianRenderer extends MobRenderer<FourEyedXanarianEntity, FourEyedXanarianModel<FourEyedXanarianEntity>> {
	public FourEyedXanarianRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FourEyedXanarianModel<>(pContext.bakeLayer(ModModelLayers.FOUR_EYED_XANARIAN_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FourEyedXanarianEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/four_eyed_xanarian.png");
	}

	@Override
	public void render(FourEyedXanarianEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}