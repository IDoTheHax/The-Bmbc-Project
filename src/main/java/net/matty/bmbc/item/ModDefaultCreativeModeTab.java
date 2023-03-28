package net.matty.bmbc.item;

import net.matty.bmbc.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModDefaultCreativeModeTab {
    public static final CreativeModeTab BMBC = new CreativeModeTab("bmbc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EIGHT_BALL.get());
        }
    };
}
