package fr.myrilandel.hordemod.blocks.map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockToEast extends Block{

	private int newMotion = 0;

	public BlockToEast(Material material) {
		super(material);
		this.setBlockName("BlockToEast");
		this.setBlockTextureName(HordeMod.MODID + ":blockToEast");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
		ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(entityPlayer);
		if(!world.isRemote)
			return false;
		else
			if(side == 1)
				entityPlayer.addChatComponentMessage(new ChatComponentText("Cliquez sur le côté du bloc !"));	
			else 
				if(props.pertePA(10)) {
					entityPlayer.setPosition(x, y+3, z);
					entityPlayer.motionX = 2;
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous utilisez 10PA pour vous déplacer"));
				}
				else
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous n'avez pas assez de PA pour réaliser cette action !"));
		return false;
	}
}
