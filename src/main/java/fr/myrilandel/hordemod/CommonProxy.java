package fr.myrilandel.hordemod;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.myrilandel.hordemod.item.EntityItemTest;
import fr.myrilandel.hordemod.registry.HMItemRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.nbt.NBTTagCompound;

public class CommonProxy {
	public void registerRender()
	{
	}
	
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}
}
