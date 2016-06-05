package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FragmentsDeTole extends Item {
	
	public FragmentsDeTole() {
		this.setUnlocalizedName("FragmentsDeTole");
		this.setTextureName(HordeMod.MODID + ":fragmentsDeTole");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
