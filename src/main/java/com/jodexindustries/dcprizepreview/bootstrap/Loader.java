package com.jodexindustries.dcprizepreview.bootstrap;

import com.jodexindustries.dcprizepreview.gui.EventListener;
import com.jodexindustries.donatecase.api.addon.internal.InternalJavaAddon;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Loader {
    private JavaPlugin plugin;
    private InternalJavaAddon addon;
    private EventListener listener;

    public Loader(InternalJavaAddon addon) {
        this.addon = addon;
    }

    public Loader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void enable() {
        listener = new EventListener();
        if(plugin != null) Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        if(addon != null) Bukkit.getServer().getPluginManager().registerEvents(listener, addon.getDonateCase());
    }

    public void disable() {
        HandlerList.unregisterAll(listener);
    }
}
