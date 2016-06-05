package fr.myrilandel.hordemod.zombies;

import java.util.List;
import java.util.Random;

import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.ParamInit;
import fr.myrilandel.hordemod.utils.TileHelper;
import fr.myrilandel.hordemod.utils.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ZombieNuitEnVille extends EntityMob {
	
	private List players; 
	private boolean passif;
	private boolean objAtteint;
	private int target;
	private int dmgType;
	private int randomX;
	private int randomZ;
	public ZombieNuitEnVille(World world) {
		super(world);
		this.setPosition(951, 8, 1006);
		players = worldObj.playerEntities;
		target = MathHelper.getRandomIntegerInRange(new Random(), 0, players.size()-1);
		dmgType = MathHelper.getRandomIntegerInRange(new Random(), 0, 2);
		passif = MathHelper.getRandomIntegerInRange(new Random(), 0, 100) > 50 ? true : false;
		randomX = passif ? MathHelper.getRandomIntegerInRange(new Random(), 913, 989) : 951;
		randomZ = passif ? MathHelper.getRandomIntegerInRange(new Random(), 1013, 1089) : 1006;
	}
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
    	boolean porteOuverte = TileHelper.getPorteOuverte(worldObj);
    	if(!porteOuverte || passif || players.size() == 0)
			return null;
		else
			return (Entity)players.get(target);
	}
	
	@Override
	protected void attackEntity(Entity entity, float power) {
		super.attackEntity(entity, power);
		if(entity instanceof EntityPlayer) {
			ExtendedEntityPropEtats props = ExtendedEntityPropEtats.get((EntityPlayer) entity);
			switch (dmgType) {
				case 1: props.switchBlesse(true); dmgType = 0; break;
				case 2: props.switchTerreur(true); dmgType = 0; break;
				default:break;
			}
		}
	}
	
	@Override
	public void onLivingUpdate()
    {
    	if(worldObj != null && players.size() > 0) {
	    	boolean porteOuverte = TileHelper.getPorteOuverte(worldObj);
	    	PathEntity pathentity;
	    	if(this.posX > 949 && posX < 953 && this.posZ > 1013 && posZ < 1017)
	    		objAtteint = true;
	    	
	    	if(!porteOuverte) {
	    		pathentity = worldObj.getEntityPathToXYZ(this, 951,4,1012, 100F,true,false,false,true);
	    		this.setPathToEntity(pathentity);
	    	}
	    	else {
	    		if(!objAtteint) {
	    			pathentity = worldObj.getEntityPathToXYZ(this, 951,4,1012, 100F,true,false,false,true);
	    			this.setPathToEntity(pathentity);	
	    		}
	    		else
		    		if(!this.passif) {
			    		pathentity = worldObj.getPathEntityToEntity(this, (Entity)players.get(target), 100F,true,false,false,true);
			    		this.setPathToEntity(pathentity); 
		    		}
		    		else {
		    			int z = MathHelper.getRandomIntegerInRange(new Random(), 1013, 1089);
			    		pathentity = worldObj.getEntityPathToXYZ(this, randomX,4,randomZ, 100F,true,false,false,true);
			    		this.setPathToEntity(pathentity); 
		    		}

	    	}
	    	
	    	
	    	
	    	if(TimeHelper.getRelativeTime(worldObj) > (ParamInit.heureNewDay*1000) - 500 && 
	    			TimeHelper.getRelativeTime(worldObj) < (ParamInit.heureNewDay*1000) - 50)
	    		this.setFire(3600);
	    	
	    	if(this.isBurning())
				this.attackEntityFrom(DamageSource.cactus, 2500F);
	    	
	    	super.onLivingUpdate();
    	}
    	else
    		this.kill();
    }
}
