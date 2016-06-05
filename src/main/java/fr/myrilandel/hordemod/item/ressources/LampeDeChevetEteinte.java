package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LampeDeChevetEteinte extends Item {
	
	public LampeDeChevetEteinte() {
		this.setUnlocalizedName("LampeDeChevetEteinte");
		this.setTextureName(HordeMod.MODID + ":lampeDeChevetEteinte");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
}
