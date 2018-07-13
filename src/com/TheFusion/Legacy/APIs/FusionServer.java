package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class FusionServer {

    public static void worldBorder(Player p) {
        WorldBorder border = p.getWorld().getWorldBorder();
        border.setCenter(p.getLocation());
        border.setSize(100);
        border.setWarningDistance(10);
        border.setDamageAmount(2);
    }

    public static void holograms(Location location) {
        for (Hologram holograms : HologramsAPI.getHolograms(Legacy.plugin)) holograms.delete();
        Hologram hologram = HologramsAPI.createHologram(Legacy.plugin, location.add(0.0, 2.0, 0.0));
        hologram.appendTextLine(ChatColor.GOLD + "" + ChatColor.BOLD + "Power Up " + ChatColor.DARK_GRAY + "- " + ChatColor.WHITE + "Rabbit`s Feets");
        hologram.insertItemLine(1, new ItemStack(Material.CHEST));
        hologram.appendTextLine(ChatColor.GRAY + "" + ChatColor.ITALIC + "Pick up to get power up");
    }
}
