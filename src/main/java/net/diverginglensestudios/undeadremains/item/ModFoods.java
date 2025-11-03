package net.diverginglensestudios.undeadremains.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties THE_FOSSILS_EYE = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200), 1f).build();

    public static final FoodProperties THE_QUARTZ_MODIFIED_FOSSILS_EYE = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200), 1f).build();

    public static final FoodProperties FOSSILIZED_DRUMSTICK = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 0.1f).build();

    public static final FoodProperties GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK = (new FoodProperties.Builder()).nutrition(4)
            .saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F).effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEat().build();

}
