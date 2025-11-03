package net.diverginglensestudios.undeadremains.entity.client.XanarianCannibal;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
import net.diverginglensestudios.undeadremains.entity.animations.XanarianCannibalAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianCannibalEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;

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

public class XanarianCannibalModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xanarian_cannibal"), "main");
	private final ModelPart XanarianCannibal;
	private final ModelPart head;


	public XanarianCannibalModel(ModelPart root) {
		this.XanarianCannibal = root.getChild("XanarianCannibal");
		this.head = this.XanarianCannibal.getChild("body").getChild("spine").getChild("torso").getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition alien = partdefinition.addOrReplaceChild("XanarianCannibal", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = alien.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 28).addBox(-2.0F, -24.0F, -10.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(64, 36).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(16, 70).addBox(-2.0F, -20.0F, 6.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.0F, 1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition torso = spine.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -2.0F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, -5.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-6.0F, -4.3F, -10.0F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.01F))
		.texOffs(52, 0).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.3F))
		.texOffs(64, 52).addBox(-4.0F, 8.0F, -8.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.31F)), PartPose.offset(0.0F, 7.0F, -7.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 18).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 8.0F, -1.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition arm_right = torso.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(48, 28).mirror().addBox(-4.0F, -2.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 80).mirror().addBox(-4.0F, 42.0F, 2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(80, 63).mirror().addBox(-4.0F, 31.0F, 10.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 7.0F, -4.0F));

		PartDefinition arm_left = torso.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(48, 28).addBox(0.0F, -2.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(80, 63).addBox(0.0F, 31.0F, 10.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 80).addBox(0.0F, 42.0F, 2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 7.0F, -4.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 70).mirror().addBox(-4.0F, -2.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 63).mirror().addBox(-4.0F, 13.0F, 2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -35.0F, 3.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 70).addBox(0.0F, -2.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 63).addBox(0.0F, 13.0F, 2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -35.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(XanarianCannibalAnimations.XANARIAN_CANNIBAL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((XanarianCannibalEntity) entity).attackAnimationState, XanarianCannibalAnimations.XANARIAN_CANNIBAL_ATTACK, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		XanarianCannibal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return XanarianCannibal;
	}
}