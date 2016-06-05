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

public class LSD extends ItemFood {

	public LSD() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("LSD");
		this.setTextureName(HordeMod.MODID + ":LSD");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.droguesCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			entityPropPA.setPA(SourcesDePA.LSD);
			entityPropPA.switchTerreur(true);
			entityPlayer.addChatMessage(new ChatComponentText("On ne sait pas d'où vient ce petit papier rose,"
					+ " mais quand on le met dans la bouche, il fait des bulles dans le cerveau."
					+ " Au fond, cela vous terrorise. Oui, c'est injuste."));	
			itemStack.stackSize--;	
		}		
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
}
