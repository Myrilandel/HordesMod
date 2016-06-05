package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RadioK7 extends Item {
	
	public RadioK7() {
		this.setUnlocalizedName("RadioK7");
		this.setTextureName(HordeMod.MODID + ":radioK7");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
