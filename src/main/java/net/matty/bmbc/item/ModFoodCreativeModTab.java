package net.matty.bmbc.item;

import net.matty.bmbc.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModFoodCreativeModTab {
    public static final CreativeModeTab BMBC_FOODS = new CreativeModeTab("bmbc_foods") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModFoodItems.COFFEE_CHERRY.get());
        }
    };
}
