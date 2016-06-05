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

public class CigaretteAllumee extends Item {

	public CigaretteAllumee() {
		this.setUnlocalizedName("CigaretteAllumee");
		this.setTextureName(HordeMod.MODID + ":cigaretteAllumee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		if(!world.isRemote) {
			if(entityPropPA.terreur) {
				entityPropPA.switchTerreur(false);
				entityPlayer.addChatMessage(new ChatComponentText("Cette dose de nicotine vous remonte le moral !"
						+ " La terreur disparait !"));
				itemStack.stackSize--;
			}
			else
				entityPlayer.addChatMessage(new ChatComponentText("Ce n'est pas l'heure de la pause cafe-clope..."));
		}
		return itemStack;
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		if(!world.isRemote) {
			if(Math.random() > 0.2) 
				entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.paquetDeCigarettesEntame));
			if(Math.random() > 0.2) 
				entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.boiteDAllumettes));
		}
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
}
