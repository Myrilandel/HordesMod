package fr.myrilandel.hordemod.item.drogues;

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

public class PiqureDeCalmant extends ItemFood {

	public PiqureDeCalmant() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("PiqureDeCalmant");
		this.setTextureName(HordeMod.MODID + ":piqureDeCalmant");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.droguesCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			if(entityPropPA.terreur) {
				entityPropPA.switchTerreur(false);

				if(entityPropPA.drogue) {
					if(!entityPropPA.dependant)
						entityPlayer.addChatMessage(new ChatComponentText("Vous avez consommé trop de drogues ! Vous êtes dépendant !"));
					entityPropPA.switchDependant(true);
				}
				else
					entityPlayer.addChatMessage(new ChatComponentText("Vous vous sentez plus calme... Et drogué."));	
	
				entityPropPA.switchDrogue(true);
				itemStack.stackSize--;	
			}		
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous n'avez pas besoin de ça pour le moment."));	
		}
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
