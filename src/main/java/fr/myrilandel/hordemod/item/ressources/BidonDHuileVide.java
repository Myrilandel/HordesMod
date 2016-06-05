package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BidonDHuileVide extends Item {
	
	public BidonDHuileVide() {
		this.setUnlocalizedName("BidonDHuileVide");
		this.setTextureName(HordeMod.MODID + ":bidonDHuileVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
