package fr.myrilandel.hordemod.item.alcools;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class VodkaMarinostov extends ItemFood {

	public VodkaMarinostov() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("VodkaMarinostov");
		this.setTextureName(HordeMod.MODID + ":vodkaMarinostov");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.alcoolsCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote)
			if(!entityPropPA.ivre && !entityPropPA.gueuleDeBois) {
				entityPropPA.setPA(SourcesDePA.vodkaMarinostov);
				entityPropPA.switchIvre(true);
				itemStack.stackSize--;
			}		
			else {
				if(entityPropPA.ivre)
					entityPlayer.addChatMessage(new ChatComponentText("Vous avez déjà bu et êtes complètement saoul !"));	
				if(entityPropPA.gueuleDeBois)
					entityPlayer.addChatMessage(new ChatComponentText("Vous avez une sacré gueule de bois. Vous ne pouvez pas boire d'alcool ajourd'hui !"));	
			}
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
}
