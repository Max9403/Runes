package com.ers.runes.Items;

import com.ers.runes.MainMod;
import com.ers.runes.runeium.RuneiumStorage;
import com.ers.runes.tileentities.RuneTileEntity;
import com.ers.runes.utilities.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

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
        boolean result = false;
        if (itemStack.stackTagCompound == null) {

            itemStack.stackTagCompound = new NBTTagCompound();
        }
        if (world.getTileEntity(x, y, z) instanceof RuneiumStorage) {
            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText("Has a charge of: " + ((RuneiumStorage) world.getTileEntity(x, y, z)).getStored()));
            }
            if ((Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))) {
                if (world.isRemote) {
                    player.addChatMessage(new ChatComponentText("Started linkage"));
                }
                System.out.println(world.getTileEntity(x, y, z));
                if(world.getTileEntity(x, y, z) instanceof RuneiumStorage) {

                    itemStack.stackTagCompound.setInteger("x", x);
                    itemStack.stackTagCompound.setInteger("y", y);
                    itemStack.stackTagCompound.setInteger("z", z);
                }
            }
            result = true;
        } else if (world.getBlock(x, y, z) == MainMod.rune) {
            RuneTileEntity test = Util.tryGetRuneTileEntityController(world, x, y, z);

            if (test != null && test.controller) {
                if ((Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))) {
                    if (itemStack.stackTagCompound.hasKey("x")) {
                        if (test.attemptEnergyLink(itemStack.stackTagCompound.getInteger("x"), itemStack.stackTagCompound.getInteger("y"), itemStack.stackTagCompound.getInteger("z"))) {
                            if (world.isRemote) {
                                player.addChatMessage(new ChatComponentText("Energy linked"));
                            }
                            itemStack.stackTagCompound.removeTag("x");
                            itemStack.stackTagCompound.removeTag("y");
                            itemStack.stackTagCompound.removeTag("z");
                            test.markDirty();
                        } else {
                            if (world.isRemote) {
                                player.addChatMessage(new ChatComponentText("Failed to link"));
                            }
                        }

                        result = true;
                    }

                } else {
                    test.active = !test.active;

                    if (world.isRemote) {
                        if (test.active) {
                            player.addChatMessage(new ChatComponentText("Runes are active"));
                        } else {
                            player.addChatMessage(new ChatComponentText("Runes are not active"));
                        }
                    }
                    result = true;
                }
            } else {
                result = Util.attemptToActivate(world, x, y, z);
                if (world.isRemote) {
                    player.addChatMessage(new ChatComponentText("Runes are active"));
                }
            }
        } else {
            if (side == Util.BlockSide.Top.value) {
                world.setBlock(x, y + 1, z, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x, y + 1, z);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;
            } else if (side == Util.BlockSide.Bottom.value) {
                world.setBlock(x, y - 1, z, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;
            } else if (side == Util.BlockSide.North.value) {

                world.setBlock(x + 1, y, z, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x + 1, y, z);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;
            } else if (side == Util.BlockSide.South.value) {
                world.setBlock(x - 1, y, z, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x - 1, y, z);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;
            } else if (side == Util.BlockSide.West.value) {
                world.setBlock(x, y, z + 1, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x, y, z + 1);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;
            } else if (side == Util.BlockSide.East.value) {
                world.setBlock(x, y, z - 1, MainMod.playerRuneiumChunk);
                TileEntity tileEntity = world.getTileEntity(x, y, z - 1);
                if (tileEntity != null) {
                    ((RuneiumStorage) tileEntity).charge(2000);
                }
                result = true;

            }
        }
        return result;
    }


    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        super.onCreated(itemStack, world, player);
        itemStack.stackTagCompound = new NBTTagCompound();
    }
    @Override
    public boolean canItemEditBlocks() {
        return true;
    }
}
