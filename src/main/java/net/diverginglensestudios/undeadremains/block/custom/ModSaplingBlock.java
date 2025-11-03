package net.diverginglensestudios.undeadremains.block.custom;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class ModSaplingBlock extends SaplingBlock{
    private final Supplier<Block> block;
    private final boolean onRoof; 
    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties, Supplier<Block> block, boolean onRoof) {
        super(pTreeGrower, pProperties);
        this.block = block;
        this.onRoof = onRoof;
    }
@Override
protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
      return pState.is(block.get());
   }
@Override
public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
    if (this.onRoof==true){
    return this.mayPlaceOn(pLevel.getBlockState(pPos.above()), pLevel, pPos.above());}
    else{
    return this.mayPlaceOn(pLevel.getBlockState(pPos.below()), pLevel, pPos.below());}
}
}