package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TaserDAutoDefenseEteint extends Item {
	
	public TaserDAutoDefenseEteint() {
		this.setUnlocalizedName("TaserDAutoDefenseEteint");
		this.setTextureName(HordeMod.MODID + ":taserDAutoDefenseEteint");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
