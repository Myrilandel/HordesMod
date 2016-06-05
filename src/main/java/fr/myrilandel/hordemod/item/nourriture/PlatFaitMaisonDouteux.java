package fr.myrilandel.hordemod.item.nourriture;

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

public class PlatFaitMaisonDouteux extends ItemFood {

	public PlatFaitMaisonDouteux() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("PlatFaitMaisonDouteux");
		this.setTextureName(HordeMod.MODID + ":platFaitMaisonDouteux");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.nourritureCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote)
			if(!entityPropPA.rassasie) {
				entityPropPA.setPA(SourcesDePA.platFaitMaisonDouteux);
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
}
