package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerManager {

    public static FusionPlayer getPlayer(Player p) {
        return new FusionPlayer(p);
    }

    public static List<FusionPlayer> getOnlinePlayers() {
        List<FusionPlayer> onlinePlayers = new ArrayList<>();
        for (Player players : Bukkit.getOnlinePlayers()) onlinePlayers.add(getPlayer(players));
        return onlinePlayers;
    }

    public static UUID getUUID(String name) {
        return Bukkit.getPlayer(name).getUniqueId();
    }

    public static void broadcastTitle(String title, String subtitle) {
        for (Player players : Bukkit.getOnlinePlayers()) Title.sendTitle(players, title, subtitle, Legacy.plugin, true);
    }

    public static void broadcastActionBar(String message) {
        for (Player players : Bukkit.getOnlinePlayers()) ActionBar.sendActionBar(players, message, Legacy.plugin, true);
    }

    public static void broadcastTab(String header, String footer) {
        for (Player players : Bukkit.getOnlinePlayers()) Tab.sendTablist(players, header, footer, true);
    }
}
