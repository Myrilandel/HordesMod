package fr.myrilandel.hordemod.zombies;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderZombieNuitEnVille extends RenderBiped {

	public RenderZombieNuitEnVille(ModelZombie modelZombie, float shadow) {
		super(modelZombie, shadow);
	}
	
	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return this.getZombieNuitEnVille((ZombieNuitEnVille)living);
	}

	private ResourceLocation getZombieNuitEnVille(ZombieNuitEnVille zombieNuitEnVille) {
		return new ResourceLocation(HordeMod.MODID + ":textures/entity/zombieNuit.png");
	}

}
