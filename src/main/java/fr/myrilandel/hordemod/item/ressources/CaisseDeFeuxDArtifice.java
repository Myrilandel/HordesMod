package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CaisseDeFeuxDArtifice extends Item{

	public CaisseDeFeuxDArtifice() {
		this.setUnlocalizedName("CaisseDeFeuxDArtifice");
		this.setTextureName(HordeMod.MODID + ":caisseDeFeuxDArtifice");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
