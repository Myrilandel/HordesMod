package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ScieAMetauxAbimee extends Item {
	
	public ScieAMetauxAbimee() {
		this.setUnlocalizedName("ScieAMetauxAbimee");
		this.setTextureName(HordeMod.MODID + ":scieAMetauxAbimee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
