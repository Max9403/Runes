package com.ers.runes.effects.particles;

import com.ers.runes.MainMod;
import com.ers.runes.tileentities.RuneTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Benjamin on 2014-12-17.
 */
public class RuneActivationParticle extends EntityFX {
    private final ResourceLocation particleLocation = new ResourceLocation(MainMod.MODID, "textures/particles/magic.png");

    protected RuneActivationParticle(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.particleRed = 0.5F;
        this.particleGreen = 0.8F;
        this.particleBlue = 1F;
        this.particleAlpha = 0.8F;
    }

    public RuneActivationParticle(World world, double x, double y, double z, double valX, double valY, double valZ) {
        super(world, x, y, z, valX, valY, valZ);
        this.particleRed = 0.5F;
        this.particleGreen = 0.8F;
        this.particleBlue = 1F;
        this.particleAlpha = 0.8F;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float partialTicks, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY) {
        tessellator.draw();

        float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
        float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
        float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
        Minecraft.getMinecraft().getTextureManager().bindTexture(particleLocation);

        tessellator.startDrawingQuads();
        GL11.glDisable(GL11.GL_LIGHTING);
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        GL11.glColor4f(1, 1, 1, 1);

        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);

        double adjustment = Math.random() * 0.5;

        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z + 0.25, 1, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z + 0.25, 0, 0);
        tessellator.addVertexWithUV(x + 0.5, y + 0.6 + adjustment, z + 0.25, 0, 1);
        tessellator.addVertexWithUV(x + 0.5, y + 0.1 + adjustment, z + 0.25, 1, 1);

        tessellator.addVertexWithUV(x + 0.5, y + 0.1 + adjustment, z + 0.25, 1, 0);
        tessellator.addVertexWithUV(x + 0.5, y + 0.6 + adjustment, z + 0.25, 0, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z + 0.25, 0, 1);
        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z + 0.25, 1, 1);

        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z, 1, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z, 0, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z + 0.5, 0, 1);
        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z + 0.5, 1, 1);

        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z + 0.5, 1, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z + 0.5, 0, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z, 0, 1);
        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z, 1, 1);

        adjustment = Math.random() * 0.5;

        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z - 0.25, 1, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z - 0.25, 0, 0);
        tessellator.addVertexWithUV(x + 0.5, y + 0.6 + adjustment, z - 0.25, 0, 1);
        tessellator.addVertexWithUV(x + 0.5, y + 0.1 + adjustment, z - 0.25, 1, 1);

        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z, 1, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z, 0, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z + 0.5, 0, 1);
        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z + 0.5, 1, 1);

        tessellator.addVertexWithUV(x + 0.5, y + 0.1 + adjustment, z - 0.25, 1, 0);
        tessellator.addVertexWithUV(x + 0.5, y + 0.6 + adjustment, z - 0.25, 0, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z - 0.25, 0, 1);
        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z - 0.25, 1, 1);

        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z + 0.5, 1, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z + 0.5, 0, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z, 0, 1);
        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z, 1, 1);

        adjustment = Math.random() * 0.5;

        tessellator.addVertexWithUV(x - 0.5, y + 0.1 + adjustment, z + 0.25, 1, 0);
        tessellator.addVertexWithUV(x - 0.5, y + 0.6 + adjustment, z + 0.25, 0, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z + 0.25, 0, 1);
        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z + 0.25, 1, 1);

        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z - 0.5, 1, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z - 0.5, 0, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z, 0, 1);
        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z, 1, 1);

        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z + 0.25, 1, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z + 0.25, 0, 0);
        tessellator.addVertexWithUV(x - 0.5, y + 0.6 + adjustment, z + 0.25, 0, 1);
        tessellator.addVertexWithUV(x - 0.5, y + 0.1 + adjustment, z + 0.25, 1, 1);

        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z, 1, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z, 0, 0);
        tessellator.addVertexWithUV(x + 0.25, y + 0.6 + adjustment, z - 0.5, 0, 1);
        tessellator.addVertexWithUV(x + 0.25, y + 0.1 + adjustment, z - 0.5, 1, 1);

        adjustment = Math.random() * 0.5;

        tessellator.addVertexWithUV(x - 0.5, y + 0.1 + adjustment, z - 0.25, 1, 0);
        tessellator.addVertexWithUV(x - 0.5, y + 0.6 + adjustment, z - 0.25, 0, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z - 0.25, 0, 1);
        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z - 0.25, 1, 1);

        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z - 0.5, 1, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z - 0.5, 0, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z, 0, 1);
        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z, 1, 1);

        tessellator.addVertexWithUV(x, y + 0.1 + adjustment, z - 0.25, 1, 0);
        tessellator.addVertexWithUV(x, y + 0.6 + adjustment, z - 0.25, 0, 0);
        tessellator.addVertexWithUV(x - 0.5, y + 0.6 + adjustment, z - 0.25, 0, 1);
        tessellator.addVertexWithUV(x - 0.5, y + 0.1 + adjustment, z - 0.25, 1, 1);

        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z, 1, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z, 0, 0);
        tessellator.addVertexWithUV(x - 0.25, y + 0.6 + adjustment, z - 0.5, 0, 1);
        tessellator.addVertexWithUV(x - 0.25, y + 0.1 + adjustment, z - 0.5, 1, 1);
        tessellator.draw();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/particle/particles.png"));
        tessellator.startDrawingQuads();
    }
}
