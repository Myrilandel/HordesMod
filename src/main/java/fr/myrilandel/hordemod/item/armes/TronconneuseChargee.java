package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class TronconneuseChargee extends Item{

	private static int count = 3;

	public TronconneuseChargee() {
		this.setUnlocalizedName("TronconneuseChargee");
		this.setTextureName(HordeMod.MODID + ":tronconneuseChargee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		if(!entityPlayer.worldObj.isRemote){
			entity.attackEntityFrom(DamageSource.cactus, 50.0F);
			count--;
			
			if(count == 0) 
				if(Math.random()>0.70) 
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.tronconneuseEteinte));
				else
					count = 3;
		}
		return false;
	}
}
