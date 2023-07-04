package gg.hipposgrumm.bmbc.items;

import gg.hipposgrumm.bmbc.element.Element;
import gg.hipposgrumm.bmbc.element.ElementRegister;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compound {
    public static final Compound EMPTY = new Compound(ElementRegister.UNKNOWN);
    private final List<Element> compoundElements;

    public Compound(Element... elements) {
        if (elements.length>0) {
            compoundElements = List.of(elements);
        } else {
            compoundElements = EMPTY.compoundElements;
        }
    }

    public List<Element> getElements() {
        return compoundElements;
    }
}
