package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FigurineDeChuck extends Item {
	
	public FigurineDeChuck() {
		this.setUnlocalizedName("FigurineDeChuck");
		this.setTextureName(HordeMod.MODID + ":figurineDeChuck");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
