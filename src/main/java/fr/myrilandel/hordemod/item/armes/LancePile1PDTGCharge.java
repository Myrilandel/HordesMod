package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LancePile1PDTGCharge extends Item {

	public LancePile1PDTGCharge() {
		this.setUnlocalizedName("LancePile1PDTGCharge");
		this.setTextureName(HordeMod.MODID + ":lancePile1PDTGCharge");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote)
			world.spawnEntityInWorld(new EntityPile(world, entityPlayer));
	
 		return new ItemStack(HMItemRegistry.lancePile1PDTGVide);
	}
}
