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
    public boolean controller = false;
    public boolean active = false;
    public int width = -1;
    public int height = -1;

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
        par1.setInteger("runeType", runeType);
        par1.setString("owner", owner);
        par1.setBoolean("controller", controller);
        par1.setBoolean("active", active);
        par1.setInteger("width", width);
        par1.setInteger("height", height);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        this.runeType = par1.getInteger("runeType");
        this.owner = par1.getString("owner");
        this.controller = par1.getBoolean("controller");
        this.active = par1.getBoolean("active");
        this.width = par1.getInteger("width");
        this.height = par1.getInteger("height");
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setInteger("runeType", runeType);
        syncData.setString("owner", owner);
        syncData.setBoolean("controller", controller);
        syncData.setBoolean("active", active);
        syncData.setInteger("width", width);
        syncData.setInteger("height", height);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        NBTTagCompound content = pkt.func_148857_g();
        this.runeType = content.getInteger("runeType");
        this.owner = content.getString("owner");
        this.controller = content.getBoolean("controller");
        this.active = content.getBoolean("active");
        this.width = content.getInteger("width");
        this.height = content.getInteger("height");
    }
}
