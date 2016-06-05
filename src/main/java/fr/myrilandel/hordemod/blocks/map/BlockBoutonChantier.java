package fr.myrilandel.hordemod.blocks.map;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.ParamInit;
import net.minecraft.block.BlockButton;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockBoutonChantier extends BlockButton{

	public BlockBoutonChantier(Material material) {
		super(false);
		this.setBlockName("BlockBoutonChantier");
		this.setBlockTextureName(HordeMod.MODID + ":blockBoutonChantier");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer entityPlayer, int side, float dx, float dy, float dz) {

		if(!world.isRemote) {
				ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(entityPlayer);
			
				if (props.pertePA(ParamInit.converterPointChantier)) {
					entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.pointDAtelier));
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous recevez un point de Chantier."));
				}
		}
		return false;
	}
}
