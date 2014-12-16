package com.ers.runes.utilities;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class JsonRune implements RuneWrapper {

    private String name;
    private String resourceName;
    private ResourceLocation resourceLocation;

    public JsonRune(String name, String resourceName, ResourceLocation resourceLocation) {
        this.name = name;
        this.resourceName = resourceName;
        this.resourceLocation = resourceLocation;
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
        return resourceLocation;
    }


    @Override
    public int getRenderColour() {
        return 0xFFFFFF;
    }

    @Override
    public void runeTick(World world, int runeX, int runeY, int runeZ, int x, int y, int z, int size) {

    }
}
