package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RadiusMarkIIDechargee extends Item {
	
	public RadiusMarkIIDechargee() {
		this.setUnlocalizedName("RadiusMarkIIDechargee");
		this.setTextureName(HordeMod.MODID + ":radiusMarkIIDechargee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
