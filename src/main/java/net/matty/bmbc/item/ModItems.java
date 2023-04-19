package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.custom.BatteryItem;
import net.matty.bmbc.item.custom.EightBallItem;
import net.matty.bmbc.item.custom.tooltips.BucketItemWithToolTip;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Special or Custom Items
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
            () -> new BatteryItem(new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC)));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC)));

    public static final RegistryObject<Item> HELIUM_BUCKET = ITEMS.register("helium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HELIUM,
                    new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> LIQUID_NITROGEN_BUCKET = ITEMS.register("nitrogen_bucket",
            () -> new BucketItemWithToolTip(ModFluids.SOURCE_NITROGEN_FLUID,
                    new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC).craftRemainder(Items.BUCKET).stacksTo(1)
                    , "Chem. Formula: ", "LN₂"));

    public static final RegistryObject<Item> SEWAGE_WATER_BUCKET = ITEMS.register("sewage_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SEWAGE_WATER,
                    new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SODIUM_HYDROXIDE_BUCKET = ITEMS.register("sodium_hydroxide_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SODIUM_HYDROXIDE,
                    new Item.Properties().tab(ModDefaultCreativeModeTab.BMBC).craftRemainder(Items.BUCKET).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
