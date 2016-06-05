package fr.myrilandel.hordemod.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.myrilandel.hordemod.blocks.BlockTest;
import fr.myrilandel.hordemod.blocks.itemBlock.ItemBlockChantier;
import fr.myrilandel.hordemod.blocks.itemBlock.ItemBlockPorte;
import fr.myrilandel.hordemod.blocks.itemBlock.ItemBlockSable;
import fr.myrilandel.hordemod.blocks.map.BlockAngles;
import fr.myrilandel.hordemod.blocks.map.BlockBanque;
import fr.myrilandel.hordemod.blocks.map.BlockBoutonAtelier;
import fr.myrilandel.hordemod.blocks.map.BlockBoutonChantier;
import fr.myrilandel.hordemod.blocks.map.BlockBoutonPuit;
import fr.myrilandel.hordemod.blocks.map.BlockCentral;
import fr.myrilandel.hordemod.blocks.map.BlockChantier;
import fr.myrilandel.hordemod.blocks.map.BlockLevierPorte;
import fr.myrilandel.hordemod.blocks.map.BlockPorte;
import fr.myrilandel.hordemod.blocks.map.BlockSable;
import fr.myrilandel.hordemod.blocks.map.BlockToEast;
import fr.myrilandel.hordemod.blocks.map.BlockToNorth;
import fr.myrilandel.hordemod.blocks.map.BlockToSouth;
import fr.myrilandel.hordemod.blocks.map.BlockToWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class HMBlockRegistry {
	
	public static Block blockTest = new BlockTest(Material.sand);
	public static Block blockBanque = new BlockBanque(Material.wood);
	public static Block blockChantier = new BlockChantier(Material.wood);
	public static Block blockCentral = new BlockCentral(Material.rock);

	
	public static Block blockAngles = new BlockAngles(Material.rock);
	public static Block blockBoutonAtelier = new BlockBoutonAtelier(Material.rock);
	public static Block blockBoutonChantier = new BlockBoutonChantier(Material.rock);
	public static Block blockBoutonPuit = new BlockBoutonPuit(Material.rock);
	public static Block blockLevierPorte = new BlockLevierPorte(Material.rock);
	public static Block blockPorte = new BlockPorte(Material.rock);
	public static Block blockSable = new BlockSable(Material.sand);
	public static Block blockToEast = new BlockToEast(Material.rock);
	public static Block blockToNorth = new BlockToNorth(Material.rock);
	public static Block blockToSouth = new BlockToSouth(Material.rock);
	public static Block blockToWest = new BlockToWest(Material.rock);

	public static void blockRegister() {
		GameRegistry.registerBlock(blockTest, "blockTest");
		GameRegistry.registerBlock(blockBanque, "blockBanque");
		GameRegistry.registerBlock(blockChantier, ItemBlockChantier.class, "blockChantier");
		GameRegistry.registerBlock(blockCentral, "blockCentral");

		GameRegistry.registerBlock(blockAngles, "blockAngles");
		GameRegistry.registerBlock(blockBoutonAtelier, "blockBoutonAtelier");
		GameRegistry.registerBlock(blockBoutonChantier, "blockBoutonChantier");
		GameRegistry.registerBlock(blockBoutonPuit, "blockBoutonPuit");
		GameRegistry.registerBlock(blockLevierPorte, "blockLevierPorte");
		GameRegistry.registerBlock(blockPorte, ItemBlockPorte.class, "blockPorte");
		GameRegistry.registerBlock(blockSable, ItemBlockSable.class, "blockSable");
		GameRegistry.registerBlock(blockToEast, "blockToEast");
		GameRegistry.registerBlock(blockToNorth, "blockToNorth");
		GameRegistry.registerBlock(blockToSouth, "blockToSouth");
		GameRegistry.registerBlock(blockToWest, "blockToWest");
	}
}
