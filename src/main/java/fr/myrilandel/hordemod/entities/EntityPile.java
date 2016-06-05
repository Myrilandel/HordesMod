package fr.myrilandel.hordemod.entities;

import fr.minecraftforgefrance.ffmtlibs.client.particle.ParticleLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPile extends EntityThrowable {

	public EntityPile(World world) {
		super(world);
	}	

	public EntityPile(World world, EntityLivingBase entity) {
		super(world, entity);
	}	
	
	protected void onImpact(MovingObjectPosition mvObjPos) {
		if(!this.worldObj.isRemote) {
			if(mvObjPos.entityHit != null)
				mvObjPos.entityHit.attackEntityFrom(DamageSource.cactus, 50.0F);
			this.setDead();
		}
	}
}
