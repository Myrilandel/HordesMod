package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ProduitsPharmaceutiques extends Item{

	public ProduitsPharmaceutiques() {
		this.setUnlocalizedName("ProduitsPharmaceutiques");
		this.setTextureName(HordeMod.MODID + ":produitsPharmaceutiques");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
