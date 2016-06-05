package fr.myrilandel.hordemod.packets;

import java.io.IOException;

import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierAtelier;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierFondations;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierMuraille;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPompe;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierPortail;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityChantierTDG;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import fr.myrilandel.hordemod.registry.HMRecipeRegistry;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.TileHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PacketBanque extends FFMTPacket {

	private int id;
	private int metadata;
	private TileEntityBanque tileBanque;
    public PacketBanque()
    {}

    public PacketBanque(int id, int metadata) {
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
	   	tileBanque = (TileEntityBanque)TileHelper.getTileBanque(player.worldObj);
    	tileBanque.updateTileEntity();
    }
    

    @Override
    public void handleServerSide(EntityPlayer player) {
	   	tileBanque = (TileEntityBanque)TileHelper.getTileBanque(player.worldObj);
	   	switch (metadata) {
		case 0:handleMuraille(player);break;
		case 1:handlePompe(player);break;
		case 2:handleAtelier(player);break;
		case 3:handleTDG(player);break;
		case 4:handleFondations(player);break;
		case 5:handlePortail(player);break;
		default:break;
		}
    	tileBanque.updateTileEntity();
    }
    
    private void handleMuraille(EntityPlayer player) {
   		TileEntityChantierMuraille tile = (TileEntityChantierMuraille)TileHelper.getTileChantierMuraille(player.worldObj);
   		switch (id) {
		case 1:if(tile.PAMuraille == 0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteMuraille);}break;
		case 2:if(tile.PAGrandFosse == 0){checkContent(new Item[]{}, ChantiersRegistry.recetteGrandFosse);}break;
		case 3:if(tile.PADouves == 0) {checkContent(new Item[]{HMItemRegistry.rationDEau}, ChantiersRegistry.recetteDouves);}break;
		case 4:if(tile.PAMurailleRasoir == 0) {checkContent(new Item[]{HMItemRegistry.ferraille,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteMurailleRasoir);}break;
		case 5:if(tile.PAFosseAPieux == 0) {checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.poutreRafistolee}, ChantiersRegistry.recetteFosseAPieux);}break;
		case 6:if(tile.PABarbeles ==0){checkContent(new Item[]{HMItemRegistry.ferraille}, ChantiersRegistry.recetteBarbeles);}break;
		case 7:if(tile.PAAppats ==0){checkContent(new Item[]{HMItemRegistry.osCharnu}, ChantiersRegistry.recetteAppats);}break; 
		case 8:if(tile.PARempartsAvances ==0){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteRempartsAvances);}break; 
		case 9:if(tile.PAPoutresRenfort ==0){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.ferraille}, ChantiersRegistry.recettePoutresRenfort);}break;
		case 10:if(tile.PAMurailleAPointes ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteMurailleAPointes);}break; 
		case 11:if(tile.PAGrogroMur ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteGrogroMur);}break;
		case 12:if(tile.PASecondeCouche ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.structuresMetalliques}, ChantiersRegistry.recetteSecondeCouche);}break; 
		case 13:if(tile.PATroisiemeCouche ==0){checkContent(new Item[]{HMItemRegistry.ferraille,HMItemRegistry.structuresMetalliques,HMItemRegistry.plaqueDeTole}, ChantiersRegistry.recetteTroisiemeCouche);}break; 
		case 14:if(tile.PAMurailleEvolutive ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteMurailleEvolutive);}break;
		case 15:if(tile.PABetonnade ==0){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteBetonnade);}break; 
		case 16:if(tile.PARapeAZombies ==0){checkContent(new Item[]{HMItemRegistry.ferraille,HMItemRegistry.plaqueDeTole,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteRapeAZombies);}break; 
		case 17:if(tile.PAOubliettes ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue}, ChantiersRegistry.recetteOubliettes);}break;
		case 18:if(tile.PABarrieres ==0){checkContent(new Item[]{HMItemRegistry.poutreRafistolee}, ChantiersRegistry.recetteBarrieres);}break;
		case 19:if(tile.PAPalissade ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.poutreRafistolee,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recettePalissade);}break; 
		case 20:if(tile.PAMurSavone ==0){checkContent(new Item[]{HMItemRegistry.pavesDeBetonInformes,HMItemRegistry.rationDEau,HMItemRegistry.produitsPharmaceutiques}, ChantiersRegistry.recetteMurSavone);}break; 
		case 21:if(tile.PAPulverisateur ==0){checkContent(new Item[]{HMItemRegistry.ferraille,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.tubeDeCuivre}, ChantiersRegistry.recettePulverisateur);}break;
		case 22:if(tile.PAProjectionAcide ==0){checkContent(new Item[]{HMItemRegistry.rationDEau,HMItemRegistry.produitsPharmaceutiques}, ChantiersRegistry.recetteProjectionAcide);}break;
		case 23:if(tile.PANeurotoxine ==0){checkContent(new Item[]{HMItemRegistry.rationDEau,HMItemRegistry.produitsPharmaceutiques,HMItemRegistry.steroidesAnabolisants}, ChantiersRegistry.recetteNeurotoxine);}break; 
		case 24:if(tile.PACloisonEnBois ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue}, ChantiersRegistry.recetteCloisonEnBois);}break;
		case 25:if(tile.PACloisonMetallique ==0){checkContent(new Item[]{HMItemRegistry.ferraille}, ChantiersRegistry.recetteCloisonMetallique);}break;
		case 26:if(tile.PACloisonEpaisse ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteCloisonEpaisse);}break;
		case 27:if(tile.PAContrePlaque ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteContrePlaque);}break;
		case 28:if(tile.PABastion ==0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteBastion);}break;
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
   		case 1:if(tile.PAAtelier == 0){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteAtelier);}break;
		case 2:if(tile.PABoucherie == 0 ){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille}, ChantiersRegistry.recetteBoucherie);}break;
		case 3:if(tile.PACrematoCue == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques}, ChantiersRegistry.recetteCrematoCue);}break;
		case 4:if(tile.PAFixationsDefenses == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteFixationsDefenses);}break;
		case 5:if(tile.PAMonticulesCanons == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteMonticulesCanons);}break;
		case 6:if(tile.PACanonABriques == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.pavesDeBetonInformes,HMItemRegistry.tubeDeCuivre,HMItemRegistry.composantElectronique}, ChantiersRegistry.recetteCanonABriques);}break;
		case 7:if(tile.PAPerforeuse == 0 ){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.tubeDeCuivre,HMItemRegistry.composantElectronique}, ChantiersRegistry.recettePerforeuse);}break;
		case 8:if(tile.PALanceGrenailles == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.plaqueDeTole,HMItemRegistry.explosifsBruts}, ChantiersRegistry.recetteLanceGrenailles);}break;
		case 9:if(tile.PACanonBrutal == 0 ){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.plaqueDeTole}, ChantiersRegistry.recetteCanonBrutal);}break;
		case 10:if(tile.PATourniquet == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques}, ChantiersRegistry.recetteTourniquet);}break;
		case 11:if(tile.PAManufacture == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.tableJarpen}, ChantiersRegistry.recetteManufacture);}break;
		case 12:if(tile.PASciesHurlantes == 0 ){checkContent(new Item[]{HMItemRegistry.ferraille,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.rustine}, ChantiersRegistry.recetteSciesHurlantes);}break;
		case 13:if(tile.PARegistreChantier == 0 ){checkContent(new Item[]{HMItemRegistry.tableJarpen}, ChantiersRegistry.recetteRegistreChantier);}break;
		case 14:if(tile.PAArchitectoire == 0 ){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.steroidesAnabolisants,HMItemRegistry.vodkaMarinostov}, ChantiersRegistry.recetteArchitectoire);}break;
		case 15:if(tile.PAPotence == 0 ){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.grosseChaineRouillee}, ChantiersRegistry.recettePotence);}break;
		case 16:if(tile.PAAbattoir == 0 ){checkContent(new Item[]{HMItemRegistry.structuresMetalliques,HMItemRegistry.pavesDeBetonInformes}, ChantiersRegistry.recetteAbattoir);}break;
		case 17:if(tile.PASupportsDefensifs == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques}, ChantiersRegistry.recetteSupportsDefensifs);}break;
		case 18:if(tile.PACantineABois == 0 ){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.rationDEau,HMItemRegistry.produitsPharmaceutiques}, ChantiersRegistry.recetteCantineABois);}break;
		case 19:if(tile.PACimetiereCadenasse == 0 ){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteCimetiereCadenasse);}break;
		case 20:if(tile.PACercueilsSurRessort == 0 ){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.ferraille,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.courroie}, ChantiersRegistry.recetteCercueilsSurRessorts);}break;
		case 21:if(tile.PACantineCentrale == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.tableJarpen,HMItemRegistry.produitsPharmaceutiques}, ChantiersRegistry.recetteCantineCentrale);}break;
		case 22:if(tile.PALaboratoireCentral == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous,HMItemRegistry.produitsPharmaceutiques}, ChantiersRegistry.recetteLaboratoireCentral);}break;
		case 23:if(tile.PAPoulailler == 0 ){checkContent(new Item[]{HMItemRegistry.planchesTordue,HMItemRegistry.poutreRafistolee,HMItemRegistry.morceauDeGrillage}, ChantiersRegistry.recettePoulailler);}break;
		case 24:if(tile.PAInfirmerie == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.produitsPharmaceutiques,HMItemRegistry.paracetoide7G}, ChantiersRegistry.recetteInfirmerie);}break;
		case 25:if(tile.PAStrategiesCitoyennes == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteStrategiesCitoyennes);}break;
		case 26:if(tile.PAQuartiersCirculaires == 0 ){checkContent(new Item[]{HMItemRegistry.poutreRafistolee,HMItemRegistry.structuresMetalliques,HMItemRegistry.poigneeDeVisEtEcrous}, ChantiersRegistry.recetteQuartiersCirculaires);}break;
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
    
    public void checkContent(Item[] item, int[] dcr) {
    	ItemStack itemStack;
    	for(int i = 0; i < item.length; i++) {
	    	for(int index = 0; index < tileBanque.contents.length; index++) {
	    		itemStack = tileBanque.contents[index];
	    		if(itemStack!= null && itemStack.getItem() == item[i]) {
	    			if(itemStack.stackSize >= dcr[i]) {
	    				tileBanque.decrStackSize(index, dcr[i]);
	    				break;
	    			}
	    			else {
	    				dcr[i] -= itemStack.stackSize;
	    				tileBanque.decrStackSize(index,itemStack.stackSize);
					}
	    		}
			}
    	}
    }
    
    @Override
    public int getDiscriminator() {
        return 3;
    }
}