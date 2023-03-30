package net.matty.bmbc.recipe;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PressureVesselRecipe>> DIGESTION_SERIALIZER =
            SERIALIZERS.register("digestion", () -> PressureVesselRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
