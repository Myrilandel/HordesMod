package fr.myrilandel.hordemod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPamplemousseExplosif extends EntityThrowable {

	public EntityPamplemousseExplosif(World world) {
		super(world);
	}	

	public EntityPamplemousseExplosif(World world, EntityLivingBase entity) {
		super(world, entity);
	}	
	
	protected void onImpact(MovingObjectPosition mvObjPos) {
		
		if(!this.worldObj.isRemote) {
			if(mvObjPos.entityHit != null)
				mvObjPos.entityHit.attackEntityFrom(DamageSource.cactus, 2.0F);
			this.setDead();
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 5.0F, false);
		}
	}
}
