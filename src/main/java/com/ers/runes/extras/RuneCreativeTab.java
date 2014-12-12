package com.ers.runes.extras;

import com.ers.runes.MainMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class RuneCreativeTab extends CreativeTabs {
        public RuneCreativeTab(String name) {
            super(name);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return MainMod.chisel;
        }
}
