package net.diverginglensestudios.undeadremains.entity.client.SmallWoodling;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SmallWoodlingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SmallWoodlingRenderer extends MobRenderer<SmallWoodlingEntity, SmallWoodlingModel<SmallWoodlingEntity>> {
    public SmallWoodlingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SmallWoodlingModel<>(pContext.bakeLayer(ModModelLayers.SMALL_WOODLING_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(SmallWoodlingEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/tree_zombie.png");
    }

    @Override
    public void render(SmallWoodlingEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}