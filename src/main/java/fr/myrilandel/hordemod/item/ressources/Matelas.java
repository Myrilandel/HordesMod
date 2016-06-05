package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Matelas extends Item {
	
	public Matelas() {
		this.setUnlocalizedName("Matelas");
		this.setTextureName(HordeMod.MODID + ":matelas");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
