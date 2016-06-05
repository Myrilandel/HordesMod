package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityBombeAEau;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BombeAEau extends Item {

	public BombeAEau() {
		this.setUnlocalizedName("BombeAEau");
		this.setTextureName(HordeMod.MODID + ":bombeAEau");
		this.setCreativeTab(HordeMod.armesCreativeTabs);
		this.setMaxStackSize(1);
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

		if(!world.isRemote)
			world.spawnEntityInWorld(new EntityBombeAEau(world, entityPlayer));

		itemStack.stackSize--;
		
		return itemStack;
	}
}
