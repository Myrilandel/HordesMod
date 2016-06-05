package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Courroie extends Item {
	
	public Courroie() {
		this.setUnlocalizedName("Courroie");
		this.setTextureName(HordeMod.MODID + ":courroie");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
