package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityPamplemousseExplosif;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PamplemousseExplosif extends Item {

	public PamplemousseExplosif() {
		this.setUnlocalizedName("PamplemousseExplosif");
		this.setTextureName(HordeMod.MODID + ":pamplemousseExplosif");
		this.setCreativeTab(HordeMod.armesCreativeTabs);
		this.setMaxStackSize(1);
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityPamplemousseExplosif(world, entityPlayer));
			itemStack.stackSize--;
		}
		return itemStack;
	}
}
