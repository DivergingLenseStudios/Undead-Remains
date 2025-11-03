package net.diverginglensestudios.undeadremains.entity.client.HammerZombie;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.HammerZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HammerZombieRenderer extends MobRenderer<HammerZombieEntity, HammerZombieModel<HammerZombieEntity>> {
    public HammerZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HammerZombieModel<>(pContext.bakeLayer(ModModelLayers.HAMMER_ZOMBIE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HammerZombieEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/hammer_zombie.png");
    }

    @Override
    public void render(HammerZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}