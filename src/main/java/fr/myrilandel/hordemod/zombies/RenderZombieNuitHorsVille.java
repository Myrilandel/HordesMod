package fr.myrilandel.hordemod.zombies;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderZombieNuitHorsVille extends RenderBiped {
	
	public RenderZombieNuitHorsVille(ModelZombie modelZombie, float shadow) {
		super(modelZombie, shadow);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return this.getZombieNuitHorsVille((ZombieNuitHorsVille)living);
	}

	private ResourceLocation getZombieNuitHorsVille(ZombieNuitHorsVille zombieNuitHorsVille) {
		return new ResourceLocation(HordeMod.MODID + ":textures/entity/zombieNuit.png");
	}

}
