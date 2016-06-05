package fr.myrilandel.hordemod.item.coffresFermes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GrosCoffreFortEnMetal extends Item {
	
	public GrosCoffreFortEnMetal() {
		this.setUnlocalizedName("GrosCoffreFortEnMetal");
		this.setTextureName(HordeMod.MODID + ":grosCoffreFortEnMetal");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
}
