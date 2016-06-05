package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CompilationDuKing extends Item{

	public CompilationDuKing() {
		this.setUnlocalizedName("CompilationDuKing");
		this.setTextureName(HordeMod.MODID + ":compilationDuKing");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
