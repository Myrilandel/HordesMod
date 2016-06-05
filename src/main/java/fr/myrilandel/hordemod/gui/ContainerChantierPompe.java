package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierPompe extends Container {

    private final TileEntityChantierPompe TileEntityChantierPompe;
    private final World world;
	public ContainerChantierPompe(TileEntityChantierPompe TileEntityChantierPompe, World world) {
		this.TileEntityChantierPompe = TileEntityChantierPompe;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.TileEntityChantierPompe.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierPompe getTileEntityChantier() {
		return TileEntityChantierPompe;
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