package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LiasseDeBillets extends Item {
	
	public LiasseDeBillets() {
		this.setUnlocalizedName("LiasseDeBillets");
		this.setTextureName(HordeMod.MODID + ":liasseDeBillets");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
