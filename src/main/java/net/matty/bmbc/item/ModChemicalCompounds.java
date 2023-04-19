package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.custom.tooltips.MineralWithToolTipItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModChemicalCompounds {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Chemical Compounds
    public static final RegistryObject<Item> ALUMINA = ITEMS.register("alumina",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModChemicalCompoundsCreativeModeTab.CHEMICAL_COMPOUNDS), "Chem. Formula: ", "Al₂O₃"));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
