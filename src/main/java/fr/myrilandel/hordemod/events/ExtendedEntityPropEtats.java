package fr.myrilandel.hordemod.events;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.packets.PacketEtats;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedEntityPropEtats implements IExtendedEntityProperties {
	
	public final static String EXT_PROP_NAME = "Ext_Tile_Entities";
	private final EntityPlayer player;
	
	public int PA;
	public int PAMax;
	
	public boolean blesse;
	public boolean clair;
	public boolean convalescent;
	public boolean drogue;
	public boolean dependant;
	public boolean desaltere;
	public boolean fatigue;
	public boolean gueuleDeBois;
	public boolean infection;
	public boolean ivre;
	public boolean rassasie;
	public boolean soif;
	public boolean terreur;

    public ExtendedEntityPropEtats(EntityPlayer player) {
    	this.player = player;
    	
    	this.PA = SourcesDePA.PAMax;
		this.PAMax = SourcesDePA.PAMax;
		
		this.blesse = false;
		this.clair = true;
		this.convalescent = false;
		this.drogue = false;
		this.dependant = false;
		this.desaltere = false;
		this.fatigue = false;
		this.gueuleDeBois = false;
		this.infection = false;
		this.ivre = false;
		this.rassasie = false;
		this.soif = false;
		this.terreur = false;
    }
    
    public static final void register(EntityPlayer player) {
    	player.registerExtendedProperties(ExtendedEntityPropEtats.EXT_PROP_NAME,
    			new ExtendedEntityPropEtats(player));
    }

	public static final ExtendedEntityPropEtats get(EntityPlayer player) {
		return (ExtendedEntityPropEtats) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("PA", this.PA);
		properties.setInteger("PAMax", this.PAMax);
		
		properties.setBoolean("blesse", this.blesse);
		properties.setBoolean("clair", this.clair);
		properties.setBoolean("convalescent", this.convalescent);
		properties.setBoolean("dependant", this.dependant);
		properties.setBoolean("desaltere", this.desaltere);
		properties.setBoolean("drogue", this.drogue);
		properties.setBoolean("fatigue", this.fatigue);
		properties.setBoolean("gueuleDeBois", this.gueuleDeBois);
		properties.setBoolean("infection", this.infection);
		properties.setBoolean("ivre", this.ivre);
		properties.setBoolean("rassasie", this.rassasie);
		properties.setBoolean("soif", this.soif);
		properties.setBoolean("terreur", this.terreur);

		compound.setTag(EXT_PROP_NAME, properties);		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);
		this.PA = properties.getInteger("PA");
		this.PAMax = properties.getInteger("PAMax");		
		
		this.blesse = properties.getBoolean("blesse");
		this.clair = properties.getBoolean("clair");
		this.convalescent = properties.getBoolean("convalescent");
		this.dependant = properties.getBoolean("dependant");
		this.desaltere = properties.getBoolean("desaltere");
		this.drogue = properties.getBoolean("drogue");
		this.fatigue = properties.getBoolean("fatigue");
		this.gueuleDeBois = properties.getBoolean("gueuleDeBois");
		this.infection = properties.getBoolean("infection");
		this.ivre = properties.getBoolean("ivre");
		this.rassasie = properties.getBoolean("rassasie");
		this.soif = properties.getBoolean("soif");
		this.terreur = properties.getBoolean("terreur");
	}

	public final void sync() 
	{
		 PacketEtats packetEtats = new PacketEtats(this.PA, this.PAMax, this.blesse, this.clair, this.convalescent,
				 							this.dependant,this.desaltere, this.drogue,
				 							this.fatigue, this.gueuleDeBois, this.infection, this.ivre, 
				 							this.rassasie, this.soif, this.terreur);
		 HordeMod.hordeModPacketHandlerEtats.sendToServer(packetEtats);
		
		 if (!player.worldObj.isRemote)
		 {
			 HordeMod.hordeModPacketHandlerEtats.sendTo(packetEtats, (EntityPlayerMP) player);
		 }
	 }
	
	@Override
	public void init(Entity entity, World world) { }
	
	public void reset() {
		this.checkMort();
		this.adapteIvreEtGueuleDeBois();
		this.adapteClairEtDrogue();
		this.adapteHydratation();
		this.adapteBlesseEtConvalescent();
		
    	this.PA = SourcesDePA.PAMax;
		
		this.fatigue = false;
		this.rassasie = false;
		sync();
	}
	
	private void checkMort() {
		if(isDependantEtNonDrogue() || this.soif || (infection && Math.random() > 0.5))
			player.attackEntityFrom(DamageSource.magic, 100);
		if(!(player.posX > 912 && player.posX < 990 && player.posZ > 1012 && player.posZ < 1090))
			player.attackEntityFrom(DamageSource.magic, 100);
	}
	
	private boolean isDependantEtNonDrogue() {
		return(this.dependant && !this.drogue);
	}
	
	private void adapteClairEtDrogue() {
		if(this.drogue)
			switchDrogue(false);
	}
	
	private void adapteIvreEtGueuleDeBois() {
		if(this.gueuleDeBois)
			this.gueuleDeBois = false;
		if(this.ivre)
			switchGueuleDeBois(true);
	}
	
	private void adapteHydratation() {
		if(!this.desaltere)
			this.soif = true;

		this.desaltere = false;
	}
	
	private void adapteBlesseEtConvalescent() {
		if(this.blesse)
			this.infection = true;

		this.convalescent = false;
	}
	
	
	public boolean pertePA(int amount) {		
		if (amount <= this.PA) {
				this.PA -= amount; this.sync();
				if(!player.worldObj.isRemote)
					player.addChatMessage(new ChatComponentText("Vous perdez "+amount+" PA et avez à présent "+PA+" PA."));
				return true;
		}
		else 
			if(!player.worldObj.isRemote)
				player.addChatMessage(new ChatComponentText("Vous n'avez pas assez de PA pour réaliser cette action."));
		return false;
	}
	
	public void gainPA(int amount) {
			this.PA = this.PA + amount <= PAMax ? this.PA+amount : PAMax; this.sync();
			if(!player.worldObj.isRemote)
				player.addChatMessage(new ChatComponentText("Vous gagnez "+amount+" PA et avez à présent "+PA+" PA."));
	}
	
	public void setPA(int amount) {		
		this.PA = amount; this.sync();
		if(!player.worldObj.isRemote)
			player.addChatMessage(new ChatComponentText("Vous avez à présent "+PA+" PA."));
	}
	
	public void switchBlesse(boolean b) {blesse = b; this.sync();}
	public void switchClair(boolean b) {clair = b; drogue = !clair; this.sync();}
	public void switchConvalescent(boolean b) {convalescent = b; blesse = !convalescent; this.sync();}
	public void switchDrogue(boolean b) {drogue = b; clair = !drogue; this.sync();}
	public void switchDependant(boolean b) {dependant = b; clair = !dependant; this.sync();}
	public void switchDesaltere(boolean b) {desaltere = b; soif = !desaltere; this.sync();}
	public void switchFatigue(boolean b) {fatigue = b; this.sync();}
	public void switchInfection(boolean b) {infection = b; this.sync();}
	public void switchIvre(boolean b) {ivre = b; this.sync();}
	public void switchGueuleDeBois(boolean b) {gueuleDeBois = b; ivre = !gueuleDeBois; this.sync();}
	public void switchRassasie(boolean b) {rassasie = b; this.sync();}
	public void switchTerreur(boolean b) {terreur = b; this.sync();}
}
