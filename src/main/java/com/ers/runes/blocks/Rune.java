package com.ers.runes.blocks;

import com.ers.runes.MainMod;
import com.ers.runes.utilities.RuneWrapper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
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
public class Rune extends Block{
    public IIcon[] icons;

    public Rune() {
        super(Material.glass);
        setHardness(0.5F);
        setBlockBounds(0, 0, 0, 1, 0, 1);
        setStepSound(Block.soundTypeStone);
        setBlockName("rune");
        icons = new IIcon[MainMod.RUNES.size()];
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x, y - 1, z) != Blocks.stone) {
            world.setBlockToAir(x, y, z);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for(int i = 0; i < MainMod.RUNES.size(); i++) {
            icons[i] = register.registerIcon(MainMod.RUNES.get(i).getTextureName().toLowerCase());
        }
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
    public IIcon getIcon(int side, int meta) {
        return icons[meta];
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int blocks = 0; blocks <= MainMod.RUNES.size(); blocks++) {
            list.add(new ItemStack(item, 1, blocks));
        }
    }
}
