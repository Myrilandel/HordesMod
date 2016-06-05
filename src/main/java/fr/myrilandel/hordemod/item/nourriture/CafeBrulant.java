package fr.myrilandel.hordemod.item.nourriture;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CafeBrulant extends ItemFood {

	public CafeBrulant() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("CafeBrulant");
		this.setTextureName(HordeMod.MODID + ":cafeBrulant");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.nourritureCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote){
				entityPropPA.gainPA(SourcesDePA.cafeBrulant);
				itemStack.stackSize--;
		}		
		return itemStack;
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.cafetiere));
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
}
