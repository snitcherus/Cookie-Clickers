package de.snitchi.cookieclicker.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigHandler {

    private FileConfiguration cookiesConfig;

    public void loadConfig(Plugin plugin) {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();

        cookiesConfig = loadYml("cookies.yml", plugin);
    }

    private FileConfiguration loadYml(String name, Plugin plugin) {
        File file = new File(plugin.getDataFolder(), name);

        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }

        if(!file.exists()){
            try (InputStream in = plugin.getResource(name)){
                assert in != null;
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getCookiesConfig() {return cookiesConfig;
    }

    public void saveCookiesConfig(Plugin plugin) {
        try {
            cookiesConfig.save(new File(plugin.getDataFolder(), "cookies.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
