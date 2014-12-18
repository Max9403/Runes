package com.ers.runes.tileentities;

import com.ers.runes.MainMod;
import com.ers.runes.effects.particles.RuneActivationParticle;
import net.minecraft.client.Minecraft;
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
    public int size = -1;
    public int current = 0;
    int counter = 0;

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
        par1.setInteger("runeType", runeType);
        par1.setString("owner", owner);
        par1.setBoolean("controller", controller);
        par1.setBoolean("active", active);
        par1.setInteger("size", size);
        par1.setInteger("current", current);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        this.runeType = par1.getInteger("runeType");
        this.owner = par1.getString("owner");
        this.controller = par1.getBoolean("controller");
        this.active = par1.getBoolean("active");
        this.size = par1.getInteger("size");
        this.current = par1.getInteger("current");
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setInteger("runeType", runeType);
        syncData.setString("owner", owner);
        syncData.setBoolean("controller", controller);
        syncData.setBoolean("active", active);
        syncData.setInteger("size", size);
        syncData.setInteger("current", current);
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
        this.size = content.getInteger("size");
        this.current = content.getInteger("current");
    }

    @Override
    public void updateEntity() {
        if(controller && active) {
            if(counter < 40) {
                counter++;
                return;
            }
            counter = 0;
            if (current > size * 4 - 1) {
                current = 0;
            }
            int xChange = 0, zChange = 0;
                if (current > size) {
                    if(current > 3 * size) {
                        xChange = 0;
                    } else if(current > 2 * size) {
                        xChange = size - (current - 2 * size);
                    } else {
                        xChange = size;
                    }
                    if (current > 3 * size) {
                        zChange = current - 3 * size;
                    } else if (current < 2 * size) {
                        zChange = current - size;
                    } else {
                        zChange = size;
                    }
                } else {
                xChange = current;
            }

            try {
                MainMod.RUNES.get(((RuneTileEntity) worldObj.getTileEntity(xCoord + xChange, yCoord, zCoord + zChange)).runeType).runeTick(worldObj, xCoord + xChange, yCoord, zCoord + zChange, xCoord, yCoord, zCoord, size);
            } catch (Exception ex) {
                controller = false;
                active = false;
            }

            Minecraft.getMinecraft().effectRenderer.addEffect(new RuneActivationParticle(worldObj, xCoord + xChange + 0.5D, yCoord, zCoord + zChange + 0.5D, 0.0D, 0.0D, 0.0D));
            current++;
        }
    }
}
