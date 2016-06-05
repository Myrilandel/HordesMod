package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class TelephonePortable extends Item{

	public static boolean critSuccess = true;
	public TelephonePortable() {
		this.setUnlocalizedName("PavesDeBetonInformes");
		this.setTextureName(HordeMod.MODID + ":pavesDeBetonInformes");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		if(!entityPlayer.worldObj.isRemote){
			if(critSuccess)
				entity.attackEntityFrom(DamageSource.cactus, 50.0F);
			
			if(!critSuccess) {
				if(Math.random()>0.50)
					entity.attackEntityFrom(DamageSource.cactus, 50.0F);
			
				double randItem = Math.random();
				if(randItem<=0.25)
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.composantElectronique));
				if(randItem>0.25 && randItem<=0.50)
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.debrisMetalliques));
				if(randItem>0.50 && randItem<=0.75)
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.pileBroyee));
				if(randItem>0.75)
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.detonateurCompact));
			
			}
			switchCritSuccess();
		}
		return false;
	}
	
	private void switchCritSuccess() {
		critSuccess = !critSuccess;
	}
}
