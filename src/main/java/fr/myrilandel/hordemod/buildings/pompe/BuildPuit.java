package fr.myrilandel.hordemod.buildings.pompe;

import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.utils.ParamInit;
import fr.myrilandel.hordemod.utils.TileHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildPuit {
	
	public static void init(World world) {
		buildCorpsPuit(world);
		buildNiveauEau(world);
	}
	
	private static void buildCorpsPuit(World world) {
		int i = 978;
		int j = 1;
		int k = 1018;
		world.setBlock(i + 0, j + 0, k + 0, Blocks.cobblestone );
		world.setBlock(i + 0, j + 0, k + 1, Blocks.cobblestone );
		world.setBlock(i + 0, j + 0, k + 2, Blocks.cobblestone );
		world.setBlock(i + 0, j + 0, k + 3, Blocks.cobblestone );
		world.setBlock(i + 0, j + 0, k + 4, Blocks.cobblestone );
		world.setBlock(i + 0, j + 0, k + 5, Blocks.dirt );
		world.setBlock(i + 0, j + 1, k + 0, Blocks.cobblestone );
		world.setBlock(i + 0, j + 1, k + 1, Blocks.cobblestone );
		world.setBlock(i + 0, j + 1, k + 2, Blocks.cobblestone );
		world.setBlock(i + 0, j + 1, k + 3, Blocks.cobblestone );
		world.setBlock(i + 0, j + 1, k + 4, Blocks.cobblestone );
		world.setBlock(i + 0, j + 1, k + 5, Blocks.dirt );
		world.setBlock(i + 0, j + 2, k + 0, Blocks.cobblestone );
		world.setBlock(i + 0, j + 2, k + 1, Blocks.cobblestone );
		world.setBlock(i + 0, j + 2, k + 2, Blocks.cobblestone );
		world.setBlock(i + 0, j + 2, k + 3, Blocks.cobblestone );
		world.setBlock(i + 0, j + 2, k + 4, Blocks.cobblestone );
		world.setBlock(i + 0, j + 3, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 0, j + 3, k + 1, Blocks.nether_brick_fence );
		world.setBlock(i + 0, j + 3, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 0, j + 3, k + 3, Blocks.nether_brick_fence );
		world.setBlock(i + 0, j + 3, k + 4, Blocks.nether_brick_fence );
		world.setBlock(i + 1, j + 0, k + 0, Blocks.cobblestone );
		world.setBlock(i + 1, j + 0, k + 4, Blocks.cobblestone );
		world.setBlock(i + 1, j + 0, k + 5, Blocks.dirt );
		world.setBlock(i + 1, j + 1, k + 0, Blocks.cobblestone );
		world.setBlock(i + 1, j + 1, k + 4, Blocks.cobblestone );
		world.setBlock(i + 1, j + 1, k + 5, Blocks.dirt );
		world.setBlock(i + 1, j + 2, k + 0, Blocks.cobblestone );
		world.setBlock(i + 1, j + 2, k + 4, Blocks.cobblestone );
		world.setBlock(i + 1, j + 3, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 1, j + 3, k + 4, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 0, k + 0, Blocks.cobblestone );
		world.setBlock(i + 2, j + 0, k + 4, Blocks.cobblestone );
		world.setBlock(i + 2, j + 0, k + 5, Blocks.dirt );
		world.setBlock(i + 2, j + 1, k + 0, Blocks.cobblestone );
		world.setBlock(i + 2, j + 1, k + 4, Blocks.cobblestone );
		world.setBlock(i + 2, j + 1, k + 5, Blocks.dirt );
		world.setBlock(i + 2, j + 2, k + 0, Blocks.cobblestone );
		world.setBlock(i + 2, j + 2, k + 2, Blocks.cauldron , 3, 2);
		world.setBlock(i + 2, j + 2, k + 4, Blocks.cobblestone );
		world.setBlock(i + 2, j + 3, k + 0, Blocks.cobblestone );
		world.setBlock(i + 2, j + 3, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 3, k + 4, Blocks.cobblestone );
		world.setBlock(i + 2, j + 3, k + 5, HMBlockRegistry.blockBoutonPuit,3,2);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 4, k + 4, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 5, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 5, k + 1, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 5, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 5, k + 3, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 5, k + 4, Blocks.nether_brick_fence );
		world.setBlock(i + 3, j + 0, k + 0, Blocks.cobblestone );
		world.setBlock(i + 3, j + 0, k + 4, Blocks.cobblestone );
		world.setBlock(i + 3, j + 0, k + 5, Blocks.dirt );
		world.setBlock(i + 3, j + 1, k + 0, Blocks.cobblestone );
		world.setBlock(i + 3, j + 1, k + 4, Blocks.cobblestone );
		world.setBlock(i + 3, j + 1, k + 5, Blocks.dirt );
		world.setBlock(i + 3, j + 2, k + 0, Blocks.cobblestone );
		world.setBlock(i + 3, j + 2, k + 4, Blocks.cobblestone );
		world.setBlock(i + 3, j + 3, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 3, j + 3, k + 4, Blocks.nether_brick_fence );
		world.setBlock(i + 4, j + 0, k + 0, Blocks.cobblestone );
		world.setBlock(i + 4, j + 0, k + 1, Blocks.cobblestone );
		world.setBlock(i + 4, j + 0, k + 2, Blocks.cobblestone );
		world.setBlock(i + 4, j + 0, k + 3, Blocks.cobblestone );
		world.setBlock(i + 4, j + 0, k + 4, Blocks.cobblestone );
		world.setBlock(i + 4, j + 0, k + 5, Blocks.dirt );
		world.setBlock(i + 4, j + 1, k + 0, Blocks.cobblestone );
		world.setBlock(i + 4, j + 1, k + 1, Blocks.cobblestone );
		world.setBlock(i + 4, j + 1, k + 2, Blocks.cobblestone );
		world.setBlock(i + 4, j + 1, k + 3, Blocks.cobblestone );
		world.setBlock(i + 4, j + 1, k + 4, Blocks.cobblestone );
		world.setBlock(i + 4, j + 1, k + 5, Blocks.dirt );
		world.setBlock(i + 4, j + 2, k + 0, Blocks.cobblestone );
		world.setBlock(i + 4, j + 2, k + 1, Blocks.cobblestone );
		world.setBlock(i + 4, j + 2, k + 2, Blocks.cobblestone );
		world.setBlock(i + 4, j + 2, k + 3, Blocks.cobblestone );
		world.setBlock(i + 4, j + 2, k + 4, Blocks.cobblestone );
		world.setBlock(i + 4, j + 3, k + 0, Blocks.nether_brick_fence );
		world.setBlock(i + 4, j + 3, k + 1, Blocks.nether_brick_fence );
		world.setBlock(i + 4, j + 3, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 4, j + 3, k + 3, Blocks.nether_brick_fence );
		world.setBlock(i + 4, j + 3, k + 4, Blocks.nether_brick_fence );
	}
	
	public static void buildSceauHaut(World world) {

		int i = 978;
		int j = 1;
		int k = 1018;

		world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
		world.setBlock(i + 2, j + 3, k + 2, Blocks.cauldron,3,2 );
		world.setBlock(i + 2, j + 2, k + 2, world.getBlock(i + 1, j + 2, k + 2));
		world.setBlock(i + 2, j + 1, k + 2, world.getBlock(i + 1, j + 1, k + 2));
		world.setBlock(i + 2, j + 0, k + 2, world.getBlock(i + 1, j + 0, k + 2));
		
	}
	
	public static void buildNiveauEau(World world) {
		int rations = TileHelper.getRations(world);
		int rationsMax = ParamInit.ration;
		
		int i = 978;
		int j = 1;
		int k = 1018;
		
		if(rations == 0) {
			for(int x = 1; x < 4; x++)
				for(int z = 1; z < 4; z++) {
					world.setBlock(i + x, j + 0, k + z, Blocks.air );
					world.setBlock(i + x, j + 1, k + z, Blocks.air );
					world.setBlock(i + x, j + 2, k + z, Blocks.air );
				}
			world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 3, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 2, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 1, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 0, k + 2, Blocks.cauldron);
		}
			
		if(rations > 0) {
			for(int x = 1; x < 4; x++)
				for(int z = 1; z < 4; z++) {
					world.setBlock(i + x, j + 0, k + z, Blocks.water );
					world.setBlock(i + x, j + 1, k + z, Blocks.air );
					world.setBlock(i + x, j + 2, k + z, Blocks.air );
				}
			world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 3, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 2, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 1, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 0, k + 2, Blocks.cauldron , 3, 2);
		}
		
		if(rations > (rationsMax * 0.33)) {
			for(int x = 1; x < 4; x++)
				for(int z = 1; z < 4; z++) {
					world.setBlock(i + x, j + 0, k + z, Blocks.water );
					world.setBlock(i + x, j + 1, k + z, Blocks.water );
					world.setBlock(i + x, j + 2, k + z, Blocks.air );
				}
			world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 3, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 2, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 1, k + 2, Blocks.cauldron , 3, 2);
		}
		
		if(rations > (rationsMax * 0.66)) {
			for(int x = 1; x < 4; x++)
				for(int z = 1; z < 4; z++) {
					world.setBlock(i + x, j + 0, k + z, Blocks.water );
					world.setBlock(i + x, j + 1, k + z, Blocks.water );
					world.setBlock(i + x, j + 2, k + z, Blocks.water );
				}
			world.setBlock(i + 2, j + 4, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 3, k + 2, Blocks.nether_brick_fence );
			world.setBlock(i + 2, j + 2, k + 2, Blocks.cauldron , 3, 2);
		}
	}
}
