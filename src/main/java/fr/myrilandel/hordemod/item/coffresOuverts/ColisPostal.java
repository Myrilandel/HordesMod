package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ColisPostal extends Item {

	private static final Item item0 = HMItemRegistry.ecritAleatoire;
	private static final Item item1 = HMItemRegistry.liasseDeBillets;
	private static final Item item2 = HMItemRegistry.pileDeFeuille;
	private static final Item item3 = HMItemRegistry.reserveDUnCitoyenAvise;
	private static final Item item4 = HMItemRegistry.teddyNOurs;
	private static final Item item5 = HMItemRegistry.vodkaMarinostov;

	Item[] tabItemRand = {item0, item1, item2, item3, item4, item5};

	public ColisPostal() {
		this.setUnlocalizedName("ColisPostal");
		this.setTextureName(HordeMod.MODID + ":colisPostal");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote)
			return new ItemStack(getRandomItem());
		return itemStack; 
	}
	
	private Item getRandomItem() {
		double randDouble = Math.random() * (tabItemRand.length);
		return tabItemRand[adjustRandom(randDouble)];
	}
	
	private int adjustRandom(double randDouble) {
		for(int i = 1; i < tabItemRand.length+1; i++)
			if (randDouble < i) 
				return i-1;
		return 0;	
	}
}
