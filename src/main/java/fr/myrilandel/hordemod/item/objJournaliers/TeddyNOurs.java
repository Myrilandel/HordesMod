package fr.myrilandel.hordemod.item.objJournaliers;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TeddyNOurs extends Item {

	public TeddyNOurs() {
		this.setUnlocalizedName("TeddyNOurs");
		this.setTextureName(HordeMod.MODID + ":teddyNOurs");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		ExtendedEntityPropJourna entityPropJourna = ExtendedEntityPropJourna.get(entityPlayer);	
		if(!world.isRemote)
			if(entityPropPA.terreur)
				if(!entityPropJourna.aUtiliseTeddyNOurs) {
					int randValue = getRandomValue();
					if(randValue < 8) {
						entityPropPA.switchTerreur(false);
						entityPlayer.addChatMessage(new ChatComponentText("Un calin a Teddy vous a permi de soigner la terreur."));
					}
					else
						entityPlayer.addChatMessage(new ChatComponentText("Ce calin ne vous a pas vraiment reconforte... Vous êtes toujours terrorise."));
					entityPropJourna.switchAUtiliseTeddyNOurs(true);
				}
				else 
					entityPlayer.addChatMessage(new ChatComponentText("Vous avez deja utilise Teddy aujourd'hui."));
			else
				entityPlayer.addChatMessage(new ChatComponentText("Inutile de caliner cet ours, vous n'etes pas terrorise."));

		return itemStack;
	}
	
	private int getRandomValue() {
		double randDouble = Math.random() * 10;
		return adjustRandom(randDouble);
	}
	
	private int adjustRandom(double randDouble) {
		for(int i = 1; i < 11; i++)
			if (randDouble < i) 
				return i-1;
		return 0;	
	}
}
