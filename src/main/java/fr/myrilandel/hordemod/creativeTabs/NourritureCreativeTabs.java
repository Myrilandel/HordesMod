package fr.myrilandel.hordemod.creativeTabs;

import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NourritureCreativeTabs extends CreativeTabs {

	public NourritureCreativeTabs(String nom) {
	        super(nom);
	}

	@Override
	public Item getTabIconItem() {
		   return HMItemRegistry.steakAppetissant;
	}
}
