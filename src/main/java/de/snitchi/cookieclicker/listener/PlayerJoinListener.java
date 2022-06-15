package de.snitchi.cookieclicker.listener;

import de.snitchi.cookieclicker.factory.CookieFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final CookieFactory cookieFactory;

    public PlayerJoinListener(CookieFactory cookieFactory) {
        this.cookieFactory = cookieFactory;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        cookieFactory.setBaseValues(player);
    }
}
