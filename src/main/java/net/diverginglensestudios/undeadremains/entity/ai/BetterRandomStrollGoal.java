package net.diverginglensestudios.undeadremains.entity.ai;


import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class BetterRandomStrollGoal extends WaterAvoidingRandomStrollGoal {

    public BetterRandomStrollGoal(PathfinderMob mob, double speed) {
        super(mob, speed);
    }

    @Override
    public boolean canUse() {
        if (isEntityAttacking()) {
            return false;
        }
        return super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        if (isEntityAttacking()) {
            return false;
        }
        return super.canContinueToUse();
    }

    /**
     * Uses reflection to check if this mob has an isAttacking() method.
     * Returns true if it does and the method returns true.
     */
    private boolean isEntityAttacking() {
        try {
            var method = this.mob.getClass().getMethod("isAttacking");
            Object result = method.invoke(this.mob);
            return result instanceof Boolean && (Boolean) result;
        } catch (Exception e) {
            // Entity doesn’t have isAttacking(), or it’s inaccessible
            return false;
        }
    }
}