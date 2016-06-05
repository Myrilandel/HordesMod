package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PortiereDeVoitureIncomplete extends Item {
	
	public PortiereDeVoitureIncomplete() {
		this.setUnlocalizedName("PortiereDeVoitureIncomplete");
		this.setTextureName(HordeMod.MODID + ":portiereDeVoitureIncomplete");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
