package net.matty.bmbc.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModChemicalCompoundsCreativeModeTab {
    public static final CreativeModeTab CHEMICAL_COMPOUNDS = new CreativeModeTab("chemical_compounds") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModChemicalCompounds.ALUMINA.get());
        }
    };
}
