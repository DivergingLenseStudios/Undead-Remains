package net.diverginglensestudios.undeadremains.worldgen.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, "undeadremains");

    public static final RegistryObject<Feature<UnderwaterBubbleBlockConfiguration>> UNDERWATER_BUBBLE =
            FEATURES.register("underwater_bubble",
                    () -> new UnderwaterBubbleBlockFeature(UnderwaterBubbleBlockConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}