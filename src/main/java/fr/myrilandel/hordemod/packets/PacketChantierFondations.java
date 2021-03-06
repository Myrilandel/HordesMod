package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketChantierFondations extends FFMTPacket {

	private int id;
	private TileEntityChantierFondations tile;

    public PacketChantierFondations()
    {}

    public PacketChantierFondations(TileEntityChantierFondations tile, int id) {
    	this.id = id;
    	this.tile = tile;
    }

    @Override
    public void writeData(ByteBuf buffer) throws IOException {
        buffer.writeInt(this.id);
    }

    @Override
    public void readData(ByteBuf buffer) {
        this.id = buffer.readInt();
    }

    @Override
    public void handleClientSide(EntityPlayer player) {
		this.tile.updateTileEntity();
    }

    @Override
    public void handleServerSide(EntityPlayer player) {
		switch (id) {
			case 1:this.tile.decreasePAMuraille();break;
			default:break;
		}
		this.tile.updateTileEntity();
    }
    
    @Override
    public int getDiscriminator() {
        return 9;
    }
}