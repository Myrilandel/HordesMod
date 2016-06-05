package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DetonateurCompact extends Item {
	
	public DetonateurCompact() {
		this.setUnlocalizedName("DetonateurCompact");
		this.setTextureName(HordeMod.MODID + ":detonateurCompact");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
