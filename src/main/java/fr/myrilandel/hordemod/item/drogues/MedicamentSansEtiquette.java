package fr.myrilandel.hordemod.item.drogues;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.events.ExtendedEntityPropEtats;
import fr.myrilandel.hordemod.utils.SourcesDePA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MedicamentSansEtiquette extends ItemFood {

	public MedicamentSansEtiquette() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("MedicamentSansEtiquette");
		this.setTextureName(HordeMod.MODID + ":medicamentSansEtiquette");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.droguesCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			int randResult = getRandomResult();
			if(randResult == 0)
				entityPlayer.addChatMessage(new ChatComponentText("Vous gobez Médicament sans étiquette. "
						+ "Après plusieurs minutes, vous sentez une douleur sourde vous serrer le crâne et votre nez se met à saigner. "
						+ "Rien d'insupportable, mais rien de positif non plus… "));

			if(randResult == 1) {
				entityPropPA.setPA(SourcesDePA.medicamentSansEtiquetteNormal);
				if(entityPropPA.drogue) {
					if(!entityPropPA.dependant) {
						entityPlayer.addChatMessage(new ChatComponentText("Vous avez consommé trop de drogues ! Vous êtes dépendant !"));
						entityPropPA.switchDependant(true);
					}
				}
				else
					entityPlayer.addChatMessage(new ChatComponentText("Les effets de la drogue ne tardent pas à se faire sentir:"
							+ " nausée, tremblements, sueurs froides… "	+ "Mais au moins, ça vous donne un bon coup de fouet. N'en abusez pas !"));	

				entityPropPA.switchDrogue(true);
			}		
			
			if(randResult == 2) {
				entityPropPA.setPA(SourcesDePA.medicamentSansEtiquetteDure);
				entityPlayer.addChatMessage(new ChatComponentText("Ce produit se revele etre un puissant steroide pour animaux ! "
						+ "Vous devenez immédiatement independant aux drogues !"));
				entityPropPA.switchDrogue(true);
				entityPropPA.switchDependant(true);
			}	

			if(randResult == 3) {
				entityPlayer.addChatMessage(new ChatComponentText("Quelques secondes à peine après, c'est la panique…"
						+ "Sueurs froids, sentiment de persécution… "
						+ "Vous vous recroquevillez, le souffle coupé, en espérant que ça passe…"
						+ " mais ça ne passe pas."));
				entityPropPA.switchTerreur(true);
			}	
			itemStack.stackSize--;	
		}		
		return itemStack;
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
    
    private int getRandomResult() {
		double randDouble = Math.random() * 4;
		return adjustRandom(randDouble);
	}
	
	private int adjustRandom(double randDouble) {
		for(int i = 1; i < 5; i++)
			if (randDouble < i) 
				return i-1;
		return 0;	
	}
}
