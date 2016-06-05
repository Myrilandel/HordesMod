package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ReserveDUnCitoyenAvise extends Item {

	private static final Item item0 = HMItemRegistry.bombePulverine;
	private static final Item item1 = HMItemRegistry.bricoFacile;
	private static final Item item2 = HMItemRegistry.lancePile1PDTGVide;
	private static final Item item3 = HMItemRegistry.pistoletAEau;
	private static final Item item4 = HMItemRegistry.fumigeneSenteurSapin;

	Item[] tabItemRand = {item0, item1, item2, item3, item4};

	public ReserveDUnCitoyenAvise() {
		this.setUnlocalizedName("ReserveDUnCitoyenAvise");
		this.setTextureName(HordeMod.MODID + ":reserveDUnCitoyenAvise");
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
