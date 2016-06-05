package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RadioK7Eteint extends Item{
	
	public RadioK7Eteint() {
		this.setUnlocalizedName("RadioK7Eteint");
		this.setTextureName(HordeMod.MODID + ":radioK7Eteint");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
