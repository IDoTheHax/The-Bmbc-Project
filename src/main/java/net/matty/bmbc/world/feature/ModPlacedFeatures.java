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
                    commonOrePlacement(18, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(80), // lowest
                                    VerticalAnchor.absolute(384))))); // highest

    public static final RegistryObject<PlacedFeature> BAUXITE_ORE_DEPOSIT = PLACED_FEATURES.register("bauxite_ore_deposit",
            () -> new PlacedFeature(ModConfiguredFeatures.BAUXITE_ORE.getHolder().get(),
                    commonOrePlacement(18, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(80), // lowest
                                    VerticalAnchor.absolute(384))))); // highest

    public static final RegistryObject<PlacedFeature> CARNALLITE_ORE = PLACED_FEATURES.register("carnallite_ore_placed", // TODO: figure out how to get this generate in shallow water
            () -> new PlacedFeature(ModConfiguredFeatures.CARNALLITE_ORE.getHolder().get(),
                    commonOrePlacement(14, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(62), // lowest
                                    VerticalAnchor.absolute(70))))); // highest

    public static final RegistryObject<PlacedFeature> DOLOMITE_ORE = PLACED_FEATURES.register("dolomite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DOLOMITE_ORE.getHolder().get(),
                    commonOrePlacement(18, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(20), // lowest
                                    VerticalAnchor.absolute(384))))); // highest

    public static final RegistryObject<PlacedFeature> EVAPORITE_ORE = PLACED_FEATURES.register("evaporite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.EVAPORITE_ORE.getHolder().get(),
                    commonOrePlacement(22, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-34), // lowest
                                    VerticalAnchor.absolute(70))))); // highest

    public static final RegistryObject<PlacedFeature> MAGNESITE_ORE = PLACED_FEATURES.register("magnesite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MAGNESITE_ORE.getHolder().get(),
                    commonOrePlacement(16, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), // lowest
                                    VerticalAnchor.absolute(384))))); // highest

    public static final RegistryObject<PlacedFeature> PEGMATITE_ORE = PLACED_FEATURES.register("pegmatite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PEGMATITE_ORE.getHolder().get(),
                    rareOrePlacement(18, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), // lowest
                                    VerticalAnchor.absolute(384))))); // highest

    public static final RegistryObject<PlacedFeature> PHOSPHORITE_ORE = PLACED_FEATURES.register("phosphorite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PHOSPHORITE_ORE.getHolder().get(),
                    rareOrePlacement(18, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), // lowest
                                    VerticalAnchor.absolute(384))))); // highest



    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}