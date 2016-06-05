package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Rustine extends Item {
	
	public Rustine() {
		this.setUnlocalizedName("Rustine");
		this.setTextureName(HordeMod.MODID + ":rustine");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
