package fr.myrilandel.hordemod.item.objJournaliers;

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

public class JeuDeCartes extends Item {

	public JeuDeCartes() {
		this.setUnlocalizedName("JeuDeCartes");
		this.setTextureName(HordeMod.MODID + ":jeuDeCartes");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		ExtendedEntityPropJourna entityPropJourna = ExtendedEntityPropJourna.get(entityPlayer);	
		if(!world.isRemote)
			if(!entityPropJourna.aJoueJeuDeCartes) {
				String[] tabCouleur = {" de Pique", " de Coeur", " de Trefle", " de Carreau"};
				String[] tabValeur = {"As","2","3","4","5","6","7","8","9","10","Valet","Dame","Roi"};
				int carteSpe = getRandomValue(55); 
				int valeur = getRandomValue(13); 
				int couleur = getRandomValue(4); 

				if(carteSpe == 0) {
					entityPlayer.addChatMessage(new ChatComponentText("Vous tirez une carte… Vous poussez un hurlement en découvrant votre nom écrit en lettre de sang sur celle-ci ! "
							+ "Vous ignorez qui est à l'origine de cette blague de très mauvais goût…Vous êtes maintenant terrorisé !"));
					entityPropPA.switchTerreur(true);
					entityPropJourna.switchAJoueJeuDeCartes(true);
					return itemStack;
				}
				
				if(carteSpe == 1) {
					entityPlayer.addChatMessage(new ChatComponentText("Vous tirez la règle du jeu !!"));
					entityPropPA.gainPA(SourcesDePA.jeuDeCartes);
					entityPropJourna.switchAJoueJeuDeCartes(true);
					return itemStack;
				}

				entityPlayer.addChatMessage(new ChatComponentText("Vous tirez "+tabValeur[valeur]+tabCouleur[couleur]));

				if(bonneCarte(tabValeur[valeur], tabCouleur[couleur]))
					entityPropPA.gainPA(SourcesDePA.jeuDeCartes);
				
				entityPropJourna.switchAJoueJeuDeCartes(true);
			}
			else
				entityPlayer.addChatMessage(new ChatComponentText("Vous avez déjà joué aux cartes aujourd'hui !"));
		return itemStack;
	}
	
	private int getRandomValue(int maxValue) {
		double randDouble = Math.random() * maxValue;
		return adjustRandom(randDouble, maxValue);
	}
	
	private int adjustRandom(double randDouble, int maxValue) {
		for(int i = 1; i < maxValue+1; i++)
			if (randDouble < i) 
				return i-1;
		return 0;	
	}
	
	private boolean bonneCarte(String valeur, String couleur) {
		return(valeur.contains("As")|| (valeur.contains("Dame") && couleur.contains(" de Coeur")));
	}
}
