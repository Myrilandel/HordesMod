package fr.myrilandel.hordemod.utils;

import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBlocksVille;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecetteChantier {

	public String name;
	public Item[] tabCompo;
	public ResourceLocation[] textures;
	public int[] nbCompos;
	public int PA;
	public int valDef;
	public String plan;
	public int idPlan;
	
	private boolean recetteIsUnlocked = true;
	private boolean buildRecette = false;
	
	public RecetteChantier(String name, Item[] tabCompo, ResourceLocation[] textures,
			int[] nbCompos, int PA) {
		this.name = name;
		this.tabCompo = tabCompo;
		this.textures = textures;
		this.nbCompos = nbCompos;
		this.PA = PA;
	}

	public RecetteChantier(String name, Item[] tabCompo, ResourceLocation[] textures,int[] nbCompos, int PA,
			int valDef) {
		this(name,tabCompo,textures,nbCompos,PA);
		this.valDef = valDef;
	}
	
	public RecetteChantier(String name, Item[] tabCompo, ResourceLocation[] textures,int[] nbCompos, int PA,
			int valDef, String plan, int idPlan) {
		this(name,tabCompo,textures,nbCompos,PA,valDef);
		this.plan = plan;
		this.idPlan = idPlan;
		this.recetteIsUnlocked = false;
	}
	
	public boolean recetteIsVisible(World world) {
			return (!buildRecette && recetteIsUnlocked);
	}

	public boolean recetteIsEnabled(World world, ExtendedEntityPropEtats props) {
		return(!buildRecette && props.PA > 0 && checkElemInBanque(world));
	}
	
	public void buildRecette() {
		this.buildRecette = true;
	}
	
	private boolean checkElemInBanque(World world) {
		TileEntityBanque tileBanque = (TileEntityBanque)TileHelper.getTileBanque(world);
		int tmp;
		for(int i = 0; i<tabCompo.length; i++) {
			tmp = 0;
			for (ItemStack itemStack : tileBanque.getContent()) {
				if(itemStack != null) {
					if(itemStack.getItem() == tabCompo[i])
						tmp += itemStack.stackSize;
				}
			}
			if(tmp < nbCompos[i])
				return false;
		}
		return true;
	}
}
