package gg.hipposgrumm.bmbc;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import gg.hipposgrumm.bmbc.items.CompoundItem;
import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public class BMBC_Main extends BetterMineBetterCraft {
    public static final String MODID = MOD_ID;
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // https://www.angelo.edu/faculty/kboudrea/periodic/physical_states.htm
    public static final Element HYDROGEN = ElementRegister.registerElement(new ResourceLocation(MODID, "hydrogen"), "H", -259.14, -252.87);
    public static final Element HELIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "helium"), "He", -272.2, -268.934);
    public static final Element LITHIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "lithium"), "Li", 180.54, 1347);
    public static final Element BERYLLIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "beryllium"), "Be", 1278, 2970);
    public static final Element BORON = ElementRegister.registerElement(new ResourceLocation(MODID, "boron"), "B", 2300, 3658);
    public static final Element CARBON = ElementRegister.registerElement(new ResourceLocation(MODID, "carbon"), "C", 3527, 4827);
    public static final Element NITROGEN = ElementRegister.registerElement(new ResourceLocation(MODID, "nitrogen"), "N", -209.86, -195.8);
    public static final Element OXYGEN = ElementRegister.registerElement(new ResourceLocation(MODID, "oxygen"), "O", -218.4, -182.96);
    public static final Element FLUORINE = ElementRegister.registerElement(new ResourceLocation(MODID, "fluorine"), "F", -219.62, -118.14);
    public static final Element NEON = ElementRegister.registerElement(new ResourceLocation(MODID, "neon"), "Ne", -248.67, -246.05);
    public static final Element SODIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "sodium"), "Na", 97.81, 882.9);
    public static final Element MAGNESIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "magnesium"), "Mg", 648.8, 1090);
    public static final Element ALUMINUM = ElementRegister.registerElement(new ResourceLocation(MODID, "aluminum"), "Al", 660.37, 2467);
    public static final Element SILICON = ElementRegister.registerElement(new ResourceLocation(MODID, "silicon"), "Si", 1410, 2355);
    public static final Element PHOSPHORUS = ElementRegister.registerElement(new ResourceLocation(MODID, "phosphorus"), "P", 44.1, 280);
    public static final Element SULFUR = ElementRegister.registerElement(new ResourceLocation(MODID, "sulfur"), "S", 130, 444.67);
    public static final Element CHLORINE = ElementRegister.registerElement(new ResourceLocation(MODID, "chlorine"), "Cl", -100.98, -33.97);
    public static final Element ARGON = ElementRegister.registerElement(new ResourceLocation(MODID, "argon"), "Ar", -189.37, -185.86);
    public static final Element POTASSIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "potassium"), "K", 63.65, 774);
    public static final Element CALCIUM = ElementRegister.registerElement(new ResourceLocation(MODID, "calcium"), "Ca", 839, 1484);

    public static final RegistryObject<Item> CONTAINED_HYDROGEN = ITEMS.register("contained_hydrogen", () -> new CompoundItem(new Item.Properties(), HYDROGEN));
    public static final RegistryObject<Item> CONTAINED_HELIUM = ITEMS.register("contained_helium", () -> new CompoundItem(new Item.Properties(), HELIUM));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new CompoundItem(new Item.Properties(), LITHIUM));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new CompoundItem(new Item.Properties(), BERYLLIUM));
    public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new CompoundItem(new Item.Properties(), BORON));
    public static final RegistryObject<Item> CARBON_INGOT = ITEMS.register("carbon_ingot", () -> new CompoundItem(new Item.Properties(), CARBON));
    public static final RegistryObject<Item> CONTAINED_NITROGEN = ITEMS.register("contained_nitrogen", () -> new CompoundItem(new Item.Properties(), NITROGEN));
    public static final RegistryObject<Item> CONTAINED_OXYGEN = ITEMS.register("contained_oxygen", () -> new CompoundItem(new Item.Properties(), OXYGEN));
    public static final RegistryObject<Item> CONTAINED_FLUORINE = ITEMS.register("contained_fluorine", () -> new CompoundItem(new Item.Properties(), FLUORINE));
    public static final RegistryObject<Item> CONTAINED_NEON = ITEMS.register("contained_neon", () -> new CompoundItem(new Item.Properties(), NEON));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new CompoundItem(new Item.Properties(), SODIUM));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new CompoundItem(new Item.Properties(), MAGNESIUM));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new CompoundItem(new Item.Properties(), ALUMINUM));
    public static final RegistryObject<Item> SILICON_INGOT = ITEMS.register("silicon_ingot", () -> new CompoundItem(new Item.Properties(), SILICON));
    public static final RegistryObject<Item> PHOSPHORUS_INGOT = ITEMS.register("phosphorus_ingot", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS));
    public static final RegistryObject<Item> SULFUR_INGOT = ITEMS.register("sulfur_ingot", () -> new CompoundItem(new Item.Properties(), SULFUR));
    public static final RegistryObject<Item> CONTAINED_CHLORINE = ITEMS.register("contained_chlorine", () -> new CompoundItem(new Item.Properties(), CHLORINE));
    public static final RegistryObject<Item> CONTAINED_ARGON = ITEMS.register("contained_argon", () -> new CompoundItem(new Item.Properties(), ARGON));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new CompoundItem(new Item.Properties(), POTASSIUM));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new CompoundItem(new Item.Properties(), CALCIUM));
}
