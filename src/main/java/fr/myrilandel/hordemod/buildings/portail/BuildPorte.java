package fr.myrilandel.hordemod.buildings.portail;

import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildPorte {

	public static void ouverte(World world) {
		clearFermee(world);
		for(int z = 1012; z < 1016; z++)
			for(int y = 4; y < 7; y++)
				world.setBlock(948, y, z, HMBlockRegistry.blockPorte, 1, 2);
		
		world.setBlock(948, 7, 1013, HMBlockRegistry.blockPorte, 1, 2);
		world.setBlock(948, 7, 1014, HMBlockRegistry.blockPorte, 1, 2);
	}
	
	public static void fermee(World world) {
		clearOuverte(world);
		for(int x = 949; x < 953; x++)
			for(int y = 4; y < 7; y++)
				world.setBlock(x, y, 1011, HMBlockRegistry.blockPorte, 1, 2);
		
		world.setBlock(951, 7, 1011, HMBlockRegistry.blockPorte, 1, 2);
		world.setBlock(950, 7, 1011, HMBlockRegistry.blockPorte, 1, 2);
		world.setBlock(951, 4, 1011, HMBlockRegistry.blockPorte, 2, 2);
	}
	
	private static void clearFermee(World world) {
		for(int x = 949; x < 953; x++)
			for(int y = 4; y < 7; y++)
				world.setBlock(x, y, 1011, Blocks.air, 1, 2);
		
		world.setBlock(951, 7, 1011, Blocks.air, 1, 2);
		world.setBlock(950, 7, 1011, Blocks.air, 1, 2);
	}
	
	private static void clearOuverte(World world) {
		for(int z = 1012; z < 1016; z++)
			for(int y = 4; y < 7; y++)
				world.setBlock(948, y, z, Blocks.air, 1, 2);
		
		world.setBlock(948, 7, 1013, Blocks.air, 1, 2);
		world.setBlock(948, 7, 1014, Blocks.air, 1, 2);
	}
}
