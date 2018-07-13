package com.TheFusion.Legacy;

import com.TheFusion.Legacy.APIs.Credits;
import com.TheFusion.Legacy.Commands.LegacyCommands;
import com.TheFusion.Legacy.Listeners.AchievementEvents;
import com.TheFusion.Legacy.Listeners.FusionCoinEvents;
import com.TheFusion.Legacy.Listeners.PlayerEvents;
import com.TheFusion.Legacy.Listeners.ProfanityFilter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Legacy extends JavaPlugin {

    public static Legacy plugin;

    @Override
    public void onEnable() {
        plugin = this;

        System.out.println("/ / / / / / / LEGACY / / / / / / /");
        System.out.println("Loading Listeners...");
        getServer().getPluginManager().registerEvents(new AchievementEvents(), this);
        getServer().getPluginManager().registerEvents(new FusionCoinEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new ProfanityFilter(), this);
        System.out.println("Listeners loaded!");
        System.out.println("Loading Commands...");
        getCommand("help").setExecutor(new LegacyCommands());
        getCommand("balance").setExecutor(new LegacyCommands());
        getCommand("whoami").setExecutor(new LegacyCommands());
        getCommand("help").setExecutor(new LegacyCommands());
        getCommand("coins").setExecutor(new LegacyCommands());
        getCommand("lag").setExecutor(new LegacyCommands());
        getCommand("transform").setExecutor(new LegacyCommands());
        getCommand("anvilgui").setExecutor(new LegacyCommands());
        getCommand("config").setExecutor(new LegacyCommands());
        System.out.println("Commands loaded!");
        System.out.println("Loading Configuration Files...");
        Configuration.createConfig();
        System.out.println("Configuration Files loaded!");
        System.out.println("Loading Vault...");
        Credits credits = new Credits();
        if (!(credits.setupEconomy())) {
            System.out.println("No Vault Loaded!");
            return;
        } else System.out.println("Vault loaded!");
        System.out.println("Finished loading Legacy!");
    }

    @Override
    public void onDisable() {
        try {
            if (MySQL.connection != null && !(MySQL.connection.isClosed())) MySQL.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if ((boolean) getConfig().get("IsHub")) {
            if (getFile().getName().equals("players.yml")) {
                File file = new File(Legacy.plugin.getDataFolder(), "players.yml");
                if (getFile().equals(file)) {
                    FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
                    try {
                        configuration.save(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
