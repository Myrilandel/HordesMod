package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ClavicepsPurpurea extends Item {
	
	public ClavicepsPurpurea() {
		this.setUnlocalizedName("ClavicepsPurpurea");
		this.setTextureName(HordeMod.MODID + ":clavicepsPurpurea");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
