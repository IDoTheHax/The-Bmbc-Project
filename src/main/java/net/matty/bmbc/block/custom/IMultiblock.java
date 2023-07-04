package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public interface IMultiblock {

    void isComplete();
    HashMap<Block, BlockPos> getBlocks();
}
