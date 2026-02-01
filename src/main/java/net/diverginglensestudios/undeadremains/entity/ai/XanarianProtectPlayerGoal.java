package net.diverginglensestudios.undeadremains.entity.ai;

import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.AbstractXanarian;
import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputation;
import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputationProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;

import java.util.List;

public class XanarianProtectPlayerGoal extends TargetGoal {

	private final Mob mob;
	private LivingEntity attacker;

	public XanarianProtectPlayerGoal(Mob mob) {
		super(mob, true);
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		if (mob.level().isClientSide) return false;

		List<ServerPlayer> players = mob.level().getEntitiesOfClass(
				ServerPlayer.class,
				mob.getBoundingBox().inflate(16)
		);

		for (ServerPlayer player : players) {
			int rep = getReputation(player);

			if (rep >= 50 && player.getLastHurtByMob() != null) {
				attacker = player.getLastHurtByMob();
				if (!(attacker instanceof AbstractXanarian)){
				return true;
				}
				else{
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public void start() {
		mob.setTarget(attacker);
		super.start();
	}

	private int getReputation(ServerPlayer player) {
		return player.getCapability(
				PlayerXanarianReputationProvider.PLAYER_XANARIAN_REPUTATION
		).map(PlayerXanarianReputation::getXanarianReputation).orElse(0);
	}
}