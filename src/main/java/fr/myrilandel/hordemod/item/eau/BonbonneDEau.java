package fr.myrilandel.hordemod.item.eau;

import java.util.List;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.registry.HMTileEntityRegistry;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BonbonneDEau extends ItemFood {
	public IIcon[] icons = new IIcon[3];

	public BonbonneDEau() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName(getUnlocalizedName());
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(entityPlayer);
			if(!props.desaltere) {
				props.switchDesaltere(true);
				props.setPA(SourcesDePA.rationDEau);
				if(itemStack.getItemDamage() == 0)
					return new ItemStack(HMItemRegistry.bonbonneDEauVide);
				else
					itemStack.setItemDamage(itemStack.getItemDamage()-1);
			}
			else 
				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez déjà bu aujourd'hui."));
		}
 		return itemStack;
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":bonbonneDEau_" + (i+1));
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
	    return "bonbonneDEau_" + stack.getItemDamage();
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
}
