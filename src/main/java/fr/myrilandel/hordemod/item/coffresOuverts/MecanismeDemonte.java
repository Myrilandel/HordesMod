package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class MecanismeDemonte extends Item {

	private static final Item item0 = HMItemRegistry.poigneeDeVisEtEcrous;
	private static final Item item1 = HMItemRegistry.ferraille;
	private static final Item item2 = HMItemRegistry.tubeDeCuivre;
	private static final Item item3 = HMItemRegistry.debrisMetalliques;

	Item[] tabItemRand = {item0, item1, item2, item3};

	public MecanismeDemonte() {
		this.setUnlocalizedName("MecanismeDemonte");
		this.setTextureName(HordeMod.MODID + ":mecanismeDemonte");
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
