package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChaineHiFiRockNRoll extends Item{

	public ChaineHiFiRockNRoll() {
		this.setUnlocalizedName("ChaineHiFiRockNRoll");
		this.setTextureName(HordeMod.MODID + ":chaineHiFiRockNRoll");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
