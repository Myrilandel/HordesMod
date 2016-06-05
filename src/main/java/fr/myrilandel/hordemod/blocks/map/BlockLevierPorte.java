package fr.myrilandel.hordemod.blocks.map;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.buildings.portail.BuildPorte;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.ParamInit;
import fr.myrilandel.hordemod.utils.TileHelper;
import fr.myrilandel.hordemod.utils.TimeHelper;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;
import net.minecraft.block.BlockLever;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockLevierPorte extends BlockLever{

	public BlockLevierPorte(Material material) {
		super();
		this.setBlockName("BlockLevierPorte");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
		this.setBlockTextureName("lever");
	}
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer entityPlayer, int side, float dx, float dy, float dz) {
		if(!world.isRemote) {
			int i1 = world.getBlockMetadata(x, y, z);
            int j1 = i1 & 7;
            int k1 = 8 - (i1 & 8);
            
			TileEntity tile = TileHelper.getTileVille(world);
			if (tile instanceof TileEntityBlocksVille) {
				
				TileEntityBlocksVille tileEntityBlocksVille = (TileEntityBlocksVille) tile;
				ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(entityPlayer);
				boolean attaqueEnCours = TimeHelper.getRelativeTimeInHour(world) >= ParamInit.heureAttaque && TimeHelper.getRelativeTimeInHour(world) < ParamInit.heureNewDay ? true : false;
			
				if(!attaqueEnCours) {
					if (props.pertePA(10)) {
						tileEntityBlocksVille.switchPorteOuverte();
						String EtatPorte = tileEntityBlocksVille.porteOuverte ? "ouverte" : "fermée";
						entityPlayer.addChatComponentMessage(new ChatComponentText("La porte est "+EtatPorte+"."));
						TileHelper.updateTileVille(world);
						if(tileEntityBlocksVille.porteOuverte)
							BuildPorte.ouverte(world);
						else
							BuildPorte.fermee(world);
						
						world.setBlockMetadataWithNotify(x, y, z, j1 + k1, 3);
			            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, k1 > 0 ? 0.6F : 0.5F);
					}
				}
				else
					entityPlayer.addChatComponentMessage(new ChatComponentText("Le systeme semble etre bloqué ! Essayez plus tard..."));
			}
		}
		return false;
	}
}
