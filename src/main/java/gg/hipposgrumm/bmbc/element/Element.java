package gg.hipposgrumm.bmbc.element;

import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;

public class Element {
    private final TranslatableContents name;
    private final double meltingPoint;
    private final double boilingPoint;

    /**
     * @apiNote Temperature in Celsius
     */
    public Element(ResourceLocation name, double meltingPoint, double boilingPoint) {
        this.name = new TranslatableContents("element."+name.getNamespace()+"."+name.getPath(), name.getPath(), TranslatableContents.NO_ARGS);
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    public String getName() {
        return name.getKey();
    }

    public ElementState getState(float temperature) {
        if (temperature >= meltingPoint) {
            if (temperature >= boilingPoint) {
                if (temperature > 150000000) return ElementState.PLASMA;
                return ElementState.GAS;
            } else {
                return ElementState.SOLID;
            }
        } else if (temperature < meltingPoint) {
            return ElementState.LIQUID;
        } else {
            return ElementState.UNKNOWN;
        }
    }
}
