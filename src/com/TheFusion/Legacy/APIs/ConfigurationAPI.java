package com.TheFusion.Legacy.APIs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigurationAPI {

    public void createFile(Plugin plugin, File file, FileConfiguration configuration, boolean copyDefaults, boolean isConfig) {
        if (copyDefaults) configuration.options().copyDefaults(true);
        if (isConfig) configuration = plugin.getConfig();
        if (!(file.exists())) {
            try {
                System.out.println(plugin.getName() + "> Creating file \"" + file.getName() + "\"...");
                if (!(plugin.getDataFolder().exists())) plugin.getDataFolder().mkdir();
                file.createNewFile();
                System.out.println(plugin.getName() + "> Created file \"" + file.getName() + "\"");
                saveFile(file, configuration);
                if (isConfig) plugin.saveConfig();
            } catch (IOException ex) {
                System.out.println(plugin.getName() + "> Failed to create file \"" + file.getName() + "\"!");
            }
        }
    }

    public void saveFile(File file, FileConfiguration configuration) {
        try {
            configuration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
