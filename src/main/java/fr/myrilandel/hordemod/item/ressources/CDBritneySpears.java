package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CDBritneySpears extends Item{

	public CDBritneySpears() {
		this.setUnlocalizedName("CDBritneySpears");
		this.setTextureName(HordeMod.MODID + ":CDBritneySpears");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
