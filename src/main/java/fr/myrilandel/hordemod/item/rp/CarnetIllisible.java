package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CarnetIllisible extends Item {
	
	public CarnetIllisible() {
		this.setUnlocalizedName("CarnetIllisible");
		this.setTextureName(HordeMod.MODID + ":carnetIllisible");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
