package com.TheFusion.Legacy.Listeners;

import com.TheFusion.Legacy.APIs.Achievement;
import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class AchievementEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        FusionPlayer player = PlayerManager.getPlayer(p);

        if (!(player.hasAchievement(Achievement.WELCOME))) player.setAchievement(Achievement.WELCOME);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        FusionPlayer player = PlayerManager.getPlayer(p);

        if (p.getLocation().getY() <= 1) {
            // In the void
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        FusionPlayer player = PlayerManager.getPlayer(p);

        if (!(e.getRightClicked() instanceof Player))
            if (!(p.hasPermission(Achievement.FRIENDS.getPermission()))) player.setAchievement(Achievement.FRIENDS);
    }
}
