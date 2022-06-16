package de.snitchi.cookieclicker.util;

import de.snitchi.cookieclicker.commands.SetCookies;
import de.snitchi.cookieclicker.commands.TestCmd;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandRegistry {

    public void registerCommand(JavaPlugin javaPlugin, ConfigHandler configHandler){
        javaPlugin.getCommand("test").setExecutor(new TestCmd());
        javaPlugin.getCommand("setCookies").setExecutor(new SetCookies(configHandler, javaPlugin));
        /*  Sample:
            javaPlugin.getCommand("test").setExecutor(new TestCmd());
         */
    }
}
