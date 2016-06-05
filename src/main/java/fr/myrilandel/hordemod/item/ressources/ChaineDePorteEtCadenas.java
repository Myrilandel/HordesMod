package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChaineDePorteEtCadenas extends Item{

	public ChaineDePorteEtCadenas() {
		this.setUnlocalizedName("ChaineDePorteEtCadenas");
		this.setTextureName(HordeMod.MODID + ":chaineDePorteEtCadenas");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
