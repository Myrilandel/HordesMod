package fr.myrilandel.hordemod.blocks.map;

import java.util.Random;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMBlockRegistry;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockAngles extends Block{

	public BlockAngles(Material material) {
		super(material);
		this.setBlockName("BlockAngles");
		this.setBlockTextureName("obsidian");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockUnbreakable();
	}
}
