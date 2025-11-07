/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.SahnUzal;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.diverginglensestudios.undeadremains.entity.animations.SahnUzalAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.SahnUzalEntity;

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

public class SahnUzalModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "sahn_uzal"), "main");
	private final ModelPart sahn_uzal;
	private final ModelPart head;


	public SahnUzalModel(ModelPart root) {
		this.sahn_uzal = root.getChild("sahn_uzal");
		this.head = this.sahn_uzal.getChild("body").getChild("torso_1").getChild("Torso_2").getChild("head");

	}


public static LayerDefinition createBodyLayer() {
	MeshDefinition meshdefinition = new MeshDefinition();
	PartDefinition partdefinition = meshdefinition.getRoot();
	PartDefinition sahn_uzal = partdefinition.addOrReplaceChild("sahn_uzal", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
	PartDefinition body = sahn_uzal.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -43.0F, 2.0F));
	PartDefinition torso_1 = body.addOrReplaceChild("torso_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
	PartDefinition Torso_2 = torso_1.addOrReplaceChild("Torso_2", CubeListBuilder.create().texOffs(134, 48).addBox(-7.0F, -21.0F, -10.0F, 14.0F, 7.0F, 11.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 0.0F, 6.0F));
	PartDefinition chestplate_deco_left_r1 = Torso_2.addOrReplaceChild("chestplate_deco_left_r1", CubeListBuilder.create().texOffs(94, 104).addBox(8.0F, -14.5F, -14.0F, 4.0F, 9.0F, 25.0F, new CubeDeformation(0.0F))
	.texOffs(94, 104).addBox(-10.0F, -14.5F, -14.0F, 4.0F, 9.0F, 25.0F, new CubeDeformation(0.0F))
	.texOffs(0, 67).addBox(-12.0F, -11.5F, -12.0F, 26.0F, 17.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.5F, -3.0F, 0.2618F, 0.0F, 0.0F));
	PartDefinition chest_gem_r1 = Torso_2.addOrReplaceChild("chest_gem_r1", CubeListBuilder.create().texOffs(82, 105).addBox(4.0F, -5.5F, -13.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -3.5F, -3.0F, 0.2618F, 0.0F, 0.0F));
	PartDefinition head = Torso_2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(152, 118).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
	.texOffs(152, 99).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.5F))
	.texOffs(126, 160).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
	.texOffs(82, 111).addBox(-1.0F, -6.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -16.0F, -7.0F));
	PartDefinition arm_right = Torso_2.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(0, 145).addBox(-11.0F, -7.0F, -4.0F, 13.0F, 13.0F, 8.0F, new CubeDeformation(0.01F))
	.texOffs(130, 138).addBox(-12.0F, 6.0F, -5.0F, 13.0F, 12.0F, 10.0F, new CubeDeformation(0.01F)), PartPose.offset(-15.0F, -12.0F, -5.0F));
	PartDefinition Shoulderpad_right = arm_right.addOrReplaceChild("Shoulderpad_right", CubeListBuilder.create().texOffs(152, 66).addBox(-6.0F, -3.0F, -5.0F, 11.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
	.texOffs(48, 170).addBox(-4.0F, -1.0F, -2.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
	.texOffs(74, 159).addBox(-6.0F, -1.0F, -5.0F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F))
	.texOffs(24, 170).addBox(-8.0F, 8.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -7.0F, 0.0F));
	PartDefinition Lower_arm_right = arm_right.addOrReplaceChild("Lower_arm_right", CubeListBuilder.create().texOffs(0, 166).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
	.texOffs(42, 145).addBox(-4.0F, 8.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 13.0F, 0.0F));
	PartDefinition weapon = Lower_arm_right.addOrReplaceChild("weapon", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 63.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 21.0F, 0.0F));
	PartDefinition blades = weapon.addOrReplaceChild("blades", CubeListBuilder.create().texOffs(98, 159).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -20.0F));
	PartDefinition cube = blades.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(98, 176).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));
	PartDefinition blade_bottom = blades.addOrReplaceChild("blade_bottom", CubeListBuilder.create().texOffs(152, 78).addBox(-0.5F, 0.0F, -13.0F, 1.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
	.texOffs(82, 115).addBox(-0.5F, 0.0F, 2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
	.texOffs(158, 160).addBox(-0.5F, 0.0F, -24.0F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
	.texOffs(94, 67).addBox(0.0F, 0.0F, -28.0F, 0.0F, 8.0F, 29.0F, new CubeDeformation(0.0F))
	.texOffs(94, 67).addBox(0.0F, 0.0F, -28.0F, 0.0F, 8.0F, 29.0F, new CubeDeformation(0.0F))
	.texOffs(94, 67).addBox(0.0F, 0.0F, -28.0F, 0.0F, 8.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 1.0F));
	PartDefinition blade_top = blades.addOrReplaceChild("blade_top", CubeListBuilder.create().texOffs(152, 78).addBox(-4.5F, 0.0F, -13.0F, 1.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
	.texOffs(82, 115).addBox(-4.5F, 0.0F, 2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
	.texOffs(158, 160).addBox(-4.5F, 0.0F, -24.0F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
	.texOffs(94, 67).addBox(-4.0F, 0.0F, -28.0F, 0.0F, 8.0F, 29.0F, new CubeDeformation(0.0F))
	.texOffs(94, 67).addBox(-4.0F, 0.0F, -28.0F, 0.0F, 8.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.5F, 1.0F, 0.0F, 0.0F, -3.1416F));
	PartDefinition arm_left = Torso_2.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(0, 145).mirror().addBox(-2.0F, -7.0F, -4.0F, 13.0F, 13.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false)
	.texOffs(130, 138).mirror().addBox(-1.0F, 6.0F, -5.0F, 13.0F, 12.0F, 10.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(15.0F, -12.0F, -5.0F));
	PartDefinition shoulderpad_left = arm_left.addOrReplaceChild("shoulderpad_left", CubeListBuilder.create().texOffs(152, 66).mirror().addBox(-5.0F, -3.0F, -5.0F, 11.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
	.texOffs(48, 170).mirror().addBox(-2.0F, -1.0F, -2.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
	.texOffs(74, 159).mirror().addBox(4.0F, -1.0F, -5.0F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
	.texOffs(24, 170).mirror().addBox(6.0F, 8.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -7.0F, 0.0F));
	PartDefinition Lower_arm_left = arm_left.addOrReplaceChild("Lower_arm_left", CubeListBuilder.create().texOffs(42, 145).mirror().addBox(-4.0F, 8.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
	.texOffs(0, 166).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.5F, 13.0F, 0.0F));
	PartDefinition pelvis = body.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(134, 19).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 17.0F, 12.0F, new CubeDeformation(0.0F))
	.texOffs(126, 170).addBox(-3.0F, 7.0F, -9.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
	.texOffs(134, 0).addBox(-7.0F, 8.0F, -8.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
	PartDefinition leg_cover_right = pelvis.addOrReplaceChild("leg_cover_right", CubeListBuilder.create().texOffs(0, 105).addBox(-11.0F, 0.0F, -7.0F, 11.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 9.0F, 0.0F));
	PartDefinition leg_cover_left = pelvis.addOrReplaceChild("leg_cover_left", CubeListBuilder.create().texOffs(0, 105).mirror().addBox(0.0F, 0.0F, -7.0F, 11.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 9.0F, 0.0F));
	PartDefinition leg_right = pelvis.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(50, 105).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 32.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 11.0F, 0.0F));
	PartDefinition leg_left = pelvis.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(50, 105).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 32.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 11.0F, 0.0F));
	PartDefinition pelvis_height = pelvis.addOrReplaceChild("pelvis_height", CubeListBuilder.create().texOffs(82, 138).addBox(-6.0F, -9.0F, -6.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
	return LayerDefinition.create(meshdefinition, 256, 256);
}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(SahnUzalAnimations.SAHN_UZAL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((SahnUzalEntity) entity).idleAnimationState, SahnUzalAnimations.SAHN_UZAL_IDLE, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).slash1AnimationState, SahnUzalAnimations.SAHN_UZAL_SLASH_ATTACK, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).slash2AnimationState, SahnUzalAnimations.SAHN_UZAL_SLASH_ATTACK_2, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).floorStabAnimationState, SahnUzalAnimations.SAHN_UZAL_FLOOR_STAB, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).slamAnimationState, SahnUzalAnimations.SAHN_UZAL_SLAM, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).slamSlashAnimationState, SahnUzalAnimations.SAHN_UZAL_SLAM_SLASH, ageInTicks, 1f);
		this.animate(((SahnUzalEntity) entity).chargeUpAnimationState, SahnUzalAnimations.SAHN_UZAL_CHARGE_UP, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sahn_uzal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return sahn_uzal;
	}
}