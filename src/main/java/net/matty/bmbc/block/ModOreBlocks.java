package net.matty.bmbc.block;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModBlocksCreativeModeTab;
import net.matty.bmbc.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModOreBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMineBetterCraft.MOD_ID);

    // Ores and its accomplices
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock(
            "bauxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> CARNALLITE_ORE = registerBlock(
            "carnallite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.0F, 2.0F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> DOLOMITE_ORE = registerBlock(
            "dolomite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.7F, 2.8F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> EVAPORITE_ORE = registerBlock(
            "evaporite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.4F, 2.2F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> MAGNESITE_ORE = registerBlock(
            "magnesite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.6F, 3.25F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> PEGMATITE_ORE = registerBlock(
            "pegmatite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.5F, 2.75F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> PHOSPHORITE_ORE = registerBlock(
            "phosphorite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.6F, 3.25F)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> SILVER_ORE = registerBlock(
            "silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock(
            "deepslate_silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)),
            ModBlocksCreativeModeTab.BMBC_BLOCKS);

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
