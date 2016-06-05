package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class PacketCentral extends FFMTPacket {

	private int id;
	private int metadata;
	private TileEntityBlocksVille tileEntityBlocksVille;
	
    public PacketCentral(){}

    public PacketCentral(int id, int metadata) {
    	this.id = id;
    	this.metadata = metadata;
    }

    @Override
    public void writeData(ByteBuf buffer) throws IOException {
        buffer.writeInt(this.id);
        buffer.writeInt(this.metadata);
    }

    @Override
    public void readData(ByteBuf buffer) {
        this.id = buffer.readInt();
        this.metadata = buffer.readInt();
    }

    @Override
    public void handleClientSide(EntityPlayer player) {
    	tileEntityBlocksVille = (TileEntityBlocksVille) TileHelper.getTileVille(player.worldObj);
    	tileEntityBlocksVille.updateTileEntity();
    }

    @Override
    public void handleServerSide(EntityPlayer player) {
    	tileEntityBlocksVille = (TileEntityBlocksVille) TileHelper.getTileVille(player.worldObj);

	   	switch (metadata) {
		case 0:handleMuraille(player);break;
		case 1:handlePompe(player);break;
		case 2:handleAtelier(player);break;
		case 3:handleTDG(player);break;
		case 4:handleFondations(player);break;
		case 5:handlePortail(player);break;
		default:break;
		}
		tileEntityBlocksVille.updateTileEntity();
    }
    
	private void handleMuraille(EntityPlayer player) {
			TileEntityChantierMuraille tile = (TileEntityChantierMuraille)TileHelper.getTileChantierMuraille(player.worldObj);
			switch (id) {
			case 1:if(tile.PAMuraille == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMuraille[ChantiersRegistry.defMuraille.length-1]);}break;
			case 2:if(tile.PAGrandFosse == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defGrandFosse[ChantiersRegistry.defGrandFosse.length-1]);}break;
			case 3:if(tile.PADouves == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defDouves[ChantiersRegistry.defDouves.length-1]);}break; 
			case 4:if(tile.PAMurailleRasoir == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMurailleRasoir[ChantiersRegistry.defMurailleRasoir.length-1]);}break;
			case 5:if(tile.PAFosseAPieux == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defFosseAPieux[ChantiersRegistry.defFosseAPieux.length-1]);}break;
			case 6:if(tile.PABarbeles == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defBarbeles[ChantiersRegistry.defBarbeles.length-1]);}break;
			case 7:if(tile.PAAppats == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defAppats[ChantiersRegistry.defAppats.length-1]);}break;
			case 8:if(tile.PARempartsAvances == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defRempartsAvances[ChantiersRegistry.defRempartsAvances.length-1]);}break;
			case 9:if(tile.PAPoutresRenfort == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defPoutresRenfort[ChantiersRegistry.defPoutresRenfort.length-1]);}break;
			case 10:if(tile.PAMurailleAPointes == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMurailleAPointes[ChantiersRegistry.defMurailleAPointes.length-1]);}break;
			case 11:if(tile.PAGrogroMur == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defGrogroMur[ChantiersRegistry.defGrogroMur.length-1]);}break;
			case 12:if(tile.PASecondeCouche == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defSecondeCouche[ChantiersRegistry.defSecondeCouche.length-1]);}break;
			case 13:if(tile.PATroisiemeCouche == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defTroisiemeCouche[ChantiersRegistry.defTroisiemeCouche.length-1]);}break;
			case 14:if(tile.PAMurailleEvolutive == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMurailleEvolutive[ChantiersRegistry.defMurailleEvolutive.length-1]);}break;
			case 15:if(tile.PABetonnade == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defBetonnade[ChantiersRegistry.defBetonnade.length-1]);}break;
			case 16:if(tile.PARapeAZombies == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defRapeAZombies[ChantiersRegistry.defRapeAZombies.length-1]);}break;
			case 17:if(tile.PAOubliettes == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defOubliettes[ChantiersRegistry.defOubliettes.length-1]);}break;
			case 18:if(tile.PABarrieres == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defBarrieres[ChantiersRegistry.defBarrieres.length-1]);}break;
			case 19:if(tile.PAPalissade == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defPalissade[ChantiersRegistry.defPalissade.length-1]);}break;
			case 20:if(tile.PAMurSavone == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMurSavone[ChantiersRegistry.defMurSavone.length-1]);}break;
			case 21:break;
			case 22:if(tile.PAProjectionAcide == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defProjectionAcide[ChantiersRegistry.defProjectionAcide.length-1]);}break;
			case 23:if(tile.PANeurotoxine == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defNeurotoxine[ChantiersRegistry.defNeurotoxine.length-1]);}break;
			case 24:if(tile.PACloisonEnBois == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defCloisonEnBois[ChantiersRegistry.defCloisonEnBois.length-1]);}break;
			case 25:if(tile.PACloisonMetallique == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defCloisonMetallique[ChantiersRegistry.defCloisonMetallique.length-1]);}break;
			case 26:if(tile.PACloisonEpaisse == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defCloisonEpaisse[ChantiersRegistry.defCloisonEpaisse.length-1]);}break;
			case 27:if(tile.PAContrePlaque == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defContrePlaque[ChantiersRegistry.defContrePlaque.length-1]);}break;
			case 28:if(tile.PABastion == 0){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defBastion[ChantiersRegistry.defBastion.length-1]);}break;

			default:break;
			}
	}
	
	private void handlePompe(EntityPlayer player) {
			TileEntityChantierPompe tile = (TileEntityChantierPompe)TileHelper.getTileChantierPompe(player.worldObj);
			switch (id) {
			default:break;
			}
	}
	
	private void handleAtelier(EntityPlayer player) {
			TileEntityChantierAtelier tile = (TileEntityChantierAtelier)TileHelper.getTileChantierAtelier(player.worldObj);
			switch (id) {
	   		case 1:if(tile.PAAtelier == 0){};break;
			case 2:if(tile.PABoucherie == 0 ){};break;
			case 3:if(tile.PACrematoCue == 0 ){};break;
			case 4:if(tile.PAFixationsDefenses == 0 ){};break;
			case 5:if(tile.PAMonticulesCanons == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defMonticulesCanons[ChantiersRegistry.defMonticulesCanons.length-1]);};break;
			case 6:if(tile.PACanonABriques == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defCanonABriques[ChantiersRegistry.defCanonABriques.length-1]);};break;
			case 7:if(tile.PAPerforeuse == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defPerforeuse[ChantiersRegistry.defPerforeuse.length-1]);};break;
			case 8:if(tile.PALanceGrenailles == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defLanceGrnailles[ChantiersRegistry.defLanceGrnailles.length-1]);};break;
			case 9:if(tile.PACanonBrutal == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defCanonBrutal[ChantiersRegistry.defCanonBrutal.length-1]);};break;
			case 10:if(tile.PATourniquet == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defTourniquet[ChantiersRegistry.defTourniquet.length-1]);};break;
			case 11:if(tile.PAManufacture == 0 ){this.tileEntityBlocksVille.converterPointAtelier--;};break;
			case 12:if(tile.PASciesHurlantes == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defSciesHurlantes[ChantiersRegistry.defSciesHurlantes.length-1]);};break;
			case 13:if(tile.PARegistreChantier == 0 ){};break;
			case 14:if(tile.PAArchitectoire == 0 ){};break;
			case 15:if(tile.PAPotence == 0 ){};break;
			case 16:if(tile.PAAbattoir == 0 ){tileEntityBlocksVille.addDefenses((Integer) ChantiersRegistry.defAbattoir[ChantiersRegistry.defAbattoir.length-1]);};break;
			case 17:if(tile.PASupportsDefensifs == 0 ){};break;
			case 18:if(tile.PACantineABois == 0 ){};break;
			case 19:if(tile.PACimetiereCadenasse == 0 ){};break;
			case 20:if(tile.PACercueilsSurRessort == 0 ){};break;
			case 21:if(tile.PACantineCentrale == 0 ){};break;
			case 22:if(tile.PALaboratoireCentral == 0 ){};break;
			case 23:if(tile.PAPoulailler == 0 ){};break;
			case 24:if(tile.PAInfirmerie == 0 ){};break;
			case 25:if(tile.PAStrategiesCitoyennes == 0 ){};break;
			case 26:if(tile.PAQuartiersCirculaires == 0 ){};break;
			default:break;
			}
	}
	
	private void handleTDG(EntityPlayer player) {
			TileEntityChantierTDG tile = (TileEntityChantierTDG)TileHelper.getTileChantierTDG(player.worldObj);
			switch (id) {
			default:break;
			}
	}
	
	private void handleFondations(EntityPlayer player) {
			TileEntityChantierFondations tile = (TileEntityChantierFondations)TileHelper.getTileChantierFondations(player.worldObj);
			switch (id) {
			default:break;
			}
	}
	
	private void handlePortail(EntityPlayer player) {
			TileEntityChantierPortail tile = (TileEntityChantierPortail)TileHelper.getTileChantierPortail(player.worldObj);
			switch (id) {
			default:break;
			}
	}
	
    @Override
    public int getDiscriminator() {
        return 4;
    }
}