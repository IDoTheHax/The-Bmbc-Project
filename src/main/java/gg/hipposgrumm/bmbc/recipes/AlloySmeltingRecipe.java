package gg.hipposgrumm.bmbc.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gg.hipposgrumm.bmbc.BMBC_Main;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class AlloySmeltingRecipe extends AbstractCookingRecipe {
    protected final ResourceLocation id;
    protected final NonNullList<Ingredient> ingredients;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;

    public AlloySmeltingRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack result, float experience, int cookingTime) {
        super(Type.INSTANCE, id, id.getPath(), CookingBookCategory.MISC, ingredients.get(0), result, experience, cookingTime);
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    @Override
    public boolean matches(Container inventory, Level level) {
        return this.ingredients.get(0).test(inventory.getItem(0));
    }

    public ItemStack assemble(Container container, RegistryAccess access) {
        return this.result.copy();
    }

    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return this.result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public float getExperience() {
        return this.experience;
    }

    public ItemStack getResultItem() {
        return this.result;
    }

    public String getGroup() {
        return getId().getPath();
    }

    public int getCookingTime() {
        return 0;
    }

    public ResourceLocation getId() {
        return id;
    }

    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public CookingBookCategory category() {
        return CookingBookCategory.MISC;
    }

    public RecipeSerializer<AlloySmeltingRecipe> getSerializer() {
        return BMBC_Main.ALLOY_SMELTING_SERIALIZER.get();
    }

    public static class Type implements RecipeType<AlloySmeltingRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "alloy_smelting";
    }

    public static class Serializer implements RecipeSerializer<AlloySmeltingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(BMBC_Main.MODID, "alloy_smelting");

        @Override
        public AlloySmeltingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            float exp = GsonHelper.getAsFloat(pSerializedRecipe, "experience", 0.0F);
            int cookTime = GsonHelper.getAsInt(pSerializedRecipe, "cookingtime", 32767);

            return new AlloySmeltingRecipe(pRecipeId, inputs, output, exp, cookTime);
        }

        @Override
        public AlloySmeltingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            float exp = buf.readFloat();
            int cookTime = buf.readInt();
            return new AlloySmeltingRecipe(id, inputs, output, exp, cookTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, AlloySmeltingRecipe recipe) {
            buf.writeInt(recipe.cookingTime);
            buf.writeFloat(recipe.experience);
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}