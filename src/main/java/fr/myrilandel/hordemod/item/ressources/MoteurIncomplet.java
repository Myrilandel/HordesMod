package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MoteurIncomplet extends Item {
	
	public MoteurIncomplet() {
		this.setUnlocalizedName("MoteurIncomplet");
		this.setTextureName(HordeMod.MODID + ":moteurIncomplet");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
