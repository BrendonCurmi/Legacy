package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class Coins {

    public static HashMap<UUID, Integer> coins = new HashMap<>();

    public void writeToFile() {
        File file = new File(Legacy.plugin.getDataFolder(), "players.yml");
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        for (UUID uuid : coins.keySet()) configuration.set(uuid + ".FusionCoins", coins.get(uuid));
        ConfigurationAPI configurationAPI = new ConfigurationAPI();
        configurationAPI.saveFile(file, configuration);
    }
}
