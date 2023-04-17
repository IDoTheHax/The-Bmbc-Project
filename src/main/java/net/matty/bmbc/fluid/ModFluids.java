package net.matty.bmbc.fluid;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_SEWAGE_WATER = FLUIDS.register("sewage_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SEWAGE_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SEWAGE_WATER = FLUIDS.register("flowing_sewage_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SEWAGE_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SODIUM_HYDROXIDE = FLUIDS.register("sodium_hydroxide_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SODIUM_HYDROXIDE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SODIUM_HYDROXIDE = FLUIDS.register("sodium_hydroxide_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SODIUM_HYDROXIDE_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SEWAGE_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SEWAGE_WATER_FLUID_TYPE, SOURCE_SEWAGE_WATER, FLOWING_SEWAGE_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.SEWAGE_WATER_BLOCK)
            .bucket(ModItems.SEWAGE_WATER_BUCKET);

    public static final ForgeFlowingFluid.Properties SODIUM_HYDROXIDE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SODIUM_HYDROXIDE_FLUID_TYPE, SOURCE_SODIUM_HYDROXIDE, FLOWING_SODIUM_HYDROXIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.SODIUM_HYDROXIDE_BLOCK)
            .bucket(ModItems.SODIUM_HYDROXIDE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
