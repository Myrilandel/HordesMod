package fr.myrilandel.hordemod.item.casses;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CutterCasse extends Item{

	public CutterCasse() {
		this.setUnlocalizedName("CutterCasse");
		this.setTextureName(HordeMod.MODID + ":cutterCasse");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.cassesCreativeTabs);
	}
}
