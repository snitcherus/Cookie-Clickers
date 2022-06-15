package de.snitchi.cookieclicker;

import de.snitchi.cookieclicker.factory.CookieFactory;
import de.snitchi.cookieclicker.util.CommandRegistry;
import de.snitchi.cookieclicker.util.ConfigHandler;
import de.snitchi.cookieclicker.util.ListenerRegistry;
import de.snitchi.cookieclicker.util.ResourceMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class CookieClickerPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        ConfigHandler configHandler = new ConfigHandler();
        ResourceMessage resourceMessage = new ResourceMessage();
        ListenerRegistry listenerRegistry = new ListenerRegistry();
        CommandRegistry commandRegistry = new CommandRegistry();
        CookieFactory cookieFactory = new CookieFactory(this, configHandler);

        configHandler.loadConfig(this);
        listenerRegistry.registerListener(this, resourceMessage, cookieFactory);
        commandRegistry.registerCommand(this);
    }
}
