package fr.myrilandel.hordemod.gui;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerChantierMuraille extends Container {

    private final TileEntityChantierMuraille tileEntityChantierMuraille;
    private final World world;
	public ContainerChantierMuraille(TileEntityChantierMuraille tileEntityChantierMuraille, World world) {
		this.tileEntityChantierMuraille = tileEntityChantierMuraille;
		this.world = world;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.tileEntityChantierMuraille.isUseableByPlayer(entityPlayer);
	}
	
	public TileEntityChantierMuraille getTileEntityChantier() {
		return tileEntityChantierMuraille;
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