package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CaddieBancal extends Item{

	public CaddieBancal() {
		this.setUnlocalizedName("CaddieBancal");
		this.setTextureName(HordeMod.MODID + ":caddieBancal");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
