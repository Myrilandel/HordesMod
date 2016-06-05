package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Cafetiere extends Item {
	
	public Cafetiere() {
		this.setUnlocalizedName("Cafetiere");
		this.setTextureName(HordeMod.MODID + ":cafetiere");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
