package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MaglitePifEteint extends Item {
	
	public MaglitePifEteint() {
		this.setUnlocalizedName("MaglitePifEteint");
		this.setTextureName(HordeMod.MODID + ":maglitePifEteint");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
