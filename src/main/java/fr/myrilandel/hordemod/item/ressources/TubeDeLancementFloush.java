package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TubeDeLancementFloush extends Item {
	
	public TubeDeLancementFloush() {
		this.setUnlocalizedName("TubeDeLancementFloush");
		this.setTextureName(HordeMod.MODID + ":tubeDeLancementFloush");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
