package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TapisPersan extends Item{

	public TapisPersan() {
		this.setUnlocalizedName("TapisPersan");
		this.setTextureName(HordeMod.MODID + ":tapisPersan");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
