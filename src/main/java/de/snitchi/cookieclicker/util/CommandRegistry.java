package de.snitchi.cookieclicker.util;

import de.snitchi.cookieclicker.commands.TestCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandRegistry {

    public void registerCommand(JavaPlugin javaPlugin){
        javaPlugin.getCommand("test").setExecutor(new TestCmd());
        /*  Sample:
            javaPlugin.getCommand("test").setExecutor(new TestCmd());
         */
    }
}
