package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SportElecEteint extends Item {
	
	public SportElecEteint() {
		this.setUnlocalizedName("SportElecEteint");
		this.setTextureName(HordeMod.MODID + ":sportElecEteint");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
