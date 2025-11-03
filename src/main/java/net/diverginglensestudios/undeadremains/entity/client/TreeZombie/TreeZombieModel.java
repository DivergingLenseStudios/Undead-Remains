package net.diverginglensestudios.undeadremains.entity.client.TreeZombie;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
import net.diverginglensestudios.undeadremains.entity.animations.TreeZombieAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.TreeZombieEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.UndeadArcheologistEntity;

// Made with Blockbench 4.12.2
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

public class TreeZombieModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "tree_zombie"), "main");
	private final ModelPart TreeZombie;
	private final ModelPart head;

	public TreeZombieModel(ModelPart root) {
		this.TreeZombie = root.getChild("Tree_Zombie");
		this.head =TreeZombie.getChild("body").getChild("torso").getChild("head");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tree_Zombie = partdefinition.addOrReplaceChild("Tree_Zombie", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition body = Tree_Zombie.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(32, 33).addBox(-4.0F, -14.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(28, 51).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(-4.0F, -12.0F, 0.0F));

		PartDefinition left_arm2 = torso.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(44, 51).addBox(0.0F, -2.0F, -2.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(0.0F, -5.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offset(4.0F, -12.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 17).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 5.0F, 12.0F, new CubeDeformation(0.5F))
		.texOffs(0, 17).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 53).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition left_leg2 = body.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(TreeZombieAnimations.TREE_ZOMBIE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((TreeZombieEntity) entity).attackAnimationState, TreeZombieAnimations.TREE_ZOMBIE_ATTACK, ageInTicks, 1f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		TreeZombie.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TreeZombie;
	}
}