package fr.myrilandel.hordemod.item.plans;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PlanRareHotel extends Item{

	public PlanRareHotel() {
		this.setUnlocalizedName("PlanRareHotel");
		this.setTextureName(HordeMod.MODID + ":planRareHotel");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("PlanRareHotel : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
