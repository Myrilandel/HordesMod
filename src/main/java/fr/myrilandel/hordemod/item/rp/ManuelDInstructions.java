package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ManuelDInstructions extends Item {
	
	public ManuelDInstructions() {
		this.setUnlocalizedName("ManuelDInstructions");
		this.setTextureName(HordeMod.MODID + ":manuelDInstructions");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
