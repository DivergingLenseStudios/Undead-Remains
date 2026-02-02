/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends SignBlockEntity {
	public ModHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(ModBlockEntities.MOD_HANGING_SIGN.get(), pPos, pBlockState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return ModBlockEntities.MOD_HANGING_SIGN.get();
	}
}
