package net.diverginglensestudios.undeadremains.entity.client.XanarianCannibal;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianCannibalEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class XanarianCannibalRenderer extends MobRenderer<XanarianCannibalEntity, XanarianCannibalModel<XanarianCannibalEntity>> {
    public XanarianCannibalRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new XanarianCannibalModel<>(pContext.bakeLayer(ModModelLayers.XANARIAN_CANNIBAL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(XanarianCannibalEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/xanarian_cannibal.png");
    }

    @Override
    public void render(XanarianCannibalEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}