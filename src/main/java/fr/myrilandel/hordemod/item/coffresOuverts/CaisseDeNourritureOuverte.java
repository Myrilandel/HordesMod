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

public class CaisseDeNourritureOuverte extends Item {

	private static final Item item0 = HMItemRegistry.doggyBag;
	private static final Item item1 = HMItemRegistry.legumeSuspect;
	private static final Item item2 = HMItemRegistry.steakAppetissant;
	private static final Item item3 = HMItemRegistry.viandeHumaine;
	private static final Item item4 = HMItemRegistry.boiteDeConserve;
	Item[] tabItemRand = {item0, item1, item2, item3, item4,};

	public IIcon[] icons = new IIcon[14];
	public CaisseDeNourritureOuverte() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName("CaisseDeNourritureOuverte");
		this.setTextureName(HordeMod.MODID + ":caisseDeNourritureOuverte");
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
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.chaiseEktorpGluten));
		if(getDamage(itemStack) == 2)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.uniteCentrale));
		if(getDamage(itemStack) == 3)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.cleAMolette));
		if(getDamage(itemStack) == 4)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.cutter));
		if(getDamage(itemStack) == 5)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.osHumainFele));
		if(getDamage(itemStack) == 6)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.coupeCoupe));
		if(getDamage(itemStack) == 7)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.canifDerisoire));
		if(getDamage(itemStack) == 8)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.grosseChaineRouillee));
		if(getDamage(itemStack) == 9)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.couteauADents));
		if(getDamage(itemStack) == 10)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.grandBatonSec));
		if(getDamage(itemStack) == 11)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.ouvreBoites));
		if(getDamage(itemStack) == 12)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.tournevis));
		if(getDamage(itemStack) == 13)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.couteauSuisse));
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
    
    @Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":caisseDeNourritureOuverte");
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;
	    return this.icons[meta];
	}
}
