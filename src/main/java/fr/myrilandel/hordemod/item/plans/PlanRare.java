package fr.myrilandel.hordemod.item.plans;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PlanRare extends Item{

	public PlanRare() {
		this.setUnlocalizedName("PlanRare");
		this.setTextureName(HordeMod.MODID + ":planRare");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			TileEntityBlocksVille tile = (TileEntityBlocksVille) TileHelper.getTileVille(world);
			if(tile.allUnlocked(tile.tabRareIsUnlocked))
				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez déjà débloqué tous les batiments de cette catégorie !"));
			else {
				int unlocked = tile.unlockNewChantier(this);
				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous avez débloqué le chantier "+ChantiersRegistry.nomChantierRare[unlocked]+" !"));
			}
			itemStack.stackSize--;
		}	
		return itemStack;
	}
}
