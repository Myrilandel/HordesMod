package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PompeAJerrycanVide extends Item {
	
	public PompeAJerrycanVide() {
		this.setUnlocalizedName("PompeAJerrycanVide");
		this.setTextureName(HordeMod.MODID + ":pompeAJerrycanVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
