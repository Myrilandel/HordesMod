package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LancePileMarkIICharge extends Item {
	
	public LancePileMarkIICharge() {
		this.setUnlocalizedName("LancePileMarkIICharge");
		this.setTextureName(HordeMod.MODID + ":lancePileMarkIICharge");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote)
			world.spawnEntityInWorld(new EntityPile(world, entityPlayer));
	
		if(Math.random() < 0.20)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.pile));
		else
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.pileBroyee));
		
		entityPlayer.inventoryContainer.detectAndSendChanges();
 		return new ItemStack(HMItemRegistry.lancePileMarkIIVide);
	}
}
