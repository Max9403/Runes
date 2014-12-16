package com.ers.runes.utilities;

import com.ers.runes.MainMod;
import com.ers.runes.tileentities.RuneTileEntity;
import net.minecraft.world.World;

import javax.xml.transform.Result;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class Util {
    public enum BlockSide {
        Bottom(0),
        Top(1),
        North(2),
        South(3),
        West(4),
        East(5);

        public int value = 0;

        private BlockSide(int value) {
            this.value = value;
        }
    }

    public static boolean attemptToActivate(World world, int x, int y, int z) {
        boolean validRune = false;
        if(world.getBlock(x, y, z) == MainMod.rune) {
            if(world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1) && world.isAirBlock(x + 1, y, z) &&  world.isAirBlock(x - 1, y, z)) {
                validRune = true;
                if(!((RuneTileEntity) world.getTileEntity(x, y, z)).controller) {
                    ((RuneTileEntity) world.getTileEntity(x, y, z)).controller = true;
                    ((RuneTileEntity) world.getTileEntity(x, y, z)).active = true;
                    ((RuneTileEntity) world.getTileEntity(x, y, z)).size = 0;
                    world.getTileEntity(x, y, z).markDirty();
                    world.markBlockForUpdate(x, y, z);
                }
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
                    if(!((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).controller) {
                        ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).controller = true;
                        ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).active = true;
                        ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ)).size = width1;
                        world.getTileEntity(x - offsetX, y, z - offsetZ).markDirty();
                        world.markBlockForUpdate(x - offsetX, y, z - offsetZ);
                    }
                }
                System.out.println("Runes can form: " + validRune + "{ " + width1 + ", " + width2 + ", " + height1 + ", " + height2 + ", " + offsetZ + ", " + offsetX +", " + width1 * 4 + "}");
            }

        }
        return validRune;
    }

    public static RuneTileEntity tryGetRuneTileEntityController(World world, int x, int y, int z)  {
        RuneTileEntity result = null;
        boolean validRune = false;
        if(world.getBlock(x, y, z) == MainMod.rune) {
            if(world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1) && world.isAirBlock(x + 1, y, z) &&  world.isAirBlock(x - 1, y, z)) {
                result = ((RuneTileEntity) world.getTileEntity(x, y, z));
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
                    result = ((RuneTileEntity) world.getTileEntity(x - offsetX, y, z - offsetZ));
                }
                System.out.println("Runes can form: " + validRune + "{ " + width1 + ", " + width2 + ", " + height1 + ", " + height2 + ", " + offsetZ + ", " + offsetX +", " + width1 * 4 + "}");
            }

        }
        return result;
    }
}
