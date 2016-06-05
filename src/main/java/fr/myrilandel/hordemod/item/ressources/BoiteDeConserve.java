package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BoiteDeConserve extends Item {
	
	public BoiteDeConserve() {
		this.setUnlocalizedName("BoiteDeConserve");
		this.setTextureName(HordeMod.MODID + ":boiteDeConserve");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
