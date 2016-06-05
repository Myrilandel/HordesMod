package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CalibrateurPDTTMarkII extends Item {
	
	public CalibrateurPDTTMarkII() {
		this.setUnlocalizedName("CalibrateurPDTTMarkII");
		this.setTextureName(HordeMod.MODID + ":calibrateurPDTTMarkII");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
