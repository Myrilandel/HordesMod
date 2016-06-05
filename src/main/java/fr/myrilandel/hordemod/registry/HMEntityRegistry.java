package fr.myrilandel.hordemod.registry;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityBombeAEau;
import fr.myrilandel.hordemod.entities.EntityBombeAEauExplosive;
import fr.myrilandel.hordemod.entities.EntityEauBullet;
import fr.myrilandel.hordemod.entities.EntityPamplemousseExplosif;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.item.EntityItemTest;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import fr.myrilandel.hordemod.zombies.ZombieNuitHorsVille;
import net.minecraft.entity.EntityList;

public class HMEntityRegistry {
	
	public static void entityRegister() {
		registerEntities();
	}

	private static void registerEntities() {
		createEntity(EntityItemTest.class, "entityItemTest", 0, 0);
		createEntity(EntityEauBullet.class, "entityEauBullet", 0, 0);
		createEntity(EntityBombeAEau.class, "entityBombeAEau", 0, 0);
		createEntity(EntityBombeAEauExplosive.class, "entityBombeAEauExplosive", 0, 0);
		createEntity(EntityPile.class, "entityPile", 0, 0);
		createEntity(EntityPamplemousseExplosif.class, "entityPamplemousseExplosif", 0, 0);
		
		createEntity(ZombieNuitEnVille.class, "zombieNuitEnVille", 150, 20);
		createEntity(ZombieNuitHorsVille.class, "zombieNuitHorsVille", 20, 150);
	}
	
	private static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, HordeMod.MODID, 64	, 1, true);
		if(solidColor != 0 && spotColor != 0)
			createEgg(randomID, solidColor, spotColor);
	}

	private static void createEgg(int randomID, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
	}
}
