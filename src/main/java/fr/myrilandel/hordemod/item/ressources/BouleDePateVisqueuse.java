package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BouleDePateVisqueuse extends Item {
	
	public BouleDePateVisqueuse() {
		this.setUnlocalizedName("BouleDePateVisqueuse");
		this.setTextureName(HordeMod.MODID + ":bouleDePateVisqueuse");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
