package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SacPlastiqueExplosif extends Item {
	
	public SacPlastiqueExplosif() {
		this.setUnlocalizedName("SacPlastiqueExplosif");
		this.setTextureName(HordeMod.MODID + ":sacPlastiqueExplosif");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
