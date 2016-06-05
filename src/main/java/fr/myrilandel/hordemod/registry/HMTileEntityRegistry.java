package fr.myrilandel.hordemod.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;

public class HMTileEntityRegistry {
		
	public static void  tileEntityRegister() {
		GameRegistry.registerTileEntity(TileEntityBlocksVille.class, "tileEntityBlocksVille");
		GameRegistry.registerTileEntity(TileEntityBanque.class, "TileEntityBanque");
		GameRegistry.registerTileEntity(TileEntityChantierMuraille.class, "TileEntityChantierMuraille");
		GameRegistry.registerTileEntity(TileEntityChantierPompe.class, "TileEntityChantierPompe");
		GameRegistry.registerTileEntity(TileEntityChantierAtelier.class, "TileEntityChantierAtelier");
		GameRegistry.registerTileEntity(TileEntityChantierTDG.class, "TileEntityChantierTDG");
		GameRegistry.registerTileEntity(TileEntityChantierFondations.class, "TileEntityChantierFondations");
		GameRegistry.registerTileEntity(TileEntityChantierPortail.class, "TileEntityChantierPortail");
	}
}
