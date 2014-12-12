package com.ers.runes;

import com.ers.runes.Items.RuneChisel;
import com.ers.runes.Items.RuneItem;
import com.ers.runes.blocks.Rune;
import com.ers.runes.extras.RuneCreativeTab;
import com.ers.runes.utilities.CodeRune;
import com.ers.runes.utilities.RuneWrapper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RUNES.add(new CodeRune("Harvest", "harvest", MODID + ":harvest"));
        RUNES.add(new CodeRune("Test", "test", MODID + ":test"));
        rune = new Rune();
        chisel = new RuneChisel();
        GameRegistry.registerBlock(rune, RuneItem.class, rune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(chisel, "runeChisel");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

}
