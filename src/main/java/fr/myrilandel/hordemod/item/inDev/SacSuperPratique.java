package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class SacSuperPratique extends Item {
	
	public SacSuperPratique() {
		this.setUnlocalizedName("SacSuperPratique");
		this.setTextureName(HordeMod.MODID + ":sacSuperPratique");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("sacSuperPratique : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
