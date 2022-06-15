package de.snitchi.cookieclicker.listener;

import de.snitchi.cookieclicker.factory.CookieFactory;
import de.snitchi.cookieclicker.util.ResourceMessage;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerJumpListener implements Listener {

    private final ResourceMessage resourceMessage;
    private final CookieFactory cookieFactory;

    public PlayerJumpListener(ResourceMessage resourceMessage, CookieFactory cookieFactory) {
        this.resourceMessage = resourceMessage;
        this.cookieFactory = cookieFactory;
    }

    @EventHandler
    public void onPlayerJump(PlayerStatisticIncrementEvent event) {

        Player player = event.getPlayer();
        // -> Kraft double value = 0.42;

        Block aboveBlock = player.getWorld().getBlockAt(player.getLocation().add(0, 2, 0));

        if(!(event.getStatistic() == Statistic.JUMP)) {
            return;
        }

        if(aboveBlock.getType() != Material.AIR) {
            return;
        }

        cookieFactory.getJumpCookies(player);
        resourceMessage.sendMessage(player, "jump_message");

    }
}
