package gg.hipposgrumm.bmbc;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import gg.hipposgrumm.bmbc.items.CompoundItem;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.creativemode_tab.*;
import net.matty.bmbc.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
    public static final Element ALUMINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "aluminium"), "Al", 13), 660.37, 2467);
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
    public static final Element GALLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "gallium"), "Ga", 31), 29.78, 2403);
    public static final Element GERMANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "germanium"), "Ge", 32), 937.4, 2830);
    public static final Element ARSENIC = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "arsenic"), "As", 33), 817, 817.0000001);
    public static final Element SELENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "selenium"), "Se", 34), 217, 684.9);
    public static final Element BROMINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "bromine"), "Br", 35), -7.3, 58.78);
    public static final Element KRYPTON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "krypton"), "Kr", 36), -156.6, -152.3);
    public static final Element RUBIDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "rubidium"), "Rb", 37), 39, 688);
    public static final Element STRONTIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "strontium"), "Sr", 38), 769, 1384);
    public static final Element YTTRIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "yttrium"), "Y", 39), 1522, 3338);
    public static final Element ZIRCONIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "zirconium"), "Zr", 40), 1852, 4377);
    public static final Element NIOBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "niobium"), "Nb", 41), 2468, 4742);
    public static final Element MOLYBDENUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "molybdenum"), "Mo", 42), 2617, 4612);
    public static final Element TECHNETIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "technetium"), "Tc", 43), 2172, 4877);
    public static final Element RUTHENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "ruthenium"), "Ru", 44), 2310, 3900);
    public static final Element RHODIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "rhodium"), "Rh", 45), 1966, 3727);
    public static final Element PALLADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "palladium"), "Pd", 46), 1552, 3140);
    public static final Element SILVER = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "silver"), "Ag", 47), 961.93, 2212);
    public static final Element CADMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "cadmium"), "Cd", 48), 320.9, 765);
    public static final Element INDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "indium"), "In", 49), 156.17, 2080);
    public static final Element TIN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "tin"), "Sn", 50), 231.97, 2270);
    public static final Element ANTIMONY = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "antimony"), "Sb", 51), 640.74, 1635);
    public static final Element TELLURIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "tellurium"), "Te", 52), 449.5, 989.8);
    public static final Element IODINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "iodine"), "I", 53), 113.5, 184.35);
    public static final Element XENON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "xenon"), "Xe", 54), -111.9, -107.1);
    public static final Element CESIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "cesium"), "Cs", 55), 28.4, 678.4);
    public static final Element BARIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "barium"), "Ba", 56), 729, 1637);
    public static final Element LANTHANUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "lanthanum"), "La", 57), 921, 3457);
    public static final Element CERIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "cerium"), "Ce", 58), 799, 3426);
    public static final Element PRASEODYMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "praseodymium"), "Pr", 59), 931, 3512);
    public static final Element NEODYMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "neodymium"), "Nd", 60), 1021, 3068);
    public static final Element PROMETHIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "promethium"), "Pm", 61), 1168, 2727);
    public static final Element SAMARIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "samarium"), "Sm", 62), 1077, 1791);
    public static final Element EUROPIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "europium"), "Eu", 63), 882, 1597);
    public static final Element GADOLINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "gadolinium"), "Gd", 64), 1313, 3266);
    public static final Element TERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "terbium"), "Tb", 65), 1356, 3123);
    public static final Element DYSPROSIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "dysprosium"), "Dy", 66), 1412, 2563);
    public static final Element HOLMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "holmium"), "Ho", 67), 1474, 2695);
    public static final Element ERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "erbium"), "Er", 68), 1529, 2863);
    public static final Element THULIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "thulium"), "Tm", 69), 1545, 1947);
    public static final Element YTTERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "ytterbium"), "Yb", 70), 824, 1193);
    public static final Element LUTETIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "lutetium"), "Lu", 71), 1663, 3395);
    public static final Element HAFNIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "hafnium"), "Hf", 72), 2230, 5197);
    public static final Element TANTALUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "tantalum"), "Ta", 73), 2996, 5425);
    public static final Element TUNGSTEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "tungsten"), "W", 74), 3407, 5657);
    public static final Element RHENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "rhenium"), "Re", 75), 3180, 5627);
    public static final Element OSMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "osmium"), "Os", 76), 3054, 5027);
    public static final Element IRIDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "iridium"), "Ir", 77), 2410, 4130);
    public static final Element PLATINUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "platinum"), "Pt", 78), 1772, 3827);
    public static final Element GOLD = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "gold"), "Au", 79), 1064.43, 2807);
    public static final Element MERCURY = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "mercury"), "Hg", 80), -38.87, 356.58);
    public static final Element THALLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "thallium"), "Tl", 81), 303.5, 1457);
    public static final Element LEAD = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "lead"), "Pb", 82), 327.5, 1740);
    public static final Element BISMUTH = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "bismuth"), "Bi", 83), 271.3, 1610);
    public static final Element POLONIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "polonium"), "Po", 84), 254, 962);
    public static final Element ASTATINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "astatine"), "At", 85), 302, 337);
    public static final Element RADON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "radon"), "Rn", 86), -71, -61.8);
    public static final Element FRANCIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "francium"), "Fr", 87), 27, 677);
    public static final Element RADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "radium"), "Ra", 88), 700, 1140);
    public static final Element ACTINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "actinium"), "Ac", 89), 1047, 3197);
    public static final Element THORIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "thorium"), "Th", 90), 1750, 4787);
    public static final Element PROTACTINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "protactinium"), "Pa", 91), 1840, 4027);
    public static final Element URANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "uranium"), "U", 92), 1132.3, 3745);

    // Solid
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new CompoundItem(new Item.Properties(), LITHIUM));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new CompoundItem(new Item.Properties(), BERYLLIUM));
    public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new CompoundItem(new Item.Properties(), BORON));
    public static final RegistryObject<Item> CARBON_INGOT = ITEMS.register("carbon_ingot", () -> new CompoundItem(new Item.Properties(), CARBON));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new CompoundItem(new Item.Properties(), SODIUM));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new CompoundItem(new Item.Properties(), MAGNESIUM));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new CompoundItem(new Item.Properties(), ALUMINIUM));
    public static final RegistryObject<Item> SILICON_CRYSTAL = ITEMS.register("silicon_crystal", () -> new CompoundItem(new Item.Properties(), SILICON));
    public static final RegistryObject<Item> WHITE_PHOSPHORUS = ITEMS.register("white_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS));
    public static final RegistryObject<Item> RED_PHOSPHORUS = ITEMS.register("red_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS));
    public static final RegistryObject<Item> BLACK_PHOSPHORUS = ITEMS.register("black_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS));
    public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new CompoundItem(new Item.Properties(), SULFUR));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new CompoundItem(new Item.Properties(), POTASSIUM));
    public static final RegistryObject<Item> CALCIUM_ROCK = ITEMS.register("calcium_rock", () -> new CompoundItem(new Item.Properties(), CALCIUM));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new CompoundItem(new Item.Properties(), SCANDIUM));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new CompoundItem(new Item.Properties(), TITANIUM));
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new CompoundItem(new Item.Properties(), VANADIUM));
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", () -> new CompoundItem(new Item.Properties(), CHROMIUM));
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new CompoundItem(new Item.Properties(), MANGANESE));
    public static final RegistryObject<Item> IRON_INGOT = ITEMS.register("iron_ingot", () -> new CompoundItem(new Item.Properties(), IRON));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new CompoundItem(new Item.Properties(), COBALT));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new CompoundItem(new Item.Properties(), NICKEL));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new CompoundItem(new Item.Properties(), COPPER));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new CompoundItem(new Item.Properties(), ZINC));
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new CompoundItem(new Item.Properties(), GALLIUM));
    public static final RegistryObject<Item> GERMANIUM_INGOT = ITEMS.register("germanium_ingot", () -> new CompoundItem(new Item.Properties(), GERMANIUM));
    public static final RegistryObject<Item> ARSENIC_INGOT = ITEMS.register("arsenic_ingot", () -> new CompoundItem(new Item.Properties(), ARSENIC));
    public static final RegistryObject<Item> SELENIUM_INGOT = ITEMS.register("selenium_ingot", () -> new CompoundItem(new Item.Properties(), SELENIUM));
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new CompoundItem(new Item.Properties(), RUBIDIUM));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new CompoundItem(new Item.Properties(), STRONTIUM));
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new CompoundItem(new Item.Properties(), YTTRIUM));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new CompoundItem(new Item.Properties(), ZIRCONIUM));
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new CompoundItem(new Item.Properties(), NIOBIUM));
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new CompoundItem(new Item.Properties(), MOLYBDENUM));
    public static final RegistryObject<Item> TECHNETIUM_INGOT = ITEMS.register("technetium_ingot", () -> new CompoundItem(new Item.Properties(), TECHNETIUM));
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new CompoundItem(new Item.Properties(), RUTHENIUM));
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new CompoundItem(new Item.Properties(), RHODIUM));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new CompoundItem(new Item.Properties(), PALLADIUM));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new CompoundItem(new Item.Properties(), SILVER));
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new CompoundItem(new Item.Properties(), CADMIUM));
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new CompoundItem(new Item.Properties(), INDIUM));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new CompoundItem(new Item.Properties(), TIN));
    public static final RegistryObject<Item> ANTIMONY_INGOT = ITEMS.register("antimony_ingot", () -> new CompoundItem(new Item.Properties(), ANTIMONY));
    public static final RegistryObject<Item> TELLURIUM_INGOT = ITEMS.register("tellurium_ingot", () -> new CompoundItem(new Item.Properties(), TELLURIUM));
    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", () -> new CompoundItem(new Item.Properties(), CESIUM));
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new CompoundItem(new Item.Properties(), BARIUM));
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new CompoundItem(new Item.Properties(), LANTHANUM));
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new CompoundItem(new Item.Properties(), CERIUM));
    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", () -> new CompoundItem(new Item.Properties(), PRASEODYMIUM));
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new CompoundItem(new Item.Properties(), NEODYMIUM));
    public static final RegistryObject<Item> PROMETHIUM_INGOT = ITEMS.register("promethium_ingot", () -> new CompoundItem(new Item.Properties(), PROMETHIUM));
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new CompoundItem(new Item.Properties(), SAMARIUM));
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new CompoundItem(new Item.Properties(), EUROPIUM));
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new CompoundItem(new Item.Properties(), GADOLINIUM));
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new CompoundItem(new Item.Properties(), TERBIUM));
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new CompoundItem(new Item.Properties(), DYSPROSIUM));
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new CompoundItem(new Item.Properties(), HOLMIUM));
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new CompoundItem(new Item.Properties(), ERBIUM));
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new CompoundItem(new Item.Properties(), THULIUM));
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new CompoundItem(new Item.Properties(), YTTERBIUM));
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new CompoundItem(new Item.Properties(), LUTETIUM));
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new CompoundItem(new Item.Properties(), HAFNIUM));
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new CompoundItem(new Item.Properties(), TANTALUM));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new CompoundItem(new Item.Properties(), TUNGSTEN));
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new CompoundItem(new Item.Properties(), RHENIUM));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new CompoundItem(new Item.Properties(), OSMIUM));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new CompoundItem(new Item.Properties(), IRIDIUM));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new CompoundItem(new Item.Properties(), PLATINUM));
    public static final RegistryObject<Item> GOLD_INGOT = ITEMS.register("gold_ingot", () -> new CompoundItem(new Item.Properties(), GOLD));
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new CompoundItem(new Item.Properties(), THALLIUM));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new CompoundItem(new Item.Properties(), LEAD));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new CompoundItem(new Item.Properties(), BISMUTH));
    public static final RegistryObject<Item> POLONIUM_INGOT = ITEMS.register("polonium_ingot", () -> new CompoundItem(new Item.Properties(), POLONIUM));
    public static final RegistryObject<Item> ASTATINE_INGOT = ITEMS.register("astatine_ingot", () -> new CompoundItem(new Item.Properties(), ASTATINE));
    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot", () -> new CompoundItem(new Item.Properties(), FRANCIUM));
    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot", () -> new CompoundItem(new Item.Properties(), RADIUM));
    public static final RegistryObject<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot", () -> new CompoundItem(new Item.Properties(), ACTINIUM));
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new CompoundItem(new Item.Properties(), THORIUM));
    public static final RegistryObject<Item> PROTACTINIUM_INGOT = ITEMS.register("protactinium_ingot", () -> new CompoundItem(new Item.Properties(), PROTACTINIUM));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new CompoundItem(new Item.Properties(), URANIUM));

    // Liquid
    public static final RegistryObject<Item> MERCURY_CANISTER = ITEMS.register("mercury_canister", () -> new CompoundItem(new Item.Properties(), MERCURY));

    // Gases
    public static final RegistryObject<Item> COMPRESSED_HYDROGEN = ITEMS.register("compressed_hydrogen", () -> new CompoundItem(new Item.Properties(), HYDROGEN));
    public static final RegistryObject<Item> COMPRESSED_HELIUM = ITEMS.register("compressed_helium", () -> new CompoundItem(new Item.Properties(), HELIUM));
    public static final RegistryObject<Item> COMPRESSED_NITROGEN = ITEMS.register("compressed_nitrogen", () -> new CompoundItem(new Item.Properties(), NITROGEN));
    public static final RegistryObject<Item> COMPRESSED_OXYGEN = ITEMS.register("compressed_oxygen", () -> new CompoundItem(new Item.Properties(), OXYGEN));
    public static final RegistryObject<Item> COMPRESSED_FLUORINE = ITEMS.register("compressed_fluorine", () -> new CompoundItem(new Item.Properties(), FLUORINE));
    public static final RegistryObject<Item> COMPRESSED_NEON = ITEMS.register("compressed_neon", () -> new CompoundItem(new Item.Properties(), NEON));
    public static final RegistryObject<Item> COMPRESSED_CHLORINE = ITEMS.register("compressed_chlorine", () -> new CompoundItem(new Item.Properties(), CHLORINE));
    public static final RegistryObject<Item> COMPRESSED_ARGON = ITEMS.register("compressed_argon", () -> new CompoundItem(new Item.Properties(), ARGON));

    public BMBC_Main(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static List<RegistryObject<Item>> doDatagen() {
        return new ArrayList<>() {{
            add(LITHIUM_INGOT);
        }};
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        private void addCreative(CreativeModeTabEvent.BuildContents event) {
            if (event.getTab() == ModResourcesCreativeModeTab.BMBC_RESOURCES) {
                // Solid
                event.accept(LITHIUM_INGOT);
                event.accept(BERYLLIUM_INGOT);
                event.accept(BORON_INGOT);
                event.accept(CARBON_INGOT);
                event.accept(SODIUM_INGOT);
                event.accept(MAGNESIUM_INGOT);
                event.accept(ALUMINIUM_INGOT);
                event.accept(SILICON_CRYSTAL);
                event.accept(WHITE_PHOSPHORUS);
                event.accept(RED_PHOSPHORUS);
                event.accept(BLACK_PHOSPHORUS);
                event.accept(SULFUR_CRYSTAL);
                event.accept(POTASSIUM_INGOT);
                event.accept(CALCIUM_ROCK);
            }
            if (event.getTab() == ModFluidsCreativeModeTab.BMBC_FLUIDS) {
                // Liquid
                event.accept(MERCURY_CANISTER);

                // Gas
                event.accept(COMPRESSED_HYDROGEN);
                event.accept(COMPRESSED_HELIUM);
                event.accept(COMPRESSED_NITROGEN);
                event.accept(COMPRESSED_OXYGEN);
                event.accept(COMPRESSED_FLUORINE);
                event.accept(COMPRESSED_NEON);
                event.accept(COMPRESSED_CHLORINE);
                event.accept(COMPRESSED_ARGON);

            }
        }
    }
}
