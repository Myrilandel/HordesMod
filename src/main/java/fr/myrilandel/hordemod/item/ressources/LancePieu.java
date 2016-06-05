package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LancePieu extends Item {
	
	public LancePieu() {
		this.setUnlocalizedName("LancePieu");
		this.setTextureName(HordeMod.MODID + ":lancePieu");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
