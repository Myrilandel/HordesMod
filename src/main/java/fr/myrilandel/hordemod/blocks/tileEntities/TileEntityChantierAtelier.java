package fr.myrilandel.hordemod.blocks.tileEntities;

import fr.myrilandel.hordemod.buildings.muraille.BuildMuraille;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.RecetteChantier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChantierAtelier extends TileEntity {
	
	public int PAAtelier = ChantiersRegistry.recetteAtelier[ChantiersRegistry.recetteAtelier.length-1];
	public int PABoucherie = ChantiersRegistry.recetteBoucherie[ChantiersRegistry.recetteBoucherie.length-1];
	public int PACrematoCue = ChantiersRegistry.recetteCrematoCue[ChantiersRegistry.recetteCrematoCue.length-1];
	public int PAFixationsDefenses = ChantiersRegistry.recetteFixationsDefenses[ChantiersRegistry.recetteFixationsDefenses.length-1];
	public int PAMonticulesCanons = ChantiersRegistry.recetteMonticulesCanons[ChantiersRegistry.recetteMonticulesCanons.length-1];
	public int PACanonABriques = ChantiersRegistry.recetteCanonABriques[ChantiersRegistry.recetteCanonABriques.length-1];
	public int PAPerforeuse = ChantiersRegistry.recettePerforeuse[ChantiersRegistry.recettePerforeuse.length-1];
	public int PALanceGrenailles = ChantiersRegistry.recetteLanceGrenailles[ChantiersRegistry.recetteLanceGrenailles.length-1];
	public int PACanonBrutal = ChantiersRegistry.recetteCanonBrutal[ChantiersRegistry.recetteCanonBrutal.length-1];
	public int PATourniquet = ChantiersRegistry.recetteTourniquet[ChantiersRegistry.recetteTourniquet.length-1];
	public int PAManufacture = ChantiersRegistry.recetteManufacture[ChantiersRegistry.recetteManufacture.length-1];
	public int PASciesHurlantes = ChantiersRegistry.recetteSciesHurlantes[ChantiersRegistry.recetteSciesHurlantes.length-1];
	public int PARegistreChantier = ChantiersRegistry.recetteRegistreChantier[ChantiersRegistry.recetteRegistreChantier.length-1];
	public int PAArchitectoire = ChantiersRegistry.recetteArchitectoire[ChantiersRegistry.recetteArchitectoire.length-1];
	public int PAPotence = ChantiersRegistry.recettePotence[ChantiersRegistry.recettePotence.length-1];
	public int PAAbattoir = ChantiersRegistry.recetteAbattoir[ChantiersRegistry.recetteAbattoir.length-1];
	public int PASupportsDefensifs = ChantiersRegistry.recetteSupportsDefensifs[ChantiersRegistry.recetteSupportsDefensifs.length-1];
	public int PACantineABois = ChantiersRegistry.recetteCantineABois[ChantiersRegistry.recetteCantineABois.length-1];
	public int PACimetiereCadenasse = ChantiersRegistry.recetteCimetiereCadenasse[ChantiersRegistry.recetteCimetiereCadenasse.length-1];
	public int PACercueilsSurRessort = ChantiersRegistry.recetteCercueilsSurRessorts[ChantiersRegistry.recetteCercueilsSurRessorts.length-1];
	public int PACantineCentrale = ChantiersRegistry.recetteCantineCentrale[ChantiersRegistry.recetteCantineCentrale.length-1];
	public int PALaboratoireCentral = ChantiersRegistry.recetteLaboratoireCentral[ChantiersRegistry.recetteLaboratoireCentral.length-1];
	public int PAPoulailler = ChantiersRegistry.recettePoulailler[ChantiersRegistry.recettePoulailler.length-1];
	public int PAInfirmerie = ChantiersRegistry.recetteInfirmerie[ChantiersRegistry.recetteInfirmerie.length-1];
	public int PAStrategiesCitoyennes = ChantiersRegistry.recetteStrategiesCitoyennes[ChantiersRegistry.recetteStrategiesCitoyennes.length-1];
	public int PAQuartiersCirculaires = ChantiersRegistry.recetteQuartiersCirculaires[ChantiersRegistry.recetteQuartiersCirculaires.length-1];

	public RecetteChantier test = ChantiersRegistry.recetteTest;
	
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        
        this.PAAtelier = compound.getInteger("PAAtelier");
    	this.PABoucherie = compound.getInteger("PABoucherie");
    	this.PACrematoCue = compound.getInteger("PACrematoCue");
    	this.PAFixationsDefenses = compound.getInteger("PAFixationsDefenses");
    	this.PAMonticulesCanons = compound.getInteger("PAMonticulesCanons");
    	this.PACanonABriques = compound.getInteger("PACanonABriques");
    	this.PAPerforeuse = compound.getInteger("PAPerforeuse");
    	this.PALanceGrenailles = compound.getInteger("PALanceGrenailles");
    	this.PACanonBrutal = compound.getInteger("PACanonBrutal");
    	this.PATourniquet = compound.getInteger("PATourniquet");
    	this.PAManufacture = compound.getInteger("PAManufacture");
    	this.PASciesHurlantes = compound.getInteger("PASciesHurlantes");
    	this.PARegistreChantier = compound.getInteger("PARegistreChantier");
    	this.PAArchitectoire = compound.getInteger("PAArchitectoire");
    	this.PAPotence = compound.getInteger("PAPotence");
    	this.PAAbattoir = compound.getInteger("PAAbattoir");
    	this.PASupportsDefensifs = compound.getInteger("PASupportsDefensifsSupports");
    	this.PACantineABois = compound.getInteger("PACantineABois");
    	this.PACimetiereCadenasse = compound.getInteger("PACimetiereCadenasse");
    	this.PACercueilsSurRessort = compound.getInteger("PACercueilsSurRessorts");
    	this.PACantineCentrale = compound.getInteger("PACantineCentrale");
    	this.PALaboratoireCentral = compound.getInteger("PALaboratoireCentral");
    	this.PAPoulailler = compound.getInteger("PAPoulailler");
    	this.PAInfirmerie = compound.getInteger("PAInfirmerie");
    	this.PAStrategiesCitoyennes = compound.getInteger("PAStrategiesCitoyennes");
    	this.PAQuartiersCirculaires = compound.getInteger("PAQuartiersCirculaires");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {	
        super.writeToNBT(compound); 

        compound.setInteger("PAAtelier", this.PAAtelier);
    	compound.setInteger("PABoucherie", this.PABoucherie);
    	compound.setInteger("PACrematoCue", this.PACrematoCue);
    	compound.setInteger("PAFixationsDefenses", this.PAFixationsDefenses);
    	compound.setInteger("PAMonticulesCanons", this.PAMonticulesCanons);
    	compound.setInteger("PACanonABriques", this.PACanonABriques);
    	compound.setInteger("PAPerforeuse", this.PAPerforeuse);
    	compound.setInteger("PALanceGrenailles", this.PALanceGrenailles);
    	compound.setInteger("PACanonBrutal", this.PACanonBrutal);
    	compound.setInteger("PATourniquet", this.PATourniquet);
    	compound.setInteger("PAManufacture", this.PAManufacture);
    	compound.setInteger("PASciesHurlantes", this.PASciesHurlantes);
    	compound.setInteger("PARegistreChantier", this.PARegistreChantier);
    	compound.setInteger("PAArchitectoire", this.PAArchitectoire);
    	compound.setInteger("PAPotence", this.PAPotence);
    	compound.setInteger("PAAbattoir", this.PAAbattoir);
    	compound.setInteger("PASupportsDefensifs", this.PASupportsDefensifs);
    	compound.setInteger("PACantineABois", this.PACantineABois);
    	compound.setInteger("PACimetiereCadenasse", this.PACimetiereCadenasse);
    	compound.setInteger("PACercueilsSurRessort", this.PACercueilsSurRessort);
    	compound.setInteger("PACantineCentrale", this.PACantineCentrale);
    	compound.setInteger("PALaboratoireCentral", this.PALaboratoireCentral);
    	compound.setInteger("PAPoulailler", this.PAPoulailler);
    	compound.setInteger("PAInfirmerie", this.PAInfirmerie);
    	compound.setInteger("PAStrategiesCitoyennes", this.PAStrategiesCitoyennes);
    	compound.setInteger("PAQuartiersCirculaires", this.PAQuartiersCirculaires);
    }
    
    public void decreasePAAtelier() {this.PAAtelier--;updateTileEntity();}
	public void decreasePABoucherie() {this.PABoucherie--;updateTileEntity();}
	public void decreasePACrematoCue() {this.PACrematoCue--;updateTileEntity();}
	public void decreasePAFixationsDefenses() {this.PAFixationsDefenses--;updateTileEntity();}
	public void decreasePAMonticulesCanons() {this.PAMonticulesCanons--;updateTileEntity();}
	public void decreasePACanonABriques() {this.PACanonABriques--;updateTileEntity();}
	public void decreasePAPerforeuse() {this.PAPerforeuse--;updateTileEntity();}
	public void decreasePALanceGrenailles() {this.PALanceGrenailles--;updateTileEntity();}
	public void decreasePACanonBrutal() {this.PACanonBrutal--;updateTileEntity();}
	public void decreasePATourniquet() {this.PATourniquet--;updateTileEntity();}
	public void decreasePAManufacture() {this.PAManufacture--;updateTileEntity();}
	public void decreasePASciesHurlantes() {this.PASciesHurlantes--;updateTileEntity();}
	public void decreasePARegistreChantier() {this.PARegistreChantier--;updateTileEntity();}
	public void decreasePAArchitectoire() {this.PAArchitectoire--;updateTileEntity();}
	public void decreasePAPotence() {this.PAPotence--;updateTileEntity();}
	public void decreasePAAbattoir() {this.PAAbattoir--;updateTileEntity();}
	public void decreasePASupportsDefensifs() {this.PASupportsDefensifs--;updateTileEntity();}
	public void decreasePACantineABois() {this.PACantineABois--;updateTileEntity();}
	public void decreasePACimetiereCadenasse() {this.PACimetiereCadenasse--;updateTileEntity();}
	public void decreasePACercueilsSurRessort() {this.PACercueilsSurRessort--;updateTileEntity();}
	public void decreasePACantineCentrale() {this.PACantineCentrale--;updateTileEntity();}
	public void decreasePALaboratoireCentral() {this.PALaboratoireCentral--;updateTileEntity();}
	public void decreasePAPoulailler() {this.PAPoulailler--;updateTileEntity();}
	public void decreasePAInfirmerie() {this.PAInfirmerie--;updateTileEntity();}
	public void decreasePAStrategiesCitoyennes() {this.PAStrategiesCitoyennes--;updateTileEntity();}
	public void decreasePAQuartiersCirculaires() {this.PAQuartiersCirculaires--;updateTileEntity();}
			
    public void updateTileEntity() {
    	this.worldObj.scheduledUpdatesAreImmediate = true;
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
    
    public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? 
				false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}
}