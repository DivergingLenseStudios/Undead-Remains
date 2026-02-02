/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.ai;

import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputation;
import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputationProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class XanarianReputationTargetGoal extends TargetGoal {
	private final Mob mob;
	private ServerPlayer target;

	public XanarianReputationTargetGoal(Mob mob) {
		super(mob, true);
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		if (mob.level().isClientSide) return false;

		double range = this.getFollowDistance();

		List<Player> players = mob.level().getEntitiesOfClass(
				Player.class,
				mob.getBoundingBox().inflate(range)
		);

		for (Player p : players) {
			if (!(p instanceof ServerPlayer player)) continue;

			int rep = getReputation(player);

			if (rep <= -20 && mob.canAttack(player)) {
				target = player;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean canContinueToUse() {
		if (target == null || !target.isAlive()) return false;

		int rep = getReputation(target);

		// Immediately stop attacking if rep improves
		return rep <= -20;
	}

	@Override
	public void start() {
		mob.setTarget(target);
		super.start();
	}

	@Override
	public void stop() {
		target = null;
		mob.setTarget(null);
		super.stop();
	}



	private int getReputation(ServerPlayer player) {
		return player.getCapability(
				PlayerXanarianReputationProvider.PLAYER_XANARIAN_REPUTATION
		).map(PlayerXanarianReputation::getXanarianReputation).orElse(0);
	}
}
