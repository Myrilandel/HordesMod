package fr.myrilandel.hordemod.creativeTabs;

import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoffresCreativeTabs extends CreativeTabs {

	public CoffresCreativeTabs(String nom) {
	        super(nom);
	}

	@Override
	public Item getTabIconItem() {
		   return HMItemRegistry.caisseDeMaterielOuverte;
	}
}
