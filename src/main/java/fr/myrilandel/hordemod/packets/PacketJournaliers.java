package fr.myrilandel.hordemod.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.events.ExtendedEntityPropJourna;

public class PacketJournaliers extends FFMTPacket {

	
	private boolean aJoueDes, aJoueGuitareArtisanale, aJoueJeuDeCartes;
	private boolean aUtiliseTeddyNOurs;

	private boolean aRecuRationDEau, aRecuStarterPack;
	
	public PacketJournaliers(){}
	public PacketJournaliers(boolean aJoueDes, boolean aJoueGuitareArtisanale, boolean aJoueJeuDeCartes,
			boolean aUtiliseTeddyNOurs,
			boolean aRecuRationDEau, boolean aRecuStarterPack){
		
		this.aJoueDes = aJoueDes; 
		this.aJoueGuitareArtisanale = aJoueGuitareArtisanale; 
		this.aJoueJeuDeCartes = aJoueJeuDeCartes; 
		this.aUtiliseTeddyNOurs = aUtiliseTeddyNOurs;
		
		this.aRecuRationDEau = aRecuRationDEau;
		this.aRecuStarterPack = aRecuStarterPack;
	}
	
	@Override
	public void writeData(ByteBuf buffer) throws IOException {
		buffer.writeBoolean(aJoueDes); 
		buffer.writeBoolean(aJoueGuitareArtisanale);
		buffer.writeBoolean(aJoueJeuDeCartes);
		buffer.writeBoolean(aUtiliseTeddyNOurs);
		
		buffer.writeBoolean(aRecuRationDEau);
		buffer.writeBoolean(aRecuStarterPack);
	}
	
	@Override
	public void readData(ByteBuf buffer) {
		this.aJoueDes = buffer.readBoolean();
		this.aJoueGuitareArtisanale = buffer.readBoolean(); 
		this.aJoueJeuDeCartes = buffer.readBoolean();
		this.aUtiliseTeddyNOurs = buffer.readBoolean();
		
		this.aRecuRationDEau = buffer.readBoolean();
		this.aRecuStarterPack = buffer.readBoolean();
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
		ExtendedEntityPropJourna props = ExtendedEntityPropJourna.get(player);
		props.aJoueDes = this.aJoueDes;
		props.aJoueGuitareArtisanale = this.aJoueGuitareArtisanale; 
		props.aJoueJeuDeCartes = this.aJoueJeuDeCartes;
		props.aUtiliseTeddyNOurs = this.aUtiliseTeddyNOurs;
		
		props.aRecuRationDEau = this.aRecuRationDEau;
		props.aRecuStarterPack = this.aRecuStarterPack;
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {
		ExtendedEntityPropJourna props = ExtendedEntityPropJourna.get(player);
		
		props.aJoueDes = this.aJoueDes;
		props.aJoueGuitareArtisanale = this.aJoueGuitareArtisanale; 
		props.aJoueJeuDeCartes = this.aJoueJeuDeCartes;
		props.aUtiliseTeddyNOurs = this.aUtiliseTeddyNOurs;
		
		props.aRecuRationDEau = this.aRecuRationDEau;
		props.aRecuStarterPack = this.aRecuStarterPack;
	}
	
	@Override
	public int getDiscriminator() {
		return 1;
	}
}