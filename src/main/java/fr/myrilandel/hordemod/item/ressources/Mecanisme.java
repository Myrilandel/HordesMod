package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Mecanisme extends Item {
	
	public Mecanisme() {
		this.setUnlocalizedName("Mecanisme");
		this.setTextureName(HordeMod.MODID + ":mecanisme");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}