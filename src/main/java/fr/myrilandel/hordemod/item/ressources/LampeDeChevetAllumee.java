package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LampeDeChevetAllumee extends Item {
	
	public LampeDeChevetAllumee() {
		this.setUnlocalizedName("LampeDeChevetAllumee");
		this.setTextureName(HordeMod.MODID + ":lampeDeChevetAllumee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
}
