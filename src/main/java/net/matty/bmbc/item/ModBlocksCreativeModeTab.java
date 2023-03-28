package net.matty.bmbc.item;

import net.matty.bmbc.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModBlocksCreativeModeTab {
    public static final CreativeModeTab BMBC_BLOCKS = new CreativeModeTab("bmbc_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SILVER_BLOCK.get());
        }
    };
}

