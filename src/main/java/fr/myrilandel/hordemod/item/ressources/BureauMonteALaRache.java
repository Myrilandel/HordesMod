package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BureauMonteALaRache extends Item {
	
	public BureauMonteALaRache() {
		this.setUnlocalizedName("BureauMonteALaRache");
		this.setTextureName(HordeMod.MODID + ":bureauMonteALaRache");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
