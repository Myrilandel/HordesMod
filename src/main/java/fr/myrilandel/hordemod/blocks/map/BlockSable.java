package fr.myrilandel.hordemod.blocks.map;

import java.util.List;
import java.util.Random;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSable extends Block {
	// Ordre http://www.d2nwiki.com/wiki/The_Bank
	public static String[] subBlock = new String[] {"blockSable_1", "blockSable_2","blockSable_3"};
	public IIcon[] iconArray = new IIcon[subBlock.length];
	

	Item[] tabItemRandDepleted = {
			HMItemRegistry.debrisMetalliques,
			HMItemRegistry.soucheDeBoisPourrie
	};

	Item[] tabRepletedResources = {
			 HMItemRegistry.planchesTordue ,
			 HMItemRegistry.ferraille ,
			 HMItemRegistry.poutreRafistolee ,
			 HMItemRegistry.structuresMetalliques ,
			 HMItemRegistry.courroie ,
			 HMItemRegistry.detonateurCompact ,
			 HMItemRegistry.tubeDeCuivre ,
			 HMItemRegistry.rustine ,
			 HMItemRegistry.composantElectronique ,
			 HMItemRegistry.poigneeDeVisEtEcrous ,
			 HMItemRegistry.explosifsBruts ,
			 HMItemRegistry.sachetDHerbeFraiche ,
			 HMItemRegistry.grandBatonSecCasse ,
			 HMItemRegistry.lentilleConvexe ,
			 HMItemRegistry.bouleQuies ,
			 HMItemRegistry.bidonDHuileVide ,
			 HMItemRegistry.diodeLazer ,
			 HMItemRegistry.bobineDeFilDeFer ,
			 HMItemRegistry.appareilElectroniqueEnPanne ,
			 HMItemRegistry.mecanisme
	};
	
	Item[] tabRepletedContainers = {
			 HMItemRegistry.lancePile1PDTGVide ,
			 HMItemRegistry.pistoletAEauVide ,
			 HMItemRegistry.telephonePortable ,
			 HMItemRegistry.cleAMolette ,
			 HMItemRegistry.cutter ,
			 HMItemRegistry.ouvreBoites ,
			 HMItemRegistry.coupeCoupe ,
			 HMItemRegistry.canifDerisoire ,
			 HMItemRegistry.grosseChaineRouillee ,
			 HMItemRegistry.tournevis ,
			 HMItemRegistry.couteauADents ,
			 HMItemRegistry.grandBatonSec ,
			 HMItemRegistry.sacPlastique ,
	};
	
	Item[] tabRepletedArmoury = {
			 HMItemRegistry.sacSupplementaire ,
			 HMItemRegistry.ceintureAPoches ,
			 HMItemRegistry.boiteDejeuner ,
			 HMItemRegistry.boiteDeJeu ,
			 HMItemRegistry.cartonDeMateriaux,
			 HMItemRegistry.sacocheUsee ,
			 HMItemRegistry.boiteEnMetal ,
			 HMItemRegistry.grosCoffreFortEnMetal ,
			 HMItemRegistry.coffreFort ,
			 HMItemRegistry.caisseDeMateriel ,
			 HMItemRegistry.boiteDeConserve ,
			 HMItemRegistry.caisseDeNourriture ,
			 HMItemRegistry.grosColisPostal ,
			 HMItemRegistry.unColis ,
	};

	Item[] tabRepletedDefences = {
			 HMItemRegistry.tableJarpen ,
			 HMItemRegistry.matelas ,
			 HMItemRegistry.vieillePorte ,
			 HMItemRegistry.plaqueDeTole ,
			 HMItemRegistry.treteau ,
	};

	Item[] tabRepletedFood = {
			 HMItemRegistry.rationDEau ,
			 HMItemRegistry.nouillesChinoises ,
			 HMItemRegistry.chewingGumsSeches ,
			 HMItemRegistry.aileronsDePouletEntames ,
			 HMItemRegistry.viandeHumaine ,
			 HMItemRegistry.jambonBeurreMoisi ,
			 HMItemRegistry.napolitainsMoisis ,
			 HMItemRegistry.biscuitFades ,
			 HMItemRegistry.paquetDeChipsMolles ,
			 HMItemRegistry.petitBeurresRances ,
			 HMItemRegistry.pimsPerime ,
			 HMItemRegistry.legumeSuspect ,
			 HMItemRegistry.viandeHumaine ,
			 HMItemRegistry.melonDIntestin ,
			 HMItemRegistry.steakAppetissant ,
			 HMItemRegistry.chamallowsSeches ,
			 HMItemRegistry.doggyBag ,
			 HMItemRegistry.deboutLesMorts ,
			 HMItemRegistry.vodkaMarinostov ,
	};
	
	Item[] tabRepletedFurniture = {
			 HMItemRegistry.liasseDeBillets ,
			 HMItemRegistry.bucheEnBonEtat ,
			 HMItemRegistry.refrigerateurDEtudiant ,
			 HMItemRegistry.fourCancerigene ,
			 HMItemRegistry.vieilleMachineALaver ,
			 HMItemRegistry.barricadeAClouer ,
			 HMItemRegistry.morceauDeGrillage ,
			 HMItemRegistry.cartons ,
			 HMItemRegistry.cantineDeFer ,
			 HMItemRegistry.chaineDePorteEtCadenas ,
			 HMItemRegistry.chaiseEktorpGluten ,
			 HMItemRegistry.uniteCentrale ,
			 HMItemRegistry.lampeDeChevetEteinte ,
			 HMItemRegistry.teddyNOurs ,
			 HMItemRegistry.CDBritneySpears ,
			 HMItemRegistry.CDPhilCollins ,
			 HMItemRegistry.compilationDuKing ,
			 HMItemRegistry.figurineDeChuck ,
			 HMItemRegistry.paillasson ,
			 HMItemRegistry.rockingChair ,
	};
	
	Item[] tabRepletedPharmacy = {
			 HMItemRegistry.steroidesAnabolisants ,
			 HMItemRegistry.betapropine5MgPerimee ,
			 HMItemRegistry.twinoides500Mg ,
			 HMItemRegistry.medicamentSansEtiquette ,
			 HMItemRegistry.bandageRudimentaire ,
			 HMItemRegistry.hydratone100Mg ,
			 HMItemRegistry.paracetoide7G ,
			 HMItemRegistry.piqureDeCalmant ,
			 HMItemRegistry.livreZenMiniature ,
			 HMItemRegistry.cyanure ,
			 HMItemRegistry.produitsPharmaceutiques ,
			 HMItemRegistry.micropurEffervescent
	};
	
	Item[] tabRepletedMiscellaneous = {
			 HMItemRegistry.aquaSplashDemonte ,
			 HMItemRegistry.scieAMetauxAbimee ,
			 HMItemRegistry.portiereDeVoitureIncomplete ,
			 HMItemRegistry.devastatorIncomplet ,
			 HMItemRegistry.tondeuseAGazonDemontee ,
			 HMItemRegistry.moteurIncomplet ,
			 HMItemRegistry.cafetiereIncomplete ,
			 HMItemRegistry.tronconneuseIncomplete ,
			 HMItemRegistry.batteurElectriqueIncomplet ,
			 HMItemRegistry.caddieBancal ,
			 HMItemRegistry.produitCorrosif ,
			 HMItemRegistry.morceauDeCaisse ,
			 HMItemRegistry.poudreCometeBrute ,
			 HMItemRegistry.meubleEnKit ,
			 HMItemRegistry.jerrycanPlein ,
			 HMItemRegistry.calibrateurPDTTMarkII ,
			 HMItemRegistry.radioK7Eteint ,
			 HMItemRegistry.morceauDeContreplaque ,
			 HMItemRegistry.epicesFortes ,
			 HMItemRegistry.outilsEnVrac ,
			 HMItemRegistry.bonbonneDEauVide ,
			 HMItemRegistry.uneEncyclopedie ,
			 HMItemRegistry.livrePoussiereux ,
			 HMItemRegistry.desherbantNessQuick ,
			 HMItemRegistry.radiusMarkIIDechargee ,
			 HMItemRegistry.baliseRadius ,
			 HMItemRegistry.boiteDAllumettes ,
			 HMItemRegistry.bricoFacile ,
			 HMItemRegistry.petitMancheVibrantEteint ,
			 HMItemRegistry.paquetDeCigarettesEntame ,
			 HMItemRegistry.sportElecEteint ,
			 HMItemRegistry.fumigeneSenteurSapin ,
	};
	
	Item[][] itemTabRand = {
			tabRepletedResources,
			tabRepletedContainers,
			tabRepletedArmoury,
			tabRepletedDefences,
			tabRepletedFood,
			tabRepletedFurniture,
			tabRepletedPharmacy,
			tabRepletedMiscellaneous,
	};
	
	public BlockSable(Material material) {
		super(material);
		this.setBlockName("BlockSable");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister) {
		for(int i = 0; i < subBlock.length; i++)
			this.iconArray[ i] = iconRegister.registerIcon(HordeMod.MODID + ":" + subBlock[i]);
	}
	
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for(int i = 0; i < subBlock.length; i++)
			list.add(new ItemStack(item, 1, i));
	}
	
	public IIcon getIcon(int side, int metadata) {
		return metadata >= 0 && metadata < subBlock.length ? this.iconArray[metadata] : this.iconArray[0];
	}
	
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer entityPlayer, int i, float dx, float dy, float dz) {
		if(!world.isRemote) {
			if(getDamageValue(world, x, y, z) == 1) {
					ItemStack itemStack = new ItemStack(tabItemRandDepleted[MathHelper.getRandomIntegerInRange(new Random() , 0, 1)]);
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez trouvé l'objet : "+itemStack.getDisplayName()+" !"));
					entityPlayer.inventory.addItemStackToInventory(itemStack);
					world.setBlock(x, y, z, this, 0, 2);
			}
			
			if(getDamageValue(world, x, y, z) == 2) {
				int randTable = MathHelper.getRandomIntegerInRange(new Random(), 0, itemTabRand.length-1);
				Item [] tabRandSelected = itemTabRand[randTable];
						
				int randItem = MathHelper.getRandomIntegerInRange(new Random(), 0, tabRandSelected.length-1);
				ItemStack itemStack = new ItemStack(tabRandSelected[randItem]);

				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez trouvé l'objet : "+itemStack.getDisplayName()+" !"));
				entityPlayer.inventory.addItemStackToInventory(itemStack);
				world.setBlock(x, y, z, Blocks.air);
			}
			entityPlayer.inventoryContainer.detectAndSendChanges();
		}
		return false;
	}
}
