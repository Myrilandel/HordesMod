package fr.myrilandel.hordemod.item.coffresOuverts;

import java.util.List;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CartonDeMateriaux extends Item{
	public IIcon[] icons = new IIcon[3];
	private static final Item item0 = HMItemRegistry.ferraille;
	private static final Item item1 = HMItemRegistry.planchesTordue;
	Item[] tabItemRand = {item0, item1};

	public CartonDeMateriaux() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName(getUnlocalizedName());
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(getRandomItem()));		
			if(itemStack.getItemDamage() == 0)
				itemStack.stackSize--;
			else
				itemStack.setItemDamage(itemStack.getItemDamage()-1);
			entityPlayer.inventoryContainer.detectAndSendChanges();
		}
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
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":cartonDeMateriaux_" + (i+1));
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;

	    return this.icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < icons.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return "cartonDeMateriaux_" + stack.getItemDamage();
	}
}
