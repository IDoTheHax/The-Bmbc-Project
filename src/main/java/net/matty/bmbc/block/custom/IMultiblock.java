package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;

public interface IMultiblock {

    BlockPos position = null;
    void isComplete();
    HashMap<Block, BlockPos> getBlocks();

    default BlockState checkNeighbour(Direction direction) {
        return null;
    }
}
