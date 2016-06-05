package fr.myrilandel.hordemod.buildings.muraille;

import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildMuraille {
	static int i = 911;
	static int j = 4;
	static int k = 1011;
	
	public static void init(World world) {
		/*for(int x = i; x < i+80; x++)
			for(int z = k; z < k+80; z++)
				for(int y = j; j < j+5; y++)
					world.setBlock(x, y, z, Blocks.air);*/
		
		for(int x = i; x < i+80; x++) {
			world.setBlock(x, j + 0, k + 0, Blocks.cobblestone);
			world.setBlock(x, j + 1, k + 0, Blocks.cobblestone_wall);
			world.setBlock(x, j + 0, k + 79, Blocks.cobblestone);
			world.setBlock(x, j + 1, k + 79, Blocks.cobblestone_wall);
			
			world.setBlock(x, j + 2, k + 0, Blocks.air);
			world.setBlock(x, j + 2, k + 79, Blocks.air);
		}
		
		for(int z = k; z < k+80; z++) {
			world.setBlock(i + 0, j + 0, z, Blocks.cobblestone);
			world.setBlock(i + 0, j + 1, z, Blocks.cobblestone_wall);
			world.setBlock(i + 79, j + 0, z, Blocks.cobblestone);
			world.setBlock(i + 79, j + 1, z, Blocks.cobblestone_wall);
		}
		world.setBlock(i + 42, j + 0, k + 1, HMBlockRegistry.blockLevierPorte, 3, 2);
	}
	
	public static void updateMuraille(World world, int PA) {
		if(PA == (2*ChantiersRegistry.recetteMuraille[2])/3) {
			for(int x = i; x < i+80; x++) {
				world.setBlock(x, j + 1, k + 79, Blocks.cobblestone);
			}
			for(int x = i; x < i+38; x++) {
				world.setBlock(x, j + 1, k + 0, Blocks.cobblestone);
			}
			for(int x = i+42; x < i+80; x++) {
				world.setBlock(x, j + 1, k + 0, Blocks.cobblestone);
			}
		}

		if(PA == ChantiersRegistry.recetteMuraille[2]/3) {
			for(int z = k; z < k+80; z++) {
				world.setBlock(i + 0, j + 1, z, Blocks.cobblestone);
				world.setBlock(i + 79, j + 1, z, Blocks.cobblestone);
			}
		}
	
		if(PA == 0) {
			for(int x = i; x < i+80; x++) {
				world.setBlock(x, j + 2, k + 79, Blocks.cobblestone_wall);
			}
			
			for(int x = i; x < i+38; x++) {
				world.setBlock(x, j + 2, k + 0, Blocks.cobblestone_wall);
			}
			
			for(int x = i+42; x < i+80; x++) {
				world.setBlock(x, j + 2, k + 0, Blocks.cobblestone_wall);
			}
			
			for(int z = k; z < k+80; z++) {
				world.setBlock(i + 0, j + 2, z, Blocks.cobblestone_wall);
				world.setBlock(i + 79, j + 2, z, Blocks.cobblestone_wall);
			}
		}
		
	}
}
	