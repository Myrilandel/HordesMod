package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class StructuresMetalliques extends Item {
	
	public StructuresMetalliques() {
		this.setUnlocalizedName("StructuresMetalliques");
		this.setTextureName(HordeMod.MODID + ":structuresMetalliques");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
