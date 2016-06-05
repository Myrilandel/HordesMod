package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PileDeFeuille extends Item {
	
	public PileDeFeuille() {
		this.setUnlocalizedName("PileDeFeuille");
		this.setTextureName(HordeMod.MODID + ":pileDeFeuille");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
