package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AquaSplashVide extends Item {
	
	public AquaSplashVide() {
		this.setUnlocalizedName("AquaSplashVide");
		this.setTextureName(HordeMod.MODID + ":aquaSplashVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
