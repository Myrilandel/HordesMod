package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PaquetDeCigarettesEntame extends Item{

	public PaquetDeCigarettesEntame() {
		this.setUnlocalizedName("PaquetDeCigarettesEntame");
		this.setTextureName(HordeMod.MODID + ":paquetDeCigarettesEntame");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
