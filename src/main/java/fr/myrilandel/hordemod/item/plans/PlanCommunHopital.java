package fr.myrilandel.hordemod.item.plans;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PlanCommunHopital extends Item{

	public PlanCommunHopital() {
		this.setUnlocalizedName("PlanCommunHopital");
		this.setTextureName(HordeMod.MODID + ":planCommunHopital");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.addChatMessage(new ChatComponentText("PlanCommunHopital : OnItemRightClick - INDEV"));
		return itemStack;
	}
}
