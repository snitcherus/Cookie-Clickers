package de.snitchi.cookieclicker.util;

import de.snitchi.cookieclicker.factory.CookieFactory;
import de.snitchi.cookieclicker.listener.PlayerJoinListener;
import de.snitchi.cookieclicker.listener.PlayerJumpListener;
import de.snitchi.cookieclicker.listener.PlayerQuitListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerRegistry {

    public void registerListener(Plugin plugin, ResourceMessage resourceMessage, CookieFactory cookieFactory,
                                 ConfigHandler configHandler) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        Listener playerJumpListener = new PlayerJumpListener(resourceMessage, cookieFactory);
        pluginManager.registerEvents(playerJumpListener, plugin);

        Listener playerJoinListener = new PlayerJoinListener(cookieFactory, plugin, configHandler);
        pluginManager.registerEvents(playerJoinListener, plugin);

        Listener playerQuitListener = new PlayerQuitListener(configHandler);
        pluginManager.registerEvents(playerQuitListener, plugin);
    }
}
