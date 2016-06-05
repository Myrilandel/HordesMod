package fr.myrilandel.hordemod.zombies;

import java.util.Random;

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

public class ZombieNuitHorsVille extends EntityMob{
	
	public ZombieNuitHorsVille(World world ) {
		super(world);
		this.setPosition(951, 8, 1006);
	}
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
		return null;
	}
	
	@Override
	public void onLivingUpdate()
    {
    	if(worldObj != null) {
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
