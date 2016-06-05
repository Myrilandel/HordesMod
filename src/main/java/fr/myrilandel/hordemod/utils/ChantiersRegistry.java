package fr.myrilandel.hordemod.utils;

import java.util.Vector;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ChantiersRegistry {
	
	public static final int nbPlanCommun = 33;
	public static final int nbPlanInhabituel = 29;
	public static final int nbPlanRare = 23;
	public static final int nbPlanTresRare = 14;
	
	public static final String[] nomChantierCommun = {
		"Douves","Muraille rasoir",
		"Fosse à pieux","Appâts",
		"Remparts avancés","Muraille à pointes",
		"Seconde couche","Bétonnade",
		"Râpe à zombies","Palissade",
		"Mur savoné","Pulvérisateur",
		"Projection acide","Bastion",
		"Potager","Sanibroyeur",
		"Percée","Caniveaux",
		"Rid'eau","Canon à briques",
		"Perforeuse","Lance-Grenailles",
		"Abattoir","Cimetière cadenassé",
		"Cantine centrale","Laboratoire central",
		"Catapulte primitive","Carte améliorée",
		"Planificateur","Scrutateur",
		"Mont pointu","Piston verrou",
		"Piston calibré"
	};
	
	public static final String[] nomChantierInhabituel = {
		"Grogro mur","Troisième couche",
		"Neurotoxine","Champ de mines à eau",
		"Pamplemousses explosifs","Douches",
		"Pluvio-canons","Boucherie",
		"Crémato-Cue","Catapulte calibrée",
		"Scanner","Guerilla",
		"La Bamba","Tour des gardiens",
		"Tourelle lance-eau","Lance-bête",
		"Armurerie","Magasin suédois",
		"Tour des éclaireurs","Décharge blindée",
		"Décharge piégée","Appâts odorants",
		"Déchardes de bois","Ferraillerie",
		"Enclos","Feu de joie",
		"Dictature des héros","Autel de la rédemption",
		"Conduite d'aération"
	};

	public static final String[] nomChantierRare = {
			"Muraille évolutive","Filtre",
			"Fertilisation sauvage","Projet Eden",
			"Arroseurs auto","Aqua tourelles",
			"Pommier de l'Outre-Monde","Roquette Foreuse",
			"Fixations de défenses","Supports défensifs",
			"Poulailler","Infirmerie",
			"Quartiers circulaires","Grand déménagement",
			"Derrick","Fausse ville",
			"Robinetterie","Décharge organisée",
			"Phare","Habitations fortifiées",
			"Habitations fortifiées","Dernière chance",
			"Roquettes",
	};

	public static final String[] nomChantierTresRare = {
			"Détecteur à eau","Cercueils sur ressort",
			"Stratégies citoyennes","Décharge humidifiée",
			"Bureau des esclavagistes","Foreuse améliorée",
			"Cinéma","Montgolfière",
			"Feux d'artifices","PMV géant",
			"Statue du Corbeau","Grande roue de Grostas",
			"Château de sable","Réacteur soviétique"
	};
	
	public static final ResourceLocation PA = new ResourceLocation(HordeMod.MODID,"textures/GUI/pointAction.png");
	
	public static final ResourceLocation composantElectronique = new ResourceLocation(HordeMod.MODID,"textures/items/composantElectronique.png");
	public static final ResourceLocation courroie = new ResourceLocation(HordeMod.MODID,"textures/items/courroie.png");
	public static final ResourceLocation explosifBrut = new ResourceLocation(HordeMod.MODID,"textures/items/explosifBrut.png");
	public static final ResourceLocation ferraille = new ResourceLocation(HordeMod.MODID,"textures/items/ferraille.png");
	public static final ResourceLocation morceauDeGrillage = new ResourceLocation(HordeMod.MODID,"textures/items/morceauDeGrillage.png");
	public static final ResourceLocation pavesDeBetons = new ResourceLocation(HordeMod.MODID,"textures/items/pavesDeBetonInformes.png");
	public static final ResourceLocation paracetoide7G = new ResourceLocation(HordeMod.MODID,"textures/items/paracetoide7G.png");
	public static final ResourceLocation planchesTordue = new ResourceLocation(HordeMod.MODID,"textures/items/planchesTordues.png");
	public static final ResourceLocation plaqueDeTole = new ResourceLocation(HordeMod.MODID,"textures/items/plaqueDeTole.png");
	public static final ResourceLocation poigneeDeVisEtEcrous = new ResourceLocation(HordeMod.MODID,"textures/items/poigneeDeVisEtEcrous.png");
	public static final ResourceLocation poutreRafistolee = new ResourceLocation(HordeMod.MODID,"textures/items/poutreRafistolee.png");
	public static final ResourceLocation produitsPharmaceutiques = new ResourceLocation(HordeMod.MODID,"textures/items/produitsPharmaceutiques.png");
	public static final ResourceLocation rationDEau = new ResourceLocation(HordeMod.MODID,"textures/items/rationDEau.png");
	public static final ResourceLocation rustine = new ResourceLocation(HordeMod.MODID,"textures/items/rustine.png");
	public static final ResourceLocation steroidesAnabolisants = new ResourceLocation(HordeMod.MODID,"textures/items/steroidesAnabolisants.png");
	public static final ResourceLocation structuresMetalliques = new ResourceLocation(HordeMod.MODID,"textures/items/structuresMetalliques.png");
	public static final ResourceLocation tableJarpen = new ResourceLocation(HordeMod.MODID,"textures/items/tableJarpen.png");
	public static final ResourceLocation tubeDeCuivre = new ResourceLocation(HordeMod.MODID,"textures/items/tubeDeCuivre.png");	
	public static final ResourceLocation vodkaMarinostov = new ResourceLocation(HordeMod.MODID,"textures/items/vodkaMarinostov.png");	

	/** Section Muraille **/
	public static int[] recetteMuraille = {15,5,30};
	public static Object[] defMuraille = {true,30};
	public static ResourceLocation[] texturesMuraille = {planchesTordue,ferraille,PA};
	
	public static int[] recetteGrandFosse = {80};
	public static Object[] defGrandFosse = {true,10};
	public static ResourceLocation[] texturesGrandFosse = {PA};
	
	public static int[] recetteDouves = {20,50};
	public static Object[] defDouves = {true,65};
	public static ResourceLocation[] texturesDouves = {rationDEau,PA};
	
	public static int[] recetteMurailleRasoir = {15,2,40};
	public static Object[] defMurailleRasoir = {true,50};
	public static ResourceLocation[] texturesMurailleRasoir = {ferraille,poigneeDeVisEtEcrous,PA};
	
	public static int[] recetteFosseAPieux = {8,4,40};
	public static Object[] defFosseAPieux = {true,40};
	public static ResourceLocation[] texturesFosseAPieux = {planchesTordue,poutreRafistolee,PA};
	
	public static int[] recetteBarbeles = {2,20};
	public static Object[] defBarbeles = {true,10};
	public static ResourceLocation[] texturesBarbeles = {ferraille,PA};
	
	public static int[] recetteAppats = {2,20};
	public static Object[] defAppats = {true,10};
	public static ResourceLocation[] texturesAppats = {ferraille,PA};
	
	public static int[] recetteRempartsAvances = {9,6,3,40};
	public static Object[] defRempartsAvances = {true,50};
	public static ResourceLocation[] texturesRempartsAvances = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,PA};
	
	public static int[] recettePoutresRenfort = {1,3,40};
	public static Object[] defPoutresRenfort = {true,25};
	public static ResourceLocation[] texturesPoutresRenfort = {poutreRafistolee,structuresMetalliques,PA};
	
	public static int[] recetteMurailleAPointes = {5,2,1,35};
	public static Object[] defMurailleAPointes = {true,45};
	public static ResourceLocation[] texturesMurailleAPointes = {planchesTordue,ferraille,PA};
	
	public static int[] recetteGrogroMur = {10,15,10,2,50};
	public static Object[] defGrogroMur = {true,80};
	public static ResourceLocation[] texturesGrogroMur = {planchesTordue,poutreRafistolee,structuresMetalliques,pavesDeBetons,PA};
	
	public static int[] recetteSecondeCouche = {35,5,65};
	public static Object[] defSecondeCouche = {true,75};
	public static ResourceLocation[] texturesSecondeCouche = {planchesTordue,structuresMetalliques,PA};
	
	public static int[] recetteTroisiemeCouche = {35,5,65};
	public static Object[] defTroisiemeCouche = {true,75};
	public static ResourceLocation[] texturesTroisiemeCouche = {ferraille,structuresMetalliques,plaqueDeTole,PA};
	
	public static int[] recetteMurailleEvolutive = {5,20,1,65};
	public static Object[] defMurailleEvolutive = {true,55};
	public static ResourceLocation[] texturesMurailleEvolutive = {planchesTordue,ferraille,pavesDeBetons,PA};
	
	public static int[] recetteBetonnade = {2,6,60};
	public static Object[] defBetonnade = {true,55};
	public static ResourceLocation[] texturesBetonnade = {structuresMetalliques,pavesDeBetons,PA};
	
	public static int[] recetteRapeAZombies = {20,3,3,60};
	public static Object[] defRapeAZombies = {true,55};
	public static ResourceLocation[] texturesRapeAZombies = {ferraille,plaqueDeTole,poigneeDeVisEtEcrous,PA};

	public static int[] recetteOubliettes = {10,50};
	public static Object[] defOubliettes = {true,35};
	public static ResourceLocation[] texturesOubliettes = {planchesTordue,PA};
	
	public static int[] recetteBarrieres = {5,50};
	public static Object[] defBarrieres = {true,30};
	public static ResourceLocation[] texturesBarrieres = {poutreRafistolee,PA};
	
	public static int[] recettePalissade = {20,5,2,50};
	public static Object[] defPalissade = {true,45};
	public static ResourceLocation[] texturesPalissade = {planchesTordue,poutreRafistolee,poigneeDeVisEtEcrous,PA};
	
	public static int[] recetteMurSavone = {1,10,5,40};
	public static Object[] defMurSavone = {true,60};
	public static ResourceLocation[] texturesMurSavone = {pavesDeBetons,rationDEau,produitsPharmaceutiques,PA};
	
	public static int[] recettePulverisateur = {10,2,2,1,50};
	public static Object[] defPulverisateur = {false};
	public static ResourceLocation[] texturesPulverisateur = {ferraille,structuresMetalliques,poigneeDeVisEtEcrous,tubeDeCuivre,PA};
	
	public static int[] recetteProjectionAcide = {2,3,30};
	public static Object[] defProjectionAcide = {true,40};	
	public static ResourceLocation[] texturesProjectionAcide = {rationDEau,produitsPharmaceutiques,PA};

	public static int[] recetteNeurotoxine = {2,5,1,40};
	public static Object[] defNeurotoxine = {true,150};
	public static ResourceLocation[] texturesNeurotoxine = {rationDEau,produitsPharmaceutiques,steroidesAnabolisants,PA};
	
	public static int[] recetteCloisonEnBois = {10,30};
	public static Object[] defCloisonEnBois = {true,25};
	public static ResourceLocation[] texturesCloisonEnBois = {planchesTordue,PA};
	
	public static int[] recetteCloisonMetallique = {10,30};
	public static Object[] defCloisonMetallique = {true,25};	
	public static ResourceLocation[] texturesCloisonMetallique = {ferraille,PA};
	
	public static int[] recetteCloisonEpaisse = {10,10,40};
	public static Object[] defCloisonEpaisse = {true,40};
	public static ResourceLocation[] texturesCloisonEpaisse = {planchesTordue,ferraille,PA};
	
	public static int[] recetteContrePlaque = {5,5,30};
	public static Object[] defContrePlaque = {true,25};
	public static ResourceLocation[] texturesContrePlaque = {planchesTordue,ferraille,PA};
	
	public static int[] recetteBastion = {15,15,30};
	public static Object[] defBastion = {true,45};	
	public static ResourceLocation[] texturesBastion = {planchesTordue,ferraille,PA};
	
	/** Section Pompe **/
	public static int[] recettePompe = {8,1,25};
	public static Object[] defPompe = {false};
	public static ResourceLocation[] texturesPompe = {ferraille,tubeDeCuivre,PA};
	
	/** Section Atelier **/
	 
	public static Vector<RecetteChantier> vectorAtelier = new Vector();
	public static RecetteChantier recetteTest = new RecetteChantier("test", 
			new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, 
			new ResourceLocation[]{planchesTordue,ferraille},
			new int[]{10,20},50,50);
	
	public static void loaderVector() {
		vectorAtelier.addElement(recetteTest);
	}
	
	public static int[] recetteAtelier = {10,8,25};
	public static Object[] defAtelier = {false};
	public static ResourceLocation[] texturesAtelier = {planchesTordue,ferraille,PA};
	
	
	
	public static int[] recetteBoucherie = {9,4,40};
	public static Object[] defBoucherie = {false};
	public static ResourceLocation[] texturesBoucherie = {planchesTordue,ferraille,PA};
	
	public static int[] recetteCrematoCue = {8,1,45};
	public static Object[] defCrematoCue = {false};
	public static ResourceLocation[] texturesCrematoCue = {poutreRafistolee,structuresMetalliques,PA};
	
	public static int[] recetteFixationsDefenses = {7,8,3,50};
	public static Object[] defFixationDefenses = {false};
	public static ResourceLocation[] texturesFixationDefenses = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,PA};
	
	public static int[] recetteMonticulesCanons = {7,1,1,50};
	public static Object[] defMonticulesCanons = {true,30};
	public static ResourceLocation[] texturesMonticulesCanons = {poutreRafistolee,structuresMetalliques,pavesDeBetons,PA};
	
	public static int[] recetteCanonABriques = {5,5,3,1,2,60};
	public static Object[] defCanonABriques = {true,50};
	public static ResourceLocation[] texturesCanonABriques = {poutreRafistolee,structuresMetalliques,pavesDeBetons,tubeDeCuivre,composantElectronique,PA};
	
	public static int[] recettePerforeuse = {10,2,1,1,40};
	public static Object[] defPerforeuse = {true,50};
	public static ResourceLocation[] texturesPerforeuse = {structuresMetalliques,poigneeDeVisEtEcrous,tubeDeCuivre,composantElectronique,PA};
	
	public static int[] recetteLanceGrenailles = {5,1,3,3,3,50};
	public static Object[] defLanceGrnailles = {true,60};
	public static ResourceLocation[] texturesLanceGrenailles = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,plaqueDeTole,explosifBrut,PA};
	
	public static int[] recetteCanonBrutal = {1,1,25};
	public static Object[] defCanonBrutal = {true,50};
	public static ResourceLocation[] texturesCanonBrutal = {structuresMetalliques,plaqueDeTole,PA};
	
	public static int[] recetteTourniquet = {2,1,15};
	public static Object[] defTourniquet = {true,10};
	public static ResourceLocation[] texturesTourniquet = {poutreRafistolee,structuresMetalliques,PA};
	
	public static int[] recetteManufacture = {5,5,1,40};
	public static Object[] defManufacture = {false};
	public static ResourceLocation[] texturesManufacture = {poutreRafistolee,structuresMetalliques,tableJarpen,PA};
	
	public static int[] recetteSciesHurlantes = {5,2,3,3,65};
	public static Object[] defSciesHurlantes = {true,45};
	public static ResourceLocation[] texturesSciesHurlantes = {ferraille,structuresMetalliques,poigneeDeVisEtEcrous,rustine,PA};
	
	public static int[] recetteRegistreChantier = {1,15};
	public static Object[] defRegistreChantier = {false};
	public static ResourceLocation[] texturesRegistreChantier = {tableJarpen,PA};
	
	public static int[] recetteArchitectoire = {10,1,1,75};
	public static Object[] defArchitectoire = {false};
	public static ResourceLocation[] texturesArchitectoire = {poutreRafistolee,steroidesAnabolisants,vodkaMarinostov,PA};
	
	public static int[] recettePotence = {1,1,13};
	public static Object[] defPotence = {false};
	public static ResourceLocation[] texturesPotence = {poutreRafistolee,PA};
	
	public static int[] recetteAbattoir = {10,2,40};
	public static Object[] defAbattoir = {true,35};
	public static ResourceLocation[] texturesAbattoir = {structuresMetalliques,pavesDeBetons,PA};
	
	public static int[] recetteSupportsDefensifs = {5,10,55};
	public static Object[] defSupportsDefensifs = {true,1};
	public static ResourceLocation[] texturesSupportsDefensifs = {poutreRafistolee,structuresMetalliques,PA};
	
	public static int[] recetteCantineABois = {2,1,1,6};
	public static Object[] defCantineABois = {false};
	public static ResourceLocation[] texturesCantineABois = {planchesTordue,rationDEau,produitsPharmaceutiques,PA};
	
	public static int[] recetteCimetiereCadenasse = {10,1,36};
	public static Object[] defCimetiereCadenasse = {true, 1};
	public static ResourceLocation[] texturesCimetiereCadenasse = {planchesTordue,poigneeDeVisEtEcrous,PA};
	
	public static int[] recetteCercueilsSurRessorts = {5,15,5,1,100};
	public static Object[] defCercueilsSurRessorts = {false};
	public static ResourceLocation[] texturesCercueilsSurRessorts = {planchesTordue,ferraille,poigneeDeVisEtEcrous,courroie,PA};
	
	public static int[] recetteCantineCentrale = {5,1,1,1,20};
	public static Object[] defCantineCentrale = {false};
	public static ResourceLocation[] texturesCantineCentrale = {poutreRafistolee,structuresMetalliques,tableJarpen,produitsPharmaceutiques,PA};
	
	public static int[] recetteLaboratoireCentral = {3,10,3,5,30};
	public static Object[] defLaboratoireCentral = {false};
	public static ResourceLocation[] texturesLaboratoireCentral = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,produitsPharmaceutiques,PA};
	
	public static int[] recettePoulailler = {5,5,2,25};
	public static Object[] defPoulailler = {false};
	public static ResourceLocation[] texturesPoulailler = {planchesTordue,poutreRafistolee,morceauDeGrillage,PA};
	
	public static int[] recetteInfirmerie = {5,5,6,1,40};
	public static Object[] defInfirmerie = {false};
	public static ResourceLocation[] texturesInfirmerie = {poutreRafistolee,structuresMetalliques,produitsPharmaceutiques,paracetoide7G,PA};
	
	public static int[] recetteStrategiesCitoyennes = {10,10,3,30};
	public static Object[] defStrategiesCitoyennes = {false};
	public static ResourceLocation[] texturesStrategiesCitoyennes = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,PA};
	
	public static int[] recetteQuartiersCirculaires = {15,15,3,60};
	public static Object[] defQuartiersCirculaires = {false};
	public static ResourceLocation[] texturesQuartiersCirculaires = {poutreRafistolee,structuresMetalliques,poigneeDeVisEtEcrous,PA};
	
	/** Section TDG **/
	public static int[] recetteTDG = {3,2,12};
	public static Object[] defTDG = {false};
	public static ResourceLocation[] texturesTDG = {planchesTordue,ferraille,PA};

	/** Section Fondations **/
	public static int[] recetteFondations = {10,8,30};
	public static Object[] defFondations = {false};
	public static ResourceLocation[] texturesFondations = {planchesTordue,ferraille,PA};
	
	/** Section Portail **/
	public static int[] recettePortail = {2,16};
	public static Object[] defPorte = {false};
	public static ResourceLocation[] texturesPortail = {ferraille,PA};

}
