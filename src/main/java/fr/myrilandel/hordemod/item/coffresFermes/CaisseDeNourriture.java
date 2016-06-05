package fr.myrilandel.hordemod.item.coffresFermes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CaisseDeNourriture extends Item{

	public CaisseDeNourriture() {
		this.setUnlocalizedName("CaisseDeNourriture");
		this.setTextureName(HordeMod.MODID + ":caisseDeNourriture");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
}
