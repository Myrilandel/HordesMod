package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Moteur extends Item {
	
	public Moteur() {
		this.setUnlocalizedName("Moteur");
		this.setTextureName(HordeMod.MODID + ":moteur");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
