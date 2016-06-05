package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LentilleConvexe extends Item {
	
	public LentilleConvexe() {
		this.setUnlocalizedName("LentilleConvexe");
		this.setTextureName(HordeMod.MODID + ":lentilleConvexe");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
