package com.ers.runes.utilities;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Benjamin on 2014-12-12.
 */
public interface RuneWrapper {
    String getName();

    String getResourceName();

    ResourceLocation getTextureLocation();

    int getRenderColour();

    void runeTick(World world, int runeX, int runeY, int runeZ, int x, int y, int z, int size);
}
