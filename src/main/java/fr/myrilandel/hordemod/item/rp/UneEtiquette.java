package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UneEtiquette extends Item {
	
	public UneEtiquette() {
		this.setUnlocalizedName("UneEtiquette");
		this.setTextureName(HordeMod.MODID + ":uneEtiquette");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
