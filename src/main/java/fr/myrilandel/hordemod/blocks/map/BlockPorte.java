package fr.myrilandel.hordemod.blocks.map;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.buildings.portail.BuildPorte;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPorte extends Block {
	
	public static String[] subBlock = new String[] {"blockPorte_1", "blockPorte_2"};
	public IIcon[] iconArray = new IIcon[subBlock.length];
	
	public BlockPorte(Material material) {
		super(material);
		this.setBlockName("BlockPorte");
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
	
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(world.getBlockMetadata(x, y, z) == 2)
			if(entity instanceof ZombieNuitEnVille) {
				double rand = Math.random();
				world.createExplosion(null, x, y, z, 2F, false);
				((ZombieNuitEnVille) entity).setHealth(0);
				if(rand > 0.95) {
					TileEntity tile = TileHelper.getTileVille(world);
					if (tile instanceof TileEntityBlocksVille && !((TileEntityBlocksVille) tile).porteOuverte) {
						((TileEntityBlocksVille) tile).switchPorteOuverte();
						TileHelper.updateTileVille(world);
						BuildPorte.ouverte(world);
					}
				}
			}
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1)), (double)((float)(p_149668_3_ + 1)), (double)((float)(p_149668_4_ + 1)));
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149633_2_), (double)p_149633_3_, (double)((float)p_149633_4_ + f), (double)((float)(p_149633_2_ + 1)), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1)));
    }
	
	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}
	
}
