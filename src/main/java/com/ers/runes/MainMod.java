package com.ers.runes;

import com.ers.runes.Items.Grimoire;
import com.ers.runes.Items.RuneChisel;
import com.ers.runes.Items.RuneItem;
import com.ers.runes.blocks.Rune;
import com.ers.runes.extras.RuneCreativeTab;
import com.ers.runes.tileentities.RuneTileEntity;
import com.ers.runes.tileentities.renders.RuneTileRenderer;
import com.ers.runes.utilities.CodeRune;
import com.ers.runes.utilities.RuneWrapper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Benjamin on 2014-12-12.
 */
@Mod(modid = MainMod.MODID, version = MainMod.VERSION, name = MainMod.NAME)
public class MainMod {
    public static final String MODID = "runes";
    public static final String NAME = "Runes";
    public static final String VERSION = "1.0.0";
    public static final CreativeTabs runeTab = new RuneCreativeTab(MainMod.MODID);

    @Mod.Instance("runes")
    public static MainMod instance;

    public static final CopyOnWriteArrayList<RuneWrapper> RUNES = new CopyOnWriteArrayList<RuneWrapper>();

    public static Block rune;

    public static Item chisel;
    public static Item grimoire = new Grimoire();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RUNES.add(new CodeRune("Harvest", "harvest", new ResourceLocation(MODID + ":textures/blocks/harvest.png")));
        RUNES.add(new CodeRune("Growth", "growth", new ResourceLocation(MODID + ":textures/blocks/growth.png")));
        RUNES.add(new CodeRune("Crafting", "crafting", new ResourceLocation(MODID + ":textures/blocks/crafting.png")));
        RUNES.add(new CodeRune("Movement", "movement", new ResourceLocation(MODID + ":textures/blocks/movement.png")));
        RUNES.add(new CodeRune("Blocks", "blocks", new ResourceLocation(MODID + ":textures/blocks/blocks.png")));
        RUNES.add(new CodeRune("Fluids", "fluids", new ResourceLocation(MODID + ":textures/blocks/fluids.png")));
        RUNES.add(new CodeRune("Protection", "protection", new ResourceLocation(MODID + ":textures/blocks/protection.png")));
        RUNES.add(new CodeRune("Enhancement", "enhancement", new ResourceLocation(MODID + ":textures/blocks/enhancement.png")));
        RUNES.add(new CodeRune("Life", "life", new ResourceLocation(MODID + ":textures/blocks/life.png")));
        RUNES.add(new CodeRune("Harm", "harm", new ResourceLocation(MODID + ":textures/blocks/harm.png")));
        RUNES.add(new CodeRune("Experience", "experience", new ResourceLocation(MODID + ":textures/blocks/experience.png")));
        RUNES.add(new CodeRune("Heat", "heat", new ResourceLocation(MODID + ":textures/blocks/heat.png")));
        RUNES.add(new CodeRune("Placing", "placing", new ResourceLocation(MODID + ":textures/blocks/placing.png")));
        RUNES.add(new CodeRune("Gathering", "gathering", new ResourceLocation(MODID + ":textures/blocks/gathering.png")));
        RUNES.add(new CodeRune("Translocation", "translocation", new ResourceLocation(MODID + ":textures/blocks/translocation.png")));
        RUNES.add(new CodeRune("Light", "light", new ResourceLocation(MODID + ":textures/blocks/light.png")));
        RUNES.add(new CodeRune("Compacting", "compacting", new ResourceLocation(MODID + ":textures/blocks/compacting.png")));
        RUNES.add(new CodeRune("Mining", "mining", new ResourceLocation(MODID + ":textures/blocks/mining.png")));
        RUNES.add(new CodeRune("Riches", "riches", new ResourceLocation(MODID + ":textures/blocks/riches.png")));
        RUNES.add(new CodeRune("Power", "power", new ResourceLocation(MODID + ":textures/blocks/power.png")));
        RUNES.add(new CodeRune("Energy", "energy", new ResourceLocation(MODID + ":textures/blocks/energy.png")));
        RUNES.add(new CodeRune("Crumbling", "crumbling", new ResourceLocation(MODID + ":textures/blocks/crumbling.png")));
        RUNES.add(new CodeRune("Items", "items", new ResourceLocation(MODID + ":textures/blocks/items.png")));
        RUNES.add(new CodeRune("Testing", "test", new ResourceLocation(MODID + ":textures/blocks/test.png")));
        System.out.println(RUNES.size() + " runes have been found");
        rune = new Rune();
        chisel = new RuneChisel();
        GameRegistry.registerBlock(rune, rune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(chisel, "runeChisel");
        GameRegistry.registerItem(grimoire, "runeGrimoire");
        GameRegistry.registerTileEntity(RuneTileEntity.class, "Rune Tile Entity");
        ClientRegistry.bindTileEntitySpecialRenderer(RuneTileEntity.class, new RuneTileRenderer());
        FMLInterModComms.sendMessage("Waila", "register", "com.ers.runes.utilities.WailaProvider.wailaCallback");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

}
