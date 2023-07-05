package gg.hipposgrumm.bmbc.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import gg.hipposgrumm.bmbc.BMBC_Main;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlloyFurnaceScreen extends AbstractContainerScreen<AlloyFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(BMBC_Main.MODID, "textures/gui/alloy_furnace.png");

    public AlloyFurnaceScreen(AlloyFurnaceMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialtick, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        //if (this.menu..isLit()) {
        //    int k = this.menu.getLitProgress();
        //    blit(poseStack, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        //}

        //int l = this.menu.getBurnProgress();
        //blit(poseStack, i + 79, j + 34, 176, 14, l + 1, 16);
    }
}
