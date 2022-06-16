package de.snitchi.cookieclicker.commands;

import de.snitchi.cookieclicker.util.ConfigHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetCookies implements CommandExecutor {

    private final ConfigHandler configHandler;
    private final Plugin plugin;

    public SetCookies(ConfigHandler configHandler, Plugin plugin) {
        this.configHandler = configHandler;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        String playerUUID = player.getUniqueId().toString();
        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();

        cookiesConfig.set(playerUUID +  ".Second_Cookies", Integer.parseInt(args[0]));
        configHandler.saveCookiesConfig(plugin);

        player.sendMessage("Cookies placed");
        return true;
    }
}
