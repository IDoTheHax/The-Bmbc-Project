package gg.hipposgrumm.bmbc;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.blocks.AlloyFurnaceBlock;
import gg.hipposgrumm.bmbc.blocks.AlloyFurnaceBlockEntity;
import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import gg.hipposgrumm.bmbc.gui.AlloyFurnaceMenu;
import gg.hipposgrumm.bmbc.items.Compound;
import gg.hipposgrumm.bmbc.items.CompoundItem;
import gg.hipposgrumm.bmbc.recipes.AlloySmeltingRecipe;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.creativemode_tab.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BMBC_Main {
    public static final String MODID = BetterMineBetterCraft.MOD_ID;
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);

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
    public static final Element IRON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(MODID, "iron"), "Fe", 26), 1535, 2750); // apart from the element...
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

    public static final RegistryObject<Block> ALLOY_FURNACE = BLOCKS.register("alloy_furnace", () -> new AlloyFurnaceBlock(BlockBehaviour.Properties.of(Material.METAL))); // TODO: Set this to the correct material later.

    // All Generic Compounds

    // Solid
    public static final Compound HYDROGEN_COMPOUND = new Compound(HYDROGEN);
    public static final Compound HELIUM_COMPOUND = new Compound(HELIUM);
    public static final Compound LITHIUM_COMPOUND = new Compound(LITHIUM);
    public static final Compound BERYLLIUM_COMPOUND = new Compound(BERYLLIUM);
    public static final Compound BORON_COMPOUND = new Compound(BORON);
    public static final Compound CARBON_COMPOUND = new Compound(CARBON);
    public static final Compound NITROGEN_COMPOUND = new Compound(NITROGEN);
    public static final Compound OXYGEN_COMPOUND = new Compound(OXYGEN);
    public static final Compound FLUORINE_COMPOUND = new Compound(FLUORINE);
    public static final Compound NEON_COMPOUND = new Compound(NEON);
    public static final Compound SODIUM_COMPOUND = new Compound(SODIUM);
    public static final Compound MAGNESIUM_COMPOUND = new Compound(MAGNESIUM);
    public static final Compound ALUMINIUM_COMPOUND = new Compound(ALUMINIUM);
    public static final Compound SILICON_COMPOUND = new Compound(SILICON);
    public static final Compound PHOSPHORUS_COMPOUND = new Compound(PHOSPHORUS);
    public static final Compound SULFUR_COMPOUND = new Compound(SULFUR);
    public static final Compound CHLORINE_COMPOUND = new Compound(CHLORINE);
    public static final Compound ARGON_COMPOUND = new Compound(ARGON);
    public static final Compound POTASSIUM_COMPOUND = new Compound(POTASSIUM);
    public static final Compound CALCIUM_COMPOUND = new Compound(CALCIUM);
    public static final Compound SCANDIUM_COMPOUND = new Compound(SCANDIUM);
    public static final Compound TITANIUM_COMPOUND = new Compound(TITANIUM);
    public static final Compound VANADIUM_COMPOUND = new Compound(VANADIUM);
    public static final Compound CHROMIUM_COMPOUND = new Compound(CHROMIUM);
    public static final Compound MANGANESE_COMPOUND = new Compound(MANGANESE);
    public static final Compound IRON_COMPOUND = new Compound(IRON);
    public static final Compound COBALT_COMPOUND = new Compound(COBALT);
    public static final Compound NICKEL_COMPOUND = new Compound(NICKEL);
    public static final Compound COPPER_COMPOUND = new Compound(COPPER);
    public static final Compound ZINC_COMPOUND = new Compound(ZINC);
    public static final Compound GALLIUM_COMPOUND = new Compound(GALLIUM);
    public static final Compound GERMANIUM_COMPOUND = new Compound(GERMANIUM);
    public static final Compound ARSENIC_COMPOUND = new Compound(ARSENIC);
    public static final Compound SELENIUM_COMPOUND = new Compound(SELENIUM);
    public static final Compound BROMINE_COMPOUND = new Compound(BROMINE);
    public static final Compound KRYPTON_COMPOUND = new Compound(KRYPTON);
    public static final Compound RUBIDIUM_COMPOUND = new Compound(RUBIDIUM);
    public static final Compound STRONTIUM_COMPOUND = new Compound(STRONTIUM);
    public static final Compound YTTRIUM_COMPOUND = new Compound(YTTRIUM);
    public static final Compound ZIRCONIUM_COMPOUND = new Compound(ZIRCONIUM);
    public static final Compound NIOBIUM_COMPOUND = new Compound(NIOBIUM);
    public static final Compound MOLYBDENUM_COMPOUND = new Compound(MOLYBDENUM);
    public static final Compound TECHNETIUM_COMPOUND = new Compound(TECHNETIUM);
    public static final Compound RUTHENIUM_COMPOUND = new Compound(RUTHENIUM);
    public static final Compound RHODIUM_COMPOUND = new Compound(RHODIUM);
    public static final Compound PALLADIUM_COMPOUND = new Compound(PALLADIUM);
    public static final Compound SILVER_COMPOUND = new Compound(SILVER);
    public static final Compound CADMIUM_COMPOUND = new Compound(CADMIUM);
    public static final Compound INDIUM_COMPOUND = new Compound(INDIUM);
    public static final Compound TIN_COMPOUND = new Compound(TIN);
    public static final Compound ANTIMONY_COMPOUND = new Compound(ANTIMONY);
    public static final Compound TELLURIUM_COMPOUND = new Compound(TELLURIUM);
    public static final Compound IODINE_COMPOUND = new Compound(IODINE);
    public static final Compound XENON_COMPOUND = new Compound(XENON);
    public static final Compound CESIUM_COMPOUND = new Compound(CESIUM);
    public static final Compound BARIUM_COMPOUND = new Compound(BARIUM);
    public static final Compound LANTHANUM_COMPOUND = new Compound(LANTHANUM);
    public static final Compound CERIUM_COMPOUND = new Compound(CERIUM);
    public static final Compound PRASEODYMIUM_COMPOUND = new Compound(PRASEODYMIUM);
    public static final Compound NEODYMIUM_COMPOUND = new Compound(NEODYMIUM);
    public static final Compound PROMETHIUM_COMPOUND = new Compound(PROMETHIUM);
    public static final Compound SAMARIUM_COMPOUND = new Compound(SAMARIUM);
    public static final Compound EUROPIUM_COMPOUND = new Compound(EUROPIUM);
    public static final Compound GADOLINIUM_COMPOUND = new Compound(GADOLINIUM);
    public static final Compound TERBIUM_COMPOUND = new Compound(TERBIUM);
    public static final Compound DYSPROSIUM_COMPOUND = new Compound(DYSPROSIUM);
    public static final Compound HOLMIUM_COMPOUND = new Compound(HOLMIUM);
    public static final Compound ERBIUM_COMPOUND = new Compound(ERBIUM);
    public static final Compound THULIUM_COMPOUND = new Compound(THULIUM);
    public static final Compound YTTERBIUM_COMPOUND = new Compound(YTTERBIUM);
    public static final Compound LUTETIUM_COMPOUND = new Compound(LUTETIUM);
    public static final Compound HAFNIUM_COMPOUND = new Compound(HAFNIUM);
    public static final Compound TANTALUM_COMPOUND = new Compound(TANTALUM);
    public static final Compound TUNGSTEN_COMPOUND = new Compound(TUNGSTEN);
    public static final Compound RHENIUM_COMPOUND = new Compound(RHENIUM);
    public static final Compound OSMIUM_COMPOUND = new Compound(OSMIUM);
    public static final Compound IRIDIUM_COMPOUND = new Compound(IRIDIUM);
    public static final Compound PLATINUM_COMPOUND = new Compound(PLATINUM);
    public static final Compound GOLD_COMPOUND = new Compound(GOLD);
    public static final Compound MERCURY_COMPOUND = new Compound(MERCURY);
    public static final Compound THALLIUM_COMPOUND = new Compound(THALLIUM);
    public static final Compound LEAD_COMPOUND = new Compound(LEAD);
    public static final Compound BISMUTH_COMPOUND = new Compound(BISMUTH);
    public static final Compound POLONIUM_COMPOUND = new Compound(POLONIUM);
    public static final Compound ASTATINE_COMPOUND = new Compound(ASTATINE);
    public static final Compound RADON_COMPOUND = new Compound(RADON);
    public static final Compound FRANCIUM_COMPOUND = new Compound(FRANCIUM);
    public static final Compound RADIUM_COMPOUND = new Compound(RADIUM);
    public static final Compound ACTINIUM_COMPOUND = new Compound(ACTINIUM);
    public static final Compound THORIUM_COMPOUND = new Compound(THORIUM);
    public static final Compound PROTACTINIUM_COMPOUND = new Compound(PROTACTINIUM);
    public static final Compound URANIUM_COMPOUND = new Compound(URANIUM);

    // Solid
     public static final RegistryObject<Item> HYDROGEN_INGOT = ITEMS.register("hydrogen_ingot", () -> new CompoundItem(new Item.Properties(), HYDROGEN_COMPOUND));
     public static final RegistryObject<Item> HELIUM_INGOT = ITEMS.register("helium_ingot", () -> new CompoundItem(new Item.Properties(), HELIUM_COMPOUND));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new CompoundItem(new Item.Properties(), LITHIUM_COMPOUND));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new CompoundItem(new Item.Properties(), BERYLLIUM_COMPOUND));
    public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new CompoundItem(new Item.Properties(), BORON_COMPOUND));
    public static final RegistryObject<Item> CARBON_INGOT = ITEMS.register("carbon_ingot", () -> new CompoundItem(new Item.Properties(), CARBON_COMPOUND));
     public static final RegistryObject<Item> NITROGEN_INGOT = ITEMS.register("nitrogen_ingot", () -> new CompoundItem(new Item.Properties(), NITROGEN_COMPOUND));
     public static final RegistryObject<Item> OXYGEN_INGOT = ITEMS.register("oxygen_ingot", () -> new CompoundItem(new Item.Properties(), OXYGEN_COMPOUND));
     public static final RegistryObject<Item> FLUORINE_INGOT = ITEMS.register("fluorine_ingot", () -> new CompoundItem(new Item.Properties(), FLUORINE_COMPOUND));
     public static final RegistryObject<Item> NEON_INGOT = ITEMS.register("neon_ingot", () -> new CompoundItem(new Item.Properties(), NEON_COMPOUND));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new CompoundItem(new Item.Properties(), SODIUM_COMPOUND));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new CompoundItem(new Item.Properties(), MAGNESIUM_COMPOUND));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new CompoundItem(new Item.Properties(), ALUMINIUM_COMPOUND));
    public static final RegistryObject<Item> SILICON_CRYSTAL = ITEMS.register("silicon_crystal", () -> new CompoundItem(new Item.Properties(), SILICON_COMPOUND));
    public static final RegistryObject<Item> WHITE_PHOSPHORUS = ITEMS.register("white_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> RED_PHOSPHORUS = ITEMS.register("red_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> BLACK_PHOSPHORUS = ITEMS.register("black_phosphorus", () -> new CompoundItem(new Item.Properties(), PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new CompoundItem(new Item.Properties(), SULFUR_COMPOUND));
     public static final RegistryObject<Item> CHLORINE_INGOT = ITEMS.register("chlorine_ingot", () -> new CompoundItem(new Item.Properties(), CHLORINE_COMPOUND));
     public static final RegistryObject<Item> ARGON_INGOT = ITEMS.register("argon_ingot", () -> new CompoundItem(new Item.Properties(), ARGON_COMPOUND));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new CompoundItem(new Item.Properties(), POTASSIUM_COMPOUND));
    public static final RegistryObject<Item> CALCIUM_ROCK = ITEMS.register("calcium_rock", () -> new CompoundItem(new Item.Properties(), CALCIUM_COMPOUND));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new CompoundItem(new Item.Properties(), SCANDIUM_COMPOUND));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new CompoundItem(new Item.Properties(), TITANIUM_COMPOUND));
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new CompoundItem(new Item.Properties(), VANADIUM_COMPOUND));
    public static final RegistryObject<Item> CHROMIUM_CRYSTAL = ITEMS.register("chromium_crystal", () -> new CompoundItem(new Item.Properties(), CHROMIUM_COMPOUND));
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new CompoundItem(new Item.Properties(), MANGANESE_COMPOUND));
    //public static final RegistryObject<Item> IRON_INGOT = ITEMS.register("iron_ingot", () -> new CompoundItem(new Item.Properties(), IRON_COMPOUND));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new CompoundItem(new Item.Properties(), COBALT_COMPOUND));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new CompoundItem(new Item.Properties(), NICKEL_COMPOUND));
    //public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new CompoundItem(new Item.Properties(), COPPER_COMPOUND));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new CompoundItem(new Item.Properties(), ZINC_COMPOUND));
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new CompoundItem(new Item.Properties(), GALLIUM_COMPOUND));
    public static final RegistryObject<Item> GERMANIUM_INGOT = ITEMS.register("germanium_ingot", () -> new CompoundItem(new Item.Properties(), GERMANIUM_COMPOUND));
    public static final RegistryObject<Item> ARSENIC_INGOT = ITEMS.register("arsenic_ingot", () -> new CompoundItem(new Item.Properties(), ARSENIC_COMPOUND));
    public static final RegistryObject<Item> SELENIUM_INGOT = ITEMS.register("selenium_ingot", () -> new CompoundItem(new Item.Properties(), SELENIUM_COMPOUND));
     public static final RegistryObject<Item> BROMINE_INGOT = ITEMS.register("bromine_ingot", () -> new CompoundItem(new Item.Properties(), BROMINE_COMPOUND));
     public static final RegistryObject<Item> KRYPTON_INGOT = ITEMS.register("krypton_ingot", () -> new CompoundItem(new Item.Properties(), KRYPTON_COMPOUND));
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new CompoundItem(new Item.Properties(), RUBIDIUM_COMPOUND));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new CompoundItem(new Item.Properties(), STRONTIUM_COMPOUND));
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new CompoundItem(new Item.Properties(), YTTRIUM_COMPOUND));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new CompoundItem(new Item.Properties(), ZIRCONIUM_COMPOUND));
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new CompoundItem(new Item.Properties(), NIOBIUM_COMPOUND));
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new CompoundItem(new Item.Properties(), MOLYBDENUM_COMPOUND));
    public static final RegistryObject<Item> TECHNETIUM_INGOT = ITEMS.register("technetium_ingot", () -> new CompoundItem(new Item.Properties(), TECHNETIUM_COMPOUND));
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new CompoundItem(new Item.Properties(), RUTHENIUM_COMPOUND));
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new CompoundItem(new Item.Properties(), RHODIUM_COMPOUND));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new CompoundItem(new Item.Properties(), PALLADIUM_COMPOUND));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new CompoundItem(new Item.Properties(), SILVER_COMPOUND));
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new CompoundItem(new Item.Properties(), CADMIUM_COMPOUND));
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new CompoundItem(new Item.Properties(), INDIUM_COMPOUND));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new CompoundItem(new Item.Properties(), TIN_COMPOUND));
    public static final RegistryObject<Item> ANTIMONY_INGOT = ITEMS.register("antimony_ingot", () -> new CompoundItem(new Item.Properties(), ANTIMONY_COMPOUND));
    public static final RegistryObject<Item> TELLURIUM_INGOT = ITEMS.register("tellurium_ingot", () -> new CompoundItem(new Item.Properties(), TELLURIUM_COMPOUND));
    public static final RegistryObject<Item> IODINE_INGOT = ITEMS.register("iodine_ingot", () -> new CompoundItem(new Item.Properties(), IODINE_COMPOUND));
     public static final RegistryObject<Item> XENON_INGOT = ITEMS.register("xenon_ingot", () -> new CompoundItem(new Item.Properties(), XENON_COMPOUND));
    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", () -> new CompoundItem(new Item.Properties(), CESIUM_COMPOUND));
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new CompoundItem(new Item.Properties(), BARIUM_COMPOUND));
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new CompoundItem(new Item.Properties(), LANTHANUM_COMPOUND));
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new CompoundItem(new Item.Properties(), CERIUM_COMPOUND));
    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", () -> new CompoundItem(new Item.Properties(), PRASEODYMIUM_COMPOUND));
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new CompoundItem(new Item.Properties(), NEODYMIUM_COMPOUND));
    public static final RegistryObject<Item> PROMETHIUM_INGOT = ITEMS.register("promethium_ingot", () -> new CompoundItem(new Item.Properties(), PROMETHIUM_COMPOUND));
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new CompoundItem(new Item.Properties(), SAMARIUM_COMPOUND));
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new CompoundItem(new Item.Properties(), EUROPIUM_COMPOUND));
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new CompoundItem(new Item.Properties(), GADOLINIUM_COMPOUND));
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new CompoundItem(new Item.Properties(), TERBIUM_COMPOUND));
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new CompoundItem(new Item.Properties(), DYSPROSIUM_COMPOUND));
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new CompoundItem(new Item.Properties(), HOLMIUM_COMPOUND));
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new CompoundItem(new Item.Properties(), ERBIUM_COMPOUND));
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new CompoundItem(new Item.Properties(), THULIUM_COMPOUND));
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new CompoundItem(new Item.Properties(), YTTERBIUM_COMPOUND));
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new CompoundItem(new Item.Properties(), LUTETIUM_COMPOUND));
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new CompoundItem(new Item.Properties(), HAFNIUM_COMPOUND));
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new CompoundItem(new Item.Properties(), TANTALUM_COMPOUND));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new CompoundItem(new Item.Properties(), TUNGSTEN_COMPOUND));
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new CompoundItem(new Item.Properties(), RHENIUM_COMPOUND));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new CompoundItem(new Item.Properties(), OSMIUM_COMPOUND));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new CompoundItem(new Item.Properties(), IRIDIUM_COMPOUND));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new CompoundItem(new Item.Properties(), PLATINUM_COMPOUND));
    //public static final RegistryObject<Item> GOLD_INGOT = ITEMS.register("gold_ingot", () -> new CompoundItem(new Item.Properties(), GOLD_COMPOUND));
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new CompoundItem(new Item.Properties(), THALLIUM_COMPOUND));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new CompoundItem(new Item.Properties(), LEAD_COMPOUND));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new CompoundItem(new Item.Properties(), BISMUTH_COMPOUND));
    public static final RegistryObject<Item> POLONIUM_INGOT = ITEMS.register("polonium_ingot", () -> new CompoundItem(new Item.Properties(), POLONIUM_COMPOUND));
    public static final RegistryObject<Item> ASTATINE_INGOT = ITEMS.register("astatine_ingot", () -> new CompoundItem(new Item.Properties(), ASTATINE_COMPOUND));
     public static final RegistryObject<Item> RADON_INGOT = ITEMS.register("radon_ingot", () -> new CompoundItem(new Item.Properties(), RADON_COMPOUND));
    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot", () -> new CompoundItem(new Item.Properties(), FRANCIUM_COMPOUND));
    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot", () -> new CompoundItem(new Item.Properties(), RADIUM_COMPOUND));
    public static final RegistryObject<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot", () -> new CompoundItem(new Item.Properties(), ACTINIUM_COMPOUND));
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new CompoundItem(new Item.Properties(), THORIUM_COMPOUND));
    public static final RegistryObject<Item> PROTACTINIUM_INGOT = ITEMS.register("protactinium_ingot", () -> new CompoundItem(new Item.Properties(), PROTACTINIUM_COMPOUND));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new CompoundItem(new Item.Properties(), URANIUM_COMPOUND));

    // Liquid
    public static final RegistryObject<Item> BROMINE_CANISTER = ITEMS.register("bromine_canister", () -> new CompoundItem(new Item.Properties(), BROMINE_COMPOUND));
    public static final RegistryObject<Item> MERCURY_CANISTER = ITEMS.register("mercury_canister", () -> new CompoundItem(new Item.Properties(), MERCURY_COMPOUND));

    // Gases
    public static final RegistryObject<Item> COMPRESSED_HYDROGEN = ITEMS.register("compressed_hydrogen", () -> new CompoundItem(new Item.Properties(), HYDROGEN_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_HELIUM = ITEMS.register("compressed_helium", () -> new CompoundItem(new Item.Properties(), HELIUM_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_NITROGEN = ITEMS.register("compressed_nitrogen", () -> new CompoundItem(new Item.Properties(), NITROGEN_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_OXYGEN = ITEMS.register("compressed_oxygen", () -> new CompoundItem(new Item.Properties(), OXYGEN_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_FLUORINE = ITEMS.register("compressed_fluorine", () -> new CompoundItem(new Item.Properties(), FLUORINE_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_NEON = ITEMS.register("compressed_neon", () -> new CompoundItem(new Item.Properties(), NEON_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_CHLORINE = ITEMS.register("compressed_chlorine", () -> new CompoundItem(new Item.Properties(), CHLORINE_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_ARGON = ITEMS.register("compressed_argon", () -> new CompoundItem(new Item.Properties(), ARGON_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_KRYPTON = ITEMS.register("compressed_krypton", () -> new CompoundItem(new Item.Properties(), KRYPTON_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_XENON = ITEMS.register("compressed_xenon", () -> new CompoundItem(new Item.Properties(), XENON_COMPOUND));
    public static final RegistryObject<Item> COMPRESSED_RADON = ITEMS.register("compressed_radon", () -> new CompoundItem(new Item.Properties(), RADON_COMPOUND));

    public static final RegistryObject<BlockEntityType<AlloyFurnaceBlockEntity>> ALLOY_FURNACE_BE = BLOCK_ENTITIES.register("alloy_furnace", () -> BlockEntityType.Builder.of(AlloyFurnaceBlockEntity::new, ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<MenuType<AlloyFurnaceMenu>> ALLOY_FURNACE_MENU = MENU_TYPES.register("alloy_furnace_menu", () -> IForgeMenuType.create(AlloyFurnaceMenu::new));

    public static final RegistryObject<RecipeSerializer<AlloySmeltingRecipe>> ALLOY_SMELTING_SERIALIZER = RECIPE_SERIALIZERS.register("alloy_smelting", () -> AlloySmeltingRecipe.Serializer.INSTANCE);

    public BMBC_Main(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        MENU_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }

    public static List<RegistryObject<Item>> doDatagen() {
        return new ArrayList<>() {{
            // Solid
            add(HYDROGEN_INGOT);
            add(HELIUM_INGOT);
            add(LITHIUM_INGOT);
            add(BERYLLIUM_INGOT);
            add(BORON_INGOT);
            add(CARBON_INGOT);
            add(NITROGEN_INGOT);
            add(OXYGEN_INGOT);
            add(FLUORINE_INGOT);
            add(NEON_INGOT);
            add(SODIUM_INGOT);
            add(MAGNESIUM_INGOT);
            add(ALUMINIUM_INGOT);
            add(SILICON_CRYSTAL);
            add(WHITE_PHOSPHORUS);
            add(RED_PHOSPHORUS);
            add(BLACK_PHOSPHORUS);
            add(SULFUR_CRYSTAL);
            add(CHLORINE_INGOT);
            add(ARGON_INGOT);
            add(POTASSIUM_INGOT);
            add(CALCIUM_ROCK);
            add(SCANDIUM_INGOT);
            add(TITANIUM_INGOT);
            add(VANADIUM_INGOT);
            add(CHROMIUM_CRYSTAL);
            add(MANGANESE_INGOT);
            //add(IRON_INGOT);
            add(COBALT_INGOT);
            add(NICKEL_INGOT);
            //add(COPPER_INGOT);
            add(ZINC_INGOT);
            add(GALLIUM_INGOT);
            add(GERMANIUM_INGOT);
            add(ARSENIC_INGOT);
            add(SELENIUM_INGOT);
            add(BROMINE_INGOT);
            add(KRYPTON_INGOT);
            add(RUBIDIUM_INGOT);
            add(STRONTIUM_INGOT);
            add(YTTRIUM_INGOT);
            add(ZIRCONIUM_INGOT);
            add(NIOBIUM_INGOT);
            add(MOLYBDENUM_INGOT);
            add(TECHNETIUM_INGOT);
            add(RUTHENIUM_INGOT);
            add(RHODIUM_INGOT);
            add(PALLADIUM_INGOT);
            add(SILVER_INGOT);
            add(CADMIUM_INGOT);
            add(INDIUM_INGOT);
            add(TIN_INGOT);
            add(ANTIMONY_INGOT);
            add(TELLURIUM_INGOT);
            add(IODINE_INGOT);
            add(XENON_INGOT);
            add(CESIUM_INGOT);
            add(BARIUM_INGOT);
            add(LANTHANUM_INGOT);
            add(CERIUM_INGOT);
            add(PRASEODYMIUM_INGOT);
            add(NEODYMIUM_INGOT);
            add(PROMETHIUM_INGOT);
            add(SAMARIUM_INGOT);
            add(EUROPIUM_INGOT);
            add(GADOLINIUM_INGOT);
            add(TERBIUM_INGOT);
            add(DYSPROSIUM_INGOT);
            add(HOLMIUM_INGOT);
            add(ERBIUM_INGOT);
            add(THULIUM_INGOT);
            add(YTTERBIUM_INGOT);
            add(LUTETIUM_INGOT);
            add(HAFNIUM_INGOT);
            add(TANTALUM_INGOT);
            add(TUNGSTEN_INGOT);
            add(RHENIUM_INGOT);
            add(OSMIUM_INGOT);
            add(IRIDIUM_INGOT);
            add(PLATINUM_INGOT);
            //add(GOLD_INGOT);
            add(MERCURY_CANISTER);
            add(THALLIUM_INGOT);
            add(LEAD_INGOT);
            add(BISMUTH_INGOT);
            add(POLONIUM_INGOT);
            add(ASTATINE_INGOT);
            add(RADON_INGOT);
            add(FRANCIUM_INGOT);
            add(RADIUM_INGOT);
            add(ACTINIUM_INGOT);
            add(THORIUM_INGOT);
            add(PROTACTINIUM_INGOT);
            add(URANIUM_INGOT);

            // Liquid
            add(BROMINE_CANISTER);
            add(MERCURY_CANISTER);

            // Gas
            add(COMPRESSED_HYDROGEN);
            add(COMPRESSED_HELIUM);
            add(COMPRESSED_NITROGEN);
            add(COMPRESSED_OXYGEN);
            add(COMPRESSED_FLUORINE);
            add(COMPRESSED_NEON);
            add(COMPRESSED_CHLORINE);
            add(COMPRESSED_ARGON);
            add(COMPRESSED_KRYPTON);
            add(COMPRESSED_XENON);
            add(COMPRESSED_RADON);
        }};
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void doCompatStuff(FMLLoadCompleteEvent event) {
            List<CompoundItem> compoundItems = new ArrayList<>();
            for (Item item:ForgeRegistries.ITEMS.getValues()) {
                if (item instanceof CompoundItem compoundItem) compoundItems.add(compoundItem);
            }
            for (Item item:ForgeRegistries.ITEMS.getValues()) {
                if (item instanceof CompoundItem) continue;
                boolean ImTheException = false;
                if (ForgeRegistries.ITEMS.getKey(item).getPath() == "iron_ingot") {
                    CompoundItem.addCompatibleItem(item, new Compound(IRON));
                    ImTheException = true;
                } else if (ForgeRegistries.ITEMS.getKey(item).getPath() == "copper_ingot") {
                    CompoundItem.addCompatibleItem(item, new Compound(COPPER));
                    ImTheException = true;
                } else if (ForgeRegistries.ITEMS.getKey(item).getPath() == "gold_ingot") {
                    CompoundItem.addCompatibleItem(item, new Compound(GOLD));
                    ImTheException = true;
                }
                if (ImTheException) continue;
                for (CompoundItem compoundItem:compoundItems) {
                    if (ForgeRegistries.ITEMS.getKey(item).getPath().replace("aluminum","aluminium") == ForgeRegistries.ITEMS.getKey(compoundItem).getPath()) {
                        CompoundItem.addCompatibleItem(item, compoundItem.getCompound());
                        break;
                    }
                }
            }
        }

        @SubscribeEvent
        public static void addCreative(CreativeModeTabEvent.BuildContents event) {
            if (event.getTab() == ModResourcesCreativeModeTab.BMBC_RESOURCES) {
                // Solid
                event.accept(HYDROGEN_INGOT);
                event.accept(HELIUM_INGOT);
                event.accept(LITHIUM_INGOT);
                event.accept(BERYLLIUM_INGOT);
                event.accept(BORON_INGOT);
                event.accept(CARBON_INGOT);
                event.accept(NITROGEN_INGOT);
                event.accept(OXYGEN_INGOT);
                event.accept(FLUORINE_INGOT);
                event.accept(NEON_INGOT);
                event.accept(SODIUM_INGOT);
                event.accept(MAGNESIUM_INGOT);
                event.accept(ALUMINIUM_INGOT);
                event.accept(SILICON_CRYSTAL);
                event.accept(WHITE_PHOSPHORUS);
                event.accept(RED_PHOSPHORUS);
                event.accept(BLACK_PHOSPHORUS);
                event.accept(SULFUR_CRYSTAL);
                event.accept(CHLORINE_INGOT);
                event.accept(ARGON_INGOT);
                event.accept(POTASSIUM_INGOT);
                event.accept(CALCIUM_ROCK);
                event.accept(SCANDIUM_INGOT);
                event.accept(TITANIUM_INGOT);
                event.accept(VANADIUM_INGOT);
                event.accept(CHROMIUM_CRYSTAL);
                event.accept(MANGANESE_INGOT);
                //event.accept(IRON_INGOT);
                event.accept(COBALT_INGOT);
                event.accept(NICKEL_INGOT);
                //event.accept(COPPER_INGOT);
                event.accept(ZINC_INGOT);
                event.accept(GALLIUM_INGOT);
                event.accept(GERMANIUM_INGOT);
                event.accept(ARSENIC_INGOT);
                event.accept(SELENIUM_INGOT);
                event.accept(BROMINE_INGOT);
                event.accept(KRYPTON_INGOT);
                event.accept(RUBIDIUM_INGOT);
                event.accept(STRONTIUM_INGOT);
                event.accept(YTTRIUM_INGOT);
                event.accept(ZIRCONIUM_INGOT);
                event.accept(NIOBIUM_INGOT);
                event.accept(MOLYBDENUM_INGOT);
                event.accept(TECHNETIUM_INGOT);
                event.accept(RUTHENIUM_INGOT);
                event.accept(RHODIUM_INGOT);
                event.accept(PALLADIUM_INGOT);
                event.accept(SILVER_INGOT);
                event.accept(CADMIUM_INGOT);
                event.accept(INDIUM_INGOT);
                event.accept(TIN_INGOT);
                event.accept(ANTIMONY_INGOT);
                event.accept(TELLURIUM_INGOT);
                event.accept(IODINE_INGOT);
                event.accept(XENON_INGOT);
                event.accept(CESIUM_INGOT);
                event.accept(BARIUM_INGOT);
                event.accept(LANTHANUM_INGOT);
                event.accept(CERIUM_INGOT);
                event.accept(PRASEODYMIUM_INGOT);
                event.accept(NEODYMIUM_INGOT);
                event.accept(PROMETHIUM_INGOT);
                event.accept(SAMARIUM_INGOT);
                event.accept(EUROPIUM_INGOT);
                event.accept(GADOLINIUM_INGOT);
                event.accept(TERBIUM_INGOT);
                event.accept(DYSPROSIUM_INGOT);
                event.accept(HOLMIUM_INGOT);
                event.accept(ERBIUM_INGOT);
                event.accept(THULIUM_INGOT);
                event.accept(YTTERBIUM_INGOT);
                event.accept(LUTETIUM_INGOT);
                event.accept(HAFNIUM_INGOT);
                event.accept(TANTALUM_INGOT);
                event.accept(TUNGSTEN_INGOT);
                event.accept(RHENIUM_INGOT);
                event.accept(OSMIUM_INGOT);
                event.accept(IRIDIUM_INGOT);
                event.accept(PLATINUM_INGOT);
                //event.accept(GOLD_INGOT);
                event.accept(MERCURY_CANISTER);
                event.accept(THALLIUM_INGOT);
                event.accept(LEAD_INGOT);
                event.accept(BISMUTH_INGOT);
                event.accept(POLONIUM_INGOT);
                event.accept(ASTATINE_INGOT);
                event.accept(RADON_INGOT);
                event.accept(FRANCIUM_INGOT);
                event.accept(RADIUM_INGOT);
                event.accept(ACTINIUM_INGOT);
                event.accept(THORIUM_INGOT);
                event.accept(PROTACTINIUM_INGOT);
                event.accept(URANIUM_INGOT);
            }
            if (event.getTab() == ModFluidsCreativeModeTab.BMBC_FLUIDS) {
                // Liquid
                event.accept(BROMINE_CANISTER);
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
                event.accept(COMPRESSED_KRYPTON);
                event.accept(COMPRESSED_XENON);
                event.accept(COMPRESSED_RADON);
            }
        }
    }
}
