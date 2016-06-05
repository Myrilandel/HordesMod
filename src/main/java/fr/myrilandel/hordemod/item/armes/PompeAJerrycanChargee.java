package fr.myrilandel.hordemod.item.armes;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.entities.EntityEauBullet;
import fr.myrilandel.hordemod.entities.EntityPile;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PompeAJerrycanChargee extends Item {

	public PompeAJerrycanChargee() {
		this.setUnlocalizedName("PompeAJerrycanChargee");
		this.setTextureName(HordeMod.MODID + ":pompeAJerrycanChargee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.armesCreativeTabs);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityEauBullet(world, entityPlayer));
			if(Math.random() < 0.15)
				return new ItemStack(HMItemRegistry.pompeAJerrycanVide);
			else
				return itemStack;
		}
		return itemStack;
	}
}
