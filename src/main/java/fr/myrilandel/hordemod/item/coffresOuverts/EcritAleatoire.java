package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class EcritAleatoire extends Item {

	private static final Item item0 = HMItemRegistry.albumPhoto;
	private static final Item item1 = HMItemRegistry.carnetIllisible;
	private static final Item item2 = HMItemRegistry.livrePoussiereux;
	private static final Item item3 = HMItemRegistry.feuilleRaccornie;
	private static final Item item4 = HMItemRegistry.manuelDInstructions;
	private static final Item item5 = HMItemRegistry.pileDeFeuille;
	private static final Item item6 = HMItemRegistry.uneEtiquette;
	private static final Item item7 = HMItemRegistry.uneLettreSansAdresse;
	private static final Item item8 = HMItemRegistry.uneEncyclopedie;
	private static final Item item9 = HMItemRegistry.livreZenMiniature;
	
	Item[] tabItemRand = {item0, item1, item2, item3, item4, item5, item6, item7, item8, item9};

	public EcritAleatoire() {
		this.setUnlocalizedName("EcritAleatoire");
		this.setTextureName(HordeMod.MODID + ":ecritAleatoire");
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
