package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityBombeAEauExplosive;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BombeAEauExplosive extends Item {

	public BombeAEauExplosive() {
		this.setUnlocalizedName("BombeAEauExplosive");
		this.setTextureName(HordeMod.MODID + ":bombeAEauExplosive");
		this.setCreativeTab(HordeMod.armesCreativeTabs);
		this.setMaxStackSize(1);
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

		if(!world.isRemote)
			world.spawnEntityInWorld(new EntityBombeAEauExplosive(world, entityPlayer));

		itemStack.stackSize--;
		
		return itemStack;
	}
}
