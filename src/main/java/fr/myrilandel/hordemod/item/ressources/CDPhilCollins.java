package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CDPhilCollins extends Item{

	public CDPhilCollins() {
		this.setUnlocalizedName("CDPhilCollins");
		this.setTextureName(HordeMod.MODID + ":CDPhilCollins");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
