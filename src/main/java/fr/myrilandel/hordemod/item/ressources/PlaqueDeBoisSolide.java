package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PlaqueDeBoisSolide extends Item{

	public PlaqueDeBoisSolide() {
		this.setUnlocalizedName("PlaqueDeBoisSolide");
		this.setTextureName(HordeMod.MODID + ":plaqueDeBoisSolide");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
