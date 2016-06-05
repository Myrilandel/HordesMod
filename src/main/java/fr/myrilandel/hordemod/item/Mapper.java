package fr.myrilandel.hordemod.item;

import java.util.Random;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.buildings.BuildVilleInit;
import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Mapper extends Item {

	public Mapper() {
		this.setUnlocalizedName("Mapper");
		this.setTextureName(HordeMod.MODID + ":mapper");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			entityPlayer.addChatComponentMessage(new ChatComponentText("Initialisation de la map en cours. Patientez svp..."));
			entityPlayer.addChatComponentMessage(new ChatComponentText("Nettoyage des zombies..."));
			for (Object object : world.loadedEntityList) {
				if(object instanceof EntityItem)
					((EntityItem) object).setDead();
			}
			entityPlayer.addChatComponentMessage(new ChatComponentText("Ajout d'un peu de sable..."));
			generateSableDesert(world);
			entityPlayer.addChatComponentMessage(new ChatComponentText("On ferme la cage à joueur..."));
			generateDelimDesert(world);
			entityPlayer.addChatComponentMessage(new ChatComponentText("Un petit puit et une petite muraille..."));
			BuildVilleInit.init(world);
			world.setWorldTime(21001);
			entityPlayer.addChatComponentMessage(new ChatComponentText("Et tout est prêt. Bonne mort à vous..."));
		}	
		return itemStack;
	}
	
	private void generateSableDesert(World world) {
		for(int i=1; i < 2001 ; i++) 
			for(int j=1; j < 2001 ; j++) {
				world.setBlock(j, 3, i, HMBlockRegistry.blockSable);
				world.setBlock(j, 4, i, Blocks.air);
			}

		for (int j = 0; j <  20; j++)
			for(int k = 0; k <  20; k++) {
				if(j == 9 && k == 10)
					continue;
				for(int i = 0; i < 10; i++) {
					int x = MathHelper.getRandomIntegerInRange(new Random(), 0+(j*100), 100+(j*100));
					int z = MathHelper.getRandomIntegerInRange(new Random(), 0+(k*100), 100+(k*100));
					if(world.getBlock(x, 3, z) == HMBlockRegistry.blockSable)
						world.setBlock(x, 3, z, HMBlockRegistry.blockSable, 1, 2);
					
					x = MathHelper.getRandomIntegerInRange(new Random(), 0+(j*100), 100+(j*100));
					z = MathHelper.getRandomIntegerInRange(new Random(), 0+(k*100), 100+(k*100));
					if(world.getBlock(x, 4, z) == Blocks.air)
						world.setBlock(x, 4, z, HMBlockRegistry.blockSable, 2, 2);
				}
			}
		for (int CA = 0; CA < 4; CA++) {
			int x = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			while(x == 9)
				x = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			int z = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			while(z == 10)
				z = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			
			world.spawnEntityInWorld(new EntityItem(world, x*100+ 50, 4, z*100 + 50, new ItemStack(HMItemRegistry.coffreDArchitecte)));
		}
		
		for (int CAS = 0; CAS < 2; CAS++) {
			int x = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			while(x == 9)
				x = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			int z = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			while(z == 10)
				z = MathHelper.getRandomIntegerInRange(new Random(), 0, 20);
			
			world.spawnEntityInWorld(new EntityItem(world, x*100+ 50, 4, z*100 + 50, new ItemStack(HMItemRegistry.coffreDArchitecteScelle)));
		}
	}
	
	private void generateDelimDesert(World world) {
		for(int i=1; i < 2000 ; i++) {
			if(i%100 == 0)
				for(int j=1; j < 2000 ; j++) {
					if(j%100 == 0) {
						world.setBlock(j, 4, i, HMBlockRegistry.blockAngles);
						world.setBlock(j, 4, i+1, HMBlockRegistry.blockAngles);
						world.setBlock(j+1, 4, i, HMBlockRegistry.blockAngles);
						world.setBlock(j+1, 4, i+1, HMBlockRegistry.blockAngles);
						world.setBlock(j, 5, i, HMBlockRegistry.blockAngles);
						world.setBlock(j, 5, i+1, HMBlockRegistry.blockAngles);
						world.setBlock(j+1, 5, i, HMBlockRegistry.blockAngles);
						world.setBlock(j+1, 5, i+1, HMBlockRegistry.blockAngles);
						j++;
					}
					else {
						world.setBlock(j, 4, i, HMBlockRegistry.blockAngles);
						world.setBlock(j, 4, i+1, HMBlockRegistry.blockAngles);
						world.setBlock(i, 4, j, HMBlockRegistry.blockAngles);
						world.setBlock(i+1, 4,j, HMBlockRegistry.blockAngles);
						
						world.setBlock(j, 5, i, HMBlockRegistry.blockToSouth);
						world.setBlock(j, 5, i+1, HMBlockRegistry.blockToNorth);
						world.setBlock(i, 5, j, HMBlockRegistry.blockToEast);
						world.setBlock(i+1, 5,j, HMBlockRegistry.blockToWest);
					}
				}
			}
			
			for(int i=1; i < 2001 ; i++) {
				world.setBlock(1, 4, i, HMBlockRegistry.blockAngles);
				world.setBlock(2000, 4, i, HMBlockRegistry.blockAngles);
				world.setBlock(i, 4, 1, HMBlockRegistry.blockAngles);
				world.setBlock(i, 4, 2000, HMBlockRegistry.blockAngles);
				world.setBlock(1, 5, i, HMBlockRegistry.blockAngles);
				world.setBlock(2000, 5, i, HMBlockRegistry.blockAngles);
				world.setBlock(i, 5, 1, HMBlockRegistry.blockAngles);
				world.setBlock(i, 5, 2000, HMBlockRegistry.blockAngles);
			}
	}
}
