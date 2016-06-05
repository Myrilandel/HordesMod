package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PeluresDePeau extends Item{

	public PeluresDePeau() {
		this.setUnlocalizedName("PeluresDePeau");
		this.setTextureName(HordeMod.MODID + ":peluresDePeau");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
