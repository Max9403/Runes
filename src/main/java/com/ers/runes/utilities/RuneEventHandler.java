package com.ers.runes.utilities;

import com.ers.runes.MainMod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

/**
 * Created by Benjamin on 2014-12-20.
 */
public class RuneEventHandler {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        if(event.crafting.getItem() == MainMod.chisel || event.crafting.getItem() == MainMod.grimoire) {
            event.player.triggerAchievement(MainMod.runeStart);
        }
    }
}
