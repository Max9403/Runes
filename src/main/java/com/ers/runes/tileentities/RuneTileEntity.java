package com.ers.runes.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Benjamin on 2014-12-15.
 */
public class RuneTileEntity extends TileEntity{
    public int runeType = -1;
    public String owner = "FakePlayer";

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
        par1.setInteger("runeType", runeType);
        par1.setString("owner", owner);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        this.runeType = par1.getInteger("runeType");
        this.owner = par1.getString("owner");
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setInteger("runeType", runeType);
        syncData.setString("owner", owner);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        NBTTagCompound content = pkt.func_148857_g();
        runeType = content.getInteger("runeType");
        owner = content.getString("owner");
    }
}
