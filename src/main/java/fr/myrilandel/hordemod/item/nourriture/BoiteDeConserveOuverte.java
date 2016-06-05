package fr.myrilandel.hordemod.item.nourriture;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BoiteDeConserveOuverte extends ItemFood {
	public IIcon[] icons = new IIcon[5];

	public BoiteDeConserveOuverte() {
		super(10, 0.0F, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setAlwaysEdible();
		this.setUnlocalizedName("BoiteDeConserveOuverte");
		this.setTextureName(HordeMod.MODID + ":boiteDeConserveOuverte");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.nourritureCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote)
			if(!entityPropPA.rassasie) {
				entityPropPA.setPA(SourcesDePA.boiteDeConserveOuverte);
				entityPropPA.switchRassasie(true);
				itemStack.stackSize--;
			}		
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous avez déjà mangé aujourd'hui."));	
		return itemStack;
	}

    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
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
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":boiteDeConserveOuverte");
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;
	    return this.icons[meta];
	}
}
