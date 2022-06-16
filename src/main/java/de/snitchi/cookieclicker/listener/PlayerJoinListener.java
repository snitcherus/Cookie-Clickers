package de.snitchi.cookieclicker.listener;

import de.snitchi.cookieclicker.factory.CookieFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    private final CookieFactory cookieFactory;
    private final Plugin plugin;

    public PlayerJoinListener(CookieFactory cookieFactory, Plugin plugin) {
        this.cookieFactory = cookieFactory;
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        cookieFactory.setBaseValues(player);

        BukkitRunnable runnable = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {
                cookieFactory.getCookiesPerSecond(player);
                player.sendMessage("Cookie");
            }
        }.runTaskTimer(plugin, 20L, 20L);
    }
}
