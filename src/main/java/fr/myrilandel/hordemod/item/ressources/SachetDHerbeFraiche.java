package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SachetDHerbeFraiche extends Item{

	public SachetDHerbeFraiche() {
		this.setUnlocalizedName("SachetDHerbeFraiche");
		this.setTextureName(HordeMod.MODID + ":sachetDHerbeFraiche");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
