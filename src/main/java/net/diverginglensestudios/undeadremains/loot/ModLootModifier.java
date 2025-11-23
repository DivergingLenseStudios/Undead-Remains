/***********************************************************/
/*       This file was copied from Kapitencraft            */
/*          https://github.com/Kapitencraft                */
/***********************************************************/

package net.diverginglensestudios.undeadremains.loot;

import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;

public abstract class ModLootModifier extends LootModifier implements IConditional {

    protected ModLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    public LootItemCondition[] getConditions() {
        return conditions;
    }
}