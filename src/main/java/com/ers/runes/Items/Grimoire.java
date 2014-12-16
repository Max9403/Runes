package com.ers.runes.Items;

import com.ers.runes.MainMod;
import net.minecraft.item.Item;

/**
 * Created by Benjamin on 2014-12-16.
 */
public class Grimoire extends Item {
    public Grimoire() {
        setMaxStackSize(1);
        setUnlocalizedName("runeGrimoire");
        setTextureName(MainMod.MODID + ":runeGrimoire");
        setCreativeTab(MainMod.runeTab);
    }
}
