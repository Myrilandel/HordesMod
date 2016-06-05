package fr.myrilandel.hordemod.item.coffresFermes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CoffreFort extends Item{

	public CoffreFort() {
		this.setUnlocalizedName("CoffreFort");
		this.setTextureName(HordeMod.MODID + ":coffreFort");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.coffresCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			ExtendedEntityPropEtats EntityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
			if(EntityPropPA.pertePA(10))
				if(Math.random() > 0.9) {
					entityPlayer.addChatMessage(new ChatComponentText("Vous avez réussi à ouvrir le coffre !"));	
					return new ItemStack(HMItemRegistry.coffreFortOuvert);
				}
				else {
					entityPlayer.addChatMessage(new ChatComponentText("Le coffre reste ferme."));
					return itemStack;
			}
		}
		return itemStack;
	}
}
