package fr.myrilandel.hordemod.buildings;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.buildings.muraille.BuildMuraille;
import fr.myrilandel.hordemod.buildings.pompe.BuildPuit;
import fr.myrilandel.hordemod.buildings.portail.BuildPorte;
import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildVilleInit {

	
	public static void init(World world) {
		world.setBlock(951, 3, 1050, HMBlockRegistry.blockCentral);
		BuildMuraille.init(world);
		BuildPuit.init(world);
		BuildPorte.fermee(world);
	}	
}
	