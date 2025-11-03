package net.diverginglensestudios.undeadremains.entity.client.Xanarian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
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

public class XanarianModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xanarian"), "main");
	private final ModelPart Xanarian;
	private final ModelPart head;


	public XanarianModel(ModelPart root) {
		this.Xanarian = root.getChild("Xanarian");
		this.head = this.Xanarian.getChild("body").getChild("spine").getChild("torso").getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Xanarian = partdefinition.addOrReplaceChild("Xanarian", CubeListBuilder.create(), PartPose.offset(0.0F, -37.0F, -1.0F));

		PartDefinition body = Xanarian.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(16, 25).addBox(-2.0F, -28.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(48, 44).addBox(-2.0F, -24.0F, 6.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, 2.0F));

		PartDefinition torso = spine.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, -5.0F, 12.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, -2.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 44).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition arm_right = torso.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 7.0F, -2.0F));

		PartDefinition arm_left = torso.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 7.0F, -2.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(16, 62).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 16).addBox(-3.0F, 9.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 16).addBox(-3.0F, 33.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 26.0F, 3.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(16, 62).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(54, 16).mirror().addBox(1.0F, 9.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(62, 16).mirror().addBox(1.0F, 33.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 26.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.XANARIAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((XanarianEntity) entity).attackAnimationState, ModAnimationDefinitions.XANARIAN_ATTACK, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Xanarian.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Xanarian;
	}
}