package fr.myrilandel.hordemod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.minecraftforgefrance.ffmtlibs.network.PacketManager;
import fr.myrilandel.hordemod.creativeTabs.AlcoolsCreativeTabs;
import fr.myrilandel.hordemod.creativeTabs.ArmesCreativeTabs;
import fr.myrilandel.hordemod.creativeTabs.CassesCreativeTabs;
import fr.myrilandel.hordemod.creativeTabs.CoffresCreativeTabs;
import fr.myrilandel.hordemod.creativeTabs.DroguesCreativeTabs;
import fr.myrilandel.hordemod.creativeTabs.NourritureCreativeTabs;
import fr.myrilandel.hordemod.events.EventHandlerGlobal;
import fr.myrilandel.hordemod.gui.EventRenderHandler;
import fr.myrilandel.hordemod.gui.GUIHandler;
import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.registry.HMEntityRegistry;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.registry.HMRecipeRegistry;
import fr.myrilandel.hordemod.registry.HMTileEntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "hordemod", name = "Mod Horde", version = "3.0.0")

public class HordeMod {
	@Instance("hordemod")
	public static HordeMod instance;			
	public static final String MODID = "hordemod";
	
	@SidedProxy(clientSide = "fr.myrilandel.hordemod.ClientProxy", 
				serverSide = "fr.myrilandel.hordemod.CommonProxy")
	public static CommonProxy proxy;
	
	public static final PacketManager hordeModPacketHandlerBanque = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "Banque");
	public static final PacketManager hordeModPacketHandlerChantierMuraille = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierMuraille");
	public static final PacketManager hordeModPacketHandlerChantierPompe = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierPompe");
	public static final PacketManager hordeModPacketHandlerChantierAtelier = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierAtelier");
	public static final PacketManager hordeModPacketHandlerChantierTDG = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierTDG");
	public static final PacketManager hordeModPacketHandlerChantierFondations = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierFondations");
	public static final PacketManager hordeModPacketHandlerChantierPortail = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "ChantierPortail");

	public static final PacketManager hordeModPacketHandlerCentral = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "Central");
	public static final PacketManager hordeModPacketHandlerEtats = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "Etats");
	public static final PacketManager hordeModPacketHandlerJourna = new PacketManager("fr.myrilandel.hordemod.packets", MODID, "Journa");

	public static CreativeTabs alcoolsCreativeTabs = new AlcoolsCreativeTabs("alcoolsCreativeTabs");
	public static CreativeTabs armesCreativeTabs = new ArmesCreativeTabs("armesCreativeTabs");
	public static CreativeTabs cassesCreativeTabs = new CassesCreativeTabs("cassesCreativeTabs");
	public static CreativeTabs coffresCreativeTabs = new CoffresCreativeTabs("coffresCreativeTabs");
	public static CreativeTabs droguesCreativeTabs = new DroguesCreativeTabs("droguesCreativeTabs");
	public static CreativeTabs nourritureCreativeTabs = new NourritureCreativeTabs("nourritureCreativeTabs");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		HMBlockRegistry.blockRegister();
		HMItemRegistry.itemRegister();
		HMTileEntityRegistry.tileEntityRegister();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		HMItemRegistry.itemRegisterDuringInit();
		HMEntityRegistry.entityRegister();
		
		FMLCommonHandler.instance().bus().register(new EventHandlerGlobal());
		MinecraftForge.EVENT_BUS.register(new EventHandlerGlobal());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		if(event.getSide() == Side.CLIENT) {
			FMLCommonHandler.instance().bus().register(new EventRenderHandler());
			MinecraftForge.EVENT_BUS.register(new EventRenderHandler());
		}
        
		proxy.registerRender();
		HMRecipeRegistry.registerAllRecipes();		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
