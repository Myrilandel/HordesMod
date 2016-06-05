package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BouleQuies extends Item {
	
	public BouleQuies() {
		this.setUnlocalizedName("BouleQuies");
		this.setTextureName(HordeMod.MODID + ":bouleQuies");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
