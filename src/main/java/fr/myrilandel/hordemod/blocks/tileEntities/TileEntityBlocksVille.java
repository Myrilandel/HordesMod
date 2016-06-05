package fr.myrilandel.hordemod.blocks.tileEntities;

import java.util.Random;

import fr.myrilandel.hordemod.item.plans.PlanCommun;
import fr.myrilandel.hordemod.item.plans.PlanInhabituel;
import fr.myrilandel.hordemod.item.plans.PlanRare;
import fr.myrilandel.hordemod.item.plans.PlanTresRare;
import fr.myrilandel.hordemod.utils.ChantiersRegistry;
import fr.myrilandel.hordemod.utils.ParamInit;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntityBlocksVille extends TileEntity {

	public boolean gameStarted = true;

	public int converterPointAtelier = ParamInit.converterPointAtelier;
	public int converterPointChantier = ParamInit.converterPointChantier;
	public int defenses = ParamInit.defenses;
	public int nbZombies = ParamInit.nbZombies;
	public int ration = ParamInit.ration;
	public boolean porteOuverte = ParamInit.porteOuverte;
	
	public static final boolean[] tabCommunIsUnlocked = new boolean[ChantiersRegistry.nbPlanCommun];
	public static final boolean[] tabInhabituelIsUnlocked = new boolean[ChantiersRegistry.nbPlanInhabituel];
	public static final boolean[] tabRareIsUnlocked = new boolean[ChantiersRegistry.nbPlanRare];
	public static final boolean[] tabTresRareIsUnlocked = new boolean[ChantiersRegistry.nbPlanTresRare];

	
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.gameStarted = compound.getBoolean("gameStarted");
        this.converterPointAtelier = compound.getInteger("converterPointAtelier");
        this.converterPointChantier = compound.getInteger("converterPointChantier");   
        this.defenses = compound.getInteger("defenses"); 
        this.nbZombies = compound.getInteger("nbZombies");
        this.ration = compound.getInteger("ration"); 
        this.porteOuverte = compound.getBoolean("porteOuverte");  
        
        for(int i = 0; i < tabCommunIsUnlocked.length; i++)
        	this.tabCommunIsUnlocked[i] = compound.getBoolean("tabCommunIsUnlocked"+i);
        
        for(int i = 0; i < tabInhabituelIsUnlocked.length; i++)
        	this.tabInhabituelIsUnlocked[i] = compound.getBoolean("tabInhabituelIsUnlocked"+i);
        
        for(int i = 0; i < tabRareIsUnlocked.length; i++)
        	this.tabRareIsUnlocked[i] = compound.getBoolean("tabRareIsUnlocked"+i);
        
        for(int i = 0; i < tabTresRareIsUnlocked.length; i++)
        	this.tabTresRareIsUnlocked[i] = compound.getBoolean("tabTresRareIsUnlocked"+i);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("gameStarted", this.gameStarted);
        compound.setInteger("converterPointAtelier", this.converterPointAtelier);
        compound.setInteger("converterPointChantier", this.converterPointChantier);
        compound.setInteger("defenses", this.defenses);
        compound.setInteger("nbZombies", this.nbZombies);
        compound.setInteger("ration", this.ration); 
        compound.setBoolean("porteOuverte", this.porteOuverte); 
        
        for(int i = 0; i < tabCommunIsUnlocked.length; i++)
        	compound.setBoolean("tabCommunIsUnlocked"+i, this.tabCommunIsUnlocked[i]);
        
        for(int i = 0; i < tabInhabituelIsUnlocked.length; i++)
        	compound.setBoolean("tabInhabituelIsUnlocked"+i, this.tabInhabituelIsUnlocked[i]);
        
        for(int i = 0; i < tabRareIsUnlocked.length; i++)
        	compound.setBoolean("tabRareIsUnlocked"+i, this.tabRareIsUnlocked[i]);
        
        for(int i = 0; i < tabTresRareIsUnlocked.length; i++)
        	compound.setBoolean("tabTresRareIsUnlocked"+i, this.tabTresRareIsUnlocked[i]);
    }

    public void switchGameStart() {this.gameStarted = !gameStarted;updateTileEntity();}

    public void increaseConverterPointAtelier() {this.converterPointAtelier++;updateTileEntity();}
    public void decreaseConverterPointAtelier() {this.converterPointAtelier--;updateTileEntity();}
    
    public void addDefenses(int amount) {this.defenses += amount;updateTileEntity();}
    public void redDefenses(int amount) {this.defenses -= amount;updateTileEntity();}

    public void addRation(int amount) {this.ration += amount;updateTileEntity();}
    public void decreaseRation() {this.ration--;updateTileEntity();}
    
    public void increaseNbZombies() {this.nbZombies+=10;updateTileEntity();}
    public void decreaseNbZombies() {this.nbZombies-=10;updateTileEntity();}
    
    public void switchPorteOuverte() {this.porteOuverte = !porteOuverte;updateTileEntity();}
    
    public void updateTileEntity() {
    	this.worldObj.scheduledUpdatesAreImmediate = true;
    	this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    public int unlockNewChantier(Item plan){
    	int random = 0;
    	if(plan instanceof PlanCommun) {
    		random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabCommunIsUnlocked.length-1);
    		while(tabCommunIsUnlocked[random])
    			random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabCommunIsUnlocked.length-1);
    		tabCommunIsUnlocked[random] = true;
    	}
    	
    	if(plan instanceof PlanInhabituel) {
    		random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabInhabituelIsUnlocked.length-1);
    		while(tabInhabituelIsUnlocked[random])
    			random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabInhabituelIsUnlocked.length-1);
    		tabInhabituelIsUnlocked[random] = true;
    	}
    	
    	if(plan instanceof PlanRare) {
    		random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabRareIsUnlocked.length-1);
    		while(tabRareIsUnlocked[random])
    			random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabRareIsUnlocked.length-1);
    		tabRareIsUnlocked[random] = true;
    	}
    	
    	if(plan instanceof PlanTresRare) {
    		random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabTresRareIsUnlocked.length-1);
    		while(tabTresRareIsUnlocked[random])
    			random = MathHelper.getRandomIntegerInRange(new Random (), 0, tabTresRareIsUnlocked.length-1);
    		tabTresRareIsUnlocked[random] = true;
    	}
		updateTileEntity();
		return random;
    }

    public boolean allUnlocked(boolean [] tab) {
    	int nbUnlocked = 0;
    	for (boolean b : tab) 
			if(b) nbUnlocked++;
		
    	return nbUnlocked == tab.length;
    }
    
    
    
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
}
