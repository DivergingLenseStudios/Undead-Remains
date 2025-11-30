//package net.diverginglensestudios.undeadremains.block.custom;
//
//import net.minecraft.world.level.ItemLike;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.CropBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.IntegerProperty;
//
//public class XansLeavsBlock extends CropBlock {
//    public static final int MAX_AGE = 7;
//    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
//
//    public XansLeavsBlock(Properties pProperties) {
//        super(pProperties);
//    }
//
//    @Override
//    protected ItemLike getBaseSeedId() {
//        return super.getBaseSeedId();
//    }
//
//    @Override
//    protected IntegerProperty getAgeProperrty() {
//        return super.getAgeProperty();
//    }
//
//    @Override 
//    public int getMaxAge() {
//        return super.getMaxAge();
//    }
//
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
//        pBuilder.add(AGE)
//        }
//}