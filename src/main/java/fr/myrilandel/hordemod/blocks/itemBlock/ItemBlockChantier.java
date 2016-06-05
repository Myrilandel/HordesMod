package fr.myrilandel.hordemod.blocks.itemBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.blocks.map.BlockChantier;
import fr.myrilandel.hordemod.blocks.map.BlockPorte;
import fr.myrilandel.hordemod.blocks.map.BlockSable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockChantier extends ItemBlock {
	
	public ItemBlockChantier(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int metadata) {
		return this.field_150939_a.getIcon(2, metadata);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata >= BlockChantier.subBlock.length)
			metadata = 0;
		
		return super.getUnlocalizedName() + "." + BlockChantier.subBlock[metadata];
	}
}