package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MorceauDeGrillage extends Item{

	public MorceauDeGrillage() {
		this.setUnlocalizedName("MorceauDeGrillage");
		this.setTextureName(HordeMod.MODID + ":morceauDeGrillage");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
