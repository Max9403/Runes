package com.ers.runes.Items;

import com.ers.runes.MainMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class RuneItem extends ItemBlock {
    public RuneItem(Block block) {
        super(block);
        setHasSubtypes(true);
        setUnlocalizedName("runeChisel");
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + MainMod.RUNES.get(itemstack.getItemDamage()).getResourceName();
    }
}
