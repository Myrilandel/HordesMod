package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BoiteDAllumettes extends Item{

	public BoiteDAllumettes() {
		this.setUnlocalizedName("BoiteDAllumettes");
		this.setTextureName(HordeMod.MODID + ":boiteDAllumettes");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
