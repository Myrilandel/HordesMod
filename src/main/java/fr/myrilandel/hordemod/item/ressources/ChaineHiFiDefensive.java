package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChaineHiFiDefensive extends Item{

	public ChaineHiFiDefensive() {
		this.setUnlocalizedName("ChaineHiFiDefensive");
		this.setTextureName(HordeMod.MODID + ":chaineHiFiDefensive");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
