package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoffreDArchitecteOuvert extends Item {

	public CoffreDArchitecteOuvert() {
		this.setUnlocalizedName("CoffreDArchitecteOuvert");
		this.setTextureName(HordeMod.MODID + ":coffreDArchitecteOuvert");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote)
			return new ItemStack(HMItemRegistry.planTresRare);
		return itemStack; 
	}
}
