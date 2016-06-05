package fr.myrilandel.hordemod.item.rp;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NoteDUnCitoyenBanni extends Item {
	
	public NoteDUnCitoyenBanni() {
		this.setUnlocalizedName("NoteDUnCitoyenBanni");
		this.setTextureName(HordeMod.MODID + ":noteDUnCitoyenBanni");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
