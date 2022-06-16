package de.snitchi.cookieclicker.util;

import de.snitchi.cookieclicker.factory.CookieFactory;
import de.snitchi.cookieclicker.listener.PlayerJoinListener;
import de.snitchi.cookieclicker.listener.PlayerJumpListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerRegistry {

    public void registerListener(Plugin plugin, ResourceMessage resourceMessage, CookieFactory cookieFactory) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        Listener playerJumpListener = new PlayerJumpListener(resourceMessage, cookieFactory);
        pluginManager.registerEvents(playerJumpListener, plugin);

        Listener playerJoinListener = new PlayerJoinListener(cookieFactory, plugin);
        pluginManager.registerEvents(playerJoinListener, plugin);
        /* Sample:
        Listener joinListener = new JoinListener(configHandler);
        pluginManager.registerEvents(joinListener, plugin);
         */
    }
}
