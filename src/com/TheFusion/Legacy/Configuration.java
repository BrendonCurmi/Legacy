package com.TheFusion.Legacy;

import com.TheFusion.Legacy.APIs.ConfigurationAPI;
import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.PlayerManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Configuration {

    public static void createConfig() {
        File file = new File(Legacy.plugin.getDataFolder(), "config.yml");
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        {
            String path = "IsHub";
            if (configuration.get(path) == null) configuration.set(path, false);
        }
        {
            String path = "VoidTeleport";
            if (configuration.get(path) == null) configuration.set(path, false);
        }
        {
            String path = "Spawn.World";
            if (configuration.get(path) == null) configuration.set(path, "World");
        }
        {
            String path = "Spawn.X";
            if (configuration.get(path) == null) configuration.set(path, 0);
        }
        {
            String path = "Spawn.Y";
            if (configuration.get(path) == null) configuration.set(path, 0);
        }
        {
            String path = "Spawn.Z";
            if (configuration.get(path) == null) configuration.set(path, 0);
        }
        {
            String path = "Spawn.Yaw";
            if (configuration.get(path) == null) configuration.set(path, 0);
        }
        {
            String path = "Spawn.Pitch";
            if (configuration.get(path) == null) configuration.set(path, 0);
        }

        ConfigurationAPI configurationAPI = new ConfigurationAPI();
        configurationAPI.createFile(Legacy.plugin, file, configuration, false, true);
        configurationAPI.saveFile(file, configuration);
    }

    public static void createPlayerFile(Player p) {
        File file = new File(Legacy.plugin.getDataFolder(), "players.yml");
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set(p.getUniqueId() + ".Name", p.getName());
        {
            String path = p.getUniqueId() + ".SignInName";
            if (configuration.get(path) == null) configuration.set(path, p.getName());
        }
        configuration.set(p.getUniqueId() + ".IsNicked", false);
        configuration.set(p.getUniqueId() + ".Nick", p.getName());
        {
            String path = p.getUniqueId() + ".Rank";
            FusionPlayer player = PlayerManager.getPlayer(p);
            if (player.isDev()) configuration.set(path, "Dev");
            else if (player.isOwner()) configuration.set(path, "Owner");
            else if (player.isAdmin()) configuration.set(path, "Admin");
            else if (player.isMod()) configuration.set(path, "Mod");
            else if (player.isVIP()) configuration.set(path, "VIP");
            else if (player.isMember()) configuration.set(path, "Member");
            else configuration.set(path, "NONE");
        }

        ConfigurationAPI configurationAPI = new ConfigurationAPI();
        configurationAPI.createFile(Legacy.plugin, file, configuration, false, false);
        configurationAPI.saveFile(file, configuration);
    }
}
