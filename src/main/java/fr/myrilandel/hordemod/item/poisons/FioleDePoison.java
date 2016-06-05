package fr.myrilandel.hordemod.item.poisons;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class FioleDePoison extends Item{

	public FioleDePoison() {
		this.setUnlocalizedName("FioleDePoison");
		this.setTextureName(HordeMod.MODID + ":fioleDePoison");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
