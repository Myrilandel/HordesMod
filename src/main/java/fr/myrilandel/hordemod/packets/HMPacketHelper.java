package fr.myrilandel.hordemod.packets;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;

public class HMPacketHelper {
	
	public static void sendPacket(TileEntityChantierMuraille tile, int id) {
		HordeMod.hordeModPacketHandlerChantierMuraille.sendToServer(new PacketChantierMuraille(tile,id));
	}
	
	public static void sendPacket(TileEntityChantierPompe tile, int id) {
		HordeMod.hordeModPacketHandlerChantierPompe.sendToServer(new PacketChantierPompe(tile,id));
	}
	
	public static void sendPacket(TileEntityChantierAtelier tile, int id) {
		HordeMod.hordeModPacketHandlerChantierAtelier.sendToServer(new PacketChantierAtelier(tile,id));
	}
	
	public static void sendPacket(TileEntityChantierTDG tile, int id) {
		HordeMod.hordeModPacketHandlerChantierTDG.sendToServer(new PacketChantierTDG(tile,id));
	}
	
	public static void sendPacket(TileEntityChantierFondations tile, int id) {
		HordeMod.hordeModPacketHandlerChantierFondations.sendToServer(new PacketChantierFondations(tile,id));
	}
	
	public static void sendPacket(TileEntityChantierPortail tile, int id) {
		HordeMod.hordeModPacketHandlerChantierPortail.sendToServer(new PacketChantierPortail(tile,id));
	}
	
	public static void sendPacket(TileEntityBanque tile, int id, int metadata) {
		HordeMod.hordeModPacketHandlerBanque.sendToServer(new PacketBanque(id, metadata));
	}
	
	public static void sendPacket(TileEntityBlocksVille tile, int id, int metadata) {
		HordeMod.hordeModPacketHandlerCentral.sendToServer(new PacketCentral(id, metadata));
	}
}
