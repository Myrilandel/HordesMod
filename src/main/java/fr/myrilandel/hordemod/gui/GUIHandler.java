package fr.myrilandel.hordemod.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import fr.myrilandel.hordemod.utils.TileHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBanque)
            return new ContainerBanque((TileEntityBanque)tile, player.inventory);
        
        if(tile instanceof TileEntityChantierMuraille)
        	return new ContainerChantierMuraille((TileEntityChantierMuraille) tile, world);
        if(tile instanceof TileEntityChantierPompe)
        	return new ContainerChantierPompe((TileEntityChantierPompe) tile, world);
        if(tile instanceof TileEntityChantierAtelier)
        	return new ContainerChantierAtelier((TileEntityChantierAtelier) tile, world);
        if(tile instanceof TileEntityChantierTDG)
        	return new ContainerChantierTDG((TileEntityChantierTDG) tile, world);
        if(tile instanceof TileEntityChantierFondations)
        	return new ContainerChantierFondations((TileEntityChantierFondations) tile, world);
        if(tile instanceof TileEntityChantierPortail)
        	return new ContainerChantierPortail((TileEntityChantierPortail) tile, world);
        
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		TileEntityBanque tileEntityBanque = (TileEntityBanque)TileHelper.getTileBanque(world);
		TileEntityBlocksVille tileEntityCentral = (TileEntityBlocksVille)TileHelper.getTileVille(world);
		
		if(tile instanceof TileEntityBanque)
			return new GUIBanque((TileEntityBanque)tile, player.inventory);
		
		if(tile instanceof TileEntityChantierMuraille)
			return new GUIChantierMuraille(world, (TileEntityChantierMuraille)tile,tileEntityBanque,tileEntityCentral, player);
		if(tile instanceof TileEntityChantierPompe)
			return new GUIChantierPompe(world, (TileEntityChantierPompe)tile,tileEntityBanque,tileEntityCentral, player);
		if(tile instanceof TileEntityChantierAtelier)
			return new GUIChantierAtelier(world, (TileEntityChantierAtelier)tile,tileEntityBanque,tileEntityCentral, player);
		if(tile instanceof TileEntityChantierTDG)
			return new GUIChantierTDG(world, (TileEntityChantierTDG)tile,tileEntityBanque,tileEntityCentral, player);
		if(tile instanceof TileEntityChantierFondations)
			return new GUIChantierFondations(world, (TileEntityChantierFondations)tile,tileEntityBanque,tileEntityCentral, player);
		if(tile instanceof TileEntityChantierPortail)
			return new GUIChantierPortail(world, (TileEntityChantierPortail)tile,tileEntityBanque,tileEntityCentral, player);
		
		return null;
	}
	
}