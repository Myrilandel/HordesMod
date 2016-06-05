package fr.myrilandel.hordemod.item.coffresFermes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BoiteEnMetal extends Item{

	public BoiteEnMetal() {
		this.setUnlocalizedName("BoiteEnMetal");
		this.setTextureName(HordeMod.MODID + ":boiteEnMetal");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
}
