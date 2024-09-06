package com.jodexindustries.dcprizepreview.gui;

import com.jodexindustries.donatecase.api.Case;
import com.jodexindustries.donatecase.api.data.CaseData;
import com.jodexindustries.donatecase.api.events.CaseInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.UUID;

public class EventListener implements Listener {
    private static final HashSet<UUID> players = new HashSet<>();

    @EventHandler
    public void onInteract(CaseInteractEvent e) {
        if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
            CaseData caseData = Case.getCase(e.getCaseType());
            if(caseData != null) {
                Inventory inventory = PreviewGUI.loadGUI(caseData);
                if(inventory == null) return;

                e.getPlayer().openInventory(inventory);
                players.add(e.getPlayer().getUniqueId());
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(players.contains(e.getWhoClicked().getUniqueId())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        players.remove(e.getPlayer().getUniqueId());
    }
}
