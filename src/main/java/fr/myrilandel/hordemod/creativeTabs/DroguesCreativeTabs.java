package fr.myrilandel.hordemod.creativeTabs;

import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DroguesCreativeTabs extends CreativeTabs {

	public DroguesCreativeTabs(String nom) {
	        super(nom);
	}

	@Override
	public Item getTabIconItem() {
		   return HMItemRegistry.piqureDeCalmant;
	}
}
