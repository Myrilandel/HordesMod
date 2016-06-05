package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Charognardes extends Item{

	public Charognardes() {
		this.setUnlocalizedName("Charognardes");
		this.setTextureName(HordeMod.MODID + ":charognardes");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
