package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChaineHiFiMaudite extends Item{

	public ChaineHiFiMaudite() {
		this.setUnlocalizedName("ChaineHiFiMaudite");
		this.setTextureName(HordeMod.MODID + ":chaineHiFiMaudite");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
