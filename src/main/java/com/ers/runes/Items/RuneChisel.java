package com.ers.runes.Items;

import com.ers.runes.MainMod;
import net.minecraft.item.Item;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class RuneChisel extends Item {

    public RuneChisel() {
        setMaxStackSize(1);
        setUnlocalizedName("runeChisel");
        setCreativeTab(MainMod.runeTab);
    }
}
