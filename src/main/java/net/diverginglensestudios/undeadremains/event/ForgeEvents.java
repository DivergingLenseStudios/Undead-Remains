/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.event;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.entity.renderer.FossilPolisherBlockEntityRenderer;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.client.BigWoodling.BigWoodlingModel;
import net.diverginglensestudios.undeadremains.entity.client.CowZombie.CowZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.FossilizedZombie.FossilizedZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.FourEyedXanarian.FourEyedXanarianModel;
import net.diverginglensestudios.undeadremains.entity.client.HammerZombie.HammerZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.SahnUzal.SahnUzalModel;
import net.diverginglensestudios.undeadremains.entity.client.SmallWoodling.SmallWoodlingModel;
import net.diverginglensestudios.undeadremains.entity.client.Spike.SpikeModel;
import net.diverginglensestudios.undeadremains.entity.client.StrayZombie.StrayZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.SupremeKnight.SupremeKnightModel;
import net.diverginglensestudios.undeadremains.entity.client.SupremeZombie.SupremeZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.TreeZombie.TreeZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.UndeadArcheologist.UndeadArcheologistModel;
import net.diverginglensestudios.undeadremains.entity.client.Xanarian.XanarianModel;
import net.diverginglensestudios.undeadremains.entity.client.XanarianCannibal.XanarianCannibalModel;
import net.diverginglensestudios.undeadremains.entity.client.horned_xanarian.HornedXanarianModel;
import net.diverginglensestudios.undeadremains.item.ModItems;
// Import Minecraft and Forge Elements
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndeadRemains.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    @SubscribeEvent
    public static void onVanillaGameEvent(VanillaGameEvent event) {
        Entity cause = event.getCause();
        if (!(cause instanceof Player))
            return;
        Player player = (Player) cause;

        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        if (boots == null || boots.isEmpty())
            return;

        if (!boots.is(ModItems.SCULK_SHARD_MODIFIED_FOSSIL_BOOTS.get()))
            return;

        GameEvent vanillaType = event.getVanillaEvent();
        if (vanillaType == GameEvent.STEP || vanillaType == GameEvent.HIT_GROUND) {
            event.setCanceled(true);
        }
    }
}
