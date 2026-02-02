/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.TreeZombie;

import com.mojang.blaze3d.vertex.PoseStack;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.TreeZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TreeZombieRenderer extends MobRenderer<TreeZombieEntity, TreeZombieModel<TreeZombieEntity>> {
	public TreeZombieRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new TreeZombieModel<>(pContext.bakeLayer(ModModelLayers.TREE_ZOMBIE_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TreeZombieEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/tree_zombie.png");
	}

	@Override
	public void render(TreeZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}

