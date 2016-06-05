package fr.myrilandel.hordemod.gui;

import org.lwjgl.opengl.GL11;

import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.packets.HMPacketHelper;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GUIChantierMuraille extends GuiContainer {

	World world;
	TileEntityChantierMuraille TEMuraille;
	TileEntityBanque tileEntityBanque;
	TileEntityBlocksVille TEVille;
	EntityPlayer player;
	ExtendedEntityPropEtats props;
	int guiWidth = 550;
	int guiHeight = 600;
	int nbElementsGui = 29;
	
	int nbFerraille = 0;
	int nbOsCharnu = 0;
	int nbPavesBeton = 0;
	int nbPlanchesTordue = 0;
	int nbPlaqueDeTole = 0;
	int nbPoigneeDeVisEtEcrous = 0;
	int nbPoutreRafistolee = 0;
	int nbProduitsPharmaceutiques = 0;
	int nbRationDEau = 0;
	int nbSteroidesAnabolisants = 0;
	int nbStructuresMetalliques = 0;
	int nbTubeDeCuivre = 0;

	public static final ResourceLocation PA = new ResourceLocation(HordeMod.MODID, "textures/GUI/pointAction.png");
	public static final ResourceLocation Def = new ResourceLocation(HordeMod.MODID, "textures/GUI/defenses.png");
	public static final ResourceLocation Background = new ResourceLocation(HordeMod.MODID, "textures/GUI/BGChantier.png");

	public GUIChantierMuraille(World world, TileEntityChantierMuraille tileEntityChantierMuraille, TileEntityBanque tileEntityBanque,
			TileEntityBlocksVille tileEntityBlocksVille, EntityPlayer player) {
		super(new ContainerChantierMuraille(tileEntityChantierMuraille, world));
		this.world = world;
		this.TEMuraille = tileEntityChantierMuraille;
		this.tileEntityBanque = tileEntityBanque;
		this.TEVille = tileEntityBlocksVille;
		this.player = player;
		props = ExtendedEntityPropEtats.get(player);
	}

	@Override
	public void initGui() {
		super.initGui();
		int x = (width - guiWidth) / 2;
		int y = (height - guiHeight) / 2;
		this.addButtons(x, y);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f1, int i1, int i2) {
		this.drawDefaultBackground();
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(HordeMod.MODID, "textures/gui/TestTuto.png"));
		int guix = (width - guiWidth) / 2;
		int guiy = (height - guiHeight) / 2;
		drawTexturedModalRect(guix, guiy, 0, 0, guiWidth, guiHeight);
		this.drawChantierContainer(guix, guiy);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.enabled) {
			props.pertePA(1);
			HMPacketHelper.sendPacket(TEMuraille, button.id);
		}
	}

	@Override
	public void updateScreen() {
		nbFerraille = 0;
		nbOsCharnu = 0;
		nbPavesBeton = 0;
		nbPlanchesTordue = 0;
		nbPlaqueDeTole = 0;
		nbPoigneeDeVisEtEcrous = 0;
		nbPoutreRafistolee = 0;
		nbProduitsPharmaceutiques = 0;
		nbRationDEau = 0;
		nbSteroidesAnabolisants = 0;
		nbStructuresMetalliques = 0;
		nbTubeDeCuivre = 0;
		updateButtons();
	}

	private void drawChantierContainer(int x, int y) {
		int[] nbBanque;
		this.drawRender(x, y, 550, 600, Background);
		drawLigneChantier(x, y, 1, "Muraille", ChantiersRegistry.defMuraille, ChantiersRegistry.recetteMuraille,
				ChantiersRegistry.texturesMuraille, new int[]{nbPlanchesTordue,nbFerraille}, TEMuraille.PAMuraille);
		if(TEMuraille.PAMuraille == 0)
			for (int i = 2; i < nbElementsGui; i++) {
				switch (i) {
				case 2:
					drawLigneChantier(x, y, i, "Grand Fossé", ChantiersRegistry.defGrandFosse, ChantiersRegistry.recetteGrandFosse,
					ChantiersRegistry.texturesMuraille, new int[]{}, TEMuraille.PAGrandFosse);
					break;
				
				case 3:
					if(TEMuraille.PAGrandFosse == 0 && TEVille.tabCommunIsUnlocked[0]) 
						drawLigneChantier(x, y, i, "Douves", ChantiersRegistry.defDouves, ChantiersRegistry.recetteDouves,
						ChantiersRegistry.texturesMuraille, new int[]{nbRationDEau},TEMuraille.PADouves);
					else
						drawLigneUnknown(x, y, i);
					break;
				
				case 4:
					if(TEVille.tabCommunIsUnlocked[1])
						drawLigneChantier(x, y, i, "Muraille rasoir", ChantiersRegistry.defMurailleRasoir, ChantiersRegistry.recetteMurailleRasoir,
						ChantiersRegistry.texturesMurailleRasoir, new int[]{nbFerraille,nbPoigneeDeVisEtEcrous},TEMuraille.PAMurailleRasoir);
					else
						drawLigneUnknown(x, y, i);
					break;
		
				case 5:
					if(TEVille.tabCommunIsUnlocked[2])
						drawLigneChantier(x, y, i, "Fosse à pieux", ChantiersRegistry.defFosseAPieux, ChantiersRegistry.recetteFosseAPieux,
						ChantiersRegistry.texturesFosseAPieux, new int[]{nbPlanchesTordue,nbPoutreRafistolee}, TEMuraille.PAFosseAPieux);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 6:
					drawLigneChantier(x, y, i, "Barbeles", ChantiersRegistry.defBarbeles, ChantiersRegistry.recetteBarbeles,
						ChantiersRegistry.texturesBarbeles, new int[]{nbFerraille}, TEMuraille.PABarbeles);
					break;
				
				case 7:
					if(TEMuraille.PABarbeles == 0)
						drawLigneChantier(x, y, i, "Appats", ChantiersRegistry.defAppats, ChantiersRegistry.recetteAppats,
						ChantiersRegistry.texturesAppats, new int[]{nbOsCharnu}, TEMuraille.PAAppats);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 8:
					if(TEVille.tabCommunIsUnlocked[3])
						drawLigneChantier(x, y, i, "Remparts avancés", ChantiersRegistry.defRempartsAvances, ChantiersRegistry.recetteRempartsAvances,
						ChantiersRegistry.texturesRempartsAvances, new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous}, TEMuraille.PARempartsAvances);
					else
						drawLigneUnknown(x, y, i);
					break;
			
				case 9:
					drawLigneChantier(x, y, i, "Poutres renforts", ChantiersRegistry.defPoutresRenfort, ChantiersRegistry.recettePoutresRenfort,
						ChantiersRegistry.texturesPoutresRenfort, new int[]{nbPoutreRafistolee,nbStructuresMetalliques}, TEMuraille.PAPoutresRenfort);
					break;
				
				case 10:
					if(TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[4]) 
						drawLigneChantier(x, y, i, "Muraille à pointes", ChantiersRegistry.defMurailleAPointes, ChantiersRegistry.recetteMurailleAPointes,
						ChantiersRegistry.texturesMurailleAPointes, new int[]{nbPlanchesTordue,nbFerraille,nbPavesBeton}, TEMuraille.PAMurailleAPointes);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 11:
					if(TEMuraille.PAMurailleAPointes == 0 && TEVille.tabInhabituelIsUnlocked[0])
						drawLigneChantier(x, y, i, "GroGro mur", ChantiersRegistry.defGrogroMur, ChantiersRegistry.recetteGrogroMur,
						ChantiersRegistry.texturesGrogroMur, new int[]{nbPlanchesTordue,nbPoutreRafistolee,nbStructuresMetalliques,nbPavesBeton}, TEMuraille.PAGrogroMur);
					else
							drawLigneUnknown(x, y, i);
					break;
				
				case 12:
					if(TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[5])
						drawLigneChantier(x, y, i, "Seconde couche", ChantiersRegistry.defSecondeCouche, ChantiersRegistry.recetteSecondeCouche,
						ChantiersRegistry.texturesSecondeCouche, new int[]{nbPlanchesTordue,nbStructuresMetalliques}, TEMuraille.PASecondeCouche);
					else
						drawLigneUnknown(x, y, i);
					break;	
				
				case 13:
					if(TEMuraille.PASecondeCouche == 0 && TEVille.tabInhabituelIsUnlocked[1])
						drawLigneChantier(x, y, i, "Troisième couche", ChantiersRegistry.defTroisiemeCouche, ChantiersRegistry.recetteTroisiemeCouche,
						ChantiersRegistry.texturesTroisiemeCouche, new int[]{nbFerraille,nbStructuresMetalliques,nbPlaqueDeTole}, TEMuraille.PATroisiemeCouche);
					else
						drawLigneUnknown(x, y, i);
					break;
			
				case 14:
					if(TEMuraille.PAPoutresRenfort == 0 && TEVille.tabRareIsUnlocked[0])
						drawLigneChantier(x, y, i, "Muaille évolutive", ChantiersRegistry.defMurailleEvolutive, ChantiersRegistry.recetteMurailleEvolutive,
								ChantiersRegistry.texturesMurailleEvolutive, new int[]{nbPlanchesTordue,nbFerraille,nbPavesBeton}, TEMuraille.PAMurailleEvolutive);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 15:
					if(TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[6])
						drawLigneChantier(x, y, i, "Bétonnade", ChantiersRegistry.defBetonnade, ChantiersRegistry.recetteBetonnade,
						ChantiersRegistry.texturesBetonnade, new int[]{nbStructuresMetalliques,nbPavesBeton}, TEMuraille.PABetonnade);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 16:
					if(TEVille.tabCommunIsUnlocked[7])
						drawLigneChantier(x, y, i, "Rape à zombies", ChantiersRegistry.defRapeAZombies, ChantiersRegistry.recetteRapeAZombies,
						ChantiersRegistry.texturesRapeAZombies, new int[]{nbFerraille,nbPlaqueDeTole,nbPoigneeDeVisEtEcrous}, TEMuraille.PARapeAZombies);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 17:
					drawLigneChantier(x, y, i, "Oubliettes", ChantiersRegistry.defOubliettes, ChantiersRegistry.recetteOubliettes,
					ChantiersRegistry.texturesOubliettes, new int[]{nbPlanchesTordue}, TEMuraille.PAOubliettes);
					break;
					
				case 18:
					drawLigneChantier(x, y, i, "Barrières", ChantiersRegistry.defBarrieres, ChantiersRegistry.recetteBarrieres,
					ChantiersRegistry.texturesBarrieres, new int[]{nbPoutreRafistolee}, TEMuraille.PABarrieres);
					break;
					
				case 19:
					if(TEVille.tabCommunIsUnlocked[8])
						drawLigneChantier(x, y, i, "Palissade", ChantiersRegistry.defPalissade, ChantiersRegistry.recettePalissade,
						ChantiersRegistry.texturesPalissade, new int[]{nbPlanchesTordue,nbPoutreRafistolee,nbPoigneeDeVisEtEcrous}, TEMuraille.PAPalissade);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 20:
					if(TEVille.tabCommunIsUnlocked[9])
						drawLigneChantier(x, y, i, "Mur savoné", ChantiersRegistry.defMurSavone, ChantiersRegistry.recetteMurSavone,
						ChantiersRegistry.texturesMurSavone, new int[]{nbPavesBeton,nbRationDEau,nbProduitsPharmaceutiques}, TEMuraille.PAMurSavone);
					else
						drawLigneUnknown(x, y, i);
					break;
				
				case 21:
					if(TEVille.tabCommunIsUnlocked[10])
						drawLigneChantier(x, y, i, "Pulvérisateur", ChantiersRegistry.defPulverisateur, ChantiersRegistry.recettePulverisateur,
						ChantiersRegistry.texturesPulverisateur, new int[]{nbFerraille,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbTubeDeCuivre}, TEMuraille.PAPulverisateur);
					else
						drawLigneUnknown(x, y, i);
					break;
										
				case 22:
					if(TEMuraille.PAPulverisateur == 0 && TEVille.tabCommunIsUnlocked[11])
						drawLigneChantier(x, y, i, "Projections acide", ChantiersRegistry.defProjectionAcide, ChantiersRegistry.recetteProjectionAcide,
						ChantiersRegistry.texturesProjectionAcide, new int[]{nbRationDEau,nbProduitsPharmaceutiques}, TEMuraille.PAProjectionAcide);
					else
						drawLigneUnknown(x, y, i);
					break;
					
				case 23:
					if(TEMuraille.PAPulverisateur == 0 && TEVille.tabInhabituelIsUnlocked[2])
						drawLigneChantier(x, y, i, "Neurotoxine", ChantiersRegistry.defNeurotoxine, ChantiersRegistry.recetteNeurotoxine,
						ChantiersRegistry.texturesNeurotoxine, new int[]{nbRationDEau,nbProduitsPharmaceutiques,nbSteroidesAnabolisants}, TEMuraille.PANeurotoxine);
					else
						drawLigneUnknown(x, y, i);
					break;
				
				case 24:
					drawLigneChantier(x, y, i, "Coison en bois", ChantiersRegistry.defCloisonEnBois, ChantiersRegistry.recetteCloisonEnBois,
					ChantiersRegistry.texturesCloisonEnBois, new int[]{nbPlanchesTordue}, TEMuraille.PACloisonEnBois);
					break;
					
				case 25:
					drawLigneChantier(x, y, i, "Cloison métallique", ChantiersRegistry.defCloisonMetallique, ChantiersRegistry.recetteCloisonMetallique,
					ChantiersRegistry.texturesCloisonMetallique, new int[]{nbFerraille}, TEMuraille.PACloisonMetallique);
					break;
					
				case 26:
					drawLigneChantier(x, y, i, "Cloison épaisse", ChantiersRegistry.defCloisonEpaisse, ChantiersRegistry.recetteCloisonEpaisse,
					ChantiersRegistry.texturesCloisonEpaisse, new int[]{nbPlanchesTordue,nbFerraille}, TEMuraille.PACloisonEpaisse);
					break;
					
				case 27:
					drawLigneChantier(x, y, i, "Contre-plaqué", ChantiersRegistry.defContrePlaque, ChantiersRegistry.recetteContrePlaque,
					ChantiersRegistry.texturesContrePlaque, new int[]{nbPlanchesTordue,nbFerraille}, TEMuraille.PAContrePlaque);
					break;
					
				case 28:
					if(TEVille.tabCommunIsUnlocked[12])
						drawLigneChantier(x, y, i, "Bastion", ChantiersRegistry.defBastion, ChantiersRegistry.recetteBastion,
						ChantiersRegistry.texturesBastion, new int[]{nbPlanchesTordue,nbFerraille}, TEMuraille.PABastion);
					else
						drawLigneUnknown(x, y, i);
					break;			
				}
			}	
	}

	private void drawLigneUnknown(int x, int y, int numLig) {
		fontRendererObj.drawString("???", 10 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
	}

	private void drawLigneChantier(int x, int y, int numLig, String nomChantier, Object[] def, int[] nbComposant,
			ResourceLocation[] textures, int[] nbDispoBanque, int PATileEntity) {
		fontRendererObj.drawString(nomChantier, 10 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);

		if(PATileEntity > 0) {
			if((Boolean) def[0]) {
				fontRendererObj.drawString("" + def[1], 140 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
				drawRender(120 + x, y + (20 * (numLig - 1)), 16, 16, Def);
			}
			for (int i = nbDispoBanque.length - 1; i >= 0; i--) {
				int color = nbDispoBanque[i] >= nbComposant[i] ? 0xFFFFFF : 0xCC0000;
				fontRendererObj.drawString(nbDispoBanque[i] + "/" + nbComposant[i], 420 + x - (i * 65),
						y + 4 + (20 * (numLig - 1)), color, false);
				drawRender(400 + x - i * 65, y + (20 * (numLig - 1)), 16, 16, textures[i]);
			}
			fontRendererObj.drawString("" + PATileEntity, 120 + x + 350, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
			drawRender(130 + x + 352, y + (20 * (numLig - 1)), 16, 16, textures[textures.length - 1]);
		}
	}

	private void addButtons(int x, int y) {
		for (int i = 1; i < nbElementsGui; i++) {
			GuiBooleanButton button = new GuiBooleanButton(i, x + 155 + 350, y -2+ (20 * (i - 1)), 30, 20, "+", true);
			
			button.enabled = false;
			this.buttonList.add(button);
		}
	}

	private void updateButtons() {
		for (ItemStack itemStack : tileEntityBanque.getContent()) {
			if(itemStack != null) {
				if(itemStack.getItem() == HMItemRegistry.ferraille)
					nbFerraille += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.osCharnu)
					nbOsCharnu += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.pavesDeBetonInformes)
					nbPavesBeton += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.planchesTordue)
					nbPlanchesTordue += itemStack.stackSize;	
				if(itemStack.getItem() == HMItemRegistry.plaqueDeTole)
					nbPlaqueDeTole += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.poigneeDeVisEtEcrous)
					nbPoigneeDeVisEtEcrous += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.poutreRafistolee)
					nbPoutreRafistolee += itemStack.stackSize;	
				if(itemStack.getItem() == HMItemRegistry.produitsPharmaceutiques)
					nbProduitsPharmaceutiques += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.rationDEau)
					nbRationDEau += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.steroidesAnabolisants)
					nbSteroidesAnabolisants += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.structuresMetalliques)
					nbStructuresMetalliques += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.tubeDeCuivre)
					nbTubeDeCuivre += itemStack.stackSize;
			}
		}
		for (Object object : buttonList) 
			if(object instanceof GuiBooleanButton) {
				GuiBooleanButton button = (GuiBooleanButton) object;

				switch (button.id) {
				case 1:button.visible = TEMuraille.PAMuraille>0;button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue, nbFerraille}, ChantiersRegistry.recetteMuraille);break;

				case 2:button.visible = checkButtonVisible(button.id); button.enabled = true;break;
		    	case 3:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbRationDEau}, ChantiersRegistry.recetteDouves);break;
		    	case 4:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille, nbPoigneeDeVisEtEcrous}, ChantiersRegistry.recetteMurailleRasoir);break;
		    	case 5:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbPoutreRafistolee}, ChantiersRegistry.recetteFosseAPieux);break;
		    	case 6:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille}, ChantiersRegistry.recetteBarbeles);break;
		    	case 7:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbOsCharnu}, ChantiersRegistry.recetteAppats);break;
		    	case 8:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous}, ChantiersRegistry.recetteRempartsAvances);break;
		    	case 9:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques},ChantiersRegistry.recettePoutresRenfort);break;
		    	case 10:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille, nbPavesBeton}, ChantiersRegistry.recetteMurailleAPointes);break;
		    	case 11:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbPoutreRafistolee,nbStructuresMetalliques,nbPavesBeton}, ChantiersRegistry.recetteGrogroMur);break;
		    	case 12:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue, nbStructuresMetalliques},ChantiersRegistry.recetteSecondeCouche);break;
		    	case 13:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille,nbStructuresMetalliques,nbPlaqueDeTole},ChantiersRegistry.recetteTroisiemeCouche );break;
		    	case 14:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille,nbPavesBeton},ChantiersRegistry.recetteMurailleEvolutive );break;
		    	case 15:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbStructuresMetalliques,nbPavesBeton},ChantiersRegistry.recetteBetonnade);break;
		    	case 16:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille,nbPlaqueDeTole,nbPoigneeDeVisEtEcrous},ChantiersRegistry.recetteRapeAZombies);break;
		    	case 17:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue},ChantiersRegistry.recetteOubliettes);break;
		    	case 18:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee},ChantiersRegistry.recetteBarrieres);break;
		    	case 19:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbPoutreRafistolee,nbPoigneeDeVisEtEcrous},ChantiersRegistry.recettePalissade);break;
		    	case 20:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPavesBeton,nbRationDEau,nbProduitsPharmaceutiques},ChantiersRegistry.recetteMurSavone);break;
		    	case 21:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbTubeDeCuivre},ChantiersRegistry.recettePulverisateur);break;
		    	case 22:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbRationDEau,nbProduitsPharmaceutiques},ChantiersRegistry.recetteProjectionAcide);break;
		    	case 23:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbRationDEau,nbProduitsPharmaceutiques,nbSteroidesAnabolisants},ChantiersRegistry.recetteNeurotoxine);break;
		    	case 24:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue},ChantiersRegistry.recetteCloisonEnBois);break;
		    	case 25:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille},ChantiersRegistry.recetteCloisonMetallique);break;
		    	case 26:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille},ChantiersRegistry.recetteCloisonEpaisse);break;
		    	case 27:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille},ChantiersRegistry.recetteContrePlaque);break;
		    	case 28:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille},ChantiersRegistry.recetteBastion);break;
				default:break;			
				}
			}
	}
	
	private boolean checkButtonVisible(int ID) {
		/** arg 1 = self, arg 2 = unlock supérieur, ag3 = plan **/
		if(TEMuraille.PAMuraille == 0) {
			switch (ID) {
			case 2: return TEMuraille.PAGrandFosse != 0;
			case 3: return TEMuraille.PADouves != 0 && TEMuraille.PAGrandFosse == 0 && TEVille.tabCommunIsUnlocked[0];
			case 4: return TEMuraille.PAMurailleRasoir != 0 && TEVille.tabCommunIsUnlocked[1];
			case 5: return TEMuraille.PAFosseAPieux != 0 && TEVille.tabCommunIsUnlocked[2];
			case 6: return TEMuraille.PABarbeles != 0;
			case 7: return TEMuraille.PAAppats != 0 && TEMuraille.PABarbeles == 0;
			case 8: return TEMuraille.PARempartsAvances != 0 && TEVille.tabCommunIsUnlocked[3];
			case 9: return TEMuraille.PAPoutresRenfort != 0;
			case 10: return TEMuraille.PAMurailleAPointes != 0 && TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[4];
			case 11: return TEMuraille.PAGrogroMur != 0 && TEMuraille.PAMurailleAPointes == 0 && TEVille.tabInhabituelIsUnlocked[0];
			case 12: return TEMuraille.PASecondeCouche != 0 && TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[5];
			case 13: return TEMuraille.PATroisiemeCouche != 0 && TEMuraille.PASecondeCouche == 0 && TEVille.tabInhabituelIsUnlocked[1];
			case 14: return TEMuraille.PAMurailleEvolutive != 0 && TEMuraille.PAPoutresRenfort == 0 && TEVille.tabRareIsUnlocked[0];
			case 15: return TEMuraille.PABetonnade != 0 && TEMuraille.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[6];
			case 16: return TEMuraille.PARapeAZombies != 0 && TEVille.tabCommunIsUnlocked[7];
			case 17: return TEMuraille.PAOubliettes != 0;
			case 18: return TEMuraille.PABarrieres != 0;
			case 19: return TEMuraille.PAPalissade != 0 && TEVille.tabCommunIsUnlocked[8];
			case 20: return TEMuraille.PAMurSavone != 0 && TEVille.tabCommunIsUnlocked[9];
			case 21: return TEMuraille.PAPulverisateur != 0 && TEVille.tabCommunIsUnlocked[10];
			case 22: return TEMuraille.PAProjectionAcide != 0 && TEMuraille.PAPulverisateur == 0 && TEVille.tabCommunIsUnlocked[11];
			case 23: return TEMuraille.PANeurotoxine != 0 && TEMuraille.PAPulverisateur == 0 && TEVille.tabInhabituelIsUnlocked[2];
			case 24: return TEMuraille.PACloisonEnBois != 0;
			case 25: return TEMuraille.PACloisonMetallique != 0;
			case 26: return TEMuraille.PACloisonEpaisse != 0;
			case 27: return TEMuraille.PAContrePlaque != 0;
			case 28: return TEMuraille.PABastion != 0 && TEVille.tabCommunIsUnlocked[12];
			default:return true;
			}
		}
		return false;
	}
	
	private boolean checkButtonEnabled(int[] tabComposant, int[] tabRecette) {
		for(int i = 0; i < tabComposant.length; i++)
			if(tabComposant[i] < tabRecette[i])
				return false;
		return props.PA>0;
	}
	
	private void drawRender(float x, float y, float width, float height, ResourceLocation texture) {
		mc.renderEngine.bindTexture(texture);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		Tessellator tessLater = Tessellator.instance;
		tessLater.startDrawingQuads();
		tessLater.addVertexWithUV(x, y, 0.0D, 0.0D, 0.0D);
		tessLater.addVertexWithUV(x, y + height, 0.0D, 0.0D, height / height);
		tessLater.addVertexWithUV(x + width, y + height, 0.0D, 1.0D, height / height);
		tessLater.addVertexWithUV(x + width, y, 0.0D, 1.0D, 0.0D);
		tessLater.draw();
	}
}