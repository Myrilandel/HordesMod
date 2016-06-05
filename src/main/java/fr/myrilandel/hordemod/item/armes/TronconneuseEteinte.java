package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TronconneuseEteinte extends Item {
	
	public TronconneuseEteinte() {
		this.setUnlocalizedName("TronconneuseEteinte");
		this.setTextureName(HordeMod.MODID + ":tronconneuseEteinte");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
