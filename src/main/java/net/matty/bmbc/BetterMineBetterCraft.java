package net.matty.bmbc;

import com.mojang.logging.LogUtils;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.block.entity.ModBlockEntities;
import net.matty.bmbc.fluid.ModFluidTypes;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.ModChemicalCompounds;
import net.matty.bmbc.item.ModFoodItems;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.ModMineralItems;
import net.matty.bmbc.networking.ModNetworkingPackets;
import net.matty.bmbc.recipe.ModRecipes;
import net.matty.bmbc.screen.ModMenuTypes;
import net.matty.bmbc.screen.PressureVesselScreen;
import net.matty.bmbc.villager.ModVillagers;
import net.matty.bmbc.world.feature.ModConfiguredFeatures;
import net.matty.bmbc.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
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
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
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

            MenuScreens.register(ModMenuTypes.PRESSURE_VESSEL_MENU.get(), PressureVesselScreen::new);
        }
    }
}
