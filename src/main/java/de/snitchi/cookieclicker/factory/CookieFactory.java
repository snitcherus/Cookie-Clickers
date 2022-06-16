package de.snitchi.cookieclicker.factory;

import de.snitchi.cookieclicker.util.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class CookieFactory {

    private final Plugin plugin;
    private final ConfigHandler configHandler;

    long cookiesPerSecond;
    long jumpCookies;
    double currentCookies;
    double shortedCookies;

    public CookieFactory(Plugin plugin, ConfigHandler configHandler) {
        this.plugin = plugin;
        this.configHandler = configHandler;
    }

    /**
     * Jacky credit -.-
     * Gives the player cookies per jump
     * @param player jumped player
     */
    public void getJumpCookies(Player player){
        getCookies(player, jumpCookies);
    }

    /**
     * Gives the player cookies per second
     * @param player player
     */
    public void getCookiesPerSecond(Player player) {

        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();

        BukkitScheduler bukkitScheduler = Bukkit.getScheduler();
        bukkitScheduler.runTaskTimer(plugin, task -> {

            if(!cookiesConfig.getBoolean(player.getUniqueId() + ".Is_Online")) {
                task.cancel();
                return;
            }

            getCookies(player, cookiesPerSecond);
            player.sendMessage("Cookie");
            System.out.println("Cookie");
        }, 20L, 20L);
    }

    /**
     * New player? Lets set the base values!
     * @param player player
     */
    public void setBaseValues(Player player) {

        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();

        String playerUUID = player.getUniqueId().toString();

        if(!(cookiesConfig.contains(playerUUID))){
            cookiesConfig.set(playerUUID + ".Current_Cookies", 0);
            cookiesConfig.set(playerUUID + ".Shorted_Cookies", 0);
            cookiesConfig.set(playerUUID + ".Jump_Cookies", 1000);
            cookiesConfig.set(playerUUID + ".Second_Cookies", 0);
            cookiesConfig.set(playerUUID + ".Is_Online", true);
            configHandler.saveCookiesConfig(plugin);
        }
    }

    /**
     * Config cookies, yeah!
     * @param fileConfiguration cookies config
     * @param playerUUID player uuid
     */
    private void getConfigCookies(FileConfiguration fileConfiguration, String playerUUID) {
        currentCookies = fileConfiguration.getInt(playerUUID + ".Current_Cookies");
        jumpCookies = fileConfiguration.getInt(playerUUID + ".Jump_Cookies");
        shortedCookies = fileConfiguration.getInt(playerUUID + ".Shorted_Cookies");
        cookiesPerSecond = fileConfiguration.getInt(playerUUID + ".Second_Cookies");
    }

    /**
     * Gets cookies from specified sources
     * @param player player
     * @param newCookies source type
     */
    private void getCookies(Player player, long newCookies) {

        FileConfiguration cookiesConfig = configHandler.getCookiesConfig();
        String playerUUID = player.getUniqueId().toString();

        getConfigCookies(cookiesConfig, playerUUID);

        currentCookies += newCookies;

        if(currentCookies < 1000) {
            cookiesConfig.set(playerUUID + ".Current_Cookies", currentCookies);
            configHandler.saveCookiesConfig(plugin);
        }

        digitCalculator(cookiesConfig, 1000, playerUUID, "K");
        digitCalculator(cookiesConfig, 1000000, playerUUID, "M");

    }

    /**
     * Calculator for digits
     * @param fileConfiguration cookies config
     * @param newDigit digit for the cool calculations
     * @param playerUUID player uuid
     * @param letter letter after the number
     */
    private void digitCalculator(FileConfiguration fileConfiguration, int newDigit, String playerUUID, String letter) {

        if(currentCookies >= newDigit){
            shortedCookies = Math.round((currentCookies / newDigit) * 100d) / 100d;
            fileConfiguration.set(playerUUID + ".Shorted_Cookies", shortedCookies + letter);
            fileConfiguration.set(playerUUID + ".Current_Cookies", currentCookies);
            configHandler.saveCookiesConfig(plugin);
        }

    }
}
