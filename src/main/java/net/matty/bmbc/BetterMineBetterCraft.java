package net.matty.bmbc;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.BMBC_Main;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.block.entity.ModBlockEntities;
import net.matty.bmbc.creativemode_tab.*;
import net.matty.bmbc.fluid.ModFluidTypes;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.*;
import net.matty.bmbc.loot.ModLootModifiers;
import net.matty.bmbc.networking.ModNetworkingPackets;
import net.matty.bmbc.recipe.ModRecipes;
import net.matty.bmbc.screen.*;
import net.matty.bmbc.screen.BiomassGeneratorScreen;
import net.matty.bmbc.sound.ModSounds;
import net.matty.bmbc.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
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

        ModArmorItems.register(modEventBus);
        ModItems.register(modEventBus);
        ModMineralItems.register(modEventBus);
        ModFoodItems.register(modEventBus);
        ModChemicalCompounds.register(modEventBus);
        ModMachineComponents.register(modEventBus);

        ModFluidBlocks.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        new BMBC_Main(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModResourcesCreativeModeTab.BMBC_RESOURCES) {
            //event.accept(ModMineralItems.ALUMINIUM);
            //event.accept(ModMineralItems.BAUXITE);
            //event.accept(ModMineralItems.BERYLLIUM);
            //event.accept(ModMineralItems.BORON);
            //event.accept(ModMineralItems.CALCIUM);
            //event.accept(ModMineralItems.CHROMIUM);
            //event.accept(ModMineralItems.GERMANIUM);
            //event.accept(ModMineralItems.LITHIUM);
            //event.accept(ModMineralItems.MAGNETIC_IRON_INGOT);
            //event.accept(ModMineralItems.MAGNESIUM);
            //event.accept(ModMineralItems.MANGANESE);
            //event.accept(ModMineralItems.WHITE_PHOSPHORUS);
            //event.accept(ModMineralItems.RED_PHOSPHORUS);
            //event.accept(ModMineralItems.BLACK_PHOSPHORUS);
            //event.accept(ModMineralItems.POTASSIUM);
            //event.accept(ModMineralItems.PURE_SILICON);
            //event.accept(ModMineralItems.SCANDIUM);
            //event.accept(ModMineralItems.SILICON_CRYSTAL);
            //event.accept(ModMineralItems.SILVER);
            //event.accept(ModMineralItems.SODIUM);
            //event.accept(ModMineralItems.SOLID_OXYGEN);
            //event.accept(ModMineralItems.SULFUR_SOLID);
            //event.accept(ModMineralItems.SULFUR_POWDER);
            //event.accept(ModMineralItems.CARNALLITE);
            //event.accept(ModMineralItems.DOLOMITE);
            //event.accept(ModMineralItems.EVAPORITE);
            //event.accept(ModMineralItems.MAGNESITE);
            //event.accept(ModMineralItems.PEGMATITE);
            //event.accept(ModMineralItems.PHOSPHORITE);
            //event.accept(ModMineralItems.BAUXITE);
            //event.accept(ModMineralItems.RAW_COBALT);
            //event.accept(ModMineralItems.RAW_SILVER);
            //event.accept(ModMineralItems.TITANIUM);
            //event.accept(ModMineralItems.VANADIUM);
            //event.accept(ModMineralItems.CRUSHED_BAUXITE);
        }
        
        if (event.getTab() == ModBlocksCreativeModeTab.BMBC_BLOCKS) {
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_LAMP);
            event.accept(ModBlocks.GARBAGE_BLOCK);

            // Ores
            event.accept(ModBlocks.BAUXITE_ORE);
            event.accept(ModBlocks.CARNALLITE_ORE);
            event.accept(ModBlocks.DOLOMITE_ORE);
            event.accept(ModBlocks.EVAPORITE_ORE);
            event.accept(ModBlocks.MAGNESITE_ORE);
            event.accept(ModBlocks.PEGMATITE_ORE);
            event.accept(ModBlocks.PHOSPHORITE_ORE);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);

            // Wood and Trees
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.MAPLE_PLANKS);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.MAPLE_WOOD);
            event.accept(ModBlocks.STRIPPED_MAPLE_LOG);
            event.accept(ModBlocks.STRIPPED_MAPLE_WOOD);

            // Nature
            event.accept(ModBlocks.SILICA_SAND);

        }

        if (event.getTab() == ModMachinesCreativeModeTab.BMBC_MACHINES) {
            //event.accept(ModBlocks.BIOMASS_GENERATOR);
            event.accept(ModBlocks.EXTRUDER);
            event.accept(ModBlocks.MACERATOR);
            event.accept(ModBlocks.PRESSURE_VESSEL);
            event.accept(ModBlocks.THREE_D_PRINTER);
        }
        
        if (event.getTab() == ModChemicalCompoundsCreativeModeTab.CHEMICAL_COMPOUNDS) {
            event.accept(ModChemicalCompounds.ALUMINA);
            event.accept(ModChemicalCompounds.SILICA);
        }

        if (event.getTab() == ModDefaultCreativeModeTab.BMBC) {
            event.accept(ModItems.BATTERY);
            event.accept(ModItems.BLUE_PRINTER_FILAMENT);
            event.accept(ModItems.C4_DETONATOR);
            event.accept(ModItems.CABLE_ROLL);
            event.accept(ModItems.COMPRESSED_CONTAINER);
            event.accept(ModItems.EIGHT_BALL);
            event.accept(ModItems.GREEN_PRINTER_FILAMENT);
            event.accept(ModItems.RED_PRINTER_FILAMENT);
            event.accept(ModItems.BLUE_PLASTIC_SCREW);
            event.accept(ModItems.GREEN_PLASTIC_SCREW);
            event.accept(ModItems.RED_PLASTIC_SCREW);
            event.accept(ModItems.ROD_TEMPLATE);
            event.accept(ModItems.SCREW_TEMPLATE);
            event.accept(ModItems.WIRE_TEMPLATE);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModItems.GARBAGE);

            event.accept(ModItems.PET_PLASTIC);
            event.accept(ModItems.PP_PLASTIC);
            event.accept(ModItems.PS_PLASTIC);
            event.accept(ModItems.PVC_PLASTIC);
            event.accept(ModItems.HDPE_PLASTIC);
            event.accept(ModItems.LDPE_PLASTIC);

            event.accept(ModItems.NBC_FABRIC);
            event.accept(ModArmorItems.NBC_HAZMAT_MASK);
            event.accept(ModArmorItems.NBC_HAZMAT_CHESTPLATE);
            event.accept(ModArmorItems.NBC_HAZMAT_LEGGINGS);
            event.accept(ModArmorItems.NBC_HAZMAT_BOOTS);

            // TODO: Potentially add Machine Component to its own creative mode tab
            event.accept(ModMachineComponents.COPPER_COIL);
            event.accept(ModMachineComponents.COPPER_FOIL);
            event.accept(ModMachineComponents.COPPER_WIRE);
            event.accept(ModMachineComponents.ELECTRIC_MOTOR);
            event.accept(ModMachineComponents.IRON_ROD);
            //event.accept(ModMineralItems.MAGNETIC_IRON_INGOT);
            event.accept(ModMachineComponents.MAGNETIC_IRON_ROD);

        }

        if (event.getTab() == ModFoodCreativeModTab.FOOD) {
            event.accept(ModFoodItems.COFFEE_CHERRY);
            event.accept(ModFoodItems.COFFEE_BEANS);
        }

        if (event.getTab() == ModFluidsCreativeModeTab.BMBC_FLUIDS) {
            event.accept(ModItems.ACETONE_BUCKET);
            event.accept(ModItems.BISPHENOL_BUCKET);
            event.accept(ModItems.CHLORINE_BUCKET);
            event.accept(ModItems.HYDROCHLORIC_ACID_BUCKET);
            event.accept(ModItems.LIQUID_HELIUM_BUCKET);
            event.accept(ModItems.LIQUID_NITROGEN_BUCKET);
            event.accept(ModItems.LIQUID_OXYGEN_BUCKET);
            event.accept(ModItems.PHENOL_BUCKET);
            event.accept(ModItems.PROPANE_BUCKET);
            event.accept(ModItems.SEWAGE_WATER_BUCKET);
            event.accept(ModItems.SODIUM_HYDROXIDE_BUCKET);
        }

        //if (event.getTab() == ExplosivesCreativeModeTab.BMBC_EXPLOSIVES) {
            //event.accept(ModBlocks.C4);
            //event.accept(ModItems.C4_DETONATOR);
        //}

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.SILICA_SAND);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModNetworkingPackets.register();
            //ModVillagers.registerPOIs();
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
            //ItemBlockRenderTypes.setRenderLayer(ModBlocks.C4.get(), RenderType.solid());

            MenuScreens.register(ModMenuTypes.BIOMASS_GENERATOR_MENU.get(), BiomassGeneratorScreen::new);
            MenuScreens.register(ModMenuTypes.EXTRUDER_MENU.get(), ExtruderScreen::new);
            MenuScreens.register(ModMenuTypes.MACERATOR_MENU.get(), MaceratorScreen::new);
            MenuScreens.register(ModMenuTypes.PRESSURE_VESSEL_MENU.get(), PressureVesselScreen::new);
            MenuScreens.register(ModMenuTypes.THREE_D_PRINTER_MENU.get(), ThreeDPrinterScreen::new);

        }
    }
}
