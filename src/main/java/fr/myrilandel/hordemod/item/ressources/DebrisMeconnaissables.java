package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DebrisMeconnaissables extends Item {
	
	public DebrisMeconnaissables() {
		this.setUnlocalizedName("DebrisMeconnaissables");
		this.setTextureName(HordeMod.MODID + ":debrisMeconnaissables");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
