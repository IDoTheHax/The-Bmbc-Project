package net.matty.bmbc.datagen;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        blockWithItem(ModBlocks.BAUXITE_ORE);
        blockWithItem(ModBlocks.CARNALLITE_ORE);
        blockWithItem(ModBlocks.DOLOMITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlocks.EVAPORITE_ORE);
        blockWithItem(ModBlocks.MAGNESITE_ORE);
        blockWithItem(ModBlocks.PEGMATITE_ORE);
        blockWithItem(ModBlocks.PHOSPHORITE_ORE);

    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
