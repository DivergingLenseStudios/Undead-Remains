/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.painting;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
    DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, UndeadRemains.MOD_ID);

    public static final RegistryObject<PaintingVariant> XANAS = 
    PAINTING_VARIANTS.register("xanas", () -> new PaintingVariant(64, 32));
    public static final RegistryObject<PaintingVariant> CANNIBAL = 
    PAINTING_VARIANTS.register("cannibal", () -> new PaintingVariant(32, 32));



    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
