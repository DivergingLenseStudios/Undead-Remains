package net.diverginglensestudios.undeadremains.item.armor.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorItem;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorMaterials;
import net.diverginglensestudios.undeadremains.item.armor.client.model.RareFossilArmorModel;
import net.diverginglensestudios.undeadremains.item.armor.client.renderer.ArmorRenderer;
import net.minecraft.world.entity.Entity;


import org.jetbrains.annotations.Nullable;


public class RareFossilArmorItem extends ModArmorItem{
 public RareFossilArmorItem(Type pType) {
        super(ModArmorMaterials.RARE_FOSSIL, pType, new Properties());
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return new ArmorRenderer<>(RareFossilArmorModel::createBodyLayer, RareFossilArmorModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return makeCustomTextureLocation(UndeadRemains.MOD_ID, "rare_fossil_armor");
    }

}
