package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PetiteChaineHiFiEnPanne extends Item{

	public PetiteChaineHiFiEnPanne() {
		this.setUnlocalizedName("PetiteChaineHiFiEnPanne");
		this.setTextureName(HordeMod.MODID + ":petiteChaineHiFiEnPanne");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
