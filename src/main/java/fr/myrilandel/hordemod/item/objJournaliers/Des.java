package fr.myrilandel.hordemod.item.objJournaliers;

import java.util.Arrays;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Des extends Item {

	public Des() {
		this.setUnlocalizedName("Des");
		this.setTextureName(HordeMod.MODID + ":des");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		ExtendedEntityPropJourna entityPropJourna = ExtendedEntityPropJourna.get(entityPlayer);
		int[] tabDes = new int[3];
		if(!world.isRemote)
			if(!entityPropJourna.aJoueDes) {
				for(int i=0; i<tabDes.length; i++)
					tabDes[i] = getRandomValue()+1;
				entityPlayer.addChatMessage(new ChatComponentText("Vous obtenez "+tabDes[0]+", "+tabDes[1]+", et "+tabDes[2]+"."));

				if(jet421(tabDes) || jetTriple(tabDes) || jetSuite(tabDes))
					entityPropPA.gainPA(SourcesDePA.des);
				entityPropJourna.switchAJoueDes(true);
			}
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous avez déjà joué aux dés aujourd'hui !"));
		return itemStack;
	}
	
	private int getRandomValue() {
		double randDouble = Math.random() * 6;
		return adjustRandom(randDouble);
	}
	
	private int adjustRandom(double randDouble) {
		for(int i = 1; i < 7; i++)
			if (randDouble < i) 
				return i-1;
		return 0;	
	}
	
	private boolean jet421(int[] tabDes) {
		boolean is4 = false, is2 = false, is1 = false;
		for (int i=0;i<tabDes.length;i++) {
			if(tabDes[i] == 4)is4 = true;
			if(tabDes[i] == 2)is2 = true;
			if(tabDes[i] == 1)is1 = true;
		}
		return (is4 && is2 && is1);
	}
	
	private boolean jetTriple(int[] tabDes) {
		return (tabDes[0] == tabDes[1] && tabDes[1] == tabDes[2]); 
	}
	
	private boolean jetSuite(int[] tabDes) {
		Arrays.sort(tabDes);
		return (tabDes[0]+1 == tabDes[1] && tabDes[1]+1 == tabDes[2]); 
	}
}
