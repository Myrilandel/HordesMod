package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PompeAJerrycanDemontee extends Item {
	
	public PompeAJerrycanDemontee() {
		this.setUnlocalizedName("PompeAJerrycanDemontee");
		this.setTextureName(HordeMod.MODID + ":pompeAJerrycanDemontee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
