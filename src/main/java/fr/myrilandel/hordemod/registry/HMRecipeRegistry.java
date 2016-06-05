package fr.myrilandel.hordemod.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HMRecipeRegistry {

	public static void registerAllRecipes() {
		recipeRegisterSimple();
		recipeRegisterComplexe();
		recipeRegisterAtelier();
		recipeRegisterReparations();
		recipeRegisterRechargements();
		recipeRegisterOpenWithTools();
	}
	
	private static void recipeRegisterSimple() {
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pureeDeCharognardes),
				new ItemStack(HMItemRegistry.bouleDePateVisqueuse),
				new ItemStack(HMItemRegistry.charognardes));	
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.chaineHiFiDefensive),
				new ItemStack(HMItemRegistry.bouleQuies),
				new ItemStack(HMItemRegistry.chaineHiFiMaudite));	
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.cafeBrulant),
				new ItemStack(HMItemRegistry.cafetiere),
				new ItemStack(HMItemRegistry.pile),	
				new ItemStack(HMItemRegistry.produitsPharmaceutiques),
				new ItemStack(HMItemRegistry.soucheDeBoisPourrie));	
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bouleDePateVisqueuse,1),
				new ItemStack(HMItemRegistry.pureeDeCharognardes,2));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.epicesFortes),
				new ItemStack(HMItemRegistry.rationDEau),
				new ItemStack(HMItemRegistry.nouillesChinoises));	
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.discoursRassurantMulticolore),
				new ItemStack(HMItemRegistry.figurineDeChuck),
				new ItemStack(HMItemRegistry.LSD));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bombeMacabre,1),
				new ItemStack(HMItemRegistry.lambeauDeChair,2));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.plaqueDeBoisSolide),
				new ItemStack(HMItemRegistry.morceauDeCaisse),
				new ItemStack(HMItemRegistry.planchesTordue));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.moteur),
				new ItemStack(HMItemRegistry.moteurIncomplet),
				new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				new ItemStack(HMItemRegistry.ferraille),
				new ItemStack(HMItemRegistry.rustine),
				new ItemStack(HMItemRegistry.detonateurCompact),
				new ItemStack(HMItemRegistry.osHumainFele));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.kitDeBricolage),
				new ItemStack(HMItemRegistry.outilsEnVrac),
				new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				new ItemStack(HMItemRegistry.rustine),
				new ItemStack(HMItemRegistry.planchesTordue));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.petiteChaineHiFi),
				new ItemStack(HMItemRegistry.petiteChaineHiFiEnPanne),
				new ItemStack(HMItemRegistry.pile),
				new ItemStack(HMItemRegistry.composantElectronique));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.clavicepsPurpurea),
				new ItemStack(HMItemRegistry.lentilleConvexe),
				new ItemStack(HMItemRegistry.sachetDHerbeFraiche));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pavesDeBetonInformes),
				new ItemStack(HMItemRegistry.sacDeCiment),
				new ItemStack(HMItemRegistry.rationDEau));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.substanceAIdentifier),
				new ItemStack(HMItemRegistry.produitsPharmaceutiques,2));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuvertePoison),
				new ItemStack(HMItemRegistry.fioleDePoison),
				new ItemStack(HMItemRegistry.boiteDeConserveOuverte));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.legumeSuspectPoison),
				new ItemStack(HMItemRegistry.fioleDePoison),
				new ItemStack(HMItemRegistry.legumeSuspect));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pureeDeCharognardesPoison),
				new ItemStack(HMItemRegistry.fioleDePoison),
				new ItemStack(HMItemRegistry.pureeDeCharognardes));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.rationDEauPoison),
				new ItemStack(HMItemRegistry.fioleDePoison),
				new ItemStack(HMItemRegistry.rationDEau));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.steroidesAnabolisantsPoison),
				new ItemStack(HMItemRegistry.fioleDePoison),
				new ItemStack(HMItemRegistry.steroidesAnabolisants));
	}
	
	private static void recipeRegisterComplexe() {
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.aquaSplashVide),
				" V ","WXY"," Z ",
				'V', new ItemStack(HMItemRegistry.sacPlastique),
				'W', new ItemStack(HMItemRegistry.tubeDeCuivre),
				'X', new ItemStack(HMItemRegistry.aquaSplashDemonte),
				'Y', new ItemStack(HMItemRegistry.rustine),
				'Z', new ItemStack(HMItemRegistry.detonateurCompact));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.batteurElectriqueVide),
				" W "," XY"," Z ",
				'W', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'X', new ItemStack(HMItemRegistry.batteurElectriqueIncomplet),
				'Y', new ItemStack(HMItemRegistry.composantElectronique),
				'Z', new ItemStack(HMItemRegistry.rustine));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.cidreClavicepsArtisanal),
				" X "," Y "," Z ",
				'X', new ItemStack(HMItemRegistry.clavicepsPurpurea),
				'Y', new ItemStack(HMItemRegistry.vodkaMarinostov),
				'Z', new ItemStack(HMItemRegistry.bidonDHuileVide));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.mineAntiPersonnel),
				"   ","WXY"," Z ",
				'W', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'X', new ItemStack(HMItemRegistry.explosifsBruts),
				'Y', new ItemStack(HMItemRegistry.rustine),
				'Z', new ItemStack(HMItemRegistry.bobineDeFilDeFer));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.torche),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.boiteDAllumettes),
				'Z', new ItemStack(HMItemRegistry.soucheDeBoisPourrie));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.guitareArtisanale),
				"  X"," Y ","Z  ",
				'X', new ItemStack(HMItemRegistry.bobineDeFilDeFer),
				'Y', new ItemStack(HMItemRegistry.grandBatonSecCasse),
				'Z', new ItemStack(HMItemRegistry.bidonDHuileVide));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.chaineHiFiMaudite),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.petiteChaineHiFi),
				'Z', new ItemStack(HMItemRegistry.CDBritneySpears));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.chaineHiFiMaudite),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.petiteChaineHiFi),
				'Z', new ItemStack(HMItemRegistry.CDPhilCollins));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.chaineHiFiRockNRoll),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.petiteChaineHiFi),
				'Z', new ItemStack(HMItemRegistry.compilationDuKing));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.caddie),
				"  W"," X "," YZ",
				'W', new ItemStack(HMItemRegistry.tubeDeCuivre),
				'X', new ItemStack(HMItemRegistry.caddieBancal),
				'Y', new ItemStack(HMItemRegistry.ferraille),
				'Z', new ItemStack(HMItemRegistry.rustine));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.cafetiere),
				"TU ","VWX","YZ ",
				'T', new ItemStack(HMItemRegistry.tubeDeCuivre),
				'U', new ItemStack(HMItemRegistry.cyanure),
				'V', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'W', new ItemStack(HMItemRegistry.cafetiereIncomplete),
				'X', new ItemStack(HMItemRegistry.ferraille),
				'Y', new ItemStack(HMItemRegistry.rustine),
				'Z', new ItemStack(HMItemRegistry.composantElectronique));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.lancePileMarkIIVide),
				" V ","WXY"," Z ",
				'V', new ItemStack(HMItemRegistry.rustine),
				'W', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'X', new ItemStack(HMItemRegistry.lancePile1PDTGVide),
				'Y', new ItemStack(HMItemRegistry.composantElectronique),
				'Z', new ItemStack(HMItemRegistry.calibrateurPDTTMarkII));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.chamallowsCalcines),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.chamallowsSeches),
				'Z', new ItemStack(HMItemRegistry.torche));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.LSD),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.clavicepsPurpurea),
				'Z', new ItemStack(HMItemRegistry.produitCorrosif));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.devastatorVide),
				" X "," Y "," Z ",
				'X', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'Y', new ItemStack(HMItemRegistry.devastatorIncomplet),
				'Z', new ItemStack(HMItemRegistry.courroie));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.sacPlastiqueExplosif),
				" W ","XYZ",
				'W', new ItemStack(HMItemRegistry.rustine),
				'X', new ItemStack(HMItemRegistry.detonateurCompact),
				'Y', new ItemStack(HMItemRegistry.sacPlastique),
				'Z', new ItemStack(HMItemRegistry.explosifsBruts));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.eauCroupiePurifiee),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.micropurEffervescent),
				'Z', new ItemStack(HMItemRegistry.eauCroupie));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.rationDEau),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.jerrycanPlein),
				'Z', new ItemStack(HMItemRegistry.micropurEffervescent));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.telescope),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.lentilleConvexe),
				'Z', new ItemStack(HMItemRegistry.tubeDeCuivre));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.paillassonPiege),
				"Y","Z",
				'Y', new ItemStack(HMItemRegistry.paillasson),
				'Z', new ItemStack(HMItemRegistry.mineAntiPersonnel));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.pompeAJerrycanChargee),
				"  Z"," XY",
				'X', new ItemStack(HMItemRegistry.jerrycanPlein),
				'Y', new ItemStack(HMItemRegistry.pompeAJerrycanDemontee),
				'Z', new ItemStack(HMItemRegistry.rustine));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.portiereDeVoiture),
				"  W"," XY","  Z",
				'W', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'X', new ItemStack(HMItemRegistry.portiereDeVoitureIncomplete),
				'Y', new ItemStack(HMItemRegistry.ferraille),
				'Z', new ItemStack(HMItemRegistry.rustine));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.bombePulverine),
				" XY"," Z ",
				'X', new ItemStack(HMItemRegistry.poudreCometeBrute),
				'Y', new ItemStack(HMItemRegistry.sacPlastique),
				'Z', new ItemStack(HMItemRegistry.rustine));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.fioleDePoison),
				"X Y"," Z ",
				'X', new ItemStack(HMItemRegistry.produitsPharmaceutiques),
				'Y', new ItemStack(HMItemRegistry.pile),
				'Z', new ItemStack(HMItemRegistry.produitCorrosif));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.scieAMetaux),
				"X","Y","Z",
				'X', new ItemStack(HMItemRegistry.rustine),
				'Y', new ItemStack(HMItemRegistry.scieAMetauxAbimee),
				'Z', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous));
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.scieAMetaux),
				" W","XY"," Z",
				'W', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'X', new ItemStack(HMItemRegistry.tondeuseAGazonDemontee),
				'Y', new ItemStack(HMItemRegistry.rustine),
				'Z', new ItemStack(HMItemRegistry.ferraille));
		
		GameRegistry.addRecipe(new ItemStack(HMItemRegistry.tronconneuseEteinte),
				" V ","WXY"," Z ",
				'V', new ItemStack(HMItemRegistry.poigneeDeVisEtEcrous),
				'W', new ItemStack(HMItemRegistry.tronconneuseIncomplete),
				'X', new ItemStack(HMItemRegistry.courroie),
				'Y', new ItemStack(HMItemRegistry.moteur),
				'Z', new ItemStack(HMItemRegistry.rustine));
	}
	
	private static void recipeRegisterAtelier() {
		//Ordre de http://www.d2nwiki.com/wiki/Workshop
		final ItemStack PA = new ItemStack(HMItemRegistry.pointDAtelier);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.planchesTordue),
				new ItemStack(HMItemRegistry.soucheDeBoisPourrie), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.planchesTordue),
				new ItemStack(HMItemRegistry.bucheEnBonEtat), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.poutreRafistolee),
				new ItemStack(HMItemRegistry.planchesTordue), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.planchesTordue),
				new ItemStack(HMItemRegistry.poutreRafistolee), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.ferraille),
				new ItemStack(HMItemRegistry.debrisMetalliques), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.structuresMetalliques),
				new ItemStack(HMItemRegistry.ferraille), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.ferraille),
				new ItemStack(HMItemRegistry.structuresMetalliques), PA);
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.kitDeBricolage),
				new ItemStack(HMItemRegistry.kitDeBricolageAbime), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.plaqueDeTole),
				new ItemStack(HMItemRegistry.morceauDeContreplaque), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuverte),
				new ItemStack(HMItemRegistry.boiteDeConserve), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.mecanismeDemonte),
				new ItemStack(HMItemRegistry.mecanisme), PA);		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.meubleEnKitAssemble),
				new ItemStack(HMItemRegistry.meubleEnKit), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.appareilElectroniqueRepare),
				new ItemStack(HMItemRegistry.appareilElectroniqueEnPanne), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte),
				new ItemStack(HMItemRegistry.caisseDeMateriel), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte),
				new ItemStack(HMItemRegistry.caisseDeNourriture), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteEnMetalOuverte),
				new ItemStack(HMItemRegistry.boiteEnMetal), PA);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosCoffreFortEnMetalOuvert),
				new ItemStack(HMItemRegistry.grosCoffreFortEnMetal), PA);
	}
	
	private static void recipeRegisterReparations() {
		//Ordre alphabetique des classes
		final ItemStack bricoFacile = new ItemStack(HMItemRegistry.bricoFacile);
		final ItemStack	kitDeBricolage = new ItemStack(HMItemRegistry.kitDeBricolage);
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.canifDerisoire,1,0),
				new ItemStack(HMItemRegistry.canifDerisoireCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.chaiseEktorpGluten,1,0),
				new ItemStack(HMItemRegistry.chaiseEktorpGlutenCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.cleAMolette,1,0),
				new ItemStack(HMItemRegistry.cleAMoletteCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.coupeCoupe,1,0),
				new ItemStack(HMItemRegistry.coupeCoupeCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.couteauADents,1,0),
				new ItemStack(HMItemRegistry.couteauADentsCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.couteauSuisse,1,0),
				new ItemStack(HMItemRegistry.couteauSuisseCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.cutter,1,0),
				new ItemStack(HMItemRegistry.cutterCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.fourCancerigene,1,0),
				new ItemStack(HMItemRegistry.fourCancerigeneCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grandBatonSec,1,0),
				new ItemStack(HMItemRegistry.grandBatonSecCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosseChaineRouillee,1,0),
				new ItemStack(HMItemRegistry.grosseChaineRouilleeCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.guitareArtisanale,1,0),
				new ItemStack(HMItemRegistry.guitareArtisanaleCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.osHumainFele,1,0),
				new ItemStack(HMItemRegistry.osHumainFeleCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.ouvreBoites,1,0),
				new ItemStack(HMItemRegistry.ouvreBoitesCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pavesDeBetonInformes,1,0),
				new ItemStack(HMItemRegistry.pavesDeBetonInformesCasses),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.refrigerateurDEtudiant,1,0),
				new ItemStack(HMItemRegistry.refrigerateurDEtudiantCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.tondeuseAGazon,1,0),
				new ItemStack(HMItemRegistry.tondeuseAGazonCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.torcheConsumee,1,0),
				new ItemStack(HMItemRegistry.torcheConsumeeCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.tournevis,1,0),
				new ItemStack(HMItemRegistry.tournevisCasse),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.uniteCentrale,1,0),
				new ItemStack(HMItemRegistry.uniteCentraleCassee),bricoFacile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.vieilleMachineALaver,1,0),
				new ItemStack(HMItemRegistry.vieilleMachineALaverCassee),bricoFacile);
	
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.canifDerisoire,1,1),
				new ItemStack(HMItemRegistry.canifDerisoireCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.chaiseEktorpGluten,1,1),
				new ItemStack(HMItemRegistry.chaiseEktorpGlutenCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.cleAMolette,1,1),
				new ItemStack(HMItemRegistry.cleAMoletteCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.coupeCoupe,1,1),
				new ItemStack(HMItemRegistry.coupeCoupeCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.couteauADents,1,1),
				new ItemStack(HMItemRegistry.couteauADentsCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.couteauSuisse,1,1),
				new ItemStack(HMItemRegistry.couteauSuisseCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.cutter,1,1),
				new ItemStack(HMItemRegistry.cutterCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.fourCancerigene,1,1),
				new ItemStack(HMItemRegistry.fourCancerigeneCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grandBatonSec,1,1),
				new ItemStack(HMItemRegistry.grandBatonSecCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosseChaineRouillee,1,1),
				new ItemStack(HMItemRegistry.grosseChaineRouilleeCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.guitareArtisanale,1,1),
				new ItemStack(HMItemRegistry.guitareArtisanaleCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.osHumainFele,1,1),
				new ItemStack(HMItemRegistry.osHumainFeleCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.ouvreBoites,1,1),
				new ItemStack(HMItemRegistry.ouvreBoitesCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pavesDeBetonInformes,1,1),
				new ItemStack(HMItemRegistry.pavesDeBetonInformesCasses),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.refrigerateurDEtudiant,1,1),
				new ItemStack(HMItemRegistry.refrigerateurDEtudiantCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.tondeuseAGazon,1,1),
				new ItemStack(HMItemRegistry.tondeuseAGazonCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.torcheConsumee,1,1),
				new ItemStack(HMItemRegistry.torcheConsumeeCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.tournevis,1,1),
				new ItemStack(HMItemRegistry.tournevisCasse),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.uniteCentrale,1,1),
				new ItemStack(HMItemRegistry.uniteCentraleCassee),kitDeBricolage);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.vieilleMachineALaver,1,1),
				new ItemStack(HMItemRegistry.vieilleMachineALaverCassee),kitDeBricolage);
	}
	
	private static void recipeRegisterRechargements() {
		final ItemStack pile = new ItemStack(HMItemRegistry.pile);
		final ItemStack	rationDEau = new ItemStack(HMItemRegistry.rationDEau);
		final ItemStack	jerrycanPlein = new ItemStack(HMItemRegistry.jerrycanPlein);

		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.lancePile1PDTGCharge),
				new ItemStack(HMItemRegistry.lancePile1PDTGVide), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.lancePileMarkIICharge),
				new ItemStack(HMItemRegistry.lancePileMarkIIVide), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.tronconneuseChargee),
				new ItemStack(HMItemRegistry.tronconneuseEteinte), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.devastatorCharge),
				new ItemStack(HMItemRegistry.devastatorVide), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.batteurElectriqueCharge),
				new ItemStack(HMItemRegistry.batteurElectriqueVide), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.taserDAutoDefenseCharge),
				new ItemStack(HMItemRegistry.taserDAutoDefenseEteint), pile);
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.aquaSplash,1,4),
				new ItemStack(HMItemRegistry.aquaSplashVide), rationDEau);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pistoletAEau,1,2),
				new ItemStack(HMItemRegistry.pistoletAEauVide), rationDEau);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bombeAEau),
				new ItemStack(HMItemRegistry.sacPlastique), rationDEau);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bombeAEauExplosive),
				new ItemStack(HMItemRegistry.sacPlastiqueExplosif), rationDEau);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.pompeAJerrycanChargee),
				new ItemStack(HMItemRegistry.pompeAJerrycanVide),jerrycanPlein );
				
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bonbonneDEau,1,2),
				new ItemStack(HMItemRegistry.bonbonneDEau,1,1),
				new ItemStack(HMItemRegistry.rationDEau, 1));	
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bonbonneDEau,1,1),
				new ItemStack(HMItemRegistry.bonbonneDEau,1,0),
				new ItemStack(HMItemRegistry.rationDEau, 1));	
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.bonbonneDEau,1,0),
				new ItemStack(HMItemRegistry.bonbonneDEauVide, 1),
				new ItemStack(HMItemRegistry.rationDEau, 1));	
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.radiusMarkII),
				new ItemStack(HMItemRegistry.radiusMarkIIDechargee), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.sportElecCharge),
				new ItemStack(HMItemRegistry.sportElecEteint), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.lampeDeChevetAllumee),
				new ItemStack(HMItemRegistry.lampeDeChevetEteinte), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.radioK7),
				new ItemStack(HMItemRegistry.radioK7Eteint), pile);
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.petitMancheVibrant),
				new ItemStack(HMItemRegistry.petitMancheVibrantEteint), pile);
		
	}

	private static void recipeRegisterOpenWithTools() {
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuverte,1,1),
				new ItemStack(HMItemRegistry.scieAMetaux),new ItemStack(HMItemRegistry.boiteDeConserve));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteEnMetalOuverte,1,1),
				new ItemStack(HMItemRegistry.scieAMetaux),new ItemStack(HMItemRegistry.boiteEnMetal));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosCoffreFortEnMetalOuvert,1,1),
				new ItemStack(HMItemRegistry.scieAMetaux),new ItemStack(HMItemRegistry.grosCoffreFortEnMetal));
	
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,1),
				new ItemStack(HMItemRegistry.chaiseEktorpGluten),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,1),
				new ItemStack(HMItemRegistry.chaiseEktorpGluten),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,2),
				new ItemStack(HMItemRegistry.uniteCentrale),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,2),
				new ItemStack(HMItemRegistry.uniteCentrale),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,3),
				new ItemStack(HMItemRegistry.cleAMolette),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,3),
				new ItemStack(HMItemRegistry.cleAMolette),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,4),
				new ItemStack(HMItemRegistry.cutter),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,4),
				new ItemStack(HMItemRegistry.cutter),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,5),
				new ItemStack(HMItemRegistry.osHumainFele),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,5),
				new ItemStack(HMItemRegistry.osHumainFele),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,6),
				new ItemStack(HMItemRegistry.coupeCoupe),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,6),
				new ItemStack(HMItemRegistry.coupeCoupe),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,7),
				new ItemStack(HMItemRegistry.canifDerisoire),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,7),
				new ItemStack(HMItemRegistry.canifDerisoire),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,8),
				new ItemStack(HMItemRegistry.grosseChaineRouillee),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,8),
				new ItemStack(HMItemRegistry.grosseChaineRouillee),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,9),
				new ItemStack(HMItemRegistry.couteauADents),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,9),
				new ItemStack(HMItemRegistry.couteauADents),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,10),
				new ItemStack(HMItemRegistry.grandBatonSec),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,10),
				new ItemStack(HMItemRegistry.grandBatonSec),new ItemStack(HMItemRegistry.caisseDeMateriel));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuverte,1,2),
				new ItemStack(HMItemRegistry.ouvreBoites),new ItemStack(HMItemRegistry.boiteDeConserve));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,11),
				new ItemStack(HMItemRegistry.ouvreBoites),new ItemStack(HMItemRegistry.caisseDeMateriel));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,11),
				new ItemStack(HMItemRegistry.ouvreBoites),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosCoffreFortEnMetalOuvert,1,2),
				new ItemStack(HMItemRegistry.ouvreBoites),new ItemStack(HMItemRegistry.grosCoffreFortEnMetal));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteEnMetalOuverte,1,2),
				new ItemStack(HMItemRegistry.ouvreBoites),new ItemStack(HMItemRegistry.boiteEnMetal));

		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuverte,1,3),
				new ItemStack(HMItemRegistry.tournevis),new ItemStack(HMItemRegistry.boiteDeConserve));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,12),
				new ItemStack(HMItemRegistry.tournevis),new ItemStack(HMItemRegistry.caisseDeMateriel));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,12),
				new ItemStack(HMItemRegistry.tournevis),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosCoffreFortEnMetalOuvert,1,3),
				new ItemStack(HMItemRegistry.tournevis),new ItemStack(HMItemRegistry.grosCoffreFortEnMetal));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteEnMetalOuverte,1,3),
				new ItemStack(HMItemRegistry.tournevis),new ItemStack(HMItemRegistry.boiteEnMetal));
		
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteDeConserveOuverte,1,4),
				new ItemStack(HMItemRegistry.couteauSuisse),new ItemStack(HMItemRegistry.boiteDeConserve));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeMaterielOuverte,1,13),
				new ItemStack(HMItemRegistry.couteauSuisse),new ItemStack(HMItemRegistry.caisseDeMateriel));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.caisseDeNourritureOuverte,1,13),
				new ItemStack(HMItemRegistry.couteauSuisse),new ItemStack(HMItemRegistry.caisseDeNourriture));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.grosCoffreFortEnMetalOuvert,1,4),
				new ItemStack(HMItemRegistry.couteauSuisse),new ItemStack(HMItemRegistry.grosCoffreFortEnMetal));
		GameRegistry.addShapelessRecipe(new ItemStack(HMItemRegistry.boiteEnMetalOuverte,1,4),
				new ItemStack(HMItemRegistry.couteauSuisse),new ItemStack(HMItemRegistry.boiteEnMetal));
	}
	
}
