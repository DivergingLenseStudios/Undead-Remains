package net.diverginglensestudios.undeadremains.worldgen.tree;

import net.minecraftforge.registries.DeferredRegister;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.worldgen.tree.custom.CalipoFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, UndeadRemains.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<CalipoFoliagePlacer>> CALIPO_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("calipo_foliage_placer", () -> new FoliagePlacerType<>(CalipoFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}