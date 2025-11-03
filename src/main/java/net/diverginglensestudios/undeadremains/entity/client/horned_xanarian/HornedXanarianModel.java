package net.diverginglensestudios.undeadremains.entity.client.horned_xanarian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.HornedXanarianEntity;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class HornedXanarianModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "horned_xanarian"), "main");
	private final ModelPart HornedXanarian;
	private final ModelPart head;


	public HornedXanarianModel(ModelPart root) {
		this.HornedXanarian = root.getChild("HornedXanarian");
		this.head = this.HornedXanarian.getChild("body").getChild("spine").getChild("torso").getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition HornedXanarian = partdefinition.addOrReplaceChild("HornedXanarian", CubeListBuilder.create(), PartPose.offset(0.0F, -37.0F, -1.0F));

		PartDefinition body = HornedXanarian.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(16, 25).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(16, 25).addBox(-2.0F, -26.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(48, 44).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(56, 60).addBox(-2.0F, -8.0F, 6.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 26).addBox(-2.0F, -22.0F, 6.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 2.0F));

		PartDefinition torso = spine.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 44).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition horn_right = head.addOrReplaceChild("horn_right", CubeListBuilder.create(), PartPose.offset(2.0F, -9.0F, 2.0F));

		PartDefinition cube_r1 = horn_right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 62).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 62).addBox(-10.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition horn_left = head.addOrReplaceChild("horn_left", CubeListBuilder.create(), PartPose.offset(-2.0F, -9.0F, 2.0F));

		PartDefinition cube_r2 = horn_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 62).mirror().addBox(5.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 62).mirror().addBox(7.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition arm_right = torso.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 3.0F, -1.0F));

		PartDefinition arm_left = torso.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 3.0F, -1.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(54, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 60).addBox(-3.0F, 12.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 62).addBox(-3.0F, 36.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 23.0F, 3.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 60).mirror().addBox(1.0F, 12.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(26, 62).mirror().addBox(1.0F, 36.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 23.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.HORNED_XANARIAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((HornedXanarianEntity) entity).attackAnimationState, ModAnimationDefinitions.HORNED_XANARIAN_ATTACK, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		HornedXanarian.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return HornedXanarian;
	}
}