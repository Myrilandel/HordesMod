package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MaglitePif extends Item{

	public MaglitePif() {
		this.setUnlocalizedName("MaglitePif");
		this.setTextureName(HordeMod.MODID + ":maglitePif");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("maglitePif : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
