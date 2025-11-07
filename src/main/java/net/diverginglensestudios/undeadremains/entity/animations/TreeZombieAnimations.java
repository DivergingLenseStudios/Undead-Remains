/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class TreeZombieAnimations {

//////////TREE_ZOMBIE_WALK//////////
public static final AnimationDefinition TREE_ZOMBIE_WALK = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("head",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, -20f, -5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(-5f, 20f, 5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(5f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_arm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, -1f, 1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.33333f, KeyframeAnimations.posVec(0f, -1f, -1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_arm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.58333f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.41667f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_arm2",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, 0f, -1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.33333f, KeyframeAnimations.posVec(0f, 0f, 1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_arm2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.41667f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_leg2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();

//////////TREE_ZOMBIE_ATTACK//////////
public static final AnimationDefinition TREE_ZOMBIE_ATTACK = AnimationDefinition.Builder.withLength(0.75f)
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-11.08f, 35.5f, -5.33f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(15.17f, -14.93f, -1.66f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_arm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_arm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(55f, 0f, 90f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(-115f, 0f, 90f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("right_arm",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2916767f, KeyframeAnimations.scaleVec(1f, 0.6f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.375f, KeyframeAnimations.scaleVec(1f, 1.9f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_arm2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-42.25f, -5.06f, -5.54f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(39.42f, -8.75f, 4.39f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
