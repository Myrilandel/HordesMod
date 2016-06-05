package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PoudreSuperFuzz extends Item {
	
	public PoudreSuperFuzz() {
		this.setUnlocalizedName("PoudreSuperFuzz");
		this.setTextureName(HordeMod.MODID + ":poudreSuperFuzz");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
