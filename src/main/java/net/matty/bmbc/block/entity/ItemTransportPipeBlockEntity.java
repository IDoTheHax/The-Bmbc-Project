package net.matty.bmbc.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class ItemTransportPipeBlockEntity extends BlockEntity {

    public ItemTransportPipeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ITEM_TRANSPORT_PIPE.get(), pos, state);
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        // Save any additional data to the tag
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        // Load any additional data from the tag
    }
}