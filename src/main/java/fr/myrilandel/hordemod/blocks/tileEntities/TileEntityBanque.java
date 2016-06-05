package fr.myrilandel.hordemod.blocks.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityBanque extends TileEntity implements IInventory{

    public ItemStack[] contents = new ItemStack[90];
    private String customName;
 
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        this.contents = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;
            if(j >= 0 && j < this.contents.length)
                this.contents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1); 
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound); 
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < this.contents.length; ++i) 
            if(this.contents[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound(); 
                nbttagcompound1.setByte("Slot", (byte)i); 
                this.contents[i].writeToNBT(nbttagcompound1); 
                nbttaglist.appendTag(nbttagcompound1);
            }
        compound.setTag("Items", nbttaglist);
    }
	
	@Override
	public int getSizeInventory() {
        return this.contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.contents[index];
	}

    @Override
    public ItemStack decrStackSize(int index, int amount)
    {
        if(this.contents[index] != null) {
            ItemStack itemstack;
            if(this.contents[index].stackSize <= amount) {
                itemstack = this.contents[index]; 
                this.contents[index] = null;
                this.updateTileEntity();
                return itemstack;
            }
            else {
                itemstack = this.contents[index].splitStack(amount); 
                if(this.contents[index].stackSize == 0)
                	this.contents[index] = null; 
                this.updateTileEntity();
                return itemstack;
            }
        }
        return null;
    }

	public ItemStack[] getContent() {
		return contents;
	}
    
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
        if(this.contents[index] != null) {
            ItemStack itemstack = this.contents[index];
            this.contents[index] = null;
            this.updateTileEntity();
            return itemstack;
        }
        return null;
	}

	@Override
    public void setInventorySlotContents(int index, ItemStack itemStack) {
        this.contents[index] = itemStack;
        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
            itemStack.stackSize = this.getInventoryStackLimit();

        this.updateTileEntity();
    }

	@Override
	public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "tile.banque";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? 
				false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack itemStack) {
		return true;
	}
	
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
	
	public void updateTileEntity() {
    	this.worldObj.scheduledUpdatesAreImmediate = true;
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        this.updateContainingBlockInfo();
        this.updateEntity();
	}
	
}

