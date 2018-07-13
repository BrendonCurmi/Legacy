package com.TheFusion.Legacy.APIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.Calendar;

abstract class VariableHandling {

    static Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
    }

    static String getServerVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().substring(23);
    }

    /**
     * Fixes the time to make sure it has 2 digits.
     *
     * @param i the time value.
     * @return the fixed value.
     */
    static String fixTime(int i) {
        return i < 10 ? "0" + i : "" + i;
    }

    /**
     * Fixes the variables of the ActionBar, with the correct values.
     *
     * @param p the player viewing the ActionBar.
     * @param msg the ActionBar message.
     * @return the fixed ActionBar message.
     */
    static String fixVariables(Player p, String msg) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = fixTime(day) + "-" + fixTime(month) + "-" + fixTime(year);

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String time = fixTime(hours) + ":" + fixTime(minutes) + ":" + fixTime(seconds);

        msg = ChatColor.translateAlternateColorCodes('&', msg)
                .replace("%player%", p.getName())
                .replace("%level%", String.valueOf(p.getLevel()))
                .replace("%health%", String.valueOf(Math.round(p.getHealth())))
                .replace("%foodlevel%", String.valueOf(Math.round(Double.parseDouble(String.valueOf(p.getFoodLevel())))))
                .replace("%maxhealth%", String.valueOf(Math.round(p.getMaxHealth())))
                .replace("%iteminhandtype%", p.getItemInHand().getType().name())
                .replace("%iteminhandamount%", String.valueOf(p.getItemInHand().getAmount()))
                .replace("%iteminhandid%", String.valueOf(p.getItemInHand().getTypeId()))
                .replace("%gamemode%", p.getGameMode().name())
                .replace("%difficulty%", "" + p.getWorld().getDifficulty())
                .replace("%world%", p.getWorld().getName())
                .replace("%blockx%", String.valueOf(p.getLocation().getBlockX()))
                .replace("%blocky%", String.valueOf(p.getLocation().getBlockY()))
                .replace("%blockz%", String.valueOf(p.getLocation().getBlockZ()))
                .replace("%onlineplayers%", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()))
                .replace("%maxonlineplayers%", String.valueOf(Bukkit.getServer().getMaxPlayers()))
                .replace("%servermotd%", Bukkit.getServer().getMotd())
                .replace("%servername%", Bukkit.getServer().getServerName())
                .replace("%serverid%", Bukkit.getServer().getServerId())
                .replace("%serverip%", Bukkit.getServer().getIp())
                .replace("%serverport%", String.valueOf(Bukkit.getServer().getPort()))
                .replace("%time%", time)
                .replace("%date%", date);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        FusionPlayer player = PlayerManager.getPlayer(p);
        if (msg.contains("%credits%")) {
            if (Credits.econ != null) msg = msg.replace("%credits%", decimalFormat.format(player.getCredits()));
            else System.out.println("ActionBar Class> Error: No Vault!");
        }
        if (msg.contains("%coins%")) msg = msg.replace("%coins%", decimalFormat.format(player.getCoins()));
        return msg;
    }
}
