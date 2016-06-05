package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PoigneeDeVisEtEcrous extends Item {
	
	public PoigneeDeVisEtEcrous() {
		this.setUnlocalizedName("PoigneeDeVisEtEcrous");
		this.setTextureName(HordeMod.MODID + ":poigneeDeVisEtEcrous");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
