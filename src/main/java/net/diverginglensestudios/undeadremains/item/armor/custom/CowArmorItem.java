package net.diverginglensestudios.undeadremains.item.armor.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorItem;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorMaterials;
import net.diverginglensestudios.undeadremains.item.armor.client.model.CowArmorModel;
import net.diverginglensestudios.undeadremains.item.armor.client.renderer.ArmorRenderer;
import net.minecraft.world.entity.Entity;


import org.jetbrains.annotations.Nullable;


public class CowArmorItem extends ModArmorItem{
 public CowArmorItem(Type pType) {
        super(ModArmorMaterials.COW, pType, new Properties());
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return new ArmorRenderer<>(CowArmorModel::createBodyLayer, CowArmorModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return makeCustomTextureLocation(UndeadRemains.MOD_ID, "cow_armor");
    }

}
