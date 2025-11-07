/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.horned_xanarian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.HornedXanarianEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HornedXanarianRenderer extends MobRenderer<HornedXanarianEntity, HornedXanarianModel<HornedXanarianEntity>> {
    public HornedXanarianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HornedXanarianModel<>(pContext.bakeLayer(ModModelLayers.HORNED_XANARIAN_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HornedXanarianEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/horned_xanarian.png");
    }

    @Override
    public void render(HornedXanarianEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}