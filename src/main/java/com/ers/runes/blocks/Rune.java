package com.ers.runes.blocks;

import com.ers.runes.MainMod;
import com.ers.runes.tileentities.RuneTileEntity;
import com.ers.runes.utilities.RuneWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.Int;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class Rune extends Block implements ITileEntityProvider{

    public Rune() {
        super(Material.glass);
        setHardness(0.5F);
        setBlockBounds(0, 0, 0, 1, 0, 1);
        setStepSound(Block.soundTypeStone);
        setBlockName("rune");
        setTickRandomly(true);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        return world.getBlock(x, y, z) == Blocks.stone;
    }

    @Override
    public boolean canRenderInPass(int pass) {
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x, y - 1, z) != Blocks.stone) {
            world.setBlockToAir(x, y, z);
        }
        if(block == MainMod.rune) {
            
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
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
    public int damageDropped(int damage) {
        return damage;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new RuneTileEntity();
    }
}
