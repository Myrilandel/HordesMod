package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MorceauDeContreplaque extends Item{

	public MorceauDeContreplaque() {
		this.setUnlocalizedName("MorceauDeContreplaque");
		this.setTextureName(HordeMod.MODID + ":morceauDeContreplaque");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
