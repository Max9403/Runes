package com.ers.runes.utilities;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class CodeRune implements RuneWrapper {

    private String name;
    private String resourceName;
    private ResourceLocation textureLocation;
    private int cost;

    public CodeRune(String name, String resourceName, ResourceLocation textureLocation) {
        this.name = name;
        this.resourceName = resourceName;
        this.textureLocation = textureLocation;
    }

    public CodeRune(String name, String resourceName, ResourceLocation resourceLocation, int cost) {
        this(name, resourceName, resourceLocation);
        this.cost = cost;
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

    @Override
    public void runeTick(World world, int runeX, int runeY, int runeZ, int x, int y, int z, int size) {
    }

    @Override
    public int getCost() {
        return cost;
    }
}
