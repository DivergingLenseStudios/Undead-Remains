/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.particles;

import javax.annotation.Nullable;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class MetatorberniteParticles extends TextureSheetParticle {
	protected MetatorberniteParticles(ClientLevel pLevel, double pX, double pY, double pZ,
									  SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
		super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);


		this.friction = 0.8f;
		this.lifetime = 40;

		this.setSpriteFromAge(spriteSet);

		this.rCol = 1f;
		this.gCol = 1f;
		this.bCol = 1f;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public Provider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Nullable
		@Override
		public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ,
									   double pXSpeed, double pYSpeed, double pZSpeed) {
			return new MetatorberniteParticles(pLevel, pX, pY, pZ, this.spriteSet, 0.1f, 0.1F, 0.1f);
		}
	}
	@Override
	protected void setSize(float pWidth, float pHeight) {
		super.setSize(pWidth, pHeight);
	}
}