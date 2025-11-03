package net.diverginglensestudios.undeadremains.entity.client.SupremeZombie;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SupremeZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SupremeZombieRenderer extends MobRenderer<SupremeZombieEntity, SupremeZombieModel<SupremeZombieEntity>> {
    public SupremeZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SupremeZombieModel<>(pContext.bakeLayer(ModModelLayers.SUPREME_ZOMBIE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SupremeZombieEntity pEntity) {
        return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/supreme_zombie.png");
    }

    @Override
    public void render(SupremeZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

