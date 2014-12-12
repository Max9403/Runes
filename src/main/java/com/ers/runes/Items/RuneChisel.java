package com.ers.runes.Items;

import com.ers.runes.MainMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
        setCreativeTab(MainMod.runeTab);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {

        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.stackTagCompound.setInteger("current", -1);
        }
        if ((Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) && !world.isRemote) {
            itemStack.stackTagCompound.setInteger("current", itemStack.stackTagCompound.getInteger("current") == MainMod.RUNES.size() - 1 ? 0 : itemStack.stackTagCompound.getInteger("current") + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        super.onCreated(itemStack, world, player);
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setInteger("current", 0);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("Used to write runes on stone");
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
            itemStack.stackTagCompound.setInteger("current", 0);
        }
        list.add("Current run: " + MainMod.RUNES.get(itemStack.stackTagCompound.getInteger("current")).getName());

    }

    @Override
    public boolean canItemEditBlocks() {
        return true;
    }
}
