package fr.myrilandel.hordemod.blocks.map;

import java.util.List;
import java.util.Random;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockChantier extends Block {

	public static String[] subBlock = new String[] {
			"blockChantier_Muraille",
			"blockChantier_Pompe",
			"blockChantier_Atelier",
			"blockChantier_TDG",
			"blockChantier_Fondations",
			"BlockChantier_Portail"};
	public IIcon[] iconArray = new IIcon[subBlock.length];
	
	public BlockChantier(Material material) {
		super(material);
		this.setBlockName("BlockChantier");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
	      
	public void registerBlockIcons(IIconRegister iconRegister) {
		for(int i = 0; i < subBlock.length; i++)
			this.iconArray[ i] = iconRegister.registerIcon(HordeMod.MODID + ":" + subBlock[i]);
	}
	
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for(int i = 0; i < subBlock.length; i++)
			list.add(new ItemStack(item, 1, i));
	}
	
	public IIcon getIcon(int side, int metadata) {
		return metadata >= 0 && metadata < subBlock.length ? this.iconArray[metadata] : this.iconArray[0];
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
    	if(metadata == 0)
    		return new TileEntityChantierMuraille();
    	if(metadata == 1)
    		return new TileEntityChantierPompe();
    	if(metadata == 2)
    		return new TileEntityChantierAtelier();
    	if(metadata == 3)
    		return new TileEntityChantierTDG();
    	if(metadata == 4)
    		return new TileEntityChantierFondations();
    	if(metadata == 5)
    		return new TileEntityChantierPortail();
    	return new TileEntityChantierMuraille();
    }
	    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer entityPlayer, int metadata, float hitX, float hitY, float hitZ) {
		
		if(world.isRemote) 
			entityPlayer.openGui(HordeMod.instance, 0, world, x, y, z); 
		
		return true;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}
	
	@Override
	public int tickRate(World world) {
		return 1;
	}
}
