package fr.myrilandel.hordemod.item.armes;

import java.util.List;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityEauBullet;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class AquaSplash extends Item{
	public IIcon[] icons = new IIcon[5];

	public AquaSplash() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName(getUnlocalizedName());
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return "aquaSplash_" + stack.getItemDamage();
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":aquaSplash_" + (i+1));
	    }
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityEauBullet(world, entityPlayer));
			if(itemStack.getItemDamage() == 0) {
				return new ItemStack(HMItemRegistry.aquaSplashVide);				
			}
			else
				itemStack.setItemDamage(itemStack.getItemDamage()-1);
		}
 		return itemStack;
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

}
