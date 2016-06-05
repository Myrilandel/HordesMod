package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ProduitCorrosif extends Item {
	
	public ProduitCorrosif() {
		this.setUnlocalizedName("ProduitCorrosif");
		this.setTextureName(HordeMod.MODID + ":produitCorrosif");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
