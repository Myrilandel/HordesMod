package fr.myrilandel.hordemod.item.casses;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CleAMoletteCassee extends Item{

	public CleAMoletteCassee() {
		this.setUnlocalizedName("CleAMoletteCassee");
		this.setTextureName(HordeMod.MODID + ":cleAMoletteCassee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.cassesCreativeTabs);
	}
}
