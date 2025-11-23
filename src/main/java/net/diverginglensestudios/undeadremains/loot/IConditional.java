/***********************************************************/
/*       This file was copied from Kapitencraft            */
/*          https://github.com/Kapitencraft                */
/***********************************************************/

package net.diverginglensestudios.undeadremains.loot;

import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public interface IConditional {

    LootItemCondition[] getConditions();
}