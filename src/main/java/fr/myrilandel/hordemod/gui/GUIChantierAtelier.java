package fr.myrilandel.hordemod.gui;

import org.lwjgl.opengl.GL11;

import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
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

public class GUIChantierAtelier extends GuiContainer {

	World world;
	TileEntityChantierAtelier TEAtelier;
	TileEntityBanque tileEntityBanque;
	TileEntityBlocksVille TEVille;
	EntityPlayer player;
	ExtendedEntityPropEtats props;
	int guiWidth = 450;
	int guiHeight = 450;
	int nbElementsGui = 27;
	
	int nbComposantElectronique = 0;
	int nbCourroie = 0;
	int nbExplosifsBruts = 0;
	int nbFerraille = 0;
	int nbGrosseChaineRouille = 0;
	int nbMorceauDeGrillage = 0;
	int nbParacetoide7G = 0;
	int nbPavesBeton = 0;
	int nbPlanchesTordue = 0;
	int nbPlaqueDeTole = 0;
	int nbPoigneeDeVisEtEcrous = 0;
	int nbPoutreRafistolee = 0;
	int nbProduitsPharmaceutiques = 0;
	int nbRationDEau = 0;
	int nbRustine = 0;
	int nbSteroidesAnabolisants = 0;
	int nbStructuresMetalliques = 0;
	int nbTableJarpen = 0;
	int nbTubeDeCuivre = 0;
	int nbVodkaMarinostov = 0;

	public static final ResourceLocation PA = new ResourceLocation(HordeMod.MODID, "textures/GUI/pointAction.png");
	public static final ResourceLocation Def = new ResourceLocation(HordeMod.MODID, "textures/GUI/defenses.png");

