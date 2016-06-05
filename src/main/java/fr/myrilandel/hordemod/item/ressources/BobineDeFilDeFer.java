package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BobineDeFilDeFer extends Item {
	
	public BobineDeFilDeFer() {
		this.setUnlocalizedName("BobineDeFilDeFer");
		this.setTextureName(HordeMod.MODID + ":bobineDeFilDeFer");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
