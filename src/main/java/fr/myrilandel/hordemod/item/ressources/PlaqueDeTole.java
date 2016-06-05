package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PlaqueDeTole extends Item {
	
	public PlaqueDeTole() {
		this.setUnlocalizedName("PlaqueDeTole");
		this.setTextureName(HordeMod.MODID + ":plaqueDeTole");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
