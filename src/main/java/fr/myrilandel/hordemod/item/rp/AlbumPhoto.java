package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AlbumPhoto extends Item {
	
	public AlbumPhoto() {
		this.setUnlocalizedName("AlbumPhoto");
		this.setTextureName(HordeMod.MODID + ":albumPhoto");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
