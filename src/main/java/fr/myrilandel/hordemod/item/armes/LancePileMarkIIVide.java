package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class LancePileMarkIIVide extends Item {

	public LancePileMarkIIVide() {
		this.setUnlocalizedName("LancePileMarkIIVide");
		this.setTextureName(HordeMod.MODID + ":lancePileMarkIIVide");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
}
