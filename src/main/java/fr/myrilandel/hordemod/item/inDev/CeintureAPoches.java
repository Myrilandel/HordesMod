package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CeintureAPoches extends Item {
	
	public CeintureAPoches() {
		this.setUnlocalizedName("CeintureAPoches");
		this.setTextureName(HordeMod.MODID + ":ceintureAPoches");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
