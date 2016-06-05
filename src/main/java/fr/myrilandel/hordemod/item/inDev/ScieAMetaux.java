package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ScieAMetaux extends Item {
	
	public ScieAMetaux() {
		this.setUnlocalizedName("ScieAMetaux");
		this.setTextureName(HordeMod.MODID + ":scieAMetaux");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("ScieAMetaux : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
