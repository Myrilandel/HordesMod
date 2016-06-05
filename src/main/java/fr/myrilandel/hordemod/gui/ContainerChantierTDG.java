package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierTDG extends Container {

    private final TileEntityChantierTDG tileEntityChantierTDG;
    private final World world;
	public ContainerChantierTDG(TileEntityChantierTDG tileEntityChantierTDG, World world) {
		this.tileEntityChantierTDG = tileEntityChantierTDG;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.tileEntityChantierTDG.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierTDG getTileEntityChantier() {
		return tileEntityChantierTDG;
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