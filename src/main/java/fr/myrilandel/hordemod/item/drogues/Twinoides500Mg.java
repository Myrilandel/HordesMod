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

public class Twinoides500Mg extends ItemFood {

	public Twinoides500Mg() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("Twinoides500Mg");
		this.setTextureName(HordeMod.MODID + ":twinoides500Mg");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.droguesCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			entityPropPA.setPA(SourcesDePA.twinoides500Mg);

			if(entityPropPA.drogue) {
				if(!entityPropPA.dependant)
					entityPlayer.addChatMessage(new ChatComponentText("Vous avez consommé trop de drogues ! Vous êtes dépendant !"));
				entityPropPA.switchDependant(true);
			}
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous êtes drogué !"));	

			entityPropPA.switchDrogue(true);
			itemStack.stackSize--;	
		}		
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
