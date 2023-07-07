package net.matty.bmbc.datagen;

import gg.hipposgrumm.bmbc.BMBC_Main;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.item.*;
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
        simpleItem(ModItems.BLUE_PRINTER_FILAMENT);
        simpleItem(ModItems.GREEN_PRINTER_FILAMENT);

        // Templates
        simpleItem(ModItems.ROD_TEMPLATE);
        simpleItem(ModItems.SCREW_TEMPLATE);
        simpleItem(ModItems.WIRE_TEMPLATE);

        // 3D Printed Items
        simpleItem(ModItems.BLUE_PLASTIC_SCREW);
        simpleItem(ModItems.GREEN_PLASTIC_SCREW);
        simpleItem(ModItems.RED_PLASTIC_SCREW);

        // Chem. Compounds
        simpleItem(ModChemicalCompounds.ALUMINA);
        simpleItem(ModChemicalCompounds.SILICA);

        // Fluids
        simpleItem(ModItems.ACETONE_BUCKET);
        simpleItem(ModItems.BISPHENOL_BUCKET);
        simpleItem(ModItems.CHLORINE_BUCKET);
        simpleItem(ModItems.HYDROCHLORIC_ACID_BUCKET);
        simpleItem(ModItems.LIQUID_HELIUM_BUCKET);
        simpleItem(ModItems.LIQUID_NITROGEN_BUCKET);
        simpleItem(ModItems.LIQUID_OXYGEN_BUCKET);
        simpleItem(ModItems.PHENOL_BUCKET);
        simpleItem(ModItems.PROPANE_BUCKET);
        simpleItem(ModItems.SEWAGE_WATER_BUCKET);
        simpleItem(ModItems.SODIUM_HYDROXIDE_BUCKET);

        // Gases

        // Foods
        simpleItem(ModFoodItems.COFFEE_BEANS);
        simpleItem(ModFoodItems.COFFEE_CHERRY);

        // Misc
        simpleItem(ModItems.BATTERY);
        simpleItem(ModItems.C4_DETONATOR);
        simpleItem(ModItems.EIGHT_BALL);
        simpleItem(ModItems.CABLE_ROLL);
        saplingItem(ModBlocks.MAPLE_SAPLING);
        simpleItem(ModItems.GARBAGE);

        // Ores, Minerals and Ingots
        //simpleItem(ModMineralItems.ALUMINIUM);
        //simpleItem(ModMineralItems.BAUXITE);
        //simpleItem(ModMineralItems.BERYLLIUM);
        //simpleItem(ModMineralItems.BORON);
        //simpleItem(ModMineralItems.CALCIUM);
        //simpleItem(ModMineralItems.CARNALLITE);
        //simpleItem(ModMineralItems.CHROMIUM);
        //simpleItem(ModMineralItems.CRUSHED_BAUXITE);
        //simpleItem(ModMineralItems.DOLOMITE);
        //simpleItem(ModMineralItems.EVAPORITE);
        //simpleItem(ModMineralItems.MAGNETIC_IRON_INGOT);
        //simpleItem(ModMineralItems.GERMANIUM);
        //simpleItem(ModMineralItems.LITHIUM);
        //simpleItem(ModMineralItems.MAGNESITE);
        //simpleItem(ModMineralItems.MAGNESIUM);
        //simpleItem(ModMineralItems.MANGANESE);
        //simpleItem(ModMineralItems.PEGMATITE);
        //simpleItem(ModMineralItems.PHOSPHORITE);
        //simpleItem(ModMineralItems.PURE_SILICON);
        //simpleItem(ModMineralItems.POTASSIUM);
        //simpleItem(ModMineralItems.RAW_COBALT);
        //simpleItem(ModMineralItems.RAW_SILVER);
        //simpleItem(ModMineralItems.SCANDIUM);
        //simpleItem(ModMineralItems.SILICON_CRYSTAL);
        //simpleItem(ModMineralItems.SILVER);
        //simpleItem(ModMineralItems.SODIUM);
        //simpleItem(ModMineralItems.SOLID_OXYGEN);
        //simpleItem(ModMineralItems.SULFUR_POWDER);
        //simpleItem(ModMineralItems.SULFUR_SOLID);
        //simpleItem(ModMineralItems.TITANIUM);
        //simpleItem(ModMineralItems.VANADIUM);

        simpleItem(BMBC_Main.LITHIUM_INGOT);
        simpleItem(BMBC_Main.BERYLLIUM_INGOT);
        simpleItem(BMBC_Main.BORON_INGOT);
        simpleItem(BMBC_Main.CARBON_INGOT);
        simpleItem(BMBC_Main.SODIUM_INGOT);
        simpleItem(BMBC_Main.MAGNESIUM_INGOT);
        simpleItem(BMBC_Main.ALUMINIUM_INGOT);
        simpleItem(BMBC_Main.SILICON_CRYSTAL);
        simpleItem(BMBC_Main.WHITE_PHOSPHORUS);
        simpleItem(BMBC_Main.RED_PHOSPHORUS );
        simpleItem(BMBC_Main.BLACK_PHOSPHORUS);
        simpleItem(BMBC_Main.SULFUR_CRYSTAL);
        simpleItem(BMBC_Main.POTASSIUM_INGOT);
        simpleItem(BMBC_Main.CALCIUM_ROCK);
        simpleItem(BMBC_Main.SCANDIUM_INGOT);
        simpleItem(BMBC_Main.TITANIUM_INGOT);
        simpleItem(BMBC_Main.VANADIUM_INGOT);
        simpleItem(BMBC_Main.CHROMIUM_CRYSTAL);
        simpleItem(BMBC_Main.MANGANESE_INGOT);

        // Radiation
        simpleItem(ModItems.NBC_FABRIC);

        simpleItem(ModArmorItems.NBC_HAZMAT_BOOTS);
        simpleItem(ModArmorItems.NBC_HAZMAT_CHESTPLATE);
        simpleItem(ModArmorItems.NBC_HAZMAT_LEGGINGS);
        simpleItem(ModArmorItems.NBC_HAZMAT_MASK);

        // Plastic
        simpleItem(ModItems.PET_PLASTIC);
        simpleItem(ModItems.PP_PLASTIC);
        simpleItem(ModItems.PS_PLASTIC);
        simpleItem(ModItems.PVC_PLASTIC);
        simpleItem(ModItems.HDPE_PLASTIC);
        simpleItem(ModItems.LDPE_PLASTIC);
        simpleItem(ModItems.EPOXY_RESIN_FLUID);
        simpleItem(ModItems.PC_PLASTIC);

        // Alloys
        simpleItem(ModAlloyItems.BRASS);

        // Other materials
        simpleItem(ModItems.FIBERGLASS);

        // PCBs
        simpleItem(ModItems.PCB_LOW_GRADE_BLANK);
        simpleItem(ModItems.PCB_HIGH_GRADE_BLANK);

        // Machine components
        simpleItem(ModMachineComponents.COPPER_COIL);
        simpleItem(ModMachineComponents.COPPER_FOIL);
        simpleItem(ModMachineComponents.COPPER_WIRE);
        simpleItem(ModMachineComponents.ELECTRIC_MOTOR);
        simpleItem(ModMachineComponents.EPOXY_CIRCUIT_BOARD);
        simpleItem(ModMachineComponents.IRON_ROD);
        simpleItem(ModMachineComponents.MAGNETIC_IRON_ROD);

        for (RegistryObject<Item> itemToModel:BMBC_Main.doDatagen()) simpleItem(itemToModel);
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
