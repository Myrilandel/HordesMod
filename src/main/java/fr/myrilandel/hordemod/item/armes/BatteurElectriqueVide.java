package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BatteurElectriqueVide extends Item {
	
	public BatteurElectriqueVide() {
		this.setUnlocalizedName("BatteurElectriqueVide");
		this.setTextureName(HordeMod.MODID + ":batteurElectriqueVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
