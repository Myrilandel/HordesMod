package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TondeuseAGazonDemontee extends Item {
	
	public TondeuseAGazonDemontee() {
		this.setUnlocalizedName("TondeuseAGazonDemontee");
		this.setTextureName(HordeMod.MODID + ":tondeuseAGazonDemontee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
