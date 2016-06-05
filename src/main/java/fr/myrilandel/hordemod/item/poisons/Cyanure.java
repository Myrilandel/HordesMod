package fr.myrilandel.hordemod.item.poisons;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Cyanure extends ItemFood {

	public Cyanure() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("Cyanure");
		this.setTextureName(HordeMod.MODID + ":cyanure");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {		
		if(!world.isRemote) {
			itemStack.stackSize--;
			entityPlayer.addChatMessage(new ChatComponentText("Quand rien ne va, une petite capsule de cyanure, "
					+ "un grand verre d’eau et on attend que ça passe avec un sourire apaisé"));	
			entityPlayer.attackEntityFrom(DamageSource.magic, 100);
			}
		
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
