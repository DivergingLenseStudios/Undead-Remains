/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.CowZombie;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.CowZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CowZombieRenderer extends MobRenderer<CowZombieEntity, CowZombieModel<CowZombieEntity>> {
	public CowZombieRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CowZombieModel<>(pContext.bakeLayer(ModModelLayers.COW_ZOMBIE_LAYER)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(CowZombieEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/cow_zombie.png");
	}

	@Override
	public void render(CowZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}