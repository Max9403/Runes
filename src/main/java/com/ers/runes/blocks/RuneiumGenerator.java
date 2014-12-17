package com.ers.runes.blocks;

import com.ers.runes.MainMod;
import com.ers.runes.runeium.RuneiumStorage;
import com.ers.runes.tileentities.RuneiumGeneratorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Benjamin on 2014-12-17.
 */
public class RuneiumGenerator extends Block implements ITileEntityProvider {
    protected RuneiumGenerator() {
        super(Material.glass);
        setHardness(3F);
        setBlockName("runeCrystal");
        setBlockTextureName(MainMod.MODID + ":runeCrystal");
        setTickRandomly(true);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new RuneiumGeneratorTileEntity();
    }
}
