package fr.myrilandel.hordemod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.zombies.ZombieNuitEnVille;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

public class BlockTest extends Block{

	public BlockTest(Material material) {
		super(material);
		this.setBlockName("BlockTest");
		this.setBlockTextureName(HordeMod.MODID + ":blockTest");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int metadata) {
		
		dropBlockAsItem(world, x, y, z, new ItemStack(HMItemRegistry.doggyBag));
	}
	    
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(entity instanceof ZombieNuitEnVille) {
			double rand = Math.random();
			world.createExplosion(null, x, y, z, 2F, false);
			((ZombieNuitEnVille) entity).setHealth(0);
			if(rand > 0.95) {
				TileEntity tile = world.getTileEntity(980, 4, 1018);
				if (tile instanceof TileEntityBlocksVille && !((TileEntityBlocksVille) tile).porteOuverte) {
					((TileEntityBlocksVille) tile).switchPorteOuverte();
					world.markBlockForUpdate(980, 4, 1018);
					world.setBlock(x, y, z, Blocks.air);
				}
			}
		}
    }
	
	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}
	
}
