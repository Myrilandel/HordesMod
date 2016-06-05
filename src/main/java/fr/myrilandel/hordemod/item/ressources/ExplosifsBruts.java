package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExplosifsBruts extends Item {
	
	public ExplosifsBruts() {
		this.setUnlocalizedName("ExplosifsBruts");
		this.setTextureName(HordeMod.MODID + ":explosifsBruts");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
