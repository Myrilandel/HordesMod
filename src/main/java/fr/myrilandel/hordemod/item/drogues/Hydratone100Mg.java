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

public class Hydratone100Mg extends ItemFood {

	public Hydratone100Mg() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("Hydratone100Mg");
		this.setTextureName(HordeMod.MODID + ":hydratone100Mg");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			if(!entityPropPA.desaltere) {
				entityPropPA.switchDesaltere(true);

				if(entityPropPA.drogue) {
					if(!entityPropPA.dependant)
						entityPlayer.addChatMessage(new ChatComponentText("Vous avez consommé trop de drogues ! Vous êtes dépendant !"));
					entityPropPA.switchDependant(true);
				}
				else
					entityPlayer.addChatMessage(new ChatComponentText("Vous n'avez plus soif... mais vous etes drogué."));	
	
				entityPropPA.switchDrogue(true);
				itemStack.stackSize--;	
			}		
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous avez déjà bu aujourd'hui."));	
		}
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
