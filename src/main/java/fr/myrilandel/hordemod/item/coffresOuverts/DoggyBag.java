package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class DoggyBag extends Item {

	private static final Item item0 = HMItemRegistry.aileronsDePouletEntames;
	private static final Item item1 = HMItemRegistry.biscuitFades;
	private static final Item item2 = HMItemRegistry.chewingGumsSeches;
	private static final Item item3 = HMItemRegistry.jambonBeurreMoisi;
	private static final Item item4 = HMItemRegistry.napolitainsMoisis;
	private static final Item item5 = HMItemRegistry.nouillesChinoises;
	private static final Item item6 = HMItemRegistry.paquetDeChipsMolles;
	private static final Item item7 = HMItemRegistry.petitBeurresRances;
	private static final Item item8 = HMItemRegistry.pimsPerime;

	Item[] tabItemRand = {item0, item1, item2, item3, item4, item5, item6, item7, item8};

	public DoggyBag() {
		this.setUnlocalizedName("DoggyBag");
		this.setTextureName(HordeMod.MODID + ":doggyBag");
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
