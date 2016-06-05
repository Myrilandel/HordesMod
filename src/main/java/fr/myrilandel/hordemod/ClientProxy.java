package fr.myrilandel.hordemod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.myrilandel.hordemod.entities.EntityBombeAEau;
import fr.myrilandel.hordemod.entities.EntityBombeAEauExplosive;
import fr.myrilandel.hordemod.entities.EntityEauBullet;
import fr.myrilandel.hordemod.entities.EntityPamplemousseExplosif;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.item.EntityItemTest;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.zombies.RenderZombieNuitEnVille;
import fr.myrilandel.hordemod.zombies.RenderZombieNuitHorsVille;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import fr.myrilandel.hordemod.zombies.ZombieNuitHorsVille;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityItemTest.class, new RenderSnowball(HMItemRegistry.itemTest));
		RenderingRegistry.registerEntityRenderingHandler(EntityEauBullet.class, new RenderSnowball(HMItemRegistry.bombeAEau));
		RenderingRegistry.registerEntityRenderingHandler(EntityBombeAEau.class, new RenderSnowball(HMItemRegistry.bombeAEau));
		RenderingRegistry.registerEntityRenderingHandler(EntityBombeAEauExplosive.class, new RenderSnowball(HMItemRegistry.bombeAEauExplosive));
		RenderingRegistry.registerEntityRenderingHandler(EntityPile.class, new RenderSnowball(HMItemRegistry.pile));
		RenderingRegistry.registerEntityRenderingHandler(EntityPamplemousseExplosif.class, new RenderSnowball(HMItemRegistry.pamplemousseExplosif));

		RenderingRegistry.registerEntityRenderingHandler(ZombieNuitEnVille.class, new RenderZombieNuitEnVille(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(ZombieNuitHorsVille.class, new RenderZombieNuitHorsVille(new ModelZombie(), 0.5F));
	}
}

