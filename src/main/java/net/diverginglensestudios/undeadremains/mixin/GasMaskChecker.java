/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(LivingEntity.class)
public abstract class GasMaskChecker {

	@Inject(method = "isAffectedByPotions", at = @At(value = "HEAD"), cancellable = true)
	private void undeadremains$injectedIsAffectedByPotions(CallbackInfoReturnable<Boolean> cir) {
		LivingEntity entity = (LivingEntity)(Object)this;
		ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);

		if (helmet.getItem() == ModItems.GAS_MASK.get()|helmet.getItem() == ModItems.METATORBERNITE_GAS_MASK.get()) {
			cir.setReturnValue(false);
		}
	}
}