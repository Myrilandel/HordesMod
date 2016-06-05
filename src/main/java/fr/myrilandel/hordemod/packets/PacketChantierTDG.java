package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketChantierTDG extends FFMTPacket {

	private int id;
	private TileEntityChantierTDG tile;

    public PacketChantierTDG()
    {}

    public PacketChantierTDG(TileEntityChantierTDG tile, int id) {
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
    	System.out.println(id);
		switch (id) {
			case 1:this.tile.decreasePAMuraille();break;
			default:break;
		}
		this.tile.updateTileEntity();
    }
    
    @Override
    public int getDiscriminator() {
        return 8;
    }
}