package fr.myrilandel.hordemod.blocks.map;

import java.util.Random;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.buildings.pompe.BuildPuit;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockBoutonPuit extends BlockButtonWood{

	private static final boolean field_150047_a = false;

	public BlockBoutonPuit(Material material) {
		super();
		this.setBlockName("BlockBoutonPuit");
		this.setBlockTextureName("wooden_button");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer entityPlayer, int side, float dx, float dy, float dz) {

		int i1 = world.getBlockMetadata(x, y, z);
        int j1 = i1 & 7;
        int k1 = 8 - (i1 & 8);

        if (k1 == 0)
        {
            return true;
        }
        else
        {
            world.setBlockMetadataWithNotify(x, y, z, j1 + k1, 3);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
            world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
        }
		
		if(!world.isRemote) {
			TileEntity tile = TileHelper.getTileVille(world);
			if (tile instanceof TileEntityBlocksVille) {
				
				TileEntityBlocksVille tileEntityBlocksVille = (TileEntityBlocksVille) tile;
				ExtendedEntityPropJourna props = ExtendedEntityPropJourna.get(entityPlayer);
				
				if (tileEntityBlocksVille.ration > 0) 
					if (!props.aRecuRationDEau) {
						entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.rationDEau));
						entityPlayer.addChatComponentMessage(new ChatComponentText("Vous recevez une ration d'eau."));
						tileEntityBlocksVille.decreaseRation();
						props.switchARecuRationDEau(true);
						TileHelper.updateTileVille(world);
						BuildPuit.buildSceauHaut(world);
					}
					else
						entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez déjà reçu votre ration aujourd'hui."));
				else
					entityPlayer.addChatComponentMessage(new ChatComponentText("Il n'y a plus d'eau dans le puit !"));
				entityPlayer.addChatComponentMessage(new ChatComponentText("Il reste "+tileEntityBlocksVille.ration+" rations dans le puit"));
			}
			entityPlayer.inventoryContainer.detectAndSendChanges();
		}
		return false;
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            int l = world.getBlockMetadata(x, y, z);
            if ((l & 8) != 0)
            {
                if (this.field_150047_a)
                {
                }
                else
                {
					BuildPuit.buildNiveauEau(world);
                    world.setBlockMetadataWithNotify(x, y, z, l & 7, 3);
                    int i1 = l & 7;
                    world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, 0.5F);
                    world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
                }
            }
        }
    }
}
