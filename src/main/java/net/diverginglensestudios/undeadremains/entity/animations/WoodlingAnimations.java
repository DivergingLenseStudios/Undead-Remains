package net.diverginglensestudios.undeadremains.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class WoodlingAnimations {

//////////BIG_WOODLING_WALK//////////
public static final AnimationDefinition BIG_WOODLING_WALK = AnimationDefinition.Builder.withLength(0.8f).looping()
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.2f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.4f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.6f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.8f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_leg",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.6f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.6f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.6f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();

//////////SMALL_WOODLING_WALK//////////
public static final AnimationDefinition SMALL_WOODLING_WALK = AnimationDefinition.Builder.withLength(0.8f).looping()
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.2f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.4f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.6f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.8f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.6f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_leg2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.2f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.6f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
