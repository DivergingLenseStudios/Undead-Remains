package net.diverginglensestudios.undeadremains.entity.client.Xanarian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class XanarianRenderer extends MobRenderer<XanarianEntity, XanarianModel<XanarianEntity>> {
    public XanarianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new XanarianModel<>(pContext.bakeLayer(ModModelLayers.XANARIAN_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(XanarianEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/xanarian.png");
    }

    @Override
    public void render(XanarianEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}