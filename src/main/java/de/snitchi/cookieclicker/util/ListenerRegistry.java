package de.snitchi.cookieclicker.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerRegistry {

    public void registerListener(Plugin plugin) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        /* Sample:
        Listener joinListener = new JoinListener(configHandler);
        pluginManager.registerEvents(joinListener, plugin);
         */
    }
}
