package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BonbonneDEauVide extends Item {
	
	public BonbonneDEauVide() {
		this.setUnlocalizedName("BonbonneDEauVide");
		this.setTextureName(HordeMod.MODID + ":bonbonneDEauVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
