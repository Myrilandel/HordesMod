package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ComposantElectronique extends Item{

	public ComposantElectronique() {
		this.setUnlocalizedName("ComposantElectronique");
		this.setTextureName(HordeMod.MODID + ":composantElectronique");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
