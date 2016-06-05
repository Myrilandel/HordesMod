package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SoucheDeBoisPourrie extends Item {
	
	public SoucheDeBoisPourrie() {
		this.setUnlocalizedName("SoucheDeBoisPourrie");
		this.setTextureName(HordeMod.MODID + ":soucheDeBoisPourrie");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
