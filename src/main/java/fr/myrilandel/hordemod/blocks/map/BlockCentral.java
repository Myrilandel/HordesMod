package fr.myrilandel.hordemod.blocks.map;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockCentral extends Block {

	public BlockCentral(Material material) {
		super(material);
		this.setBlockName("BlockCentral");
		this.setBlockTextureName("diamond_block");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityBlocksVille(); 
    }
    
    @Override
    public void onBlockClicked(World world, int x, int y, int z,
    		EntityPlayer entityPlayer) {
    	entityPlayer.addChatComponentMessage(new ChatComponentText(x+", "+y+", "+z));
    }
    
	@Override
	public int tickRate(World world) {
		return 1;
	}
}
