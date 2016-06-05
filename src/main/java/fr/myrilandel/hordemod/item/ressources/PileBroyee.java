package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PileBroyee extends Item {
	
	public PileBroyee() {
		this.setUnlocalizedName("PileBroyee");
		this.setTextureName(HordeMod.MODID + ":pileBroyee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
