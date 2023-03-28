package net.matty.bmbc.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModResourcesCreativeModeTab {
    public static final CreativeModeTab ORES_AND_MINERALS = new CreativeModeTab("ores_and_minerals") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModMineralItems.SILVER.get());
        }
    };
}
