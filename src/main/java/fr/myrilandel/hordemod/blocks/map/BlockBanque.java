package fr.myrilandel.hordemod.blocks.map;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBanque extends Block{

	public BlockBanque(Material material) {
		super(material);
		this.setBlockName("BlockBanque");
		this.setBlockTextureName(HordeMod.MODID + ":blockBanque");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
	   
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityBanque(); 
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
		
		if(!world.isRemote)
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
