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

public class SteroidesAnabolisantsPoison extends ItemFood {

	public SteroidesAnabolisantsPoison() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("SteroidesAnabolisantsPoison");
		this.setTextureName(HordeMod.MODID + ":steroidesAnabolisantsPoison");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			itemStack.stackSize--;
			entityPlayer.addChatMessage(new ChatComponentText("Oups, il semblerait que quelqu'un ait empoisonné ceci..."));	
			entityPlayer.attackEntityFrom(DamageSource.magic, 100);
			}		
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
