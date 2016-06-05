package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LambeauDeChair extends Item {
	
	public LambeauDeChair() {
		this.setUnlocalizedName("LambeauDeChair");
		this.setTextureName(HordeMod.MODID + ":lambeauDeChair");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
