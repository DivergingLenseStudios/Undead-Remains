/***********************************************************/
/*       This file was copied from Kapitencraft            */
/*          https://github.com/Kapitencraft                */
/***********************************************************/

package net.diverginglensestudios.undeadremains.helpers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.diverginglensestudios.undeadremains.loot.IConditional;
import net.diverginglensestudios.undeadremains.loot.LootContextReader;
import net.diverginglensestudios.undeadremains.loot.ModLootModifier;
import net.diverginglensestudios.undeadremains.loot.ModLootTableModifiers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.function.Function;

public interface LootTableHelper {
    static <T extends IConditional> Codec<T> simpleCodec(Function<LootItemCondition[], T> function) {
        return RecordCodecBuilder.create(instance -> instance.group(
                ModLootModifier.LOOT_CONDITIONS_CODEC.optionalFieldOf("conditions", new LootItemCondition[0])
                        .forGetter(IConditional::getConditions))
                .apply(instance, function));
    }

    /**
     * get the source as a {@link Player}, or null
     */
    static Player getPlayerSource(LootContext context) {
        return getEntitySource(context) instanceof Player player ? player : null;
    }

    /**
     * get the source as a {@link LivingEntity} or null
     */
    static LivingEntity getLivingSource(LootContext context) {
        return getEntitySource(context) instanceof LivingEntity living ? living : null;
    }

    /**
     * atempts to get the Killer entity or this entity if the killer entity is null
     * (or null, if neither can be found)
     */
    static Entity getEntitySource(LootContext context) {
        return LootContextReader.of(context, Entity.class).withParam(LootContextParams.KILLER_ENTITY)
                .ifNull(LootContextParams.THIS_ENTITY).getValue();
    }
}