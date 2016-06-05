package fr.myrilandel.hordemod.gui;

import org.lwjgl.opengl.GL11;

import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
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

public class GUIChantierFondations extends GuiContainer {

	World world;
	TileEntityChantierFondations TEFondations;
	TileEntityBanque tileEntityBanque;
	TileEntityBlocksVille TEVille;
	EntityPlayer player;
	ExtendedEntityPropEtats props;
	int guiWidth = 450;
	int guiHeight = 450;
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

	public GUIChantierFondations(World world, TileEntityChantierFondations tileEntityChantierMuraille, TileEntityBanque tileEntityBanque,
			TileEntityBlocksVille tileEntityBlocksVille, EntityPlayer player) {
		super(new ContainerChantierFondations(tileEntityChantierMuraille, world));
		this.world = world;
		this.TEFondations = tileEntityChantierMuraille;
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
			HMPacketHelper.sendPacket(TEFondations, button.id);
			HMPacketHelper.sendPacket(tileEntityBanque, button.id,4);
			HMPacketHelper.sendPacket(TEVille, button.id,4);
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
		drawLigneChantier(x, y, 1, "Muraille", ChantiersRegistry.defMuraille, ChantiersRegistry.recetteMuraille,
				ChantiersRegistry.texturesMuraille, new int[]{nbPlanchesTordue,nbFerraille}, TEFondations.PAMuraille);
		if(TEFondations.PAMuraille == 0)
			for (int i = 2; i < nbElementsGui; i++) {
				switch (i) {
				case 2: drawLigneChantier(x, y, 1, "Muraille", ChantiersRegistry.defMuraille, ChantiersRegistry.recetteMuraille,
						ChantiersRegistry.texturesMuraille, new int[]{nbPlanchesTordue,nbFerraille}, TEFondations.PAMuraille);
				}
			}	
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
				case 1:button.visible = TEFondations.PAMuraille>0;button.enabled = checkButtonEnabled(new int[]{nbPlanchesTordue, nbFerraille}, ChantiersRegistry.recetteMuraille);break;

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
		if(TEFondations.PAMuraille == 0) {
			switch (ID) {
			case 2: return TEFondations.PAGrandFosse != 0;
			case 3: return TEFondations.PADouves != 0 && TEFondations.PAGrandFosse == 0 && TEVille.tabCommunIsUnlocked[0];
			case 4: return TEFondations.PAMurailleRasoir != 0 && TEVille.tabCommunIsUnlocked[1];
			case 5: return TEFondations.PAFosseAPieux != 0 && TEVille.tabCommunIsUnlocked[2];
			case 6: return TEFondations.PABarbeles != 0;
			case 7: return TEFondations.PAAppats != 0 && TEFondations.PABarbeles == 0;
			case 8: return TEFondations.PARempartsAvances != 0 && TEVille.tabCommunIsUnlocked[3];
			case 9: return TEFondations.PAPoutresRenfort != 0;
			case 10: return TEFondations.PAMurailleAPointes != 0 && TEFondations.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[4];
			case 11: return TEFondations.PAGrogroMur != 0 && TEFondations.PAMurailleAPointes == 0 && TEVille.tabInhabituelIsUnlocked[0];
			case 12: return TEFondations.PASecondeCouche != 0 && TEFondations.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[5];
			case 13: return TEFondations.PATroisièmeCouche != 0 && TEFondations.PASecondeCouche == 0 && TEVille.tabInhabituelIsUnlocked[1];
			case 14: return TEFondations.PAMurailleEvolutive != 0 && TEFondations.PAPoutresRenfort == 0 && TEVille.tabRareIsUnlocked[0];
			case 15: return TEFondations.PABetonnade != 0 && TEFondations.PAPoutresRenfort == 0 && TEVille.tabCommunIsUnlocked[6];
			case 16: return TEFondations.PARapeAZombies != 0 && TEVille.tabCommunIsUnlocked[7];
			case 17: return TEFondations.PAOubliettes != 0;
			case 18: return TEFondations.PABarrieres != 0;
			case 19: return TEFondations.PAPalissade != 0 && TEVille.tabCommunIsUnlocked[8];
			case 20: return TEFondations.PAMurSavone != 0 && TEVille.tabCommunIsUnlocked[9];
			case 21: return TEFondations.PAPulverisateur != 0 && TEVille.tabCommunIsUnlocked[10];
			case 22: return TEFondations.PAProjectionAcide != 0 && TEFondations.PAPulverisateur == 0 && TEVille.tabCommunIsUnlocked[11];
			case 23: return TEFondations.PANeurotoxine != 0 && TEFondations.PAPulverisateur == 0 && TEVille.tabInhabituelIsUnlocked[2];
			case 24: return TEFondations.PACloisonEnBois != 0;
			case 25: return TEFondations.PACloisonMetallique != 0;
			case 26: return TEFondations.PACloisonEpaisse != 0;
			case 27: return TEFondations.PAContrePlaque != 0;
			case 28: return TEFondations.PABastion != 0 && TEVille.tabCommunIsUnlocked[12];
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