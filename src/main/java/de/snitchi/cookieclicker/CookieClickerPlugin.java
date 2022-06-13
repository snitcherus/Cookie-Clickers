package de.snitchi.cookieclicker;

import de.snitchi.cookieclicker.util.CommandRegistry;
import de.snitchi.cookieclicker.util.ListenerRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class CookieClickerPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        ListenerRegistry listenerRegistry = new ListenerRegistry();
        CommandRegistry commandRegistry = new CommandRegistry();

        listenerRegistry.registerListener(this);
        commandRegistry.registerCommand(this);
    }
}
