package fr.myrilandel.hordemod.blocks.tileEntities;

import fr.myrilandel.hordemod.buildings.muraille.BuildMuraille;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChantierMuraille extends TileEntity {
	
	public int PAMuraille = ChantiersRegistry.recetteMuraille[ChantiersRegistry.recetteMuraille.length-1];
	public int PAGrandFosse = ChantiersRegistry.recetteGrandFosse[ChantiersRegistry.recetteGrandFosse.length-1];
	public int PADouves = ChantiersRegistry.recetteDouves[ChantiersRegistry.recetteDouves.length-1];
	public int PAMurailleRasoir = ChantiersRegistry.recetteMurailleRasoir[ChantiersRegistry.recetteMurailleRasoir.length-1];
	public int PAFosseAPieux = ChantiersRegistry.recetteFosseAPieux[ChantiersRegistry.recetteFosseAPieux.length-1];
	public int PABarbeles = ChantiersRegistry.recetteBarbeles[ChantiersRegistry.recetteBarbeles.length-1];
	public int PAAppats = ChantiersRegistry.recetteAppats[ChantiersRegistry.recetteAppats.length-1];
	public int PARempartsAvances = ChantiersRegistry.recetteRempartsAvances[ChantiersRegistry.recetteRempartsAvances.length-1];
	public int PAPoutresRenfort = ChantiersRegistry.recettePoutresRenfort[ChantiersRegistry.recettePoutresRenfort.length-1];
	public int PAMurailleAPointes = ChantiersRegistry.recetteMurailleAPointes[ChantiersRegistry.recetteMurailleAPointes.length-1];
	public int PAGrogroMur = ChantiersRegistry.recetteGrogroMur[ChantiersRegistry.recetteGrogroMur.length-1];
	public int PASecondeCouche = ChantiersRegistry.recetteSecondeCouche[ChantiersRegistry.recetteSecondeCouche.length-1];
	public int PATroisiemeCouche = ChantiersRegistry.recetteTroisiemeCouche[ChantiersRegistry.recetteTroisiemeCouche.length-1];
	public int PAMurailleEvolutive = ChantiersRegistry.recetteMurailleEvolutive[ChantiersRegistry.recetteMurailleEvolutive.length-1];
	public int PABetonnade = ChantiersRegistry.recetteBetonnade[ChantiersRegistry.recetteBetonnade.length-1];
	public int PARapeAZombies = ChantiersRegistry.recetteRapeAZombies[ChantiersRegistry.recetteRapeAZombies.length-1];
	public int PAOubliettes = ChantiersRegistry.recetteOubliettes[ChantiersRegistry.recetteOubliettes.length-1];
	public int PABarrieres = ChantiersRegistry.recetteBarrieres[ChantiersRegistry.recetteBarrieres.length-1];
	public int PAPalissade = ChantiersRegistry.recettePalissade[ChantiersRegistry.recettePalissade.length-1];
	public int PAMurSavone = ChantiersRegistry.recetteMurSavone[ChantiersRegistry.recetteMurSavone.length-1];
	public int PAPulverisateur = ChantiersRegistry.recettePulverisateur[ChantiersRegistry.recettePulverisateur.length-1];
	public int PAProjectionAcide = ChantiersRegistry.recetteProjectionAcide[ChantiersRegistry.recetteProjectionAcide.length-1];
	public int PANeurotoxine = ChantiersRegistry.recetteNeurotoxine[ChantiersRegistry.recetteNeurotoxine.length-1];
	public int PACloisonEnBois = ChantiersRegistry.recetteCloisonEnBois[ChantiersRegistry.recetteCloisonEnBois.length-1];
	public int PACloisonMetallique = ChantiersRegistry.recetteCloisonMetallique[ChantiersRegistry.recetteCloisonMetallique.length-1];
	public int PACloisonEpaisse = ChantiersRegistry.recetteCloisonEpaisse[ChantiersRegistry.recetteCloisonEpaisse.length-1];
	public int PAContrePlaque = ChantiersRegistry.recetteContrePlaque[ChantiersRegistry.recetteContrePlaque.length-1];
	public int PABastion = ChantiersRegistry.recetteBastion[ChantiersRegistry.recetteBastion.length-1];

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.PAMuraille = compound.getInteger("PAMuraille");
    	this.PAGrandFosse = compound.getInteger("PAGrandFosse");
    	this.PADouves = compound.getInteger("PADouves");
    	this.PAMurailleRasoir = compound.getInteger("PAMurailleRasoir");
    	this.PAFosseAPieux = compound.getInteger("PAFosseAPieux");
    	this.PABarbeles = compound.getInteger("PABarbeles");
    	this.PAAppats = compound.getInteger("PAAppats");
    	this.PARempartsAvances = compound.getInteger("PARempartsAvances");
    	this.PAPoutresRenfort = compound.getInteger("PAPoutresRenfort");
    	this.PAMurailleAPointes = compound.getInteger("PAMurailleAPointes");
    	this.PAGrogroMur = compound.getInteger("PAGrogroMur");
    	this.PASecondeCouche = compound.getInteger("PASecondeCouche");
    	this.PATroisiemeCouche = compound.getInteger("PATroisièmeCouche");
    	this.PAMurailleEvolutive = compound.getInteger("PAMurailleEvolutive");
    	this.PABetonnade = compound.getInteger("PABetonnade");
    	this.PARapeAZombies = compound.getInteger("PARapeAZombies");
    	this.PAOubliettes = compound.getInteger("PAOubliettes");
    	this.PABarrieres = compound.getInteger("PABarrieres");
    	this.PAPalissade = compound.getInteger("PAPalissade");
    	this.PAMurSavone = compound.getInteger("PAMurSavone");
    	this.PAPulverisateur = compound.getInteger("PAPulverisateur");
    	this.PAProjectionAcide = compound.getInteger("PAProjectionAcide");
    	this.PANeurotoxine = compound.getInteger("PANeurotoxine");
    	this.PACloisonEnBois = compound.getInteger("PACloisonEnBois");
    	this.PACloisonMetallique = compound.getInteger("PACloisonMetallique");
    	this.PACloisonEpaisse = compound.getInteger("PACloisonEpaisse");
    	this.PAContrePlaque = compound.getInteger("PAContrePlaque");
    	this.PABastion = compound.getInteger("PABastion");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);      
        compound.setInteger("PAMuraille", this.PAMuraille);
        compound.setInteger("PAGrandFosse", this.PAGrandFosse);
    	compound.setInteger("PADouves", this.PADouves);
    	compound.setInteger("PAMurailleRasoir", this.PAMurailleRasoir);
    	compound.setInteger("PAFosseAPieux", this.PAFosseAPieux);
    	compound.setInteger("PABarbeles", this.PABarbeles);
    	compound.setInteger("PAAppats", this.PAAppats);
    	compound.setInteger("PARempartsAvances", this.PARempartsAvances);
    	compound.setInteger("PAPoutresRenfort", this.PAPoutresRenfort);
    	compound.setInteger("PAMurailleAPointes", this.PAMurailleAPointes);
    	compound.setInteger("PAGrogroMur", this.PAGrogroMur);
    	compound.setInteger("PASecondeCouche", this.PASecondeCouche);
    	compound.setInteger("PATroisièmeCouche", this.PATroisiemeCouche);
    	compound.setInteger("PAMurailleEvolutive", this.PAMurailleEvolutive);
    	compound.setInteger("PABetonnade", this.PABetonnade);
    	compound.setInteger("PARapeAZombies", this.PARapeAZombies);
    	compound.setInteger("PAOubliettes", this.PAOubliettes);
    	compound.setInteger("PABarrieres", this.PABarrieres);
    	compound.setInteger("PAPalissade", this.PAPalissade);
    	compound.setInteger("PAMurSavone", this.PAMurSavone);
    	compound.setInteger("PAPulverisateur", this.PAPulverisateur);
    	compound.setInteger("PAProjectionAcide", this.PAProjectionAcide);
    	compound.setInteger("PANeurotoxine", this.PANeurotoxine);
    	compound.setInteger("PACloisonEnBois", this.PACloisonEnBois);
    	compound.setInteger("PACloisonMetallique", this.PACloisonMetallique);
    	compound.setInteger("PACloisonEpaisse", this.PACloisonEpaisse);
    	compound.setInteger("PAContrePlaque", this.PAContrePlaque);
    	compound.setInteger("PABastion", this.PABastion);
    }
    
    public void decreasePAMuraille() {this.PAMuraille--;BuildMuraille.updateMuraille(this.worldObj, PAMuraille);updateTileEntity();}
    public void decreasePAGrandFosse() {this.PAGrandFosse--;updateTileEntity();}
    public void decreasePADouves() {this.PADouves--;updateTileEntity();}
    public void decreasePAMurailleRasoir() {this.PAMurailleRasoir--;updateTileEntity();}
	public void decreasePAFosseAPieux() {this.PAFosseAPieux--;updateTileEntity();}
	public void decreasePABarbeles() {this.PABarbeles--;updateTileEntity();}
	public void decreasePAAppats() {this.PAAppats--;updateTileEntity();}
	public void decreasePARempartsAvances() {this.PARempartsAvances--;updateTileEntity();}
	public void decreasePAPoutresRenfort() {this.PAPoutresRenfort--;updateTileEntity();}
	public void decreasePAMurailleAPointes() {this.PAMurailleAPointes--;updateTileEntity();}
	public void decreasePAGrogroMur() {this.PAGrogroMur--;updateTileEntity();}
	public void decreasePASecondeCouche() {this.PASecondeCouche--;updateTileEntity();}
	public void decreasePATroisièmeCouche() {this.PATroisiemeCouche--;updateTileEntity();}
	public void decreasePAMurailleEvolutive() {this.PAMurailleEvolutive--;updateTileEntity();}
	public void decreasePABetonnade() {this.PABetonnade--;updateTileEntity();}
	public void decreasePARapeAZombies() {this.PARapeAZombies--;updateTileEntity();}
	public void decreasePAOubliettes() {this.PAOubliettes--;updateTileEntity();}
	public void decreasePABarrieres() {this.PABarrieres--;updateTileEntity();}
	public void decreasePAPalissade() {this.PAPalissade--;updateTileEntity();}
	public void decreasePAMurSavone() {this.PAMurSavone--;updateTileEntity();}
	public void decreasePAPulverisateur() {this.PAPulverisateur--;updateTileEntity();}
	public void decreasePAProjectionAcide() {this.PAProjectionAcide--;updateTileEntity();}
	public void decreasePANeurotoxine() {this.PANeurotoxine--;updateTileEntity();}
	public void decreasePACloisonEnBois() {this.PACloisonEnBois--;updateTileEntity();}
	public void decreasePACloisonMetallique() {this.PACloisonMetallique--;updateTileEntity();}
	public void decreasePACloisonEpaisse() {this.PACloisonEpaisse--;updateTileEntity();}
	public void decreasePAContrePlaque() {this.PAContrePlaque--;updateTileEntity();}
	public void decreasePABastion() {this.PABastion--;updateTileEntity();}
			
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