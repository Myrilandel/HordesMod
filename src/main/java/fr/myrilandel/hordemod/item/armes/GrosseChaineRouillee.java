package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class GrosseChaineRouillee extends Item{
	public IIcon[] icons = new IIcon[2];

	public GrosseChaineRouillee() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName("GrosseChaineRouillee");
		this.setTextureName(HordeMod.MODID + ":grosseChaineRouillee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		if(!entityPlayer.worldObj.isRemote){
			if(Math.random()>0.50) 
				entity.attackEntityFrom(DamageSource.cactus, 50.0F);
			
			if(Math.random()>0.70) 
				entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,new ItemStack(HMItemRegistry.grosseChaineRouilleeCassee));
		}
		return false;
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(getDamage(itemStack) == 0)
			return;
		if(getDamage(itemStack) == 1)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.kitDeBricolageAbime));
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":grosseChaineRouillee");
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;
	    return this.icons[meta];
	}
}
