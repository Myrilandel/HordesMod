package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TronconneuseIncomplete extends Item {
	
	public TronconneuseIncomplete() {
		this.setUnlocalizedName("TronconneuseIncomplete");
		this.setTextureName(HordeMod.MODID + ":tronconneuseIncomplete");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
