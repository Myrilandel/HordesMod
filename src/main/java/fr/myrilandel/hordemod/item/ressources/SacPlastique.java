package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SacPlastique extends Item{

	public SacPlastique() {
		this.setUnlocalizedName("SacPlastique");
		this.setTextureName(HordeMod.MODID + ":sacPlastique");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
