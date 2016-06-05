package fr.myrilandel.hordemod.item.points;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PointDAtelier extends Item {
	
	public PointDAtelier() {
		this.setUnlocalizedName("PointDAtelier");
		this.setTextureName(HordeMod.MODID + ":pointDAtelier");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
