package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FeuilleRaccornie extends Item {
	
	public FeuilleRaccornie() {
		this.setUnlocalizedName("FeuilleRaccornie");
		this.setTextureName(HordeMod.MODID + ":feuilleRaccornie");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
