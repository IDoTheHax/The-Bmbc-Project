package gg.hipposgrumm.bmbc.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class AlloyFurnaceBlockEntityRenderer implements BlockEntityRenderer<AlloyFurnaceBlockEntity> {
    public AlloyFurnaceBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(AlloyFurnaceBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        switch (pBlockEntity.getBlockState().getValue(AlloyFurnaceBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(0));
            case EAST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
            case SOUTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
            case WEST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
        }
    }
}
