package com.ers.runes.blocks;

import com.ers.runes.tileentities.RuneiumPlayerChunkTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Benjamin on 2014-12-18.
 */
public class RuneiumPlayerChunk extends Block implements ITileEntityProvider {
    public RuneiumPlayerChunk() {
        super(Material.leaves);
        setBlockName("playerChunk");
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new RuneiumPlayerChunkTileEntity();
    }
}
