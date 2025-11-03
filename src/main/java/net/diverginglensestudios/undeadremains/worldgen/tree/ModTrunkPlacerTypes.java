package net.diverginglensestudios.undeadremains.worldgen.tree;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.worldgen.tree.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, UndeadRemains.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<CreeperTrunkPlacer>> CREEPER_TRUNK_PLACER =
            TRUNK_PLACER.register("creeper_trunk_placer", () -> new TrunkPlacerType<>(CreeperTrunkPlacer.CODEC));

    public static final RegistryObject<TrunkPlacerType<ModStraightTrunkPlacer>> MOD_STRAIGHT_TRUNK_PLACER =
            TRUNK_PLACER.register("mod_straight_trunk_placer", () -> new TrunkPlacerType<>(ModStraightTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}