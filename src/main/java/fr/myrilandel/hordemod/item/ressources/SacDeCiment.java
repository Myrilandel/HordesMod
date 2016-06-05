package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SacDeCiment extends Item {
	
	public SacDeCiment() {
		this.setUnlocalizedName("SacDeCiment");
		this.setTextureName(HordeMod.MODID + ":sacDeCiment");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
