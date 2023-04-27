package net.matty.bmbc;

import com.mojang.logging.LogUtils;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.block.ModOreBlocks;
import net.matty.bmbc.block.entity.ModBlockEntities;
import net.matty.bmbc.creativemode_tab.*;
import net.matty.bmbc.fluid.ModFluidTypes;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.ModChemicalCompounds;
import net.matty.bmbc.item.ModFoodItems;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.ModMineralItems;
import net.matty.bmbc.loot.ModLootModifiers;
import net.matty.bmbc.networking.ModNetworkingPackets;
import net.matty.bmbc.recipe.ModRecipes;
import net.matty.bmbc.screen.ModMenuTypes;
import net.matty.bmbc.screen.PressureVesselScreen;
import net.matty.bmbc.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterMineBetterCraft.MOD_ID)
public class BetterMineBetterCraft {
    public static final String MOD_ID = "bmbc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BetterMineBetterCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModMineralItems.register(modEventBus);
        ModFoodItems.register(modEventBus);
        ModChemicalCompounds.register(modEventBus);

        ModFluidBlocks.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModOreBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModResourcesCreativeModeTab.BMBC_RESOURCES) {
            event.accept(ModMineralItems.ALUMINIUM);
            event.accept(ModMineralItems.BAUXITE);
            event.accept(ModMineralItems.BERYLLIUM);
            event.accept(ModMineralItems.BORON);
            event.accept(ModMineralItems.CALCIUM);
            event.accept(ModMineralItems.LITHIUM);
            event.accept(ModMineralItems.MAGNESIUM);
            event.accept(ModMineralItems.WHITE_PHOSPHORUS);
            event.accept(ModMineralItems.RED_PHOSPHORUS);
            event.accept(ModMineralItems.BLACK_PHOSPHORUS);
            event.accept(ModMineralItems.POTASSIUM);
            event.accept(ModMineralItems.SILICON_CRYSTAL);
            event.accept(ModMineralItems.SILVER);
            event.accept(ModMineralItems.SODIUM);
            event.accept(ModMineralItems.SOLID_OXYGEN);
            event.accept(ModMineralItems.SULFUR_SOLID);
            event.accept(ModMineralItems.SULFUR_POWDER);
            event.accept(ModMineralItems.CARNALLITE);
            event.accept(ModMineralItems.DOLOMITE);
            event.accept(ModMineralItems.EVAPORITE);
            event.accept(ModMineralItems.MAGNESITE);
            event.accept(ModMineralItems.PEGMATITE);
            event.accept(ModMineralItems.PHOSPHORITE);
            event.accept(ModMineralItems.BAUXITE);
            event.accept(ModMineralItems.RAW_SILVER);
        }
        
        if (event.getTab() == ModBlocksCreativeModeTab.BMBC_BLOCKS) {
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_LAMP);
            event.accept(ModBlocks.PRESSURE_VESSEL);
            event.accept(ModOreBlocks.BAUXITE_ORE);
            event.accept(ModOreBlocks.CARNALLITE_ORE);
            event.accept(ModOreBlocks.DOLOMITE_ORE);
            event.accept(ModOreBlocks.EVAPORITE_ORE);
            event.accept(ModOreBlocks.MAGNESITE_ORE);
            event.accept(ModOreBlocks.PEGMATITE_ORE);
            event.accept(ModOreBlocks.PHOSPHORITE_ORE);
            event.accept(ModOreBlocks.SILVER_ORE);
            event.accept(ModOreBlocks.DEEPSLATE_SILVER_ORE);
        }
        
        if (event.getTab() == ModChemicalCompoundsCreativeModeTab.CHEMICAL_COMPOUNDS) {
            event.accept(ModChemicalCompounds.ALUMINA);
            event.accept(ModChemicalCompounds.SILICA);
        }

        if (event.getTab() == ModDefaultCreativeModeTab.BMBC) {
            event.accept(ModItems.BATTERY);
            event.accept(ModItems.EIGHT_BALL);
        }

        if (event.getTab() == ModFoodCreativeModTab.FOOD) {
            event.accept(ModFoodItems.COFFEE_CHERRY);
            event.accept(ModFoodItems.COFFEE_BEANS);
        }

        if (event.getTab() == ModFluidsCreativeModeTab.BMBC_FLUIDS) {
            event.accept(ModItems.LIQUID_HELIUM_BUCKET);
            event.accept(ModItems.LIQUID_NITROGEN_BUCKET);
            event.accept(ModItems.LIQUID_OXYGEN_BUCKET);
            event.accept(ModItems.SEWAGE_WATER_BUCKET);
            event.accept(ModItems.SODIUM_HYDROXIDE_BUCKET);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModNetworkingPackets.register();
            ModVillagers.registerPOIs();
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SEWAGE_WATER.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SEWAGE_WATER.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SODIUM_HYDROXIDE.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SODIUM_HYDROXIDE.get(), RenderType.solid());

            MenuScreens.register(ModMenuTypes.PRESSURE_VESSEL_MENU.get(), PressureVesselScreen::new);
        }
    }
}
