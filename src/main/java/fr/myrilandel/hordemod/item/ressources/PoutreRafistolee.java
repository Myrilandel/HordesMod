package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PoutreRafistolee extends Item {
	
	public PoutreRafistolee() {
		this.setUnlocalizedName("PoutreRafistolee");
		this.setTextureName(HordeMod.MODID + ":poutreRafistolee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
