package gg.hipposgrumm.bmbc.items;

import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompoundItem extends Item {
    private static Map<Item, Compound> compatibleItems = new HashMap<>();
    private final Compound compound;

    public CompoundItem(Properties pProperties, Compound compound) {
        super(pProperties);
        this.compound = compound;
    }

    public static void addCompatibleItem(Item item, Compound compound) {
        compatibleItems.put(item, compound);
    }

    public Compound getCompound() {
        return compound;
    }

    public List<Element> getCompoundElements() {
        return compound.getElements();
    }

    public static List<Element> getCompoundElementsOf(Item item) {
        if (item instanceof CompoundItem compoundItem) {
            return compoundItem.getCompoundElements();
        } else if (compatibleItems.getOrDefault(item, Compound.EMPTY) != Compound.EMPTY) {
            return compatibleItems.getOrDefault(item, Compound.EMPTY).getElements();
        } else {
            return Compound.EMPTY.getElements();
        }
    }
}
