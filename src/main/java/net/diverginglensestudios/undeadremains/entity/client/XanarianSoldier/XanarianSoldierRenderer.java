/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.XanarianSoldier;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianSoldierEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class XanarianSoldierRenderer extends MobRenderer<XanarianSoldierEntity, XanarianSoldierModel<XanarianSoldierEntity>> {
	public XanarianSoldierRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new XanarianSoldierModel<>(pContext.bakeLayer(ModModelLayers.XANARIAN_SOLDIER_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(XanarianSoldierEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/xanarian_soldier.png");
	}

	@Override
	public void render(XanarianSoldierEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}