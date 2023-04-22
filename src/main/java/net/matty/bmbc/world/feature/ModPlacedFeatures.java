package net.matty.bmbc.world.feature;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BetterMineBetterCraft.MOD_ID);


    public static final RegistryObject<PlacedFeature> SILVER_ORE_DEPOSIT = PLACED_FEATURES.register("silver_ore_deposit",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(80),
                                    VerticalAnchor.absolute(384)))));

    public static final RegistryObject<PlacedFeature> BAUXITE_ORE_DEPOSIT = PLACED_FEATURES.register("bauxite_ore_deposit",
            () -> new PlacedFeature(ModConfiguredFeatures.BAUXITE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(80),
                                    VerticalAnchor.absolute(384)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}