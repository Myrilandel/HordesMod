package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UneEncyclopedie extends Item {
	
	public UneEncyclopedie() {
		this.setUnlocalizedName("UneEncyclopedie");
		this.setTextureName(HordeMod.MODID + ":uneEncyclopedie");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
