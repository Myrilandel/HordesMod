package fr.myrilandel.hordemod.utils;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileHelper {
	private static int xBanque = 951;
	private static int yBanque = 5;
	private static int zBanque = 1052;
	
	private static int xChantierMuraille = 951;
	private static int yChantierMuraille = 4;
	private static int zChantierMuraille = 1040;
	
	private static int xChantierPompe = 951;
	private static int yChantierPompe = 4;
	private static int zChantierPompe = 1040;
	
	private static int xChantierAtelier = 951;
	private static int yChantierAtelier = 4;
	private static int zChantierAtelier = 1040;
	
	private static int xChantierTDG = 951;
	private static int yChantierTDG = 4;
	private static int zChantierTDG = 1040;
	
	private static int xChantierFondations = 951;
	private static int yChantierFondations = 4;
	private static int zChantierFondations = 1040;
	
	private static int xChantierPortail = 951;
	private static int yChantierPortail = 4;
	private static int zChantierPortail = 1040;
	
	private static int xVille = 951;
	private static int yVille = 3;
	private static int zVille = 1050;
	
	public static TileEntity getTileBanque(World world) {
		return world.getTileEntity(xBanque, yBanque, zBanque);
	}
	
	public static void updateTileBanque(World world) {
		world.markBlockForUpdate(xBanque, yBanque, zBanque);
	}
	
	public static TileEntity getTileChantierMuraille(World world) {
		return world.getTileEntity(xChantierMuraille, yChantierMuraille, zChantierMuraille);
	}
	
	public static TileEntity getTileChantierPompe(World world) {
		return world.getTileEntity(xChantierPompe, yChantierPompe, zChantierPompe);
	}
	
	public static TileEntity getTileChantierAtelier(World world) {
		return world.getTileEntity(xChantierAtelier, yChantierAtelier, zChantierAtelier);
	}
	
	public static TileEntity getTileChantierTDG(World world) {
		return world.getTileEntity(xChantierTDG, yChantierTDG, zChantierTDG);
	}
	
	public static TileEntity getTileChantierFondations(World world) {
		return world.getTileEntity(xChantierFondations, yChantierFondations, zChantierFondations);
	}
	
	public static TileEntity getTileChantierPortail(World world) {
		return world.getTileEntity(xChantierPortail, yChantierPortail, zChantierPortail);
	}
	public static TileEntity getTileVille(World world) {
		return world.getTileEntity(xVille, yVille, zVille);
	}
	
	public static void updateTileVille(World world) {
		world.markBlockForUpdate(xVille, yVille, zVille);
	}
	
	public static int getDefenses(World world) {
		TileEntity tile = world.getTileEntity(xVille, yVille, zVille);
		if(tile instanceof TileEntityBlocksVille)
			return ((TileEntityBlocksVille) tile).defenses;
		return 0;
	}
	
	public static int getNbZombies(World world) {
		TileEntity tile = world.getTileEntity(xVille, yVille, zVille);
		if(tile instanceof TileEntityBlocksVille)
			return ((TileEntityBlocksVille) tile).nbZombies;
		return 0;
	}
	
	public static int getRations(World world) {
		if(world == null)
			return 0;
		TileEntity tile = world.getTileEntity(xVille, yVille, zVille);
		if(tile instanceof TileEntityBlocksVille)
			return ((TileEntityBlocksVille) tile).ration;
		return 0;
	}
	
	public static boolean getPorteOuverte(World world) {
		if(world == null)
			return false;
		TileEntity tile = world.getTileEntity(xVille, yVille, zVille);
		if(tile instanceof TileEntityBlocksVille)
			return ((TileEntityBlocksVille) tile).porteOuverte;
		
		return false;
	}
}
