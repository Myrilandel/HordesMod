package fr.myrilandel.hordemod.item.casses;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ChaiseEktorpGlutenCassee extends Item{

	public ChaiseEktorpGlutenCassee() {
		this.setUnlocalizedName("ChaiseEktorpGlutenCassee");
		this.setTextureName(HordeMod.MODID + ":chaiseEktorpGlutenCassee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.cassesCreativeTabs);
	}
}
