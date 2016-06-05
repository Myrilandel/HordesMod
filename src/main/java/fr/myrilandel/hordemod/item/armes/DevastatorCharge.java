package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DevastatorCharge extends Item {

	public static boolean critSuccess = true;
	
	public DevastatorCharge() {
		this.setUnlocalizedName("DevastatorCharge");
		this.setTextureName(HordeMod.MODID + ":devastatorCharge");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityPile(world, entityPlayer));
		
			if(!critSuccess) 			
				if(Math.random() < 0.50)
					entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.pile));
			switchCritSuccess();
			
			if(!critSuccess) 
		 		return itemStack;
			else 
				return new ItemStack(HMItemRegistry.devastatorVide);
		}
		entityPlayer.inventoryContainer.detectAndSendChanges();
		return itemStack;
	}
	
	private void switchCritSuccess() {
		critSuccess = !critSuccess;
	}
}
