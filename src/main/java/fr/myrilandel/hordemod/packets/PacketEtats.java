package fr.myrilandel.hordemod.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;

public class PacketEtats extends FFMTPacket {

	private int PA, PAMax;
	
	private boolean blesse, clair, convalescent, dependant, desaltere, drogue, fatigue;
	private boolean gueuleDeBois, infection, ivre, rassasie, soif, terreur;

	public PacketEtats(){}
	public PacketEtats(int PA, int PAMax,
			boolean blesse, boolean clair, boolean convalescent,
			boolean dependant, boolean desaltere, boolean drogue,
			boolean fatigue, boolean gueuleDeBois, boolean infection, boolean ivre, 
			boolean rassasie, boolean soif, boolean terreur){
		
		this.PA = PA; 
		this.PAMax = PAMax;
		
		this.blesse = blesse; this.clair = clair; 
		this.convalescent = convalescent; this.dependant = dependant; 
		this.desaltere = desaltere; this.drogue = drogue; 
		this.fatigue = fatigue;	this.gueuleDeBois = gueuleDeBois; 
		this.infection = infection; this.ivre = ivre; 
		this.rassasie = rassasie; this.soif = soif; 
		this.terreur = terreur;
	}
	
	@Override
	public void writeData(ByteBuf buffer) throws IOException {
		buffer.writeInt(PA); buffer.writeInt(PAMax);
		
		buffer.writeBoolean(blesse); buffer.writeBoolean(clair); 
		buffer.writeBoolean(convalescent); buffer.writeBoolean(dependant);
		buffer.writeBoolean(desaltere); buffer.writeBoolean(drogue); 
		buffer.writeBoolean(fatigue);  buffer.writeBoolean(gueuleDeBois);
		buffer.writeBoolean(infection);	buffer.writeBoolean(ivre);
		buffer.writeBoolean(rassasie); buffer.writeBoolean(soif);
		buffer.writeBoolean(terreur);
	}
	
	@Override
	public void readData(ByteBuf buffer) {
		this.PA = buffer.readInt();	this.PAMax = buffer.readInt();
		
		this.blesse = buffer.readBoolean(); this.clair = buffer.readBoolean();
		this.convalescent = buffer.readBoolean(); this.dependant = buffer.readBoolean(); 
		this.desaltere = buffer.readBoolean(); this.drogue = buffer.readBoolean(); 
		this.fatigue = buffer.readBoolean(); this.gueuleDeBois = buffer.readBoolean(); 
		this.infection = buffer.readBoolean(); this.ivre = buffer.readBoolean(); 
		this.rassasie = buffer.readBoolean(); this.soif = buffer.readBoolean(); 
		this.terreur = buffer.readBoolean();
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
		ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(player);
		props.PA = this.PA;	props.PAMax = this.PAMax;
		
		props.blesse = this.blesse; props.clair = this.clair;
		props.convalescent = this.convalescent; props.dependant = this.dependant; 
		props.desaltere = this.desaltere; props.drogue = this.drogue;
		props.fatigue = this.fatigue; props.gueuleDeBois = this.gueuleDeBois;
		props.infection = this.infection; props.ivre = this.ivre; 
		props.rassasie = this.rassasie; props.soif = this.soif; 
		props.terreur = this.terreur;
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {
		ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get(player);
		props.PA = this.PA;	props.PAMax = this.PAMax;
		
		props.blesse = this.blesse; props.clair = this.clair;
		props.convalescent = this.convalescent; props.dependant = this.dependant; 
		props.desaltere = this.desaltere; props.drogue = this.drogue;
		props.fatigue = this.fatigue; props.gueuleDeBois = this.gueuleDeBois; 
		props.infection = this.infection; props.ivre = this.ivre;
		props.rassasie = this.rassasie; props.soif = this.soif; 
		props.terreur = this.terreur;
	}
	
	@Override
	public int getDiscriminator() {
		return 0;
	}
}