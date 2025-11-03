package net.diverginglensestudios.undeadremains.entity.client.Spike;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SpikeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpikeRenderer extends MobRenderer<SpikeEntity, SpikeModel<SpikeEntity>> {
    public SpikeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SpikeModel<>(pContext.bakeLayer(ModModelLayers.SPIKE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpikeEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/spike.png");
    }

    @Override
    public void render(SpikeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}