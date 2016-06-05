package fr.myrilandel.hordemod.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.ParamInit;
import fr.myrilandel.hordemod.utils.PosHelper;
import fr.myrilandel.hordemod.utils.TileHelper;
import fr.myrilandel.hordemod.utils.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class EventRenderHandler extends GuiScreen {
	
	Minecraft mc = Minecraft.getMinecraft();
	World world;
	int HMPosX;
	int HMPosZ;
	
	public static final ResourceLocation background = new ResourceLocation(HordeMod.MODID,"textures/GUI/background.png");
	public static final ResourceLocation backgroundEnVille = new ResourceLocation(HordeMod.MODID,"textures/GUI/backgroundEnVille.png");

	public static final ResourceLocation empty = new ResourceLocation(HordeMod.MODID,"textures/GUI/empty1.png");

	public static final ResourceLocation PA = new ResourceLocation(HordeMod.MODID,"textures/GUI/pointAction.png");
	
	public static final ResourceLocation blesse = new ResourceLocation(HordeMod.MODID,"textures/GUI/blesse.png");
	public static final ResourceLocation clair = new ResourceLocation(HordeMod.MODID,"textures/GUI/clair.png");
	public static final ResourceLocation convalescent = new ResourceLocation(HordeMod.MODID,"textures/GUI/convalescent.png");
	public static final ResourceLocation drogue = new ResourceLocation(HordeMod.MODID,"textures/GUI/drogue.png");
	public static final ResourceLocation dependant = new ResourceLocation(HordeMod.MODID,"textures/GUI/dependant.png");
	public static final ResourceLocation desaltere = new ResourceLocation(HordeMod.MODID,"textures/GUI/desaltere.png");
	public static final ResourceLocation fatigue = new ResourceLocation(HordeMod.MODID,"textures/GUI/fatigue.png");
	public static final ResourceLocation infection = new ResourceLocation(HordeMod.MODID,"textures/GUI/infection.png");
	public static final ResourceLocation ivre = new ResourceLocation(HordeMod.MODID,"textures/GUI/ivre.png");
	public static final ResourceLocation gueuleDeBois = new ResourceLocation(HordeMod.MODID,"textures/GUI/gueuleDeBois.png");
	public static final ResourceLocation rassasie = new ResourceLocation(HordeMod.MODID,"textures/GUI/rassasie.png");
	public static final ResourceLocation soif = new ResourceLocation(HordeMod.MODID,"textures/GUI/soif.png");
	public static final ResourceLocation terreur = new ResourceLocation(HordeMod.MODID,"textures/GUI/terreur.png");

	public static final ResourceLocation defenses = new ResourceLocation(HordeMod.MODID,"textures/GUI/defenses.png");
	public static final ResourceLocation porteFermee = new ResourceLocation(HordeMod.MODID,"textures/GUI/porteFermee.png");
	public static final ResourceLocation rations = new ResourceLocation(HordeMod.MODID,"textures/GUI/rationDEau.png");
	
	public static final ResourceLocation defPerso = new ResourceLocation(HordeMod.MODID,"textures/GUI/defPerso.png");
	public static final ResourceLocation nbZombieCase = new ResourceLocation(HordeMod.MODID,"textures/GUI/zombies.png");


	@SubscribeEvent
	public void eventHandler(RenderGameOverlayEvent.Pre event)
	{
		HMPosX = PosHelper.getHMPosX(mc.thePlayer.posX);
		HMPosZ = PosHelper.getHMPosZ(mc.thePlayer.posZ);
		world = mc.theWorld;

		drawGUIBackgrounds();
		drawGUIEtats(event);

		if(PosHelper.isEnVille(mc.thePlayer.posX, mc.thePlayer.posZ))
			drawGUIEnVille();
		else
			drawGUIHorsVille();
	
		drawGUIPositionEtTemps();
 		this.mc.getTextureManager().bindTexture(Gui.icons);
	}
	
	@SubscribeEvent
	public void postEventHandler(RenderGameOverlayEvent.Post event)
	{
	}
	
	private void drawGUIBackgrounds() {
	    drawRender(2, 2, 215.0F, 31.0F,background);
		drawRender(2, 33, 215.0F, 60.0F,backgroundEnVille);
	}
	
	private void drawGUIEtats(RenderGameOverlayEvent event) {  
		
	    this.mc.fontRenderer.drawString(ExtendedEntityPropEtats.get(mc.thePlayer).PA+"/"+ExtendedEntityPropEtats.get(mc.thePlayer).PAMax, 225, 12, 0xFF0000,false);
	    drawRender(266, 8, 16.0F, 16.0F, PA);
		drawRender(11, 10, 16.0F, 16.0F, renderClairEtDrogue());		
		drawRender(37, 10, 16.0F, 16.0F, renderSoifEtDesaltere());
		drawRender(63, 10, 16.0F, 16.0F, renderRassasie());
		drawRender(89, 10, 16.0F, 16.0F, renderIvreEtGueuleDeBois());
		drawRender(115, 10, 16.0F, 16.0F, renderBlesseEtConvalescent());
		drawRender(141, 10, 16.0F, 16.0F, renderInfection());
		drawRender(167, 10, 16.0F, 16.0F, renderDependant());
		drawRender(193, 10, 16.0F, 16.0F, renderTerreur());
	}
	
	private void drawGUIPositionEtTemps() {
		this.mc.fontRenderer.drawString("Pos : " + HMPosX +"/"+ HMPosZ ,227, 30, 4000, false);
		this.mc.fontRenderer.drawString("Jour : " + TimeHelper.getHMNbDays(world),229, 45, 4000, false);
		
		boolean attaqueEnCours = TimeHelper.getRelativeTimeInHour(world) >= ParamInit.heureAttaque && TimeHelper.getRelativeTimeInHour(world) < ParamInit.heureNewDay ? true : false;
		this.mc.fontRenderer.drawString(attaqueEnCours ? "Attaque en cours !" : "Attaque dans : " + TimeHelper.getNextZombieAttacks(world)+" H",105, 48, 4000, false);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
	
	private void drawGUIEnVille() {			
			this.mc.fontRenderer.drawString(": "+TileHelper.getDefenses(world),33, 74, 4000,false);
		    drawRender(13, 69, 16.0F, 16.0F,defenses);
			this.mc.fontRenderer.drawString(": "+TileHelper.getRations(world),103, 74, 4000,false);
		    drawRender(82, 69, 16.0F, 16.0F,rations);
		    this.mc.fontRenderer.drawString(TileHelper.getPorteOuverte(world) ? "Ouverte":"Fermée", 168, 74, 4000,false);
		    drawRender(149, 69, 16.0F, 16.0F,porteFermee); 
		    this.mc.fontRenderer.drawString(": "+TileHelper.getNbZombies(world), 30, 48, 4000,false);
		    drawRender(10, 43, 16.0F, 16.0F,nbZombieCase); 
	}
	
	private void drawGUIHorsVille() {
		
	}
	
	private void drawRender(float x, float y, float width, float height, ResourceLocation texture) {
		this.mc.renderEngine.bindTexture(texture);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	
	    Tessellator tessLater = Tessellator.instance;
	    tessLater.startDrawingQuads();
	    tessLater.addVertexWithUV(x, y, 0.0D, 0.0D, 0.0D);
	    tessLater.addVertexWithUV(x, y + height, 0.0D, 0.0D, height / height);
	    tessLater.addVertexWithUV(x + width, y + height, 0.0D, 1.0D, height / height);
	    tessLater.addVertexWithUV(x + width, y, 0.0D, 1.0D, 0.0D);
	    tessLater.draw();
	}
	  
	private ResourceLocation renderClairEtDrogue() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).clair)
			return clair;
		if(ExtendedEntityPropEtats.get(mc.thePlayer).drogue)
			return drogue;
		return empty;
	}
	  
	private ResourceLocation renderSoifEtDesaltere() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).soif)
			return soif;
		if(ExtendedEntityPropEtats.get(mc.thePlayer).desaltere)
			return desaltere;
		return empty;
	}
  
	private ResourceLocation renderRassasie() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).rassasie)
			return rassasie;
		return empty;
	}
	  
	private ResourceLocation renderIvreEtGueuleDeBois() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).ivre)
			return ivre;
		if(ExtendedEntityPropEtats.get(mc.thePlayer).gueuleDeBois)
			return gueuleDeBois;
		return empty;
	}
	  
	private ResourceLocation renderBlesseEtConvalescent() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).blesse)
			return blesse;
		if(ExtendedEntityPropEtats.get(mc.thePlayer).convalescent)
			return convalescent;
		return empty;
	}
  
	private ResourceLocation renderInfection() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).infection)
			return infection;
		return empty;
	}

	private ResourceLocation renderDependant() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).dependant)
			return dependant;
		return empty;
	}

	private ResourceLocation renderTerreur() {
		if(ExtendedEntityPropEtats.get(mc.thePlayer).terreur)
			return terreur;
		return empty;
	}
}
