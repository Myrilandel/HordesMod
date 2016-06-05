package fr.myrilandel.hordemod.item.devEnd;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BandageRudimentaire extends Item{

	public BandageRudimentaire() {
		this.setUnlocalizedName("BandageRudimentaire");
		this.setTextureName(HordeMod.MODID + ":bandageRudimentaire");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote)
			if(props.blesse) 
				if(!props.convalescent) {
					props.switchConvalescent(true);
					entityPlayer.addChatMessage(new ChatComponentText("Ce bandage apaise vos blessures. Attention, vous etes en convalescence."));
					itemStack.stackSize--;
				}
				else
					entityPlayer.addChatMessage(new ChatComponentText("Vous etes en convalescence et ne pouvez pas réutiliser de bandage aujourd'hui. La nuit va etre longue pour vous..."));
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous n'avez pas besoin d'utiliser ce bandage pour l'instant."));
			
		return itemStack;
	}
}
