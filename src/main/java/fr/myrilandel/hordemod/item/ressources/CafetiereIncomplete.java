package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CafetiereIncomplete extends Item {
	
	public CafetiereIncomplete() {
		this.setUnlocalizedName("CafetiereIncomplete");
		this.setTextureName(HordeMod.MODID + ":cafetiereIncomplete");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
