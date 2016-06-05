package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LivreZenMiniature extends Item {
	
	public LivreZenMiniature() {
		this.setUnlocalizedName("LivreZenMiniature");
		this.setTextureName(HordeMod.MODID + ":livreZenMiniature");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
