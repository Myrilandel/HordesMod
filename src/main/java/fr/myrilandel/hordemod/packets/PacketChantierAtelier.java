package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.utils.TileHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketChantierAtelier extends FFMTPacket {

	private int id;
	private TileEntityChantierAtelier tile;

    public PacketChantierAtelier()
    {}

    public PacketChantierAtelier(TileEntityChantierAtelier tile, int id) {
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
    	tile = (TileEntityChantierAtelier) TileHelper.getTileChantierAtelier(player.worldObj);
    	
		switch (id) {
			case 1:if(tile.PAAtelier > 0){this.tile.decreasePAAtelier();sendNextPackets(player);}break;
			case 2:if(tile.PABoucherie > 0){this.tile.decreasePABoucherie();sendNextPackets(player);}break;
			case 3:if(tile.PACrematoCue > 0){this.tile.decreasePACrematoCue();sendNextPackets(player);}break;
			case 4:if(tile.PAFixationsDefenses > 0){this.tile.decreasePAFixationsDefenses();sendNextPackets(player);}break;
			case 5:if(tile.PAMonticulesCanons > 0){this.tile.decreasePAMonticulesCanons();sendNextPackets(player);}break;
			case 6:if(tile.PACanonABriques > 0){this.tile.decreasePACanonABriques();sendNextPackets(player);}break;
			case 7:if(tile.PAPerforeuse > 0){this.tile.decreasePAPerforeuse();sendNextPackets(player);}break;
			case 8:if(tile.PALanceGrenailles > 0){this.tile.decreasePALanceGrenailles();sendNextPackets(player);}break;
			case 9:if(tile.PACanonBrutal > 0){this.tile.decreasePACanonBrutal();sendNextPackets(player);}break;
			case 10:if(tile.PATourniquet > 0){this.tile.decreasePATourniquet();sendNextPackets(player);}break;
			case 11:if(tile.PAManufacture > 0){this.tile.decreasePAManufacture();sendNextPackets(player);}break;
			case 12:if(tile.PASciesHurlantes > 0){this.tile.decreasePASciesHurlantes();sendNextPackets(player);}break;
			case 13:if(tile.PARegistreChantier > 0){this.tile.decreasePARegistreChantier();sendNextPackets(player);}break;
			case 14:if(tile.PAArchitectoire > 0){this.tile.decreasePAArchitectoire();sendNextPackets(player);}break;
			case 15:if(tile.PAPotence > 0){this.tile.decreasePAPotence();sendNextPackets(player);}break;
			case 16:if(tile.PAAbattoir > 0){this.tile.decreasePAAbattoir();sendNextPackets(player);}break;
			case 17:if(tile.PASupportsDefensifs > 0){this.tile.decreasePASupportsDefensifs();sendNextPackets(player);}break;
			case 18:if(tile.PACantineABois > 0){this.tile.decreasePACantineABois();sendNextPackets(player);}break;
			case 19:if(tile.PACimetiereCadenasse > 0){this.tile.decreasePACimetiereCadenasse();sendNextPackets(player);}break;
			case 20:if(tile.PACercueilsSurRessort > 0){this.tile.decreasePACercueilsSurRessort();sendNextPackets(player);}break;
			case 21:if(tile.PACantineCentrale > 0){this.tile.decreasePACantineCentrale();sendNextPackets(player);}break;
			case 22:if(tile.PALaboratoireCentral > 0){this.tile.decreasePALaboratoireCentral();sendNextPackets(player);}break;
			case 23:if(tile.PAPoulailler > 0){this.tile.decreasePAPoulailler();sendNextPackets(player);}break;
			case 24:if(tile.PAInfirmerie > 0){this.tile.decreasePAInfirmerie();sendNextPackets(player);}break;
			case 25:if(tile.PAStrategiesCitoyennes > 0){this.tile.decreasePAStrategiesCitoyennes();sendNextPackets(player);}break;
			case 26:if(tile.PAQuartiersCirculaires > 0){this.tile.decreasePAQuartiersCirculaires();sendNextPackets(player);}break;
			default:break;
		}
		this.tile.updateTileEntity();

    }
    
    private void sendNextPackets(EntityPlayer player) {
    	TileEntityBanque tileEntityBanque = (TileEntityBanque) TileHelper.getTileBanque(player.worldObj);
		TileEntityBlocksVille TEVille = (TileEntityBlocksVille) TileHelper.getTileVille(player.worldObj);
		HMPacketHelper.sendPacket(tileEntityBanque,id,2);
		HMPacketHelper.sendPacket(TEVille, id,2);
    }
    
    @Override
    public int getDiscriminator() {
        return 7;
    }
}