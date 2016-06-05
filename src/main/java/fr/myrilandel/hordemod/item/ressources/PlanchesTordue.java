package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PlanchesTordue extends Item {
	
	public PlanchesTordue() {
		this.setUnlocalizedName("PlanchesTordues");
		this.setTextureName(HordeMod.MODID + ":planchesTordues");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
