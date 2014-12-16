package com.ers.runes.Items;

import com.ers.runes.MainMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        boolean validRune = false;
        if(world.getBlock(x, y, z) == MainMod.rune) {
            if(world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1) && world.isAirBlock(x + 1, y, z) &&  world.isAirBlock(x - 1, y, z)) {
                validRune = true;
            } else {
                int width1 = 0, width2 = 0, height1 = 0, height2 = 0;

                int offset1 = 0, offset2 = 0;

                while (world.getBlock(x, y, z - offset1 -1) == MainMod.rune) {
                    /*if(world.getBlock(x - 1, y, z - offset1 -1) == MainMod.rune || world.getBlock(x + 1, y, z - offset1 -1) == MainMod.rune) {
                        offset1++;
                        break;
                    }*/
                    offset1++;
                }

                while (world.getBlock(x - offset2 -1, y, z) == MainMod.rune) {
                    offset2++;
                }

                if (offset1 == 0) {
                    while (world.getBlock(x - offset2, y, z - offset1 -1) == MainMod.rune) {
                        offset1++;
                    }
                }
                if (offset2 == 0) {
                    while (world.getBlock(x - offset2 -1, y, z - offset1) == MainMod.rune) {
                        offset2++;
                    }
                }

                do {
                    if(world.getBlock(x - offset2 + width1 + 1, y, z - offset1) == MainMod.rune) {
                        width1++;
                    } else {
                        break;
                    }
                } while(true);

                do {
                    if(world.getBlock(x - offset2 + width1, y, z + height1 + 1 - offset1) == MainMod.rune) {
                        height1++;
                    } else {
                        break;
                    }
                } while(true);

                do {
                    if(world.getBlock(x - offset2 + width2 + 1,  y, z + height1- offset1) == MainMod.rune) {
                        width2++;
                    } else {
                        break;
                    }
                } while(true);


                do {
                    if(world.getBlock(x - offset2 + width1,  y, z + height2 + 1- offset1 ) == MainMod.rune) {
                        height2++;
                    } else {
                        break;
                    }
                } while(true);

                validRune = width1 != 0 && width2 != 0 && height1 != 0 && height2 != 0 && width1 == width2 && width2 == height1 && height1 == height2;
                System.out.println("Runes can form: " + validRune + "{ " + width1 + ", " + width2 + ", " + height1 + ", " + height2 + ", " + offset1 + ", " + offset2 +"}");
            }

        }
        return validRune;
    }
}
