package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierPortail extends Container {

    private final TileEntityChantierPortail tileEntityChantierPortail;
    private final World world;
	public ContainerChantierPortail(TileEntityChantierPortail tileEntityChantierPortail, World world) {
		this.tileEntityChantierPortail = tileEntityChantierPortail;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.tileEntityChantierPortail.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierPortail getTileEntityChantier() {
		return tileEntityChantierPortail;
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