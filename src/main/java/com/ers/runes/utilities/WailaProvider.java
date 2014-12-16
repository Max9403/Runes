package com.ers.runes.utilities;

import com.ers.runes.MainMod;
import com.ers.runes.blocks.Rune;
import com.ers.runes.tileentities.RuneTileEntity;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Benjamin on 2014-12-16.
 */
public class WailaProvider implements IWailaDataProvider {
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        if(accessor.getTileEntity() instanceof RuneTileEntity) {
            currenttip.add(MainMod.RUNES.get(((RuneTileEntity)accessor.getTileEntity()).runeType).getName());
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(TileEntity tileEntity, NBTTagCompound nbtTagCompound, World world, int i, int i1, int i2) {
        return nbtTagCompound;
    }

    public static void wailaCallback(IWailaRegistrar registrar){
        registrar.registerBodyProvider(new WailaProvider(), Rune.class);
    }
}
