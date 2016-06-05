package fr.myrilandel.hordemod.events;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.packets.PacketJournaliers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedEntityPropJourna implements IExtendedEntityProperties {
	
	public final static String EXT_PROP_NAME = "ExtPropJourna";
	private final EntityPlayer player;

	public boolean aJoueDes;
	public boolean aJoueGuitareArtisanale; 
	public boolean aJoueJeuDeCartes;
	public boolean aUtiliseTeddyNOurs;
	
	public boolean aRecuRationDEau;
	public boolean aRecuStarterPack;

    public ExtendedEntityPropJourna(EntityPlayer player) {
    	this.player = player;
		
		this.aJoueDes = false;
		this.aJoueGuitareArtisanale = false;
		this.aJoueJeuDeCartes = false;
		this.aUtiliseTeddyNOurs = false;
		
		this.aRecuRationDEau = false;
		this.aRecuStarterPack = false;
    }
    
    public static final void register(EntityPlayer player) {
    	player.registerExtendedProperties(ExtendedEntityPropJourna.EXT_PROP_NAME,
    			new ExtendedEntityPropJourna(player));
    }

	public static final ExtendedEntityPropJourna get(EntityPlayer player) {
		return (ExtendedEntityPropJourna) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setBoolean("aJoueDes", this.aJoueDes);
		properties.setBoolean("aJoueGuitareArtisanale", this.aJoueGuitareArtisanale);
		properties.setBoolean("aJoueJeuDeCartes", this.aJoueJeuDeCartes);
		properties.setBoolean("aUtiliseTeddyNOurs", this.aUtiliseTeddyNOurs);

		properties.setBoolean("aRecuRationDEau", this.aRecuRationDEau);
		properties.setBoolean("aRecuStarterPack", this.aRecuStarterPack);

		compound.setTag(EXT_PROP_NAME, properties);		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);

		this.aJoueDes = properties.getBoolean("aJoueDes");
		this.aJoueGuitareArtisanale = properties.getBoolean("aJoueGuitareArtisanale");
		this.aJoueJeuDeCartes = properties.getBoolean("aJoueJeuDeCartes");
		this.aUtiliseTeddyNOurs = properties.getBoolean("aUtiliseTeddyNOurs");
		
		this.aRecuRationDEau = properties.getBoolean("aRecuRationDEau");
		this.aRecuStarterPack = properties.getBoolean("aRecuStarterPack");
	}

	public final void sync() 
	{
		 PacketJournaliers packetJournaliers = new PacketJournaliers(this.aJoueDes, this.aJoueGuitareArtisanale, this.aJoueJeuDeCartes, 
				 							this.aUtiliseTeddyNOurs, this.aRecuRationDEau, this.aRecuStarterPack);
		 HordeMod.hordeModPacketHandlerJourna.sendToServer(packetJournaliers);
		
		 if (!player.worldObj.isRemote)
		 {
			 HordeMod.hordeModPacketHandlerJourna.sendTo(packetJournaliers, (EntityPlayerMP) player);
		 }
	 }
	
	@Override
	public void init(Entity entity, World world) { }
	
	public void reset() {
		this.resetObjetJournalier();
		sync();
	}
	
	private void resetObjetJournalier() {
		this.aJoueDes = false;
		this.aJoueGuitareArtisanale = false;
		this.aJoueJeuDeCartes = false;
		this.aUtiliseTeddyNOurs = false;
		this.aRecuRationDEau = false;
	}

	public void switchAJoueDes(boolean b) {aJoueDes = b; this.sync();}
	public void switchAJoueGuitareArtisanale(boolean b) {aJoueGuitareArtisanale = b; this.sync();}
	public void switchAJoueJeuDeCartes(boolean b) {aJoueJeuDeCartes = b; this.sync();}
	public void switchAUtiliseTeddyNOurs(boolean b) {aUtiliseTeddyNOurs = b; this.sync();}
	public void switchARecuRationDEau(boolean b) {aRecuRationDEau = b; this.sync();}
	public void switchARecuStarterPack(boolean b) {aRecuStarterPack = b; this.sync();}
}
