package net.diverginglensestudios.undeadremains.util;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType ASH = WoodType.register(new WoodType(UndeadRemains.MOD_ID + ":ash", BlockSetType.OAK));
    public static final WoodType CALIPO = WoodType.register(new WoodType(UndeadRemains.MOD_ID + ":calipo", BlockSetType.OAK));
}
