package net.matty.bmbc.block;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.custom.CoffeeCropBlock;
import net.matty.bmbc.block.custom.PressureVesselBlock;
import net.matty.bmbc.item.ModBlocksCreativeModeTab;
import net.matty.bmbc.item.ModResourcesCreativeModeTab;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.custom.SilverLampBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMineBetterCraft.MOD_ID);

    // Special Blocks
    public static final RegistryObject<Block> SILVER_LAMP = registerBlock("silver_lamp",
            () -> new SilverLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(SilverLampBlock.LIT) ? 15 : 0)), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    // Ores and its accomplices
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    // Crops
    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee_crop",
            () -> new CoffeeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> PRESSURE_VESSEL = registerBlock("pressure_vessel",
            () -> new PressureVesselBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModBlocksCreativeModeTab.BMBC_BLOCKS);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
