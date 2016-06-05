package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DebrisMetalliques extends Item {
	
	public DebrisMetalliques() {
		this.setUnlocalizedName("DebrisMetalliques");
		this.setTextureName(HordeMod.MODID + ":debrisMetalliques");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
