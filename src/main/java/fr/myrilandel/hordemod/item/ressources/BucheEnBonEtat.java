package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BucheEnBonEtat extends Item {
	
	public BucheEnBonEtat() {
		this.setUnlocalizedName("BucheEnBonEtat");
		this.setTextureName(HordeMod.MODID + ":bucheEnBonEtat");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
