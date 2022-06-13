package de.snitchi.cookieclicker.util;

import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResourceMessage {

    public void sendMessage(Player player, String path, Object... replaces) {
        player.sendMessage(getMessage(path, replaces));
    }

    /**
     * Gets the message from the CookieClicker resourceBundle.
     *
     * @param path     path to the message
     * @param replaces replaces a part of the message
     * @return formats the message
     */
    public String getMessage(String path, Object... replaces) {
        ResourceBundle systemBundle = ResourceBundle.getBundle("CookieClicker");
        String pattern = systemBundle.getString(path);
        return MessageFormat.format(pattern, replaces);
    }

}
