package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierFondations extends Container {

    private final TileEntityChantierFondations tileEntityChantierFondations;
    private final World world;
	public ContainerChantierFondations(TileEntityChantierFondations tileEntityChantierFondations, World world) {
		this.tileEntityChantierFondations = tileEntityChantierFondations;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.tileEntityChantierFondations.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierFondations getTileEntityChantier() {
		return tileEntityChantierFondations;
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