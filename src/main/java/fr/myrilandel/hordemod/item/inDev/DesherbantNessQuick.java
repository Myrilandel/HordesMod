package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class DesherbantNessQuick extends Item{

	public DesherbantNessQuick() {
		this.setUnlocalizedName("DesherbantNessQuick");
		this.setTextureName(HordeMod.MODID + ":desherbantNessQuick");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("desherbantNessQuick : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
