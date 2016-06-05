package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PoudreCometeBrute extends Item {
	
	public PoudreCometeBrute() {
		this.setUnlocalizedName("PoudreCometeBrute");
		this.setTextureName(HordeMod.MODID + ":poudreCometeBrute");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
