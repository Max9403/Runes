package com.ers.runes.tileentities;

import com.ers.runes.runeium.RuneiumStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Benjamin on 2014-12-17.
 */
public class RuneiumGeneratorTileEntity extends TileEntity implements RuneiumStorage {

    private int charge = 0;
    private int counter;

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
        par1.setInteger("charge", charge);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        charge = par1.getInteger("charge");
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setInteger("charge", charge);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        NBTTagCompound content = pkt.func_148857_g();
        charge = content.getInteger("charge");
    }

    @Override
    public int getStored() {
        return charge;
    }

    @Override
    public void charge(int amount) {
        charge += amount;
    }

    @Override
    public void discharge(int amount) {
        charge -= amount;
    }

    @Override
    public void updateEntity() {
        charge += 5;
    }
}
