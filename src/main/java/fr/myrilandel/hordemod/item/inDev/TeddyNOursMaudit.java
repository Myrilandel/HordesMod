package fr.myrilandel.hordemod.item.inDev;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TeddyNOursMaudit extends Item{

	public TeddyNOursMaudit() {
		this.setUnlocalizedName("TeddyNOursMaudit");
		this.setTextureName(HordeMod.MODID + ":teddyNOursMaudit");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("TeddyNOursMaudit : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
