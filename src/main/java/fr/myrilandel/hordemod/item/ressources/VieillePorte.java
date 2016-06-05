package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class VieillePorte extends Item {
	
	public VieillePorte() {
		this.setUnlocalizedName("VieillePorte");
		this.setTextureName(HordeMod.MODID + ":vieillePorte");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
