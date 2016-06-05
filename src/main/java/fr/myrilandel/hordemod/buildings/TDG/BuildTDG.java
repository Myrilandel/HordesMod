package fr.myrilandel.hordemod.buildings.TDG;

import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildTDG {

	static int i = 954;
	static int j = 4;
	static int k = 1049;
	
	public static void updateTDG(World world, int PA) {
		if(PA == (2*ChantiersRegistry.recetteTDG[2])/3) {
			for (int x = 0; x < 5; x++)
				for(int y = 0; y < 6 ; y++)
					for(int z = 0; z < 6; z++)
						world.setBlock(i + x, j + y, k + z, Blocks.air);
			
			world.setBlock(i + 0, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 0, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 0, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 0, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 0, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 0, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 0, j + 2, k + 1, Blocks.planks);
			world.setBlock(i + 0, j + 2, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 4, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 4, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 1, Blocks.iron_bars);
			world.setBlock(i + 3, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 4, Blocks.iron_bars);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.iron_bars);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 4, Blocks.iron_bars);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.iron_bars);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 2, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.iron_bars);
		}
		
		if(PA == (ChantiersRegistry.recetteTDG[2])/3) {
			world.setBlock(i + 0, j + 0, k + 1, Blocks.log,1,2);
			world.setBlock(i + 0, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 0, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 0, j + 0, k + 4, Blocks.log,1,2);
			world.setBlock(i + 0, j + 1, k + 1, Blocks.log,1,2);
			world.setBlock(i + 0, j + 1, k + 4, Blocks.log,1,2);
			world.setBlock(i + 0, j + 2, k + 1, Blocks.log,1,2);
			world.setBlock(i + 0, j + 2, k + 4, Blocks.log,1,2);
			world.setBlock(i + 0, j + 3, k + 1, Blocks.log,1,2);
			world.setBlock(i + 0, j + 3, k + 2, Blocks.planks);
			world.setBlock(i + 0, j + 3, k + 3, Blocks.planks);
			world.setBlock(i + 0, j + 3, k + 4, Blocks.log,1,2);
			world.setBlock(i + 0, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 0, j + 4, k + 2, Blocks.planks);
			world.setBlock(i + 0, j + 4, k + 3, Blocks.planks);
			world.setBlock(i + 0, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 0, j + 5, k + 1, Blocks.iron_bars);
			world.setBlock(i + 0, j + 5, k + 4, Blocks.iron_bars);
			world.setBlock(i + 1, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.glass_pane);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.glass_pane);
			world.setBlock(i + 1, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 3, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 4, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 4, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 4, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 4, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 5, k + 1, Blocks.iron_bars);
			world.setBlock(i + 1, j + 5, k + 4, Blocks.iron_bars);
			world.setBlock(i + 2, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.glass_pane);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.glass_pane);
			world.setBlock(i + 2, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 3, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 4, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 4, k + 2, Blocks.planks);
			world.setBlock(i + 2, j + 4, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 5, k + 1, Blocks.iron_bars);
			world.setBlock(i + 2, j + 5, k + 4, Blocks.iron_bars);
			world.setBlock(i + 3, j + 0, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 0, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 0, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 1, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 2, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 3, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 3, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 3, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 3, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 3, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 3, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 4, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 4, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 4, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 4, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 5, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 5, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 5, k + 2, Blocks.iron_bars);
			world.setBlock(i + 3, j + 5, k + 3, Blocks.iron_bars);
			world.setBlock(i + 3, j + 5, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 5, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 6, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 6, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 6, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 6, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 7, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 7, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 7, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 7, k + 5, Blocks.iron_bars);
			world.setBlock(i + 3, j + 8, k + 0, Blocks.iron_bars);
			world.setBlock(i + 3, j + 8, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 8, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 8, k + 5, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 0, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 0, k + 5, Blocks.iron_bars);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 3, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 3, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 4, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 4, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 5, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 5, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 6, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 7, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 0, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 1, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 2, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 3, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 4, Blocks.iron_bars);
			world.setBlock(i + 4, j + 8, k + 5, Blocks.iron_bars);
			world.setBlock(i + 2, j + 1, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 2, j + 2, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 2, j + 3, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 2, j + 4, k + 3, Blocks.ladder,4,2);
		}
		
		if(PA == 0) {
			world.setBlock(i + 0, j + 5, k + 1, Blocks.air);
			world.setBlock(i + 0, j + 5, k + 4, Blocks.air);
			world.setBlock(i + 1, j + 5, k + 1, Blocks.air);
			world.setBlock(i + 1, j + 5, k + 4, Blocks.air);
			world.setBlock(i + 2, j + 5, k + 1, Blocks.air);
			world.setBlock(i + 2, j + 5, k + 4, Blocks.air);
			world.setBlock(i + 3, j + 0, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 0, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 1, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 2, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 3, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 3, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 4, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 4, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 5, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 5, k + 2, Blocks.air);
			world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			world.setBlock(i + 3, j + 5, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 6, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 6, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 7, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 7, k + 5, Blocks.air);
			world.setBlock(i + 3, j + 8, k + 0, Blocks.air);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 2, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air);	
			world.setBlock(i + 3, j + 8, k + 5, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 0, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 0, k + 5, Blocks.air);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 3, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 3, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 4, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 4, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 5, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 5, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 6, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 7, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 0, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 1, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 2, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 3, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 4, Blocks.air);
			world.setBlock(i + 4, j + 8, k + 5, Blocks.air);
			
			i-=1;
			world.setBlock(i + 0, j + 7, k + 1, Blocks.oak_stairs, 4, 2);
			world.setBlock(i + 0, j + 7, k + 4, Blocks.oak_stairs, 4, 2);
			world.setBlock(i + 0, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 0, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 0, j + 8, k + 3, Blocks.planks);
			world.setBlock(i + 0, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 0, j + 9, k + 1, Blocks.nether_brick_fence);
			world.setBlock(i + 0, j + 9, k + 2, Blocks.nether_brick_fence);
			world.setBlock(i + 0, j + 9, k + 3, Blocks.nether_brick_fence);
			world.setBlock(i + 0, j + 9, k + 4, Blocks.nether_brick_fence);
			world.setBlock(i + 1, j + 0, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 0, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 3, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 3, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 3, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 3, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 4, k + 2, Blocks.log,1,2);
			world.setBlock(i + 1, j + 4, k + 3, Blocks.log,1,2);
			world.setBlock(i + 1, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 5, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 5, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 5, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 5, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 6, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 6, k + 2, Blocks.glass_pane);
			world.setBlock(i + 1, j + 6, k + 3, Blocks.glass_pane);
			world.setBlock(i + 1, j + 6, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 7, k + 0, Blocks.oak_stairs, 6, 2);
			world.setBlock(i + 1, j + 7, k + 1, Blocks.log,1,2);
			world.setBlock(i + 1, j + 7, k + 2, Blocks.log,1,2);
			world.setBlock(i + 1, j + 7, k + 3, Blocks.log,1,2);
			world.setBlock(i + 1, j + 7, k + 4, Blocks.log,1,2);
			world.setBlock(i + 1, j + 7, k + 5, Blocks.oak_stairs, 7, 2);
			world.setBlock(i + 1, j + 8, k + 0, Blocks.planks);
			world.setBlock(i + 1, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 1, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 1, j + 8, k + 3, Blocks.planks);
			world.setBlock(i + 1, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 1, j + 8, k + 5, Blocks.planks);
			world.setBlock(i + 1, j + 9, k + 0, Blocks.nether_brick_fence);
			world.setBlock(i + 1, j + 9, k + 1, Blocks.nether_brick_fence);
			world.setBlock(i + 1, j + 9, k + 4, Blocks.nether_brick_fence);
			world.setBlock(i + 1, j + 9, k + 5, Blocks.nether_brick_fence);
			world.setBlock(i + 2, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 2, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.glass_pane);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.glass_pane);
			world.setBlock(i + 2, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 3, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 2, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 2, j + 5, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 5, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 6, k + 1, Blocks.glass_pane);
			world.setBlock(i + 2, j + 6, k + 4, Blocks.glass_pane);
			world.setBlock(i + 2, j + 7, k + 1, Blocks.log,1,2);
			world.setBlock(i + 2, j + 7, k + 4, Blocks.log,1,2);
			world.setBlock(i + 2, j + 8, k + 0, Blocks.planks);
			world.setBlock(i + 2, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 2, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 2, j + 8, k + 3, Blocks.planks);
			world.setBlock(i + 2, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 2, j + 8, k + 5, Blocks.planks);
			world.setBlock(i + 2, j + 9, k + 0, Blocks.nether_brick_fence);
			world.setBlock(i + 2, j + 9, k + 5, Blocks.nether_brick_fence);
			world.setBlock(i + 3, j + 0, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 3, j + 0, k + 4, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 1, k + 4, Blocks.planks);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.glass_pane);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.glass_pane);
			world.setBlock(i + 3, j + 3, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 3, k + 4, Blocks.planks);
			world.setBlock(i + 3, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 5, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 5, k + 4, Blocks.planks);
			world.setBlock(i + 3, j + 6, k + 1, Blocks.glass_pane);
			world.setBlock(i + 3, j + 6, k + 4, Blocks.glass_pane);
			world.setBlock(i + 3, j + 7, k + 1, Blocks.log,1,2);
			world.setBlock(i + 3, j + 7, k + 4, Blocks.log,1,2);
			world.setBlock(i + 3, j + 8, k + 0, Blocks.planks);
			world.setBlock(i + 3, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 3, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 3, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 3, j + 8, k + 5, Blocks.planks);
			world.setBlock(i + 3, j + 9, k + 0, Blocks.nether_brick_fence);
			world.setBlock(i + 3, j + 9, k + 5, Blocks.nether_brick_fence);
			world.setBlock(i + 4, j + 0, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 0, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 0, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 0, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 1, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 1, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 2, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 3, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 3, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 3, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 3, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 4, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 4, k + 2, Blocks.log,1,2);
			world.setBlock(i + 4, j + 4, k + 3, Blocks.log,1,2);
			world.setBlock(i + 4, j + 4, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 5, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 5, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 5, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 5, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 6, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 6, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 6, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 6, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 7, k + 0, Blocks.oak_stairs, 6, 2);
			world.setBlock(i + 4, j + 7, k + 1, Blocks.log,1,2);
			world.setBlock(i + 4, j + 7, k + 2, Blocks.log,1,2);
			world.setBlock(i + 4, j + 7, k + 3, Blocks.log,1,2);
			world.setBlock(i + 4, j + 7, k + 4, Blocks.log,1,2);
			world.setBlock(i + 4, j + 7, k + 5, Blocks.oak_stairs, 7, 2);
			world.setBlock(i + 4, j + 8, k + 0, Blocks.planks);
			world.setBlock(i + 4, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 4, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 4, j + 8, k + 3, Blocks.planks);
			world.setBlock(i + 4, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 4, j + 8, k + 5, Blocks.planks);
			world.setBlock(i + 4, j + 9, k + 0, Blocks.nether_brick_fence);
			world.setBlock(i + 4, j + 9, k + 1, Blocks.nether_brick_fence);
			world.setBlock(i + 4, j + 9, k + 4, Blocks.nether_brick_fence);
			world.setBlock(i + 4, j + 9, k + 5, Blocks.nether_brick_fence);
			world.setBlock(i + 5, j + 7, k + 1, Blocks.oak_stairs,5,2);
			world.setBlock(i + 5, j + 7, k + 4, Blocks.oak_stairs,5,2);
			world.setBlock(i + 5, j + 8, k + 1, Blocks.planks);
			world.setBlock(i + 5, j + 8, k + 2, Blocks.planks);
			world.setBlock(i + 5, j + 8, k + 3, Blocks.planks);
			world.setBlock(i + 5, j + 8, k + 4, Blocks.planks);
			world.setBlock(i + 5, j + 9, k + 1, Blocks.nether_brick_fence);
			world.setBlock(i + 5, j + 9, k + 2, Blocks.nether_brick_fence);
			world.setBlock(i + 5, j + 9, k + 3, Blocks.nether_brick_fence);
			world.setBlock(i + 5, j + 9, k + 4, Blocks.nether_brick_fence);
			world.setBlock(i + 3, j + 1, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 3, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 4, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 5, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 6, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 7, k + 3, Blocks.ladder,4,2);
			world.setBlock(i + 3, j + 8, k + 3, Blocks.ladder,4,2);
		}
	}

}