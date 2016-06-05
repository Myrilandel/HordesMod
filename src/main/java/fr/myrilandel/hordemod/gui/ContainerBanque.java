package fr.myrilandel.hordemod.gui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;

public class ContainerBanque extends Container{

    private final TileEntityBanque tileEntityBanque;
    private int field_94535_f = -1;
    private int field_94536_g;
    private final Set field_94537_h = new HashSet();
    
    public ContainerBanque(TileEntityBanque tileEntityBanque, InventoryPlayer inventoryPlayer) {
    	this.tileEntityBanque = tileEntityBanque;
    	tileEntityBanque.openInventory();
        for(int i = 0; i < 10; ++i)
            for(int j = 0; j < 9; ++j)
                this.addSlotToContainer(new Slot(tileEntityBanque, j + i * 9, 8 + j * 18, 18 + i * 18));

        this.bindPlayerInventory(inventoryPlayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
    	/* On modifie légèrement en ajoutant un test (slot.inventory instanceof InventoryPlayer)
    	 * Les transfert via shift + Click seront donc possible uniquement dans le sens 
    	 * inventaire du joueur -> Coffre. 
    	 * Cela permet d'empiler les stacks automatiquement dans le coffre et de ne pas pouvoir retirer
    	 * d'itemStacks de stackSize > 1.
    	 */
    	
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if(slot != null && slot.getHasStack() && slot.inventory instanceof InventoryPlayer)
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if(slotIndex < this.tileEntityBanque.getSizeInventory())
            {
                if(!this.mergeItemStack(itemstack1, this.tileEntityBanque.getSizeInventory(), this.inventorySlots.size(), true)) {
                    tileEntityBanque.updateTileEntity();
                	this.detectAndSendChanges();
                	return null;
                }
            }
            else 
            	if(!this.mergeItemStack(itemstack1, 0, this.tileEntityBanque.getSizeInventory(), false)) {
                    this.detectAndSendChanges();
                    tileEntityBanque.updateTileEntity();
            		return null;
            	}
            if(itemstack1.stackSize == 0) 
                slot.putStack((ItemStack)null);
            else 
                slot.onSlotChanged();
        }
        tileEntityBanque.updateTileEntity();
        this.detectAndSendChanges();
        return itemstack;
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileEntityBanque.isUseableByPlayer(player);
	}
	
