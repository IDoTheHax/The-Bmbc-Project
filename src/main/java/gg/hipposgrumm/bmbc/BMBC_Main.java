package gg.hipposgrumm.bmbc;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import gg.hipposgrumm.bmbc.items.CompoundItem;
import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public class BMBC_Main {
    public static final String MODID = BetterMineBetterCraft.MOD_ID;
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // https://www.angelo.edu/faculty/kboudrea/periodic/physical_states.htm
    public static final Element HYDROGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "hydrogen"), "H", 1), -259.14, -252.87);
    public static final Element HELIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "helium"), "He", 2), -272.2, -268.934);
    public static final Element LITHIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "lithium"), "Li", 3), 180.54, 1347);
    public static final Element BERYLLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "beryllium"), "Be", 4), 1278, 2970);
    public static final Element BORON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "boron"), "B", 5), 2300, 3658);
    public static final Element CARBON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "carbon"), "C", 6), 3527, 4827);
    public static final Element NITROGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "nitrogen"), "N", 7), -209.86, -195.8);
    public static final Element OXYGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "oxygen"), "O", 8), -218.4, -182.96);
    public static final Element FLUORINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "fluorine"), "F", 9), -219.62, -118.14);
    public static final Element NEON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "neon"), "Ne", 10), -248.67, -246.05);
    public static final Element SODIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "sodium"), "Na", 11), 97.81, 882.9);
    public static final Element MAGNESIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "magnesium"), "Mg", 12), 648.8, 1090);
    public static final Element ALUMINUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "aluminum"), "Al", 13), 660.37, 2467);
    public static final Element SILICON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "silicon"), "Si", 14), 1410, 2355);
    public static final Element PHOSPHORUS = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "phosphorus"), "P", 15), 44.1, 280);
    public static final Element SULFUR = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "sulfur"), "S", 16), 130, 444.67);
    public static final Element CHLORINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "chlorine"), "Cl", 17), -100.98, -33.97);
    public static final Element ARGON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "argon"), "Ar", 18), -189.37, -185.86);
    public static final Element POTASSIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "potassium"), "K", 19), 63.65, 774);
    public static final Element CALCIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "calcium"), "Ca", 20), 839, 1484);
    public static final Element SCANDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "scandium"), "Sc", 21), 1541, 2831);
    public static final Element TITANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "titanium"), "Ti", 22), 1660, 3287);
    public static final Element VANADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "vanadium"), "V", 23), 1887, 3377);
    public static final Element CHROMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "chromium"), "Cr", 24), 1857, 2672);
    public static final Element MANGANESE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "manganese"), "Mn", 25), 1244, 1962);
    public static final Element IRON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "iron"), "Fe", 26), 1535, 2750);
    public static final Element COBALT = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "cobalt"), "Co", 27), 1495, 2870);
    public static final Element NICKEL = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "nickel"), "Ni", 28), 1453, 2732);
    public static final Element COPPER = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "copper"), "Cu", 29), 1083.4, 2567);
    public static final Element ZINC = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "zinc"), "Zn", 30), 419.58, 907);

    public static final RegistryObject<Item> CONTAINED_HYDROGEN = ITEMS.register("contained_hydrogen", () -> new CompoundItem(new Item.Properties(), HYDROGEN));
    public static final RegistryObject<Item> CONTAINED_HELIUM = ITEMS.register("contained_helium", () -> new CompoundItem(new Item.Properties(), HELIUM));
    //public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new CompoundItem(new Item.Properties(), LITHIUM));
    //public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new CompoundItem(new Item.Properties(), BERYLLIUM));
    //public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new CompoundItem(new Item.Properties(), BORON));
    public static final RegistryObject<Item> CARBON_INGOT = ITEMS.register("carbon_ingot", () -> new CompoundItem(new Item.Properties(), CARBON));
    public static final RegistryObject<Item> CONTAINED_NITROGEN = ITEMS.register("contained_nitrogen", () -> new CompoundItem(new Item.Properties(), NITROGEN));
    public static final RegistryObject<Item> CONTAINED_OXYGEN = ITEMS.register("contained_oxygen", () -> new CompoundItem(new Item.Properties(), OXYGEN));
    public static final RegistryObject<Item> CONTAINED_FLUORINE = ITEMS.register("contained_fluorine", () -> new CompoundItem(new Item.Properties(), FLUORINE));
    public static final RegistryObject<Item> CONTAINED_NEON = ITEMS.register("contained_neon", () -> new CompoundItem(new Item.Properties(), NEON));
    //public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new CompoundItem(new Item.Properties(), SODIUM));
    //public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new CompoundItem(new Item.Properties(), MAGNESIUM));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new CompoundItem(new Item.Properties(), ALUMINUM));
    public static final RegistryObject<Item> SILICON_INGOT = ITEMS.register("silicon_ingot", () -> new CompoundItem(new Item.Properties(), SILICON));
    public static final RegistryObject<Item> PHOSPHORUS_INGOT = ITEMS.register("phosphorus_ingot", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS));
    public static final RegistryObject<Item> SULFUR_INGOT = ITEMS.register("sulfur_ingot", () -> new CompoundItem(new Item.Properties(), SULFUR));
    public static final RegistryObject<Item> CONTAINED_CHLORINE = ITEMS.register("contained_chlorine", () -> new CompoundItem(new Item.Properties(), CHLORINE));
    public static final RegistryObject<Item> CONTAINED_ARGON = ITEMS.register("contained_argon", () -> new CompoundItem(new Item.Properties(), ARGON));
    //public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new CompoundItem(new Item.Properties(), POTASSIUM));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new CompoundItem(new Item.Properties(), CALCIUM));

    public BMBC_Main(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
