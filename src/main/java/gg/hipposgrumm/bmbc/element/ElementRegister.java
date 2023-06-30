package gg.hipposgrumm.bmbc.element;

import com.mojang.logging.LogUtils;
import gg.hipposgrumm.bmbc.BMBC_Main;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ElementRegister {
    private static Map<ResourceLocation, Element> registeredElements;
    public static final Element UNKNOWN = new Element(new ResourceLocation(BMBC_Main.MODID, "unknown"), -32768, 32767);

    public static Element registerElement(ResourceLocation id, double meltingPoint, double boilingPoint) {
        Element element = new Element(id, meltingPoint, boilingPoint);
        if (registeredElements.containsKey(id)) {
            LogUtils.getLogger().warn("Element called "+id+" already exists!");
        } else if (!(meltingPoint<boilingPoint)) {
            LogUtils.getLogger().warn("Element called "+id+" must have a boiling point higher than its melting point!");
        } else {
            registeredElements.put(id, element);
        }
        return element;
    }

    public static Element getElement(ResourceLocation name) {
        return registeredElements.getOrDefault(name, UNKNOWN);
    }
}
