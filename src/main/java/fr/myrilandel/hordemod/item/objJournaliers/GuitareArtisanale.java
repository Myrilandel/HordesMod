package fr.myrilandel.hordemod.item.objJournaliers;

import java.util.List;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.PosHelper;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class GuitareArtisanale extends Item {
	public IIcon[] icons = new IIcon[2];

	public GuitareArtisanale() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName("GuitareArtisanale");
		this.setTextureName(HordeMod.MODID + ":guitareArtisanale");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		ExtendedEntityPropJourna entityPropJourna = ExtendedEntityPropJourna.get(entityPlayer);		
		if(!world.isRemote) {
			if(!PosHelper.isEnVille(entityPlayer.posX, entityPlayer.posZ)) {
				entityPlayer.addChatComponentMessage(new ChatComponentText("Vous devriez plutot faire ça en ville..."));
				return itemStack;
			}

			if(!entityPropJourna.aJoueGuitareArtisanale) {
				entityPlayer.addChatComponentMessage(new ChatComponentText("Quel doux son mélodieux !"));
				List listePlayers = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
				for(int i=0; i<listePlayers.size(); i++) {
					EntityPlayer receiver =  (EntityPlayer) listePlayers.get(i);
					ExtendedEntityPropJourna propsReceiver = ExtendedEntityPropJourna.get(receiver);
					if(PosHelper.isEnVille(receiver.posX, receiver.posZ))
						ExtendedEntityPropEtats.get(receiver).gainPA(SourcesDePA.guitareArtisanale);
					
					propsReceiver.switchAJoueGuitareArtisanale(true);
				}
			}
			else				
				entityPlayer.addChatComponentMessage(new ChatComponentText("Pas plus d'un concert par jour !"));
		}
		return itemStack;
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(getDamage(itemStack) == 0)
			return;
		if(getDamage(itemStack) == 1)
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(HMItemRegistry.kitDeBricolageAbime));
		entityPlayer.inventoryContainer.detectAndSendChanges();
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < icons.length; i ++) {
	        this.icons[i] = reg.registerIcon(HordeMod.MODID + ":guitareArtisanale");
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > icons.length-1)
	        meta = 0;
	    return this.icons[meta];
	}
}
