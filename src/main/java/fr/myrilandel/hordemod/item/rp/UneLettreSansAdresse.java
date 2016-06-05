package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UneLettreSansAdresse extends Item {
	
	public UneLettreSansAdresse() {
		this.setUnlocalizedName("UneLettreSansAdresse");
		this.setTextureName(HordeMod.MODID + ":uneLettreSansAdresse");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
