package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FusilDAssautVide extends Item {
	
	public FusilDAssautVide() {
		this.setUnlocalizedName("FusilDAssautVide");
		this.setTextureName(HordeMod.MODID + ":fusilDAssautVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
