package net.matty.bmbc.fluid;

import com.mojang.math.Vector3f;
import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation HELIUM_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_helium");
    public static final ResourceLocation NITROGEN_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_nitrogen");
    public static final ResourceLocation SEWAGE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_sewage_water");
    public static final ResourceLocation SODIUM_HYDROXIDE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_sodium_hydroxide");


    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<FluidType> HELIUM_GAS_TYPE = register("helium_fluid",
            FluidType.Properties.create().lightLevel(2).density(-999999999).viscosity(5).temperature(-999999999).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, HELIUM_OVERLAY_RL,
            0xA1EAE5D8, new Vector3f(234f / 255f, 229f / 255f, 216f / 255f));

    public static final RegistryObject<FluidType> NITROGEN_FLUID_TYPE = register("nitrogen_fluid",
            FluidType.Properties.create().lightLevel(2).density(806).viscosity(1).temperature(-195).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, NITROGEN_OVERLAY_RL,
            0xA1D0D1F1, new Vector3f(208f / 255f, 209f / 255f, 241f / 255f));

    public static final RegistryObject<FluidType> SEWAGE_WATER_FLUID_TYPE = register("sewage_water_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, SEWAGE_OVERLAY_RL,
            0xA1E038D0, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f));

    public static final RegistryObject<FluidType> SODIUM_HYDROXIDE_FLUID_TYPE = register("sodium_hydroxide_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, SODIUM_HYDROXIDE_OVERLAY_RL,
            0xA1CACCCE, new Vector3f(69f / 255f, 69f / 255f, 69f / 255f));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties,
                                                      ResourceLocation still, ResourceLocation flowing,
                                                      ResourceLocation overlay, int color, Vector3f particleColor) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(still, flowing, overlay, color, particleColor, properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
