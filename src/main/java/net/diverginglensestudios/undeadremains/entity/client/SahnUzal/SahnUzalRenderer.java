package net.diverginglensestudios.undeadremains.entity.client.SahnUzal;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SahnUzalEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SahnUzalRenderer extends MobRenderer<SahnUzalEntity, SahnUzalModel<SahnUzalEntity>> {
    public SahnUzalRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SahnUzalModel<>(pContext.bakeLayer(ModModelLayers.SAHN_UZAL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SahnUzalEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/sahn_uzal.png");
    }

    @Override
    public void render(SahnUzalEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

