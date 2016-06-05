package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.utils.TileHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketChantierMuraille extends FFMTPacket {

	private int id;
	private TileEntityChantierMuraille tile;

    public PacketChantierMuraille()
    {}

    public PacketChantierMuraille(TileEntityChantierMuraille tile, int id) {
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
    }

    @Override
    public void handleServerSide(EntityPlayer player) {
    	tile = (TileEntityChantierMuraille) TileHelper.getTileChantierMuraille(player.worldObj);
    	
		switch (id) {
			case 1:if(tile.PAMuraille > 0){this.tile.decreasePAMuraille();sendNextPackets(player);}break;
			case 2:if(tile.PAGrandFosse > 0){this.tile.decreasePAGrandFosse();sendNextPackets(player);}break;
			case 3:if(tile.PADouves > 0){this.tile.decreasePADouves();sendNextPackets(player);}break;
			case 4:if(tile.PAMurailleRasoir > 0){this.tile.decreasePAMurailleRasoir();sendNextPackets(player);}break;
			case 5:if(tile.PAFosseAPieux > 0){this.tile.decreasePAFosseAPieux();sendNextPackets(player);}break;
			case 6:if(tile.PABarbeles > 0){this.tile.decreasePABarbeles();sendNextPackets(player);}break;
			case 7:if(tile.PAAppats > 0){this.tile.decreasePAAppats();sendNextPackets(player);}break;
			case 8:if(tile.PARempartsAvances > 0){this.tile.decreasePARempartsAvances();sendNextPackets(player);}break;
			case 9:if(tile.PAPoutresRenfort > 0){this.tile.decreasePAPoutresRenfort();sendNextPackets(player);}break;
			case 10:if(tile.PAMurailleAPointes > 0){this.tile.decreasePAMurailleAPointes();sendNextPackets(player);}break;
			case 11:if(tile.PAGrogroMur > 0){this.tile.decreasePAGrogroMur();sendNextPackets(player);}break;
			case 12:if(tile.PASecondeCouche > 0){this.tile.decreasePASecondeCouche();sendNextPackets(player);}break;
			case 13:if(tile.PATroisiemeCouche > 0){this.tile.decreasePATroisièmeCouche();sendNextPackets(player);}break;
			case 14:if(tile.PAMurailleEvolutive > 0){this.tile.decreasePAMurailleEvolutive();sendNextPackets(player);}break;
			case 15:if(tile.PABetonnade > 0){this.tile.decreasePABetonnade();sendNextPackets(player);}break;
			case 16:if(tile.PARapeAZombies > 0){this.tile.decreasePARapeAZombies();sendNextPackets(player);}break;
			case 17:if(tile.PAOubliettes > 0){this.tile.decreasePAOubliettes();sendNextPackets(player);}break;
			case 18:if(tile.PABarrieres > 0){this.tile.decreasePABarrieres();sendNextPackets(player);}break;
			case 19:if(tile.PAPalissade > 0){this.tile.decreasePAPalissade();sendNextPackets(player);}break;
			case 20:if(tile.PAMurSavone > 0){this.tile.decreasePAMurSavone();sendNextPackets(player);}break;
			case 21:if(tile.PAPulverisateur > 0){this.tile.decreasePAPulverisateur();sendNextPackets(player);}break;
			case 22:if(tile.PAProjectionAcide > 0){this.tile.decreasePAProjectionAcide();sendNextPackets(player);}break;
			case 23:if(tile.PANeurotoxine > 0){this.tile.decreasePANeurotoxine();sendNextPackets(player);}break;
			case 24:if(tile.PACloisonEnBois > 0){this.tile.decreasePACloisonEnBois();sendNextPackets(player);}break;
			case 25:if(tile.PACloisonMetallique > 0){this.tile.decreasePACloisonMetallique();sendNextPackets(player);}break;
			case 26:if(tile.PACloisonEpaisse > 0){this.tile.decreasePACloisonEpaisse();sendNextPackets(player);}break;
			case 27:if(tile.PAContrePlaque > 0){this.tile.decreasePAContrePlaque();sendNextPackets(player);}break;
			case 28:if(tile.PABastion > 0){this.tile.decreasePABastion();sendNextPackets(player);}break;
			default:break;
		}
		this.tile.updateTileEntity();
    }
    
    private void sendNextPackets(EntityPlayer player) {
    	TileEntityBanque tileEntityBanque = (TileEntityBanque) TileHelper.getTileBanque(player.worldObj);
		TileEntityBlocksVille TEVille = (TileEntityBlocksVille) TileHelper.getTileVille(player.worldObj);
		HMPacketHelper.sendPacket(tileEntityBanque,id,0);
		HMPacketHelper.sendPacket(TEVille, id,0);
    }
    @Override
    public int getDiscriminator() {
        return 5;
    }
}