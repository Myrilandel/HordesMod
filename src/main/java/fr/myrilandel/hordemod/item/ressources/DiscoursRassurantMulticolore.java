package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class DiscoursRassurantMulticolore extends Item{

	public DiscoursRassurantMulticolore() {
		this.setUnlocalizedName("DiscoursRassurantMulticolore");
		this.setTextureName(HordeMod.MODID + ":discoursRassurantMulticolore");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
