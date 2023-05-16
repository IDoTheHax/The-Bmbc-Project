package net.matty.bmbc.datagen;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.item.ModChemicalCompounds;
import net.matty.bmbc.item.ModFoodItems;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.ModMineralItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BetterMineBetterCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Register Item Models

        // 3D Printer Filaments
        simpleItem(ModItems.RED_PRINTER_FILAMENT);

        // 3D Printer Templates
        simpleItem(ModItems.SCREW_TEMPLATE);

        // Chem. Compounds
        simpleItem(ModChemicalCompounds.ALUMINA);
        simpleItem(ModChemicalCompounds.SILICA);

        // Fluids
        simpleItem(ModItems.LIQUID_HELIUM_BUCKET);
        simpleItem(ModItems.LIQUID_NITROGEN_BUCKET);
        simpleItem(ModItems.LIQUID_OXYGEN_BUCKET);
        simpleItem(ModItems.SEWAGE_WATER_BUCKET);
        simpleItem(ModItems.SODIUM_HYDROXIDE_BUCKET);

        // Foods
        simpleItem(ModFoodItems.COFFEE_BEANS);
        simpleItem(ModFoodItems.COFFEE_CHERRY);

        // Misc
        simpleItem(ModItems.BATTERY);
        simpleItem(ModItems.EIGHT_BALL);
        simpleItem(ModItems.CABLE_ROLL);
        saplingItem(ModBlocks.MAPLE_SAPLING);

        // Ores, Minerals and Ingots
        simpleItem(ModMineralItems.ALUMINIUM);
        simpleItem(ModMineralItems.BAUXITE);
        simpleItem(ModMineralItems.BERYLLIUM);
        simpleItem(ModMineralItems.BLACK_PHOSPHORUS);
        simpleItem(ModMineralItems.BORON);
        simpleItem(ModMineralItems.CALCIUM);
        simpleItem(ModMineralItems.CARNALLITE);
        simpleItem(ModMineralItems.DOLOMITE);
        simpleItem(ModMineralItems.EVAPORITE);
        simpleItem(ModMineralItems.LITHIUM);
        simpleItem(ModMineralItems.MAGNESITE);
        simpleItem(ModMineralItems.MAGNESIUM);
        simpleItem(ModMineralItems.PEGMATITE);
        simpleItem(ModMineralItems.PHOSPHORITE);
        simpleItem(ModMineralItems.POTASSIUM);
        simpleItem(ModMineralItems.RAW_SILVER);
        simpleItem(ModMineralItems.RED_PHOSPHORUS);
        simpleItem(ModMineralItems.SILICON_CRYSTAL);
        simpleItem(ModMineralItems.SILVER);
        simpleItem(ModMineralItems.SODIUM);
        simpleItem(ModMineralItems.SOLID_OXYGEN);
        simpleItem(ModMineralItems.SULFUR_POWDER);
        simpleItem(ModMineralItems.SULFUR_SOLID);
        simpleItem(ModMineralItems.WHITE_PHOSPHORUS);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterMineBetterCraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BetterMineBetterCraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
