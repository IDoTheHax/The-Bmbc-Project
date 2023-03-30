package net.matty.bmbc.intergration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.recipe.PressureVesselRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIBetterMineBetterCraftPlugin implements IModPlugin {
    public static RecipeType<PressureVesselRecipe> DIGESTION_TYPE =
            new RecipeType<>(PressureVesselRecipeCategory.UID, PressureVesselRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BetterMineBetterCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                PressureVesselRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<PressureVesselRecipe> recipesDigestion = rm.getAllRecipesFor(PressureVesselRecipe.Type.INSTANCE);
        registration.addRecipes(DIGESTION_TYPE, recipesDigestion);
    }
}
