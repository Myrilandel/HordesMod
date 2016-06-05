package fr.myrilandel.hordemod.item.eau;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EauCroupiePurifiee extends ItemFood {

	public EauCroupiePurifiee() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("EauCroupiePurifiee");
		this.setTextureName(HordeMod.MODID + ":eauCroupiePurifiee");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			if(!entityPropPA.desaltere) {
				entityPropPA.switchDesaltere(true);
				entityPropPA.setPA(SourcesDePA.rationDEau);
				itemStack.stackSize--;
			}
			else
				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez déjà bu aujourd'hui."));
		}
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
}
