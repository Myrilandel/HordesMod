package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RevolverVide extends Item {
	
	public RevolverVide() {
		this.setUnlocalizedName("RevolverVide");
		this.setTextureName(HordeMod.MODID + ":revolverVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
