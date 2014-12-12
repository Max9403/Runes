package com.ers.runes.blocks;

import com.ers.runes.MainMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class Rune extends Block{
    public Rune() {
        super(Material.glass);
        setHardness(0.5F);
        setBlockBounds(0, 0, 0, 1, 0, 1);
        setStepSound(Block.soundTypeStone);
        setBlockName("rune");
        setBlockTextureName("runes:rune");

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
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int blocks = 0; blocks <= MainMod.RUNES.size(); blocks++) {
            list.add(new ItemStack(item, 1, blocks));
        }
    }
}
