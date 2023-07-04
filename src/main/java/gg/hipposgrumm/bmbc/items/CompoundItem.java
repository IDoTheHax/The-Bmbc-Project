package gg.hipposgrumm.bmbc.items;

import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CompoundItem extends Item {
    private final List<Element> compoundElements;
    public CompoundItem(Properties pProperties, Element... elements) {
        super(pProperties);
        if (elements.length>0) {
            compoundElements = List.of(elements);
        } else {
            compoundElements = List.of(ElementRegister.UNKNOWN);
        }
    }

    public List<Element> getCompoundElements() {
        return compoundElements;
    }
}
