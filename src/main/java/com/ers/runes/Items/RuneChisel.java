package com.ers.runes.Items;

import com.ers.runes.MainMod;
import com.ers.runes.utilities.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class RuneChisel extends Item {

    public RuneChisel() {
        setMaxStackSize(1);
        setUnlocalizedName("runeChisel");
        setTextureName(MainMod.MODID + ":runeChisel");
        setCreativeTab(MainMod.runeTab);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.stackTagCompound.setInteger("current", 0);
        }
        if ((Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))) {
            itemStack.stackTagCompound.setInteger("current", itemStack.stackTagCompound.getInteger("current") == MainMod.RUNES.size() - 1 ? 0 : itemStack.stackTagCompound.getInteger("current") + 1);
            if(!world.isRemote) {
                player.addChatMessage(new ChatComponentText("Rune of " + MainMod.RUNES.get(itemStack.stackTagCompound.getInteger("current")).getName()));
            }
        } else {
            if(side == Util.BlockSide.Top.value) {
                if(world.getBlock(x, y, z) == Blocks.stone && world.isAirBlock(x, y + 1, z) && !world.isRemote) {
                    world.setBlock(x, y + 1, z, MainMod.rune, itemStack.stackTagCompound.getInteger("current"), 3);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        super.onCreated(itemStack, world, player);
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setInteger("current", 0);
    }

    public String getItemStackDisplayName(ItemStack itemStack)
    {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.stackTagCompound.setInteger("current", 0);
        }
        return StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(itemStack) + ".name").trim() + ": " + MainMod.RUNES.get(itemStack.stackTagCompound.getInteger("current")).getName().trim();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("Used to write runes on stone");
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.stackTagCompound.setInteger("current", 0);
        }
        list.add("Current rune: " + MainMod.RUNES.get(itemStack.stackTagCompound.getInteger("current")).getName());
    }

    @Override
    public boolean canItemEditBlocks() {
        return true;
    }
}
