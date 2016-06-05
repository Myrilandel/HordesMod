package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SubstanceEpaisse extends Item{

	public SubstanceEpaisse() {
		this.setUnlocalizedName("SubstanceEpaisse");
		this.setTextureName(HordeMod.MODID + ":substanceEpaisse");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
