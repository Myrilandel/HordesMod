package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierAtelier extends Container {

    private final TileEntityChantierAtelier tileEntityChantierAtelier;
    private final World world;
	public ContainerChantierAtelier(TileEntityChantierAtelier tileEntityChantierAtelier, World world) {
		this.tileEntityChantierAtelier = tileEntityChantierAtelier;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.tileEntityChantierAtelier.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierAtelier getTileEntityChantier() {
		return tileEntityChantierAtelier;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer entityPlayer) {
		super.onContainerClosed(entityPlayer);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
	}
}