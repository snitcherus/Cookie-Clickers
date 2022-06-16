package de.snitchi.cookieclicker.listener;

import de.snitchi.cookieclicker.util.ConfigHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final ConfigHandler configHandler;

    public PlayerQuitListener(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent playerQuitEvent) {

        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();
        Player player = playerQuitEvent.getPlayer();

        cookiesConfig.set(player.getUniqueId() + ".Is_Online", false);
    }
}
