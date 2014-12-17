package com.ers.runes.Items;

import com.ers.runes.MainMod;
import com.ers.runes.runeium.RuneiumStorage;
import com.ers.runes.tileentities.RuneTileEntity;
import com.ers.runes.tileentities.RuneiumGeneratorTileEntity;
import com.ers.runes.utilities.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
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
        boolean result;
        if(world.getTileEntity(x, y, z) instanceof RuneiumStorage) {
            player.addChatMessage(new ChatComponentText("Has a charge of: " + ((RuneiumStorage)world.getTileEntity(x, y, z)).getStored()));
            result = true;
        } else {
            RuneTileEntity test = Util.tryGetRuneTileEntityController(world, x, y, z);
            if (test != null && test.controller) {
                test.active = !test.active;
                result = true;
            } else {
                result = Util.attemptToActivate(world, x, y, z);
            }
        }
        return result;
    }
}
