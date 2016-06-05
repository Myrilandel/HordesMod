package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BricoFacile extends Item {
	
	public BricoFacile() {
		this.setUnlocalizedName("BricoFacile");
		this.setTextureName(HordeMod.MODID + ":bricoFacile");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
