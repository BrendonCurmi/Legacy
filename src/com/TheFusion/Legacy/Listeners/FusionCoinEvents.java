package com.TheFusion.Legacy.Listeners;

import com.TheFusion.Legacy.APIs.*;
import com.TheFusion.Legacy.Legacy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.util.UUID;

public class FusionCoinEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (((boolean) Legacy.plugin.getConfig().get("IsHub"))) {
            File file = new File(Legacy.plugin.getDataFolder(), "players.yml");
            FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
            Player p = e.getPlayer();
            FusionPlayer player = PlayerManager.getPlayer(p);
            UUID uuid = PlayerManager.getUUID(player.getName());

            if (!(configuration.contains(uuid.toString()))) {
                configuration.set(uuid + ".FusionCoins", 0);
                Coins.coins.put(uuid, 0);
            } else
                Coins.coins.put(uuid, configuration.getInt(uuid + ".FusionCoins"));
            p.sendMessage(MsgType.SYSTEM + "§eYour §a§lFusionCoin§e balance was downloaded: §d" + player.getCoins());
        }
    }
}
