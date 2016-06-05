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

public class Betapropine5MgPerimee extends ItemFood {

	public Betapropine5MgPerimee() {
		super(10, 0.0F, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("Betapropine5MgPerimee");
		this.setTextureName(HordeMod.MODID + ":betapropine5MgPerimee");
		this.setMaxStackSize(1);
		this.setCreativeTab(HordeMod.droguesCreativeTabs);
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		ExtendedEntityPropEtats entityPropPA = ExtendedEntityPropEtats.get(entityPlayer);
		
		if(!world.isRemote) {
			int randResult = getRandomResult();
			if(randResult == 0)
				entityPlayer.addChatMessage(new ChatComponentText("Mal de tete... Sang... Rien de grave... Rien ne se passe."));

			if(randResult == 1) {
				entityPropPA.setPA(SourcesDePA.betapropine5MgPerimeeNormal);
				if(entityPropPA.drogue) {
					if(!entityPropPA.dependant) {
						entityPlayer.addChatMessage(new ChatComponentText("Vous avez consommé trop de drogues ! Vous êtes dépendant !"));
						entityPropPA.switchDependant(true);
					}
				}
				else
					entityPlayer.addChatMessage(new ChatComponentText("Vous êtes drogué !"));	

				entityPropPA.switchDrogue(true);
			}		
			
			if(randResult == 2) {
				entityPropPA.setPA(SourcesDePA.betapropine5MgPerimeeDure);
				entityPlayer.addChatMessage(new ChatComponentText("Ce produit se revele etre un puissant steroide pour animaux ! "
						+ "Vous devenez immédiatement independant aux drogues !"));
				entityPropPA.switchDrogue(true);
				entityPropPA.switchDependant(true);
			}	

			if(randResult == 3) {
				entityPlayer.addChatMessage(new ChatComponentText("Fièvre, bave, spasmes... La totale. Vous devenez immédiatement independant aux drogues. "
						+ "Vous ne recuperez pas de PA. Et comme si ça ne suffisait pas, vous etes terrorise. La totale."));
				entityPropPA.switchDependant(true);
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
