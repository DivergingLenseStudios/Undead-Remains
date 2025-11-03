package net.diverginglensestudios.undeadremains.worldgen.biome;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(UndeadRemains.MOD_ID, "overworld"), 5));
    }
}