package net.diverginglensestudios.undeadremains.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.client.gui.screens.TitleScreen;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		UndeadRemains.LOGGER.info("This line is printed by an example mod mixin!");
	}
}