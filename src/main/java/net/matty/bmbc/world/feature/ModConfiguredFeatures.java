package net.matty.bmbc.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModOreBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BetterMineBetterCraft.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModOreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BAUXITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.BAUXITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CARNALLITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.CARNALLITE_ORE.get().defaultBlockState())
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_TUFF, ModOreBlocks.CARNALLITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DOLOMITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.DOLOMITE_ORE.get().defaultBlockState())
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_TUFF, ModOreBlocks.DOLOMITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EVAPORITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.EVAPORITE_ORE.get().defaultBlockState())
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_TUFF, ModOreBlocks.EVAPORITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.MAGNESITE_ORE.get().defaultBlockState())
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_TUFF, ModOreBlocks.MAGNESITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PEGMATITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.PEGMATITE_ORE.get().defaultBlockState())
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_TUFF, ModOreBlocks.PEGMATITE_ORE.get().defaultBlockState()),
            //OreConfiguration.target((RuleTest) OreFeatures.ORE_GRANITE, ModOreBlocks.PEGMATITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PHOSPHORITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModOreBlocks.PHOSPHORITE_ORE.get().defaultBlockState())
            //OreConfiguration.target(OreFeatures.ORE_TUFF, ModOreBlocks.PHOSPHORITE_ORE.get().defaultBlockState())
    ));


    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_ORE = CONFIGURED_FEATURES.register("silver_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES.get(),26)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BAUXITE_ORE = CONFIGURED_FEATURES.register("bauxite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BAUXITE_ORES.get(),26)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CARNALLITE_ORE = CONFIGURED_FEATURES.register("carnallite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CARNALLITE_ORES.get(),5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DOLOMITE_ORE = CONFIGURED_FEATURES.register("dolomite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_DOLOMITE_ORES.get(),7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EVAPORITE_ORE = CONFIGURED_FEATURES.register("evaporite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_EVAPORITE_ORES.get(),6)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAGNESITE_ORE = CONFIGURED_FEATURES.register("magnesite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESITE_ORES.get(),8)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PEGMATITE_ORE = CONFIGURED_FEATURES.register("pegmatite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PEGMATITE_ORES.get(),16)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PHOSPHORITE_ORE = CONFIGURED_FEATURES.register("phosphorite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PHOSPHORITE_ORES.get(),16)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
