package com.ers.runes;

import com.ers.runes.Items.RuneChisel;
import com.ers.runes.blocks.Rune;
import com.ers.runes.utilities.CodeRune;
import com.ers.runes.utilities.RuneWrapper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Benjamin on 2014-12-12.
 */
@Mod(modid = MainMod.MODID, version = MainMod.VERSION, name = MainMod.NAME)
public class MainMod {
    public static final String MODID = "runes";
    public static final String NAME = "Runes";
    public static final String VERSION = "1.0.0";

    @Mod.Instance("runes")
    public static MainMod instance;

    public static final CopyOnWriteArrayList<RuneWrapper> RUNES = new CopyOnWriteArrayList<RuneWrapper>();

    public static Block rune = new Rune();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RUNES.add(new CodeRune("Harvest"));
        RUNES.add(new CodeRune("Test"));
        GameRegistry.registerBlock(rune, RuneChisel.class, rune.getUnlocalizedName().substring(5));

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

}