	public GUIChantierAtelier(World world, TileEntityChantierAtelier tileEntityChantierAtelier, TileEntityBanque tileEntityBanque,
			TileEntityBlocksVille tileEntityBlocksVille, EntityPlayer player) {
		super(new ContainerChantierAtelier(tileEntityChantierAtelier, world));
		this.world = world;
		this.TEAtelier = tileEntityChantierAtelier;
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
			HMPacketHelper.sendPacket(TEAtelier, button.id);
			HMPacketHelper.sendPacket(tileEntityBanque, button.id,2);
			HMPacketHelper.sendPacket(TEVille, button.id,2);
		}
	}

	@Override
	public void updateScreen() {
		nbComposantElectronique = 0;
		nbCourroie = 0;
		nbExplosifsBruts = 0;
		nbFerraille = 0;
		nbGrosseChaineRouille = 0;
		nbMorceauDeGrillage = 0;
		nbParacetoide7G = 0;
		nbPavesBeton = 0;
		nbPlanchesTordue = 0;
		nbPlaqueDeTole = 0;
		nbPoigneeDeVisEtEcrous = 0;
		nbPoutreRafistolee = 0;
		nbProduitsPharmaceutiques = 0;
		nbRationDEau = 0;
		nbRustine = 0;
		nbSteroidesAnabolisants = 0;
		nbStructuresMetalliques = 0;
		nbTableJarpen = 0;
		nbTubeDeCuivre = 0;
		nbVodkaMarinostov = 0;
		updateButtons();
	}

	private void drawChantierContainer(int x, int y) {
		int[] nbBanque;
	}
			

	private void drawLigneUnknown(int x, int y, int numLig) {
		fontRendererObj.drawString("???", 10 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
	}

	private void drawLigneChantier(int x, int y, int numLig, String nomChantier, Object[] def, int[] nbComposant,
			ResourceLocation[] textures, int[] nbDispoBanque, int PATileEntity) {

		fontRendererObj.drawString(nomChantier, 10 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);

		if (PATileEntity > 0) {
			if ((Boolean) def[0]) {
				fontRendererObj.drawString("" + def[1], 90 + x, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
				drawRender(112 + x, y + (20 * (numLig - 1)), 16, 16, Def);
			}
			for (int i = nbDispoBanque.length - 1; i >= 0; i--) {
				int color = nbDispoBanque[i] >= nbComposant[i] ? 0xFFFFFF : 0xCC0000;
				fontRendererObj.drawString(nbDispoBanque[i] + "/" + nbComposant[i], 288 + x - (i * 60),
						y + 4 + (20 * (numLig - 1)), color, false);
				drawRender(318 + x - i * 60, y + (20 * (numLig - 1)), 16, 16, textures[i]);
			}
			fontRendererObj.drawString("" + PATileEntity, 10 + x + 340, y + 4 + (20 * (numLig - 1)), 0xFFFFFF, false);
			drawRender(20 + x + 352, y + (20 * (numLig - 1)), 16, 16, textures[textures.length - 1]);
		}
	}

	private void addButtons(int x, int y) {
		for (int i = 1; i < nbElementsGui; i++) {
			GuiBooleanButton button = new GuiBooleanButton(i, x + 45 + 350, y + (20 * (i - 1)), 30, 20, "+", true);
			button.enabled = false;
			this.buttonList.add(button);
		}
	}

	private void updateButtons() {
		for (ItemStack itemStack : tileEntityBanque.getContent()) {
			if(itemStack != null) {
				if(itemStack.getItem() == HMItemRegistry.composantElectronique)
					nbComposantElectronique += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.courroie)
					nbCourroie += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.explosifsBruts)
					nbExplosifsBruts += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.ferraille)
					nbFerraille += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.grosseChaineRouillee)
					nbGrosseChaineRouille += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.morceauDeGrillage)
					nbMorceauDeGrillage += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.paracetoide7G)
					nbParacetoide7G += itemStack.stackSize;
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
				if(itemStack.getItem() == HMItemRegistry.rustine)
					nbRustine += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.steroidesAnabolisants)
					nbSteroidesAnabolisants += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.structuresMetalliques)
					nbStructuresMetalliques += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.tableJarpen)
					nbTableJarpen += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.tubeDeCuivre)
					nbTubeDeCuivre += itemStack.stackSize;
				if(itemStack.getItem() == HMItemRegistry.vodkaMarinostov)
					nbVodkaMarinostov += itemStack.stackSize;
			}
		}
		for (Object object : buttonList) 
			if(object instanceof GuiBooleanButton) {
				GuiBooleanButton button = (GuiBooleanButton) object;

				switch (button.id) {
				case 1:button.visible = TEAtelier.PAAtelier>0;button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue, nbFerraille}, ChantiersRegistry.recetteAtelier);break;
		    	case 2:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille}, ChantiersRegistry.recetteBoucherie);break;
		    	case 3:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee, nbStructuresMetalliques}, ChantiersRegistry.recetteCrematoCue);break;
		    	case 4:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous}, ChantiersRegistry.recetteFixationsDefenses);break;
		    	case 5:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPavesBeton}, ChantiersRegistry.recetteMonticulesCanons);break;
		    	case 6:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPavesBeton,nbTubeDeCuivre,nbComposantElectronique}, ChantiersRegistry.recetteCanonABriques);break;
		    	case 7:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbTubeDeCuivre,nbComposantElectronique}, ChantiersRegistry.recettePerforeuse);break;
		    	case 8:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbPlaqueDeTole,nbExplosifsBruts},ChantiersRegistry.recetteLanceGrenailles);break;
		    	case 9:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbStructuresMetalliques,nbPlaqueDeTole}, ChantiersRegistry.recetteCanonBrutal);break;
		    	case 10:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques}, ChantiersRegistry.recetteTourniquet);break;
		    	
		    	case 11:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee, nbStructuresMetalliques,nbTableJarpen},ChantiersRegistry.recetteManufacture);break;
		    	case 12:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbFerraille,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbRustine},ChantiersRegistry.recetteSciesHurlantes );break;
		    	case 13:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbTableJarpen},ChantiersRegistry.recetteRegistreChantier );break;
		    	case 14:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbSteroidesAnabolisants,nbVodkaMarinostov},ChantiersRegistry.recetteArchitectoire);break;
		    	case 15:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbGrosseChaineRouille},ChantiersRegistry.recettePotence);break;
		    	case 16:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbStructuresMetalliques,nbPavesBeton},ChantiersRegistry.recetteAbattoir);break;
		    	case 17:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques},ChantiersRegistry.recetteSupportsDefensifs);break;
		    	case 18:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbRationDEau,nbProduitsPharmaceutiques},ChantiersRegistry.recetteCantineABois);break;
		    	case 19:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbPoigneeDeVisEtEcrous},ChantiersRegistry.recetteCimetiereCadenasse);break;
		    	case 20:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbFerraille,nbPoigneeDeVisEtEcrous,nbCourroie},ChantiersRegistry.recetteCercueilsSurRessorts);break;
		    	
		    	case 21:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbTableJarpen,nbProduitsPharmaceutiques},ChantiersRegistry.recetteCantineCentrale);break;
		    	case 22:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous,nbProduitsPharmaceutiques},ChantiersRegistry.recetteLaboratoireCentral);break;
		    	case 23:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue,nbPoutreRafistolee,nbMorceauDeGrillage},ChantiersRegistry.recettePoulailler);break;
		    	case 24:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbProduitsPharmaceutiques,nbParacetoide7G},ChantiersRegistry.recetteInfirmerie);break;
		    	case 25:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous},ChantiersRegistry.recetteStrategiesCitoyennes);break;
		    	case 26:button.visible = checkButtonVisible(button.id); button.enabled = checkButtonEnabled(new int[]{nbPoutreRafistolee,nbStructuresMetalliques,nbPoigneeDeVisEtEcrous},ChantiersRegistry.recetteQuartiersCirculaires);break;
				default:break;			
				}
			}
	}
	
	private boolean checkButtonVisible(int ID) {
		/** arg 1 = self, arg 2 = unlock supérieur, ag3 = plan **/
		if(TEAtelier.PAAtelier == 0) {
			switch (ID) {
			case 2: return TEAtelier.PABoucherie != 0 && TEVille.tabInhabituelIsUnlocked[7];
			case 3: return TEAtelier.PACrematoCue != 0 && TEAtelier.PABoucherie == 0 && TEVille.tabInhabituelIsUnlocked[8];
			case 4: return TEAtelier.PAFixationsDefenses != 0 && TEVille.tabRareIsUnlocked[8];
			case 5: return TEAtelier.PAMonticulesCanons != 0;
			case 6: return TEAtelier.PACanonABriques != 0 && TEAtelier.PAMonticulesCanons == 0 && TEVille.tabCommunIsUnlocked[19];
			case 7: return TEAtelier.PAPerforeuse != 0 && TEAtelier.PAMonticulesCanons == 0 && TEVille.tabCommunIsUnlocked[20];
			case 8: return TEAtelier.PALanceGrenailles != 0 && TEAtelier.PAMonticulesCanons == 0 && TEVille.tabCommunIsUnlocked[21];
			case 9: return TEAtelier.PACanonBrutal != 0 && TEAtelier.PAMonticulesCanons == 0;
			case 10: return TEAtelier.PATourniquet != 0;
			case 11: return TEAtelier.PAManufacture != 0;
			case 12: return TEAtelier.PASciesHurlantes != 0;
			case 13: return TEAtelier.PARegistreChantier != 0;
			case 14: return TEAtelier.PAArchitectoire != 0 && TEAtelier.PARegistreChantier == 0;
			case 15: return TEAtelier.PAPotence != 0;
			case 16: return TEAtelier.PAAbattoir != 0 && TEVille.tabCommunIsUnlocked[22];
			case 17: return TEAtelier.PASupportsDefensifs != 0 && TEVille.tabRareIsUnlocked[9];
			case 18: return TEAtelier.PACantineABois != 0;
			case 19: return TEAtelier.PACimetiereCadenasse != 0;
			case 20: return TEAtelier.PACercueilsSurRessort != 0 && TEAtelier.PACimetiereCadenasse == 0 && TEVille.tabTresRareIsUnlocked[1];
			case 21: return TEAtelier.PACantineCentrale != 0 && TEVille.tabCommunIsUnlocked[23];
			case 22: return TEAtelier.PALaboratoireCentral != 0 && TEVille.tabCommunIsUnlocked[24];
			case 23: return TEAtelier.PAPoulailler != 0 && TEVille.tabRareIsUnlocked[10];
			case 24: return TEAtelier.PAInfirmerie != 0 && TEVille.tabRareIsUnlocked[11];
			case 25: return TEAtelier.PAStrategiesCitoyennes != 0 && TEVille.tabTresRareIsUnlocked[2];
			case 26: return TEAtelier.PAQuartiersCirculaires != 0 && TEVille.tabRareIsUnlocked[12];
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