package fr.myrilandel.hordemod.item.coffresFermes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CaisseDeMateriel extends Item{

	public CaisseDeMateriel() {
		this.setUnlocalizedName("CaisseDeMateriel");
		this.setTextureName(HordeMod.MODID + ":caisseDeMateriel");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
}
