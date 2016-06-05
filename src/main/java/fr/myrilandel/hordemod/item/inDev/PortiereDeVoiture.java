package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PortiereDeVoiture extends Item {
	
	public PortiereDeVoiture() {
		this.setUnlocalizedName("PortiereDeVoiture");
		this.setTextureName(HordeMod.MODID + ":portiereDeVoiture");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
