/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.Sucker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.diverginglensestudios.undeadremains.entity.animations.ModFishAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SuckerModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "sucker"), "main");
	private final ModelPart Sucker;
	private final ModelPart tail;


	public SuckerModel(ModelPart root) {
		this.Sucker = root.getChild("sucker");
		this.tail = this.Sucker.getChild("body").getChild("tail");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sucker = partdefinition.addOrReplaceChild("sucker", CubeListBuilder.create(), PartPose.offset(0.0F, 28.0F, 0.0F));

		PartDefinition body = sucker.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(7.0F, -2.0F, 2.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, -1.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -2.0F, -2.0F));

		PartDefinition fin_right = torso.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(1.0F, -4.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 2.0F, 2.0F));

		PartDefinition trunk = torso.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, -12.0F, -4.0F, 6.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(36, 21).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin_left = torso.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(0, 41).addBox(12.0F, -4.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 2.0F, 2.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 36).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).addBox(-0.5F, -1.0F, 2.5F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 9).addBox(-1.5F, 0.0F, 1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 1.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		float f = 1.0F;
		float f1 = 1.0F;
		if (!pEntity.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}
		this.tail.yRot = -f * 0.25F * Mth.sin(f1 * 0.6F * pAgeInTicks);
		//this.animate(((XanaranhaEntity) pEntity).attackAnimationState, ModFishAnimations.XANARANHA_ATTACK, pAgeInTicks, 1f);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Sucker.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Sucker;
	}
}