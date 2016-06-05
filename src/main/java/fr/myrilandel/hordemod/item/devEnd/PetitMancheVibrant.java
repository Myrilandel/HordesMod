package fr.myrilandel.hordemod.item.devEnd;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PetitMancheVibrant extends Item {

	public PetitMancheVibrant() {
		this.setUnlocalizedName("PetitMancheVibrant");
		this.setTextureName(HordeMod.MODID + ":petitMancheVibrant");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		if(!world.isRemote) {
			if(entityPropPA.terreur) {
				entityPropPA.switchTerreur(false);
				entityPlayer.addChatMessage(new ChatComponentText("Il vibre, vous titille et vous chatouille "
						+ "et vous fait oublier tous vos soucis pendant quelques instant"));
				itemStack.stackSize--;
			}
			else
				entityPlayer.addChatMessage(new ChatComponentText("Avez vous VRAIMENT besoin de ça ?"));
		}
		return new ItemStack(HMItemRegistry.petitMancheVibrantEteint);
	}
}
