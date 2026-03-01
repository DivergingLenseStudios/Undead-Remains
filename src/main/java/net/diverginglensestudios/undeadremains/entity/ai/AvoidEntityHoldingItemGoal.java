package net.diverginglensestudios.undeadremains.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.item.Item;

public class AvoidEntityHoldingItemGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {

	public AvoidEntityHoldingItemGoal(PathfinderMob mob, Class<T> entityClassToAvoid, Item itemToCheck, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier) {
		super(mob, entityClassToAvoid, maxDistance, walkSpeedModifier, sprintSpeedModifier,
				living -> living.getMainHandItem().is(itemToCheck) || living.getOffhandItem().is(itemToCheck));
	}
}