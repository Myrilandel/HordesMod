package fr.myrilandel.hordemod.events;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import fr.minecraftforgefrance.ffmtlibs.network.PacketHandler;
import fr.myrilandel.hordemod.CommonProxy;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.ParamInit;
import fr.myrilandel.hordemod.utils.TileHelper;
import fr.myrilandel.hordemod.utils.TimeHelper;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import fr.myrilandel.hordemod.zombies.ZombieNuitHorsVille;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.SpecialSpawn;

public class EventHandlerGlobal {
	public static CommonProxy proxy; 
	public static boolean tick = true;
	
 	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote	&& event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
			if (playerData != null) {
				((ExtendedEntityPropJourna) (event.entity.getExtendedProperties(ExtendedEntityPropJourna.EXT_PROP_NAME))).loadNBTData(playerData);
				((ExtendedEntityPropEtats) (event.entity.getExtendedProperties(ExtendedEntityPropEtats.EXT_PROP_NAME))).loadNBTData(playerData);
			}
			((ExtendedEntityPropJourna) (event.entity.getExtendedProperties(ExtendedEntityPropJourna.EXT_PROP_NAME))).sync();
			((ExtendedEntityPropEtats) (event.entity.getExtendedProperties(ExtendedEntityPropEtats.EXT_PROP_NAME))).sync();

