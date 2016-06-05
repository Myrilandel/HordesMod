package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BarricadeAClouer extends Item {
	
	public BarricadeAClouer() {
		this.setUnlocalizedName("BarricadeAClouer");
		this.setTextureName(HordeMod.MODID + ":barricadeAClouer");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
