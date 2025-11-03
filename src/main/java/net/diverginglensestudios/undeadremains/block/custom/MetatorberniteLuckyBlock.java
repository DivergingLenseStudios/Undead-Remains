package net.diverginglensestudios.undeadremains.block.custom;

import java.util.List;
import java.util.Random;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.entity.custom.Other.CustomEffectCloudEntity;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

public class MetatorberniteLuckyBlock extends Block {

    public MetatorberniteLuckyBlock(Properties pProperties) {
        super(pProperties);
    }
@Override
public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
    super.destroy(pLevel, pPos, pState);
    if (pLevel instanceof ServerLevel serverLevel) {
        Random random = new Random();
        int choice = random.nextInt(6) + 1; // Generates 1, 2, or 3

        if (choice==1){//////////EVENT_1//////////
            CustomEffectCloudEntity areaEffectCloud = new CustomEffectCloudEntity(serverLevel,
        pPos.getX() + 0.5, // Center the cloud in the block
        pPos.getY() + 0.5,
        pPos.getZ() + 0.5);

        areaEffectCloud.setRadius(10.0F);
        areaEffectCloud.setRadiusOnUse(-0.5F);
        areaEffectCloud.setWaitTime(10);
        areaEffectCloud.setDuration(1000); // Duration in ticks (10 seconds)
        areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / areaEffectCloud.getDuration());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
        areaEffectCloud.setParticle(ModParticles.METATORBERNITE_PARTICLES.get());
        areaEffectCloud.setDimensions(10F, 2F);
        serverLevel.addFreshEntity(areaEffectCloud);

        } else if (choice==2){//////////EVENT_2//////////
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
            if (lightningBolt != null) {
                lightningBolt.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5);
                lightningBolt.setVisualOnly(false); // Ensures it causes fire and damage
                serverLevel.addFreshEntity(lightningBolt);
            }
        } else if (choice==3) {//////////EVENT_3//////////
            // Drop a random Rare Fossil Armor piece
            ItemStack armorDrop;
            int armorChoice = random.nextInt(5); // 0-4 for different armor pieces

            switch (armorChoice) {
                case 0 -> armorDrop = new ItemStack(ModItems.METATORBERNITE_HELMET.get());
                case 1 -> armorDrop = new ItemStack(ModItems.METATORBERNITE_CHESTPLATE.get());
                case 2 -> armorDrop = new ItemStack(ModItems.METATORBERNITE_LEGGINGS.get());
                case 3 -> armorDrop = new ItemStack(ModItems.METATORBERNITE_BOOTS.get());
                case 4 -> armorDrop = new ItemStack(ModItems.GAS_MASK.get());
                default -> armorDrop = ItemStack.EMPTY;
            }

            if (!armorDrop.isEmpty()) {
                Block.popResource(serverLevel, pPos, armorDrop);
            }
        } else if (choice==4) {//////////EVENT_4//////////

            // Drop a random Rare Fossil Armor piece
            ItemStack toolDrop;
            int toolChoice = random.nextInt(5); // 0-4 for different armor pieces

            switch (toolChoice) {
                case 0 -> toolDrop = new ItemStack(ModItems.METATORBERNITE_SWORDAXE.get());
                case 1 -> toolDrop = new ItemStack(ModItems.METATORBERNITE_HOE.get());
                case 2 -> toolDrop = new ItemStack(ModItems.METATORBERNITE_PICKAXE.get());
                case 3 -> toolDrop = new ItemStack(ModItems.METATORBERNITE_SHOVEL.get());
                default -> toolDrop = ItemStack.EMPTY;
            }

            if (!toolDrop.isEmpty()) {
                Block.popResource(serverLevel, pPos, toolDrop);
            }

        } else if (choice==5) {//////////EVENT_5//////////
            int mobcount = 0;
            int addedheight = 0;
            while (mobcount<10){//amount of mobs spawned
            ZombieVillager customEntity = new ZombieVillager(EntityType.ZOMBIE_VILLAGER, serverLevel);
            customEntity.moveTo(pPos.getX() + 0.5, pPos.getY()+addedheight, pPos.getZ() + 0.5, 0, 0);
            serverLevel.addFreshEntity(customEntity);
            mobcount ++;
            addedheight ++;
        }
            
        } else if (choice==6) {//////////EVENT_6//////////
            serverLevel.levelEvent(2001, pPos, Block.getId(ModBlocks.METATORBERNITE_BLOCK.get().defaultBlockState())); // Particle effect
            serverLevel.playSound(null, pPos, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            ItemStack drop = new ItemStack(ModItems.METATORBERNITE_GRENADE.get(), random.nextInt(8) + 1);
            Block.popResource(serverLevel, pPos, drop);

            }


        }
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        return List.of(); // Prevents default block drops
    }
}

