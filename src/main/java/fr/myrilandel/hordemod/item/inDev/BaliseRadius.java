package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BaliseRadius extends Item{

	public BaliseRadius() {
		this.setUnlocalizedName("BaliseRadius");
		this.setTextureName(HordeMod.MODID + ":baliseRadius");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("BaliseRadius : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
