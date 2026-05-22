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
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;
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
		this.head = this.Xanarian_Soldier.getChild("body").getChild("upper_body").getChild("torso").getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Xanarian_Soldier = partdefinition.addOrReplaceChild("Xanarian_Soldier", CubeListBuilder.create(), PartPose.offset(0.0F, -37.0F, -1.0F));

		PartDefinition body = Xanarian_Soldier.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition upper_body = body.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(64, 47).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-2.0F, -26.0F, -5.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(50, 83).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(80, 36).addBox(-2.0F, -8.0F, 6.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(86, 66).addBox(-2.0F, -22.0F, 6.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 2.0F));

		PartDefinition torso = upper_body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 64).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.01F))
				.texOffs(80, 18).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition horn_right = head.addOrReplaceChild("horn_right", CubeListBuilder.create(), PartPose.offset(2.0F, -9.0F, 2.0F));

		PartDefinition horn2_r1 = horn_right.addOrReplaceChild("horn2_r1", CubeListBuilder.create().texOffs(34, 95).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 89).addBox(-10.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition horn_left = head.addOrReplaceChild("horn_left", CubeListBuilder.create(), PartPose.offset(-2.0F, -9.0F, 2.0F));

		PartDefinition horn2_r2 = horn_left.addOrReplaceChild("horn2_r2", CubeListBuilder.create().texOffs(34, 95).mirror().addBox(5.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(24, 89).mirror().addBox(7.0F, -14.0F, -1.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2253F, 0.0F, 0.0F));

		PartDefinition arm_right = torso.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 43.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 3.0F, -1.0F));

		PartDefinition sword = arm_right.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(0, 0).addBox(-1.01F, -27.0F, -27.0F, 0.0F, 32.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.01F, -27.0F, -27.0F, 0.0F, 32.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(-5, 4).addBox(-1.0F, -27.0F, -21.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(-5, 4).addBox(-1.0F, -27.0F, -21.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -26.0F, -23.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -26.0F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -24.0F, -23.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -24.0F, -22.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -23.0F, -22.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -23.0F, -21.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -21.0F, -23.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -22.0F, -23.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -22.0F, -24.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -23.0F, -24.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -23.0F, -26.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -23.0F, -26.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -21.0F, -27.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -21.0F, -27.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -16.0F, -27.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -16.0F, -26.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -14.0F, -26.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -14.0F, -25.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -13.0F, -25.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -12.0F, -24.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -13.0F, -24.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -12.0F, -23.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -11.0F, -23.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -11.0F, -22.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -10.0F, -22.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -12.0F, -20.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-1.0F, -12.0F, -20.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -12.0F, -17.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -11.0F, -17.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -11.0F, -16.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -10.0F, -16.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -10.0F, -15.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -9.0F, -16.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -9.0F, -16.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -7.0F, -16.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -7.0F, -15.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -6.0F, -15.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -7.0F, -13.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -7.0F, -13.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -7.0F, -11.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -6.0F, -11.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -6.0F, -10.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -4.0F, -10.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -4.0F, -8.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -3.0F, -8.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -3.0F, -11.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -3.0F, -11.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, 0.0F, -11.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 0.0F, -9.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 1.0F, -9.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 1.0F, -8.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 0).addBox(-1.0F, 2.0F, -8.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 2.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-4, 0).addBox(-1.0F, 5.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 4.0F, 4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 4.0F, 4.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 0.0F, 5.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 1.0F, 2.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -8.0F, 1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -9.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -11.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-1.0F, -11.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -11.0F, -3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -9.0F, -2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -7.0F, -3.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -8.0F, -3.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -10.0F, -4.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -10.0F, -6.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -11.0F, -6.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -11.0F, -7.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -13.0F, -7.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -13.0F, -7.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -15.0F, -6.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-1.0F, -15.0F, -7.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-1.0F, -16.0F, -7.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 5).addBox(-1.0F, -16.0F, -9.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 4).addBox(-1.0F, -16.0F, -9.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(3, 3).addBox(-1.0F, -15.0F, -10.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 2).addBox(-1.0F, -16.0F, -10.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(-1.0F, -16.0F, -11.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-1.0F, -17.0F, -11.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 20).addBox(-1.0F, -17.0F, -12.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-1.0F, -20.0F, -12.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 15).addBox(-1.0F, -20.0F, -12.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.0F, -22.0F, -10.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 12).addBox(-1.0F, -22.0F, -11.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-1.0F, -23.0F, -11.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-1.0F, -24.0F, -12.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 9).addBox(-1.0F, -24.0F, -13.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-1.0F, -25.0F, -13.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 7).addBox(-1.0F, -25.0F, -14.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-1.0F, -26.0F, -14.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 4).addBox(-1.0F, -26.0F, -16.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(-1.0F, -27.0F, -16.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 2).addBox(-1.0F, -23.0F, -12.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -27.0F, -21.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 37.0F, -0.3F, 0.7854F, 0.0F, 0.0F));

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

		this.animateWalk(ModAnimationDefinitions.XANARIAN_SOLDIER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		//this.animate(((XanarianEntity) entity).attackAnimationState, ModAnimationDefinitions.XANARIAN_ATTACK, ageInTicks, 1f);
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