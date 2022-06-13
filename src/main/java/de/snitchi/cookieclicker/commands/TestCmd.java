package de.snitchi.cookieclicker.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if(!(sender instanceof Player)){
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("Hello World");
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null){
            return true;
        }
        player.teleport(target.getLocation());
        return true;
    }
}
