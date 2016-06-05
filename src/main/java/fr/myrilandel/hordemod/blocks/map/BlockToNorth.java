package fr.myrilandel.hordemod.blocks.map;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockToNorth extends Block{

	private boolean movement = false;
	
	public BlockToNorth(Material material) {
		super(material);
		this.setBlockName("BlockToNorth");
		this.setBlockTextureName(HordeMod.MODID + ":blockToNorth");
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
					entityPlayer.motionZ = -2;
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous utilisez 10PA pour vous déplacer"));
				}
				else
					entityPlayer.addChatComponentMessage(new ChatComponentText("Vous n'avez pas assez de PA pour réaliser cette action !"));
		return false;
	}

}
