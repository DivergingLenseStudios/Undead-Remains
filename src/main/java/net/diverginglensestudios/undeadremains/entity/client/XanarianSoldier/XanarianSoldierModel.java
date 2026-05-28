/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.XanarianSoldier;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
import net.diverginglensestudios.undeadremains.entity.animations.XanarianSoldierAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianSoldierEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class XanarianSoldierModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xanarian_soldier"), "main");
	private final ModelPart Xanarian_Soldier;
	private final ModelPart head;


	public XanarianSoldierModel(ModelPart root) {
		this.Xanarian_Soldier = root.getChild("Xanarian_Soldier");
		this.head = this.Xanarian_Soldier.getChild("body").getChild("spine").getChild("torso").getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Xanarian_Soldier = partdefinition.addOrReplaceChild("Xanarian_Soldier", CubeListBuilder.create(), PartPose.offset(0.0F, -37.0F, -1.0F));

		PartDefinition body = Xanarian_Soldier.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(64, 47).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-2.0F, -26.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(50, 83).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(80, 36).addBox(-2.0F, -8.0F, 6.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(86, 66).addBox(-2.0F, -22.0F, 6.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 2.0F));

		PartDefinition torso = spine.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 64).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.01F))
				.texOffs(80, 18).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition horn_right = head.addOrReplaceChild("horn_right", CubeListBuilder.create(), PartPose.offset(2.0F, -9.0F, 2.0F));

		PartDefinition cube_r1 = horn_right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 99).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 89).addBox(-10.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition horn_left = head.addOrReplaceChild("horn_left", CubeListBuilder.create(), PartPose.offset(-2.0F, -9.0F, 2.0F));

		PartDefinition cube_r2 = horn_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 99).mirror().addBox(5.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(24, 89).mirror().addBox(7.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition arm_right = torso.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 3.0F, -1.0F));

		PartDefinition sword = arm_right.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -27.0F, -27.0F, 0.0F, 32.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, -27.0F, -27.0F, 0.0F, 32.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(34, 95).addBox(-0.5F, -27.0F, -21.0F, 1.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(50, 64).addBox(-0.5F, -26.0F, -23.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 64).addBox(-0.5F, -26.0F, -23.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(80, 46).addBox(-0.5F, -24.0F, -23.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 104).addBox(-0.5F, -24.0F, -22.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(84, 46).addBox(-0.5F, -23.0F, -22.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 103).addBox(-0.5F, -23.0F, -21.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(56, 64).addBox(-0.5F, -21.0F, -23.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 46).addBox(-0.5F, -22.0F, -23.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(88, 46).addBox(-0.5F, -22.0F, -24.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 104).addBox(-0.5F, -23.0F, -24.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(96, 44).addBox(-0.5F, -23.0F, -26.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 103).addBox(-0.5F, -23.0F, -26.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(92, 46).addBox(-0.5F, -21.0F, -27.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 89).addBox(-0.5F, -21.0F, -27.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(96, 46).addBox(-0.5F, -16.0F, -27.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 103).addBox(-0.5F, -16.0F, -26.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(46, 97).addBox(-0.5F, -14.0F, -26.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 104).addBox(-0.5F, -14.0F, -25.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(46, 98).addBox(-0.5F, -13.0F, -25.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 99).addBox(-0.5F, -12.0F, -24.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 104).addBox(-0.5F, -13.0F, -24.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 104).addBox(-0.5F, -12.0F, -23.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(100, 46).addBox(-0.5F, -11.0F, -23.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 104).addBox(-0.5F, -11.0F, -22.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 99).addBox(-0.5F, -10.0F, -22.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 103).addBox(-0.5F, -12.0F, -20.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(86, 80).addBox(-0.5F, -12.0F, -20.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 104).addBox(-0.5F, -12.0F, -17.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 100).addBox(-0.5F, -11.0F, -17.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 104).addBox(-0.5F, -11.0F, -16.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 101).addBox(-0.5F, -10.0F, -16.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 78).addBox(-0.5F, -10.0F, -15.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 47).addBox(-0.5F, -9.0F, -16.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 103).addBox(-0.5F, -9.0F, -16.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 48).addBox(-0.5F, -7.0F, -16.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 79).addBox(-0.5F, -7.0F, -15.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(60, 99).addBox(-0.5F, -6.0F, -15.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 80).addBox(-0.5F, -7.0F, -13.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 99).addBox(-0.5F, -7.0F, -13.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 105).addBox(-0.5F, -7.0F, -11.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 49).addBox(-0.5F, -6.0F, -11.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 103).addBox(-0.5F, -6.0F, -10.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(72, 99).addBox(-0.5F, -4.0F, -10.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 105).addBox(-0.5F, -4.0F, -8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 50).addBox(-0.5F, -3.0F, -8.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 105).addBox(-0.5F, -3.0F, -7.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 51).addBox(-0.5F, -2.0F, -7.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 105).addBox(-0.5F, -2.0F, -6.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(34, 100).addBox(-0.5F, -1.0F, -8.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 105).addBox(-0.5F, -2.0F, -8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 52).addBox(-0.5F, -2.0F, -9.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 105).addBox(-0.5F, -3.0F, -9.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(40, 100).addBox(-0.5F, -3.0F, -11.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 94).addBox(-0.5F, -3.0F, -11.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 101).addBox(-0.5F, 0.0F, -11.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 105).addBox(-0.5F, 0.0F, -9.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 53).addBox(-0.5F, 1.0F, -9.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 105).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(96, 36).addBox(-0.5F, 2.0F, -8.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(50, 105).addBox(-0.5F, 1.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 54).addBox(-0.5F, 1.0F, -4.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 103).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 55).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 105).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 56).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 105).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 57).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 105).addBox(-0.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 58).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 105).addBox(-0.5F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 59).addBox(-0.5F, 3.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 103).addBox(-0.5F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(96, 40).addBox(-0.5F, 5.0F, 0.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 105).addBox(-0.5F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 60).addBox(-0.5F, 4.0F, 4.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 89).addBox(-0.5F, 0.0F, 5.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(60, 101).addBox(-0.5F, 0.0F, 3.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 105).addBox(-0.5F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 61).addBox(-0.5F, 1.0F, 2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 105).addBox(-0.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 62).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 105).addBox(-0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(68, 105).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 64).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 105).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 101).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 105).addBox(-0.5F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 65).addBox(-0.5F, -4.0F, 1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 93).addBox(-0.5F, -8.0F, 2.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 66).addBox(-0.5F, -8.0F, 1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 105).addBox(-0.5F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 67).addBox(-0.5F, -9.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 103).addBox(-0.5F, -11.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(94, 80).addBox(-0.5F, -11.0F, -3.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(80, 103).addBox(-0.5F, -11.0F, -3.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 68).addBox(-0.5F, -9.0F, -3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 105).addBox(-0.5F, -9.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 69).addBox(-0.5F, -8.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 104).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 70).addBox(-0.5F, -6.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 105).addBox(-0.5F, -7.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 71).addBox(-0.5F, -7.0F, -3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 105).addBox(-0.5F, -8.0F, -3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 72).addBox(-0.5F, -8.0F, -4.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 104).addBox(-0.5F, -10.0F, -4.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(72, 101).addBox(-0.5F, -10.0F, -6.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(82, 105).addBox(-0.5F, -11.0F, -6.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 73).addBox(-0.5F, -11.0F, -7.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 104).addBox(-0.5F, -13.0F, -7.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 74).addBox(-0.5F, -13.0F, -7.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 104).addBox(-0.5F, -15.0F, -6.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 75).addBox(-0.5F, -15.0F, -7.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 105).addBox(-0.5F, -16.0F, -7.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(34, 102).addBox(-0.5F, -16.0F, -9.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 105).addBox(-0.5F, -16.0F, -9.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 76).addBox(-0.5F, -15.0F, -10.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 105).addBox(-0.5F, -16.0F, -10.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 77).addBox(-0.5F, -16.0F, -11.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(90, 105).addBox(-0.5F, -17.0F, -11.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 102).addBox(-0.5F, -17.0F, -12.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 78).addBox(-0.5F, -20.0F, -12.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(40, 102).addBox(-0.5F, -20.0F, -12.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 104).addBox(-0.5F, -22.0F, -10.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 81).addBox(-0.5F, -22.0F, -11.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 105).addBox(-0.5F, -23.0F, -11.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(94, 105).addBox(-0.5F, -24.0F, -12.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 103).addBox(-0.5F, -24.0F, -13.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 105).addBox(-0.5F, -25.0F, -13.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(58, 103).addBox(-0.5F, -25.0F, -14.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 105).addBox(-0.5F, -26.0F, -14.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 44).addBox(-0.5F, -26.0F, -16.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 105).addBox(-0.5F, -27.0F, -16.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(102, 82).addBox(-0.5F, -23.0F, -12.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 63).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 104).addBox(-0.5F, -27.0F, -21.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 37.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition shoulderpad_right = arm_right.addOrReplaceChild("shoulderpad_right", CubeListBuilder.create().texOffs(50, 66).addBox(-9.0F, -3.0F, -4.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(82, 83).mirror().addBox(-6.0F, 6.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition arm_left = torso.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 3.0F, -1.0F));

		PartDefinition shoulderpad_left = arm_left.addOrReplaceChild("shoulderpad_left", CubeListBuilder.create().texOffs(82, 83).addBox(1.0F, 6.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.1F))
				.texOffs(50, 66).mirror().addBox(0.0F, -3.0F, -4.0F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 89).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 89).addBox(-3.0F, 12.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(34, 89).addBox(-3.0F, 36.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 23.0F, 3.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 89).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 89).mirror().addBox(1.0F, 12.0F, 2.0F, 2.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(34, 89).mirror().addBox(1.0F, 36.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 23.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(XanarianSoldierAnimations.XANARIAN_SOLDIER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((XanarianSoldierEntity) entity).slamAnimationState, XanarianSoldierAnimations.XANARIAN_SOLDIER_SLAM, ageInTicks, 1f);
		this.animate(((XanarianSoldierEntity) entity).slashAnimationState, XanarianSoldierAnimations.XANARIAN_SOLDIER_SLASH, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Xanarian_Soldier.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Xanarian_Soldier;
	}
}