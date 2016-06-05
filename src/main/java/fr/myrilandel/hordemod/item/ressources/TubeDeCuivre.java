package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TubeDeCuivre extends Item {
	
	public TubeDeCuivre() {
		this.setUnlocalizedName("TubeDeCuivre");
		this.setTextureName(HordeMod.MODID + ":tubeDeCuivre");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
