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

public class TaserDAutoDefenseCharge extends Item {

	public TaserDAutoDefenseCharge() {
		this.setUnlocalizedName("TaserDAutoDefenseCharge");
		this.setTextureName(HordeMod.MODID + ":taserDAutoDefenseCharge");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		if(!entityPlayer.worldObj.isRemote){
			if(Math.random()>0.50) 
				entity.attackEntityFrom(DamageSource.cactus, 50.0F);
			
			if(Math.random()>0.30) 
				entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.taserDAutoDefenseEteint));
		}
		return false;
	}
}
