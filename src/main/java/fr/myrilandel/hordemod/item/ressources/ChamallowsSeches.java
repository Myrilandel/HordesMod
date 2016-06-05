package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChamallowsSeches extends Item {
	
	public ChamallowsSeches() {
		this.setUnlocalizedName("ChamallowsSeches");
		this.setTextureName(HordeMod.MODID + ":chamallowsSeches");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
