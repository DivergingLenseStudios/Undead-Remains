/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item.armor.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorItem;
import net.diverginglensestudios.undeadremains.item.armor.client.model.GasMaskModel;
import net.diverginglensestudios.undeadremains.item.armor.client.renderer.ArmorRenderer;
import net.minecraft.world.entity.Entity;


import org.jetbrains.annotations.Nullable;


public class GasMaskItem extends ModArmorItem{
 public GasMaskItem(Type pType) {
        super(ArmorMaterials.LEATHER, pType, new Properties());
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return new ArmorRenderer<>(GasMaskModel::createBodyLayer, GasMaskModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return makeCustomTextureLocation(UndeadRemains.MOD_ID, "gas_mask");
    }

}
