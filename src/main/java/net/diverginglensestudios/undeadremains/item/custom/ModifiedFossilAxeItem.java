/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class ModifiedFossilAxeItem extends AxeItem {

    public ModifiedFossilAxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents,
            TooltipFlag isAdvanced) {
        tooltipComponents.add(
                Component.translatable("tooltip.undeadremains.rabbit_foot_modified_fossil_axe")
                        .withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slotId,
            boolean isSelected) {
        if (level.isClientSide())
            return; // Only run on server side

        if (!(entity instanceof Player player)) {
        } else {
            // Give effect only if this item is in main hand
            if (isSelected || player.getOffhandItem() == stack) {
                // Give the effect, short duration to keep it active but prevent stacking
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, 1, true, false, false));
            }
        }

        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

}