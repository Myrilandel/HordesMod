package fr.myrilandel.hordemod.item.points;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PointDeChantier extends Item {
	
	public PointDeChantier() {
		this.setUnlocalizedName("PointDeChantier");
		this.setTextureName(HordeMod.MODID + ":pointDeChantier");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
