package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DevastatorIncomplet extends Item {
	
	public DevastatorIncomplet() {
		this.setUnlocalizedName("DevastatorIncomplet");
		this.setTextureName(HordeMod.MODID + ":devastatorIncomplet");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
