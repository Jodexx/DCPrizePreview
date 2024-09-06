package com.jodexindustries.dcprizepreview;

import com.jodexindustries.donatecase.api.events.CaseInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class EventListener implements Listener {
    @EventHandler
    public void onInteract(CaseInteractEvent e) {
        if(e.getAction() == Action.LEFT_CLICK_BLOCK) {

        }
    }
}
