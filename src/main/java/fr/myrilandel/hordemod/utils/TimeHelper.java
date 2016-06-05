package fr.myrilandel.hordemod.utils;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TimeHelper {
	
	public static int getMCNbDays(World world) {
		if(world == null)
			return 0;
		return (int) world.getWorldTime()/24000;
	}
	
	public static int getHMNbDays(World world) {
		if(world == null)
			return 0;
		int decallageHorraire = (24 - ParamInit.heureNewDay) * 1000;
		return (int) (world.getWorldTime()+decallageHorraire)/24000;
	}
	
	public static long getRelativeTime(World world) {
		if(world == null)
			return 0;
		return world.getWorldTime()-(getMCNbDays(world) * 24000);
	}
	
	public static int getRelativeTimeInHour(World world) {
		if(world == null)
			return 0;
		return (int) getRelativeTime(world)/1000;
	}
	
	public static int getNextZombieAttacks(World world) {
		if(world == null)
			return 0;
		if(getRelativeTimeInHour(world) < ParamInit.heureAttaque)
			return ParamInit.heureAttaque - getRelativeTimeInHour(world);
		else	
			return ParamInit.heureAttaque + (24-getRelativeTimeInHour(world));
	}
}
