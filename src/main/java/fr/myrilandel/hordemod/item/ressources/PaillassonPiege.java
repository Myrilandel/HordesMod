package fr.myrilandel.hordemod.item.ressources;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PaillassonPiege extends Item{

	public PaillassonPiege() {
		this.setUnlocalizedName("PaillassonPiege");
		this.setTextureName(HordeMod.MODID + ":paillassonPiege");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
