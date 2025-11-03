package net.diverginglensestudios.undeadremains.item.armor.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorItem;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorMaterials;
import net.diverginglensestudios.undeadremains.item.armor.client.model.MetatorberniteGasMaskModel;
import net.diverginglensestudios.undeadremains.item.armor.client.renderer.ArmorRenderer;
import net.minecraft.world.entity.Entity;


import org.jetbrains.annotations.Nullable;


public class MetatorberniteGasMaskItem extends ModArmorItem{
 public MetatorberniteGasMaskItem(Type pType) {
        super(ModArmorMaterials.METATORBERNITE, pType, new Properties());
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorRenderer<?> getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return new ArmorRenderer<>(MetatorberniteGasMaskModel::createBodyLayer, MetatorberniteGasMaskModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return makeCustomTextureLocation(UndeadRemains.MOD_ID, "metatorbernite_gas_mask");
    }

}
