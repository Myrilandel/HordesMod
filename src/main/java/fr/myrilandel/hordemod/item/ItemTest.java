package fr.myrilandel.hordemod.item;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemTest extends ItemSword {

	public ItemTest() {
		super(ToolMaterial.IRON);
		this.setUnlocalizedName("ItemTest");
		this.setTextureName(HordeMod.MODID + ":pile");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			TileEntityChantierMuraille tile = (TileEntityChantierMuraille)TileHelper.getTileChantierMuraille(world);
			System.out.println(tile);
			tile.PAMuraille -=10;
			itemStack.stackSize--;
		}
		return itemStack;
	}	
}
