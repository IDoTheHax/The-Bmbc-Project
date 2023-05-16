package net.matty.bmbc.datagen;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.custom.ThreeDPrinterBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BetterMineBetterCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_LAMP);
        blockWithItem(ModBlocks.PRESSURE_VESSEL);
        blockWithItem(ModBlocks.MACERATOR); // TODO: Change Later !!!
        generateThreeDPrinter(
                ModBlocks.THREE_D_PRINTER.get(),
                cube(ForgeRegistries.BLOCKS.getKey(ModBlocks.THREE_D_PRINTER.get()).getPath(),
                        new ResourceLocation("minecraft:cube"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_front"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_top")),
                cube(ForgeRegistries.BLOCKS.getKey(ModBlocks.THREE_D_PRINTER.get()).getPath() + "_on",
                        new ResourceLocation("minecraft:cube"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_sides"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_front_on"),
                        new ResourceLocation(BetterMineBetterCraft.MOD_ID,"block/3d_printer_top"))
        );

        blockWithItem(ModBlocks.BAUXITE_ORE);
        blockWithItem(ModBlocks.CARNALLITE_ORE);
        blockWithItem(ModBlocks.DOLOMITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlocks.EVAPORITE_ORE);
        blockWithItem(ModBlocks.MAGNESITE_ORE);
        blockWithItem(ModBlocks.PEGMATITE_ORE);
        blockWithItem(ModBlocks.PHOSPHORITE_ORE);
        blockWithItem(ModBlocks.SILVER_ORE);

        // Trees
        logBlock(((RotatedPillarBlock) ModBlocks.MAPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.MAPLE_WOOD.get(), blockTexture(ModBlocks.MAPLE_LOG.get()), blockTexture(ModBlocks.MAPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_LOG.get(), new ResourceLocation(BetterMineBetterCraft.MOD_ID, "block/stripped_maple_log"),
                new ResourceLocation(BetterMineBetterCraft.MOD_ID, "block/stripped_maple_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_WOOD.get(), new ResourceLocation(BetterMineBetterCraft.MOD_ID, "block/stripped_maple_log"),
                new ResourceLocation(BetterMineBetterCraft.MOD_ID, "block/stripped_maple_log"));

        blockWithItem(ModBlocks.MAPLE_PLANKS);
        blockWithItem(ModBlocks.MAPLE_LEAVES);
        saplingBlock(ModBlocks.MAPLE_SAPLING);

        simpleBlockItem(ModBlocks.MAPLE_LOG.get(), models().withExistingParent("bmbc:maple_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.MAPLE_WOOD.get(), models().withExistingParent("bmbc:maple_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAPLE_LOG.get(), models().withExistingParent("bmbc:stripped_maple_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAPLE_WOOD.get(), models().withExistingParent("bmbc:stripped_maple_wood", "minecraft:block/cube_column"));

    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void generateThreeDPrinter(Block block, ModelFile offModel, ModelFile onModel) {
        getVariantBuilder(block)
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.NORTH)
                .with(ThreeDPrinterBlock.ACTIVE, false)
                .modelForState()
                .modelFile(offModel).rotationX(0).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.SOUTH)
                .with(ThreeDPrinterBlock.ACTIVE, false)
                .modelForState()
                .modelFile(offModel).rotationX(180).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.EAST)
                .with(ThreeDPrinterBlock.ACTIVE, false)
                .modelForState()
                .modelFile(offModel).rotationX(90).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.WEST)
                .with(ThreeDPrinterBlock.ACTIVE, false)
                .modelForState()
                .modelFile(offModel).rotationX(270).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.NORTH)
                .with(ThreeDPrinterBlock.ACTIVE, true)
                .modelForState()
                .modelFile(onModel).rotationX(0).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.SOUTH)
                .with(ThreeDPrinterBlock.ACTIVE, true)
                .modelForState()
                .modelFile(onModel).rotationX(180).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.EAST)
                .with(ThreeDPrinterBlock.ACTIVE, true)
                .modelForState()
                .modelFile(onModel).rotationX(90).addModel()
                .partialState()
                .with(ThreeDPrinterBlock.FACING, Direction.WEST)
                .with(ThreeDPrinterBlock.ACTIVE, true)
                .modelForState()
                .modelFile(onModel).rotationX(270).addModel();

        simpleBlockItem(block, offModel);
    }

    public ModelFile cube(String name, ResourceLocation parent, ResourceLocation eastTexture, ResourceLocation westTexture, ResourceLocation northTexture, ResourceLocation southTexture, ResourceLocation frontTexture, ResourceLocation topTexture) {
        return models().withExistingParent(name, parent)
                .texture("east", eastTexture)
                .texture("west", westTexture)
                .texture("north", northTexture)
                .texture("south", southTexture)
                .texture("front", frontTexture)
                .texture("top", topTexture);
    }
}
