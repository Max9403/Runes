package com.ers.runes.Items;

import com.ers.runes.MainMod;
import com.ers.runes.tileentities.RuneTileEntity;
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
                ((RuneTileEntity) world.getTileEntity(x, y, z)).controller = true;
                ((RuneTileEntity) world.getTileEntity(x, y, z )).size = 0;
                world.getTileEntity(x, y, z).markDirty();
            } else {
                int width1 = 0, width2 = 0, height1 = 0, height2 = 0;

                int offsetZ = 0, offsetX = 0;

                while (world.getBlock(x, y, z - offsetZ -1) == MainMod.rune) {
                    /*if(world.getBlock(x - 1, y, z - offset1 -1) == MainMod.rune || world.getBlock(x + 1, y, z - offset1 -1) == MainMod.rune) {
                        offset1++;
                        break;
                    }*/
                    offsetZ++;
                }

                while (world.getBlock(x - offsetX -1, y, z) == MainMod.rune) {
                    offsetX++;
                }

                if (offsetZ == 0) {
                    while (world.getBlock(x - offsetX, y, z - offsetZ -1) == MainMod.rune) {
                        offsetZ++;
                    }
                }
                if (offsetX == 0) {
                    while (world.getBlock(x - offsetX -1, y, z - offsetZ) == MainMod.rune) {
                        offsetX++;
                    }
                }

                do {
                    if(world.getBlock(x - offsetX + width1 + 1, y, z - offsetZ) == MainMod.rune) {
                        width1++;
                    } else {
                        break;
                    }
                } while(true);

                do {
                    if(world.getBlock(x - offsetX + width1, y, z + height1 + 1 - offsetZ) == MainMod.rune) {
                        height1++;
                    } else {
                        break;
                    }
                } while(true);

                do {
                    if(world.getBlock(x - offsetX + width2 + 1,  y, z + height1- offsetZ) == MainMod.rune) {
                        width2++;
                    } else {
                        break;
                    }
                } while(true);


                do {
                    if(world.getBlock(x - offsetX + width1,  y, z + height2 + 1- offsetZ ) == MainMod.rune) {
                        height2++;
                    } else {
                        break;
                    }
                } while(true);

                validRune = width1 != 0 && width2 != 0 && height1 != 0 && height2 != 0 && width1 == width2 && width2 == height1 && height1 == height2;
                if (validRune) {
                    ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).controller = true;
                    ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).size = width1;
                    world.getTileEntity(x - offsetX, y, z - offsetZ).markDirty();
                }
                System.out.println("Runes can form: " + validRune + "{ " + width1 + ", " + width2 + ", " + height1 + ", " + height2 + ", " + offsetZ + ", " + offsetX +", " + width1 * 4 + "}");
            }

        }
        return validRune;
    }
}
