package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.custom.tooltips.MineralWithToolTipItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMineralItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Ingots and their raw variants
    public static final RegistryObject<Item> ALUMINIUM = ITEMS.register("aluminium_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "Al"));

    public static final RegistryObject<Item> BERYLLIUM = ITEMS.register("beryllium_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "Be"));

    public static final RegistryObject<Item> BORON = ITEMS.register("boron_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "B"));

    public static final RegistryObject<Item> LITHIUM = ITEMS.register("lithium_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "Li"));

    public static final RegistryObject<Item> SILVER = ITEMS.register("silver_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "Ag"));

    public static final RegistryObject<Item> BAUXITE = ITEMS.register("raw_bauxite",
            () -> new MineralWithToolTipItem(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)
                    ,"Chem. Formula: ", "Al₂H₂O₄"));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModResourcesCreativeModeTab.ORES_AND_MINERALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