			giveSarterPack(event);
		}
 		
		if(event.entity instanceof EntityLiving) 
			if(!(event.entity instanceof ZombieNuitEnVille || event.entity instanceof ZombieNuitHorsVille))
		    	event.setCanceled(true);
		
		/*if(event.entity instanceof EntityPlayer && ServeurState.isClose)
			event.setCanceled(true);*/
	}
 	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		addExtendedProperties(event);
	}
	
	
	@SubscribeEvent
	public int onTickServer(TickEvent.WorldTickEvent event)	{
		if(!event.world.isRemote && event.phase == Phase.END) {
			long time = TimeHelper.getRelativeTime(event.world);
			TileEntity tile = TileHelper.getTileVille(event.world);
			if(!gameHasStarted(tile) && time % 2000 == 0) {
				event.world.setWorldTime(1000);
				return 0;
			}
			
			if(time == ParamInit.heureNewDay * 1000)
				if(tick) {		
					MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatComponentText("Initialisation d'une nouvelle journée. Patientez svp...")));
					resetPlayerJourna(event);
					resetWorldJourna(event);
					resetNextAttack(event);
					MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatComponentText("Initialisation réussie !")));					
					tick = false;	
				}
			
			if(time == ParamInit.heureAttaque * 1000)
				if(tick) {		
					MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatComponentText("L'attaque va commencer !!")));
					spawnAttack(event);
					tick = false;	
				}
				
			if(!tick && (time == (ParamInit.heureNewDay * 1000) + ParamInit.nextTick || 
					time == (ParamInit.heureAttaque * 1000) + ParamInit.nextTick))
				tick = true;
		}
		return 0;
	}
	
	private boolean gameHasStarted(TileEntity tile){
		if(tile instanceof TileEntityBlocksVille) {
			TileEntityBlocksVille tileVille = (TileEntityBlocksVille) tile;
			return tileVille.gameStarted;
		}
		return false;
	}
	
	private void resetNextAttack(TickEvent.WorldTickEvent event) {
		TileEntity tile = TileHelper.getTileVille(event.world);
		if(tile instanceof TileEntityBlocksVille) {
			TileEntityBlocksVille tileVille = (TileEntityBlocksVille) tile;
			tileVille.increaseNbZombies();
		}
	}
	private void spawnAttack(TickEvent.WorldTickEvent event) {
		int nbZombies = TileHelper.getNbZombies(event.world);
		int def = TileHelper.getDefenses(event.world);
			if(nbZombies <= def)
				for (int i = 0; i < nbZombies; i++)
					event.world.spawnEntityInWorld(new ZombieNuitHorsVille(event.world));
			else {
				for(int i = 0; i < def; i++)
					event.world.spawnEntityInWorld(new ZombieNuitHorsVille(event.world));
				for(int i = 0; i < (nbZombies-def); i++)
					event.world.spawnEntityInWorld(new ZombieNuitEnVille(event.world));
			}
	}
	
	private void resetPlayerJourna(TickEvent.WorldTickEvent event) {
		List listePlayers = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		if(listePlayers.size() > 0) {
			for(int i = 0; i < listePlayers.size(); i++) {
				EntityPlayer entityPlayer = (EntityPlayer) listePlayers.get(i);
				ExtendedEntityPropEtats propsEtats = ExtendedEntityPropEtats.get(entityPlayer);
				ExtendedEntityPropJourna propsJourna = ExtendedEntityPropJourna.get(entityPlayer);
				propsEtats.reset();
				propsJourna.reset();
			}
			int rand = MathHelper.getRandomIntegerInRange(new Random(), 0, listePlayers.size()-1);
			EntityPlayer entityPlayer = (EntityPlayer) listePlayers.get(rand);
			//entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.planCommun));
		}
	}
	
	private void resetWorldJourna(TickEvent.WorldTickEvent event) {
		World world = MinecraftServer.getServer().getEntityWorld();
		for (int j = 0; j <  20; j++)
			for(int k = 0; k <  20; k++) {
				if(j == 9 && k == 10)
					continue;
				for(int i = 0; i < 10; i++) {
					int x = MathHelper.getRandomIntegerInRange(new Random(), 0+(j*100), 100+(j*100));
					int z = MathHelper.getRandomIntegerInRange(new Random(), 0+(k*100), 100+(k*100));
					if(world.getBlock(x, 3, z) == HMBlockRegistry.blockSable)
						world.setBlock(x, 3, z, HMBlockRegistry.blockSable, 1, 2);
				}
			}
		
		for (int nbRepleted = 0; nbRepleted < 4;  nbRepleted ++) {
			int j = MathHelper.getRandomIntegerInRange(new Random(), 0, 19);
			int k = MathHelper.getRandomIntegerInRange(new Random(), 0, 19);
			while(j == 9 && k == 10) {
				j = MathHelper.getRandomIntegerInRange(new Random(), 0, 19);
				k = MathHelper.getRandomIntegerInRange(new Random(), 0, 19);
			}
			
			for(int i = 0; i < 10; i++) {
				int x = MathHelper.getRandomIntegerInRange(new Random(), 0+(j*100), 100+(j*100));
				int z = MathHelper.getRandomIntegerInRange(new Random(), 0+(k*100), 100+(k*100));
				if(world.getBlock(x, 4, z) == Blocks.air)
					world.setBlock(x, 4, z, HMBlockRegistry.blockSable, 2, 2);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(event.entity instanceof EntityPlayer)
			event.entity.dropItem(new HMItemRegistry().osCharnu, 1);
	}
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if(event.entity instanceof EntityPlayer)
			event.entity.motionY = 0;
	}
	
	@SubscribeEvent
	public void onItemExpireEvent(ItemExpireEvent event) {
		event.setCanceled(true);
	}
	
	private void addExtendedProperties(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if(ExtendedEntityPropEtats.get((EntityPlayer) event.entity) == null)
				ExtendedEntityPropEtats.register((EntityPlayer) event.entity);
			
			if(ExtendedEntityPropJourna.get((EntityPlayer) event.entity) == null)
				ExtendedEntityPropJourna.register((EntityPlayer) event.entity);
		}
	}
	
	private void giveSarterPack(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer entityPlayer = (EntityPlayer) event.entity;
			ExtendedEntityPropJourna props = ExtendedEntityPropJourna.get(entityPlayer);
			if(!props.aRecuStarterPack) {
				entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.affaireDUnCitoyen));
				entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.doggyBag));
				props.switchARecuStarterPack(true);
			}
		}
	}

	/*	@SubscribeEvent
	public void onTickClient(TickEvent.ClientTickEvent event)
	{
		if(event.phase == Phase.START) {
			GuiScreen currentScreen = Minecraft.getMinecraft().currentScreen;
			GuiCustomMainMenu customMenu = new GuiCustomMainMenu();

			if(currentScreen instanceof GuiMainMenu && !currentScreen.equals(customMenu)) 
				Minecraft.getMinecraft().displayGuiScreen(customMenu);
		}
	}
*/
}
