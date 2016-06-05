package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MorceauDeCaisse extends Item{

	public MorceauDeCaisse() {
		this.setUnlocalizedName("MorceauDeCaisse");
		this.setTextureName(HordeMod.MODID + ":morceauDeCaisse");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
