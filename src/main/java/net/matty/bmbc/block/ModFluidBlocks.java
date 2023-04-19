package net.matty.bmbc.block;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFluidBlocks {
    public static final DeferredRegister<Block> FLUID_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<LiquidBlock> HELIUM_BLOCK = FLUID_BLOCKS.register("helium_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HELIUM, BlockBehaviour.Properties.copy(Blocks.WATER).air()));

    public static final RegistryObject<LiquidBlock> NITROGEN_BLOCK = FLUID_BLOCKS.register("nitrogen_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NITROGEN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER).air()));

    public static final RegistryObject<LiquidBlock> OXYGEN_BLOCK = FLUID_BLOCKS.register("oxygen_block",
            () -> new LiquidBlock(ModFluids.SOURCE_OXYGEN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER).air()));

    public static final RegistryObject<LiquidBlock> SEWAGE_WATER_BLOCK = FLUID_BLOCKS.register("sewage_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SEWAGE_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> SODIUM_HYDROXIDE_BLOCK = FLUID_BLOCKS.register("sodium_hydroxide_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SODIUM_HYDROXIDE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = FLUID_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        FLUID_BLOCKS.register(eventBus);
    }
}
