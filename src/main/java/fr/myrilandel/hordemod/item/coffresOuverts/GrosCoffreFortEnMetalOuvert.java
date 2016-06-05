package fr.myrilandel.hordemod.item.coffresOuverts;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class GrosCoffreFortEnMetalOuvert extends Item {

	private static final Item item0 = HMItemRegistry.aquaSplashDemonte;
	private static final Item item1 = HMItemRegistry.batteurElectriqueIncomplet;
	private static final Item item2 = HMItemRegistry.bricoFacile;
	private static final Item item3 = HMItemRegistry.calibrateurPDTTMarkII;
	private static final Item item4 = HMItemRegistry.ceintureAPoches;
	private static final Item item5 = HMItemRegistry.coupeCoupe;
	private static final Item item6 = HMItemRegistry.devastatorIncomplet;
	private static final Item item7 = HMItemRegistry.tondeuseAGazonDemontee;
	private static final Item item8 = HMItemRegistry.tronconneuseIncomplete;

	Item[] tabItemRand = {item0, item1, item2, item3, item4, item5, item6, item7, item8};
	public IIcon[] icons = new IIcon[5];
	
	public GrosCoffreFortEnMetalOuvert() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName("GrosCoffreFortEnMetalOuvert");
		this.setTextureName(HordeMod.MODID + ":grosCoffreFortEnMetalOuvert");
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
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(getDamage(itemStack) == 0)
			return;
		if(getDamage(itemStack) == 1)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.scieAMetaux));
		if(getDamage(itemStack) == 2)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.ouvreBoites));
		if(getDamage(itemStack) == 3)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.tournevis));
		if(getDamage(itemStack) == 4)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.couteauSuisse));
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
    
    @Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":grosCoffreFortEnMetalOuvert");
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;
	    return this.icons[meta];
	}
}
