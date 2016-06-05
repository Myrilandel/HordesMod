package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ferraille extends Item {
	
	public Ferraille() {
		this.setUnlocalizedName("Ferraille");
		this.setTextureName(HordeMod.MODID + ":ferraille");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
