package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AquaSplashDemonte extends Item {
	
	public AquaSplashDemonte() {
		this.setUnlocalizedName("AquaSplashDemonte");
		this.setTextureName(HordeMod.MODID + ":aquaSplashDemonte");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
