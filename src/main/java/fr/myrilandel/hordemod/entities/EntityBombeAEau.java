package fr.myrilandel.hordemod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityBombeAEau extends EntityThrowable {

	public EntityBombeAEau(World world) {
		super(world);
	}	

	public EntityBombeAEau(World world, EntityLivingBase entity) {
		super(world, entity);
	}	
	
	protected void onImpact(MovingObjectPosition mvObjPos) {
		this.createExplosion(null, this.posX, this.posY, this.posZ, 1.0F, false);
			if(!this.worldObj.isRemote) {
				if(mvObjPos.entityHit != null && !(mvObjPos.entityHit instanceof EntityPlayer))
					mvObjPos.entityHit.setFire(3600);
				this.setDead();
			}
	}
	
	public Explosion createExplosion(Entity entity, double posX, double posY, double posZ, float power, boolean falming)
    {
        return this.newExplosion(entity, posX, posY, posZ, power, false, falming);
    }
	
	public Explosion newExplosion(Entity entity, double posX, double posY, double posZ, float power, boolean flaming, boolean smoking)
    {
        Explosion explosion = new Explosion(this.worldObj, entity, posX, posY, posZ, power);
        explosion.isFlaming = true;
        explosion.isSmoking = smoking;
        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this.worldObj, explosion)) return explosion;
        explosion.doExplosionA();
        explosion.doExplosionB(false);
        return explosion;
    }
}