    private void bindPlayerInventory(InventoryPlayer inventory)
    {
        for(int i = 0; i < 3; ++i)
        	for(int j = 0; j < 9; ++j)
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 196 + i * 18));


        for(int i = 0; i < 9; ++i)
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 244));
    }
    
    @Override
    public ItemStack slotClick(int indexSlot, int mouseButon, int function, EntityPlayer entityPlayer)
    {
    	/* On redéfinie la fonction de telle sorte à ce que les itemStacks soient déposées ou retirées par pile de 1.
    	 * Si l'itemStack est déposé dans le coffre, il peut se stacker avec les items déjà présents et atteindre une
    	 * stackSize de 64.
    	 * Si l'itemStack est déposé dans l'inventaire du joueur, il ne peut pas avoir de stackSize > 1. 
    	 */
    	
        ItemStack itemstack = null;
        InventoryPlayer inventoryplayer = entityPlayer.inventory;
        int i1;
        ItemStack itemstack3;

        if (function == 5)
        {
            int l = this.field_94536_g;
            this.field_94536_g = func_94532_c(mouseButon);

            if ((l != 1 || this.field_94536_g != 2) && l != this.field_94536_g)
            {
                this.func_94533_d();
            }
            else if (inventoryplayer.getItemStack() == null)
            {
                this.func_94533_d();
            }
            else if (this.field_94536_g == 0)
            {
                this.field_94535_f = func_94529_b(mouseButon);

                if (func_94528_d(this.field_94535_f))
                {
                    this.field_94536_g = 1;
                    this.field_94537_h.clear();
                }
                else
                {
                    this.func_94533_d();
                }
            }
            else if (this.field_94536_g == 1)
            {
                Slot slot = (Slot)this.inventorySlots.get(indexSlot);

                if (slot != null && func_94527_a(slot, inventoryplayer.getItemStack(), true) && slot.isItemValid(inventoryplayer.getItemStack()) && inventoryplayer.getItemStack().stackSize > this.field_94537_h.size() && this.canDragIntoSlot(slot))
                {
                    this.field_94537_h.add(slot);
                }
            }
            else if (this.field_94536_g == 2)
            {
                if (!this.field_94537_h.isEmpty())
                {
                    itemstack3 = inventoryplayer.getItemStack().copy();
                    i1 = inventoryplayer.getItemStack().stackSize;
                    Iterator iterator = this.field_94537_h.iterator();

                    while (iterator.hasNext())
                    {
                        Slot slot1 = (Slot)iterator.next();

                        if (slot1 != null && func_94527_a(slot1, inventoryplayer.getItemStack(), true) && slot1.isItemValid(inventoryplayer.getItemStack()) && inventoryplayer.getItemStack().stackSize >= this.field_94537_h.size() && this.canDragIntoSlot(slot1))
                        {
                            ItemStack itemstack1 = itemstack3.copy();
                            int j1 = slot1.getHasStack() ? slot1.getStack().stackSize : 0;
                            func_94525_a(this.field_94537_h, this.field_94535_f, itemstack1, j1);

                            if (itemstack1.stackSize > 64)
                            {
                                itemstack1.stackSize = 64;
                            }

                            if (itemstack1.stackSize > slot1.getSlotStackLimit())
                            {
                                itemstack1.stackSize = slot1.getSlotStackLimit();
                            }

                            i1 -= itemstack1.stackSize - j1;
                            slot1.putStack(itemstack1);
                        }
                    }

                    itemstack3.stackSize = i1;

                    if (itemstack3.stackSize <= 0)
                    {
                        itemstack3 = null;
                    }

                    inventoryplayer.setItemStack(itemstack3);
                }

                this.func_94533_d();
            }
            else
            {
                this.func_94533_d();
            }
        }
        else if (this.field_94536_g != 0)
        {
            this.func_94533_d();
        }
        else
        {
            Slot slot2;
            int l1;
            ItemStack itemstack5;

            if ((function == 0 || function == 1) && (mouseButon == 0 || mouseButon == 1))
            {
                if (indexSlot == -999)
                {
                    if (inventoryplayer.getItemStack() != null && indexSlot == -999)
                    {
                        if (mouseButon == 0 || mouseButon == 1)
                        {
                            entityPlayer.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack().splitStack(1), true);

                            if (inventoryplayer.getItemStack().stackSize == 0)
                            {
                                inventoryplayer.setItemStack((ItemStack)null);
                            }
                        }
                    }
                }
                else if (function == 1)
                {
                    if (indexSlot < 0)
                    {
                        return null;
                    }

                    slot2 = (Slot)this.inventorySlots.get(indexSlot);

                    if (slot2 != null && slot2.canTakeStack(entityPlayer))
                    {
                        itemstack3 = this.transferStackInSlot(entityPlayer, indexSlot);

                        if (itemstack3 != null)
                        {
                            Item item = itemstack3.getItem();
                            itemstack = itemstack3.copy();
                            if (slot2.getStack() != null && slot2.getStack().getItem() == item)
                            {
                                this.retrySlotClick(indexSlot, mouseButon, true, entityPlayer);
                            }
                        }
                    }
                }
                else
                {
                    if (indexSlot < 0)
                    {
                        return null;
                    }

                    slot2 = (Slot)this.inventorySlots.get(indexSlot);

                    if (slot2 != null)
                    {
                        itemstack3 = slot2.getStack();
                        ItemStack itemstack4 = inventoryplayer.getItemStack();

                        if (itemstack3 != null)
                        {
                            itemstack = itemstack3.copy();
                        }

                        if (itemstack3 == null)
                        {
                            if (itemstack4 != null && slot2.isItemValid(itemstack4))
                            {
                                l1 = 1;//mouseButon == 0 ? itemstack4.stackSize : 1;

                                if (l1 > slot2.getSlotStackLimit())
                                {
                                    l1 = slot2.getSlotStackLimit();
                                }

                                if (itemstack4.stackSize >= l1)
                                {
                                    slot2.putStack(itemstack4.splitStack(l1));
                                }

                                if (itemstack4.stackSize == 0)
                                {
                                    inventoryplayer.setItemStack((ItemStack)null);
                                }
                            }
                        }
                        else if (slot2.canTakeStack(entityPlayer))
                        {
                            if (itemstack4 == null)
                            {
                                l1 = 1;//mouseButon == 0 ? itemstack3.stackSize : (itemstack3.stackSize + 1) / 2;
                                itemstack5 = slot2.decrStackSize(l1);
                                inventoryplayer.setItemStack(itemstack5);

                                if (itemstack3.stackSize == 0)
                                {
                                    slot2.putStack((ItemStack)null);
                                }

                                slot2.onPickupFromSlot(entityPlayer, inventoryplayer.getItemStack());
                            }
                            else if (slot2.isItemValid(itemstack4))
                            {
                                if (itemstack3.getItem() == itemstack4.getItem() && itemstack3.getItemDamage() == itemstack4.getItemDamage() && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4))
                                {
                                    l1 = 1;//mouseButon == 0 ? itemstack4.stackSize : 1;

                                    if (l1 > slot2.getSlotStackLimit() - itemstack3.stackSize)
                                    {
                                        l1 = slot2.getSlotStackLimit() - itemstack3.stackSize;
                                    }

                                    if (l1 > itemstack4.getMaxStackSize() - itemstack3.stackSize)
                                    {
                                        l1 = itemstack4.getMaxStackSize() - itemstack3.stackSize;
                                    }
                                    //Partie Modifiée - START//
                                    if(!(slot2.inventory == inventoryplayer)) {

                                    	l1 = 1;
                                    	itemstack4.splitStack(l1);
                                    	itemstack3.stackSize += l1;
                                    	tileEntityBanque.updateTileEntity();
                                    }
                                    else {
                                    	itemstack4.splitStack(l1);
                                        slot2.onPickupFromSlot(entityPlayer, inventoryplayer.getItemStack());
                                    	inventoryplayer.setItemStack(itemstack4);

                                    } 
                                    
                                    if (itemstack4.stackSize == 0)
                                    {
                                        inventoryplayer.setItemStack((ItemStack)null);
                                    }
                                    //Partie Modifiée - END//
                                }
                                else if (itemstack4.stackSize <= slot2.getSlotStackLimit())
                                {
                                    slot2.putStack(itemstack4);
                                    inventoryplayer.setItemStack(itemstack3);

                                }
                            }
                            else if (itemstack3.getItem() == itemstack4.getItem() && itemstack4.getMaxStackSize() > 1 && (!itemstack3.getHasSubtypes() || itemstack3.getItemDamage() == itemstack4.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4))
                            {
                                l1 = itemstack3.stackSize;

                                if (l1 > 0 && l1 + itemstack4.stackSize <= itemstack4.getMaxStackSize())
                                {
                                    itemstack4.stackSize += l1;
                                    itemstack3 = slot2.decrStackSize(l1);


                                    if (itemstack3.stackSize == 0)
                                    {
                                        slot2.putStack((ItemStack)null);
                                    }

                                    slot2.onPickupFromSlot(entityPlayer, inventoryplayer.getItemStack());

                                }
                            }
                        }
                        slot2.onSlotChanged();
                    }
                }
            }
            else if (function == 2 && mouseButon >= 0 && mouseButon < 9)
            {
                slot2 = (Slot)this.inventorySlots.get(indexSlot);

                if (slot2.canTakeStack(entityPlayer))
                {
                    itemstack3 = inventoryplayer.getStackInSlot(mouseButon);
                    boolean flag = itemstack3 == null || slot2.inventory == inventoryplayer && slot2.isItemValid(itemstack3);
                    l1 = -1;

                    if (!flag)
                    {
                        l1 = inventoryplayer.getFirstEmptyStack();
                        flag |= l1 > -1;
                    }

                    if (slot2.getHasStack() && flag)
                    {

                        itemstack5 = slot2.getStack();
                        inventoryplayer.setInventorySlotContents(mouseButon, itemstack5.copy());

                        if ((slot2.inventory != inventoryplayer || !slot2.isItemValid(itemstack3)) && itemstack3 != null)
                        {
                            if (l1 > -1)
                            {
                                inventoryplayer.addItemStackToInventory(itemstack3);
                                slot2.decrStackSize(itemstack5.stackSize);
                                slot2.putStack((ItemStack)null);
                                slot2.onPickupFromSlot(entityPlayer, itemstack5);
                            }
                        }
                        else
                        {

                            slot2.decrStackSize(itemstack5.stackSize);
                            slot2.putStack(itemstack3);
                            slot2.onPickupFromSlot(entityPlayer, itemstack5);
                        }
                    }
                    else if (!slot2.getHasStack() && itemstack3 != null && slot2.isItemValid(itemstack3))
                    {
                        inventoryplayer.setInventorySlotContents(mouseButon, (ItemStack)null);
                        slot2.putStack(itemstack3);
                    }
                }
            }
            else if (function == 3 && entityPlayer.capabilities.isCreativeMode && inventoryplayer.getItemStack() == null && indexSlot >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(indexSlot);

                if (slot2 != null && slot2.getHasStack())
                {
                    itemstack3 = slot2.getStack().copy();
                    itemstack3.stackSize = itemstack3.getMaxStackSize();
                    inventoryplayer.setItemStack(itemstack3);
                }
            }
            else if (function == 4 && inventoryplayer.getItemStack() == null && indexSlot >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(indexSlot);

                if (slot2 != null && slot2.getHasStack() && slot2.canTakeStack(entityPlayer))
                {
                    itemstack3 = slot2.decrStackSize(mouseButon == 0 ? 1 : slot2.getStack().stackSize);
                    slot2.onPickupFromSlot(entityPlayer, itemstack3);
                    entityPlayer.dropPlayerItemWithRandomChoice(itemstack3, true);
                }
            }
            else if (function == 6 && indexSlot >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(indexSlot);
                itemstack3 = inventoryplayer.getItemStack();

                if (itemstack3 != null && (slot2 == null || !slot2.getHasStack() || !slot2.canTakeStack(entityPlayer)))
                {
                    i1 = mouseButon == 0 ? 0 : this.inventorySlots.size() - 1;
                    l1 = mouseButon == 0 ? 1 : -1;

                    for (int i2 = 0; i2 < 2; ++i2)
                    {
                        for (int j2 = i1; j2 >= 0 && j2 < this.inventorySlots.size() && itemstack3.stackSize < itemstack3.getMaxStackSize(); j2 += l1)
                        {
                            Slot slot3 = (Slot)this.inventorySlots.get(j2);

                            if (slot3.getHasStack() && func_94527_a(slot3, itemstack3, true) && slot3.canTakeStack(entityPlayer) && this.func_94530_a(itemstack3, slot3) && (i2 != 0 || slot3.getStack().stackSize != slot3.getStack().getMaxStackSize()))
                            {
                                int k1 = Math.min(itemstack3.getMaxStackSize() - itemstack3.stackSize, slot3.getStack().stackSize);
                                ItemStack itemstack2 = slot3.decrStackSize(k1);
                                itemstack3.stackSize += k1;

                                if (itemstack2.stackSize <= 0)
                                {
                                    slot3.putStack((ItemStack)null);
                                }

                                slot3.onPickupFromSlot(entityPlayer, itemstack2);
                            }
                        }
                    }
                }
                this.detectAndSendChanges();
            }
        }

        return itemstack;
    }

    @Override
    protected boolean mergeItemStack(ItemStack itemStack, int start, int end, boolean backward)
    {
    	/* Ici, on redéfinie la méthode en remplaçant simplement quelques condtions.
    	 * Dans la méthode de la classe Container mère on trouve un test  if (itemStack.isStackable()). 
    	 * La méthode isStackable() est définie comme : 
    	 * 	public boolean isStackable()
    		{
        		return this.getMaxStackSize() > 1 && (!this.isItemStackDamageable() || !this.isItemDamaged());
    		}
    	 * Il faut alors simplement faire sauter la partie getMaxStackSize() > 1. Le test devient donc 
    	 * if (!itemStack.isItemStackDamageable() || !itemStack.isItemDamaged())
    	 * 
    	 * Par la suite, il suffit simplement de remplacer les itemStack.getMaxStackSize() par 64 
    	 * car on ne peut stacker les objets que le coffre (Grace à la modification de la méthode transferStackInSlot
    	 */
    	
        boolean flag1 = false;
        int k = start;

        if (backward)
        {
            k = end - 1;
        }

        Slot slot;
        ItemStack itemstack1;

        if (!itemStack.isItemStackDamageable() || !itemStack.isItemDamaged())
        {
            while (itemStack.stackSize > 0 && (!backward && k < end || backward && k >= start))
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();
	                if (itemstack1 != null && itemstack1.getItem() == itemStack.getItem() && (!itemStack.getHasSubtypes() || itemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemStack, itemstack1))
	                {
	                    int l = itemstack1.stackSize + itemStack.stackSize;
	
	                    //if (l <= itemStack.getMaxStackSize())
		                if (l <= 64)
	                    {
	                        itemStack.stackSize = 0;
	                        itemstack1.stackSize = l;
	                        slot.onSlotChanged();
	                        flag1 = true;
	                    }
	                    //else if (itemstack1.stackSize < itemStack.getMaxStackSize())
		                else if (itemstack1.stackSize < 64)
	                    {
		                	//itemStack.stackSize -= itemStack.getMaxStackSize() - itemstack1.stackSize;
	                        //itemstack1.stackSize = itemStack.getMaxStackSize();
	                        itemStack.stackSize -= 64 - itemstack1.stackSize;
	                        itemstack1.stackSize = 64;
	                        slot.onSlotChanged();
	                        flag1 = true;
	                    }
	                }
	
	                if (backward)
	                {
	                    --k;
	                }
	                else
	                {
	                    ++k;
	                }
            }
        }

        if (itemStack.stackSize > 0)
        {
            if (backward)
            {
                k = end - 1;
            }
            else
            {
                k = start;
            }

            while (!backward && k < end || backward && k >= start)
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (itemstack1 == null)
                {
                    slot.putStack(itemStack.copy());
                    slot.onSlotChanged();
                    itemStack.stackSize = 0;
                    flag1 = true;
                    break;
                }

                if (backward)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }
        this.detectAndSendChanges();
        tileEntityBanque.updateTileEntity();
        return flag1;
    }
    
    @Override
    public void putStackInSlot(int index, ItemStack itemStack)
    {
        this.getSlot(index).putStack(itemStack);
        tileEntityBanque.updateTileEntity();
        this.detectAndSendChanges();
    }
}
