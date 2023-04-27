package net.matty.bmbc.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModOreBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("overworld_silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BAUXITE_ORE_KEY = registerKey("overworld_bauxite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CARNALLITE_ORE_KEY = registerKey("overworld_carnallite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DOLOMITE_ORE_KEY = registerKey("overworld_dolomite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EVAPORITE_ORE_KEY = registerKey("overworld_evaporite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGNESITE_ORE_KEY = registerKey("overworld_magnesite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PEGMATITE_ORE_KEY = registerKey("overworld_pegmatite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PHOSPHORITE_ORE_KEY = registerKey("overworld_phosphorite_ore");

    //public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_GEODE_KEY = registerKey("zircon_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        // register keys
        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES.get(), 26));
        register(context, OVERWORLD_BAUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_BAUXITE_ORES.get(), 26));
        register(context, OVERWORLD_CARNALLITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_CARNALLITE_ORES.get(), 8));
        register(context, OVERWORLD_DOLOMITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_DOLOMITE_ORES.get(), 10));
        register(context, OVERWORLD_EVAPORITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_EVAPORITE_ORES.get(), 9));
        register(context, OVERWORLD_MAGNESITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESITE_ORES.get(), 11));
        register(context, OVERWORLD_PEGMATITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_PEGMATITE_ORES.get(), 11));
        register(context, OVERWORLD_PHOSPHORITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_PHOSPHORITE_ORES.get(), 11));

    }

    // Ore configuration
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModOreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BAUXITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.BAUXITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CARNALLITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.CARNALLITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DOLOMITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.DOLOMITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EVAPORITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.EVAPORITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.MAGNESITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PEGMATITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.PEGMATITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PHOSPHORITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModOreBlocks.PHOSPHORITE_ORE.get().defaultBlockState())
    ));

    private static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BetterMineBetterCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
