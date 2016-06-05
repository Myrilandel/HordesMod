package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LivrePoussiereux extends Item {
	
	public LivrePoussiereux() {
		this.setUnlocalizedName("LivrePoussiereux");
		this.setTextureName(HordeMod.MODID + ":livrePoussiereux");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
