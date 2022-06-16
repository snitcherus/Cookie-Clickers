package de.snitchi.cookieclicker.listener;

import de.snitchi.cookieclicker.factory.CookieFactory;
import de.snitchi.cookieclicker.util.ConfigHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    private final CookieFactory cookieFactory;
    private final ConfigHandler configHandler;

    public PlayerJoinListener(CookieFactory cookieFactory, Plugin plugin, ConfigHandler configHandler) {
        this.cookieFactory = cookieFactory;
        this.configHandler = configHandler;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent){

        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();
        Player player = playerJoinEvent.getPlayer();

        cookiesConfig.set(player.getUniqueId() + ".Is_Online", true);

        cookieFactory.setBaseValues(player);
        cookieFactory.getCookiesPerSecond(player);
    }
}
