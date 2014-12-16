package com.ers.runes.utilities;

import net.minecraft.util.ResourceLocation;

/**
 * Created by Benjamin on 2014-12-12.
 */
public interface RuneWrapper {
    String getName();

    String getResourceName();

    ResourceLocation getTextureLocation();

    int getRenderColour();
}
