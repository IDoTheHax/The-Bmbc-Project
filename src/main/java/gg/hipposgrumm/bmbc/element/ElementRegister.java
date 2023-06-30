package gg.hipposgrumm.bmbc.element;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.BMBC_Main;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementRegister {
    public static final Element UNKNOWN = new Element(new Element.Data(new ResourceLocation(BMBC_Main.MODID, "unknown"), "Ukn", 0), -32768, 32767);
    private static Map<ResourceLocation, Element> registeredElements = new HashMap<>()
    {{
        put(UNKNOWN.getData().getId(), UNKNOWN);
    }};
    public static Element registerElement(Element.Data data, double meltingPoint, double boilingPoint) {
        Element element = new Element(data, meltingPoint, boilingPoint);
        if (registeredElements.containsKey(data.getId())) {
            LogUtils.getLogger().warn("Element called "+data+" already exists!");
        } else if (!(meltingPoint<boilingPoint)) {
            LogUtils.getLogger().warn("Element called " + data + " must have a boiling point higher than its melting point!");
        } else {
            registeredElements.put(data.getId(), element);
        }
        return element;
    }

    public static Element getElement(ResourceLocation name) {
        return registeredElements.getOrDefault(name, UNKNOWN);
    }
}
