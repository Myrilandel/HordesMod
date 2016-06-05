package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AppareilElectroniqueEnPanne extends Item {
	
	public AppareilElectroniqueEnPanne() {
		this.setUnlocalizedName("AppareilElectroniqueEnPanne");
		this.setTextureName(HordeMod.MODID + ":appareilElectroniqueEnPanne");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
