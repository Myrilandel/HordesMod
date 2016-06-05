package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PistoletAEauVide extends Item {

	public PistoletAEauVide() {
		this.setUnlocalizedName("PistoletAEauVide");
		this.setTextureName(HordeMod.MODID + ":pistoletAEauVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
