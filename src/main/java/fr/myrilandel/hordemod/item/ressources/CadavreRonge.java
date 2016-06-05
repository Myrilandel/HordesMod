package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CadavreRonge extends Item{

	public CadavreRonge() {
		this.setUnlocalizedName("CadavreRonge");
		this.setTextureName(HordeMod.MODID + ":cadavreRonge");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
