package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RadioactiveBlock extends Block {
    public RadioactiveBlock(Properties properties) {
        super(properties);
    }

    public void randomTick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource source) {
        if (!level.isAreaLoaded(blockPos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
        if (level.getMaxLocalRawBrightness(blockPos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for(int i = 0; i < 4; ++i) {
                BlockPos blockpos = blockPos.offset(source.nextInt(3) - 1, source.nextInt(5) - 3, source.nextInt(3) - 1);
            }
        }
    }
}
