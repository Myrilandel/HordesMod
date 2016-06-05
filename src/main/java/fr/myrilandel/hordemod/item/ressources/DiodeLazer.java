package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DiodeLazer extends Item {
	
	public DiodeLazer() {
		this.setUnlocalizedName("DiodeLazer");
		this.setTextureName(HordeMod.MODID + ":diodeLazer");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
