package fr.myrilandel.hordemod.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityItemTest extends EntityThrowable {

	public EntityItemTest(World world) {
		super(world);
	}	

	public EntityItemTest(World world, EntityLivingBase entity) {
		super(world, entity);
	}	
	
	protected void onImpact(MovingObjectPosition mvObjPos) {
		if(!this.worldObj.isRemote) {
			if(mvObjPos.entityHit != null)
				mvObjPos.entityHit.attackEntityFrom(DamageSource.fall, 2.0F);
			this.setDead();
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 4.5F, false);
		}
	}
}
