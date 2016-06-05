package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BatteurElectriqueIncomplet extends Item {
	
	public BatteurElectriqueIncomplet() {
		this.setUnlocalizedName("BatteurElectriqueIncomplet");
		this.setTextureName(HordeMod.MODID + ":batteurElectriqueIncomplet");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
