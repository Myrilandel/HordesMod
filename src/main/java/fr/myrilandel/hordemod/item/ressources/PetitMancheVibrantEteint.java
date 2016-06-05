package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PetitMancheVibrantEteint extends Item {
	
	public PetitMancheVibrantEteint() {
		this.setUnlocalizedName("PetitMancheVibrantEteint");
		this.setTextureName(HordeMod.MODID + ":petitMancheVibrantEteint");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
