package com.ers.runes.tileentities.renders;

import com.ers.runes.MainMod;
import com.ers.runes.tileentities.RuneTileEntity;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Benjamin on 2014-12-15.
 */
public class RuneTileRenderer extends TileEntitySpecialRenderer {
    public final int renderId;

    public RuneTileRenderer() {
        renderId = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        Minecraft.getMinecraft().renderEngine.bindTexture(MainMod.RUNES.get(((RuneTileEntity)tileEntity).runeType).getTextureLocation());
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glDisable(GL11.GL_LIGHTING);
        Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0, 0.01, 1, 0, 0);
        tessellator.addVertexWithUV(1, 0.01, 1, 0, 1);
        tessellator.addVertexWithUV(1, 0.01, 0, 1, 1);
        tessellator.addVertexWithUV(0, 0.01, 0, 1, 0);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glPopAttrib();
    }
}
