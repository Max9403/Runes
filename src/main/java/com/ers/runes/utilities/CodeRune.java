package com.ers.runes.utilities;

import net.minecraft.util.ResourceLocation;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class CodeRune implements RuneWrapper {

    private String name;
    private String resourceName;
    private ResourceLocation textureLocation;

    public CodeRune(String name, String resourceName, ResourceLocation textureLocation) {
        this.name = name;
        this.resourceName = resourceName;
        this.textureLocation = textureLocation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getResourceName() {
        return resourceName;
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return textureLocation;
    }


    @Override
    public int getRenderColour() {
        return 0x000000;
    }
}
