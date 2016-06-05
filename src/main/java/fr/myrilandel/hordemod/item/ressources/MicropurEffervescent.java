package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MicropurEffervescent extends Item{

	public MicropurEffervescent() {
		this.setUnlocalizedName("MicropurEffervescent");
		this.setTextureName(HordeMod.MODID + ":micropurEffervescent");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
