package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MeubleEnKit extends Item {
	
	public MeubleEnKit() {
		this.setUnlocalizedName("MeubleEnKit");
		this.setTextureName(HordeMod.MODID + ":meubleEnKit");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
