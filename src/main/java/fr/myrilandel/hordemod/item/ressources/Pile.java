package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Pile extends Item {
	
	public Pile() {
		this.setUnlocalizedName("Pile");
		this.setTextureName(HordeMod.MODID + ":pile");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
