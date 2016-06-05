package fr.myrilandel.hordemod.gui;

import org.lwjgl.opengl.GL11;

import fr.myrilandel.hordemod.HordeMod;
import fr.myrilandel.hordemod.blocks.tileEntities.TileEntityBanque;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUIBanque extends GuiContainer{

    private static final ResourceLocation textures = new ResourceLocation(HordeMod.MODID, "textures/gui/container/banque.png");
    private TileEntityBanque tileEntityBanque;
    private IInventory inventoryPlayer;

	public GUIBanque(TileEntityBanque tileEntityBanque, InventoryPlayer inventoryPlayer) {
        super(new ContainerBanque(tileEntityBanque, inventoryPlayer));
        this.tileEntityBanque = tileEntityBanque;
        this.inventoryPlayer = inventoryPlayer;
        this.allowUserInput = false;
        this.ySize = 290;
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		String tileName = this.tileEntityBanque.hasCustomInventoryName() ? this.tileEntityBanque.getInventoryName() : I18n.format(this.tileEntityBanque.getInventoryName());
        this.fontRendererObj.drawString(tileName, (this.xSize - this.fontRendererObj.getStringWidth(tileName)) / 2, 6, 0);
        String invName = this.inventoryPlayer.hasCustomInventoryName() ? this.inventoryPlayer.getInventoryName() : I18n.format(this.inventoryPlayer.getInventoryName());
        this.fontRendererObj.drawString(invName, (this.xSize - this.fontRendererObj.getStringWidth(invName)) / 2, this.ySize , 0);		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
        this.mc.getTextureManager().bindTexture(textures); 
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);		
	}
}
