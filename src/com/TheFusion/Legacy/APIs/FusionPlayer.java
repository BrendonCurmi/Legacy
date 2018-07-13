package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.List;

public class FusionPlayer {

    protected Player p;

    public FusionPlayer() {
        this(null);
    }

    public FusionPlayer(Player p) {
        this.p = p;
    }

    /**
     * Gets the player's name.
     */
    public String getName() {
        return p.getName();
    }

    /**
     * Get the player's rank.
     */
    public Rank getRank() {
        for (Rank rank : Rank.values()) if (p.hasPermission(rank.getPermission())) return rank;
        return null;
    }

    /**
     * Returns true if player is a Dev.
     */
    public boolean isDev() {
        return p.hasPermission(Rank.DEV.getPermission());
    }

    /**
     * Returns true if player is an Owner.
     */
    public boolean isOwner() {
        return p.hasPermission(Rank.OWNER.getPermission());
    }

    /**
     * Returns true if player is an Admin.
     */
    public boolean isAdmin() {
        return p.hasPermission(Rank.ADMIN.getPermission());
    }

    /**
     * Returns true if player is a Mod.
     */
    public boolean isMod() {
        return p.hasPermission(Rank.MOD.getPermission());
    }

    /**
     * Returns true if player is a VIP.
     */
    public boolean isVIP() {
        return p.hasPermission(Rank.VIP.getPermission());
    }

    /**
     * Returns true if player is a Member.
     */
    public boolean isMember() {
        return p.hasPermission(Rank.MEMBER.getPermission());
    }

    /**
     * Sends the player a specified message.
     */
    public void sendMessage(String message) {
        p.sendMessage(message);
    }

    /**
     * Gets the player's coin balance.
     */
    public int getCoins() {
        return Coins.coins.get(PlayerManager.getUUID(p.getName()));
    }

    /**
     * Gives coins to the player.
     */
    public void giveCoins(int coin) {
        Coins.coins.put(PlayerManager.getUUID(p.getName()), getCoins() + coin);
        Coins coins = new Coins();
        coins.writeToFile();
    }

    /**
     * Takes coins from the player.
     */
    public void takeCoins(int coin) {
        if (getCoins() >= coin) {
            Coins.coins.put(PlayerManager.getUUID(p.getName()), getCoins() - coin);
            Coins coins = new Coins();
            coins.writeToFile();
        }
    }

    /**
     * Gets the player's credit balance.
     */
    public double getCredits() {
        return Credits.econ.getBalance(p);
    }

    /**
     * Gives credits to the player.
     */
    public void giveCredits(int credits) {
        Credits.econ.bankDeposit(p.getName(), credits);
        p.sendMessage(MsgType.ECONOMY + "§a§l+" + credits + " §b§lCREDITS");
    }

    /**
     * Takes credits from the player.
     */
    public void takeCredits(int credits) {
        if (getCredits() >= credits) Credits.econ.bankWithdraw(p.getName(), credits);
    }

    /**
     * Sends the player to the current world's assigned spawn.
     */
    public void sendToSpawn() {
        World world = Bukkit.getServer().getWorld(Legacy.plugin.getConfig().getString("Spawn.World"));
        double x = (double) Legacy.plugin.getConfig().get("Spawn.X");
        double y = (double) Legacy.plugin.getConfig().get("Spawn.Y");
        double z = (double) Legacy.plugin.getConfig().get("Spawn.Z");
        float yaw = (float) Legacy.plugin.getConfig().get("Spawn.Yaw");
        float pitch = (float) Legacy.plugin.getConfig().get("Spawn.Pitch");
        p.teleport(new Location(world, x, y, z, yaw, pitch));
    }

    /**
     * Sets the title for the player.
     */
    public void setTitle(String title, String subtitle) {
        Title.sendTitle(p, title, subtitle, Legacy.plugin, true);
    }

    /**
     * Sets the actionbar for the player.
     */
    public void setActionBar(String message) {
        ActionBar.sendActionBar(p, message, Legacy.plugin, true);
    }

    /**
     * Sets the tab for the player.
     */
    public void setTab(String header, String footer) {
        Tab.sendTablist(p, header, footer, true);
    }

    /**
     * Gets the disguise for the player.
     */
    public String getDisguise() {
        return DisguiseCraft.getAPI().getDisguise(p).type.toString();
    }

    /**
     * Sets the disguise for the player.
     */
    public void setDisguise(DisguiseType disguise) {
        DisguiseCraftAPI api = DisguiseCraft.getAPI();
        api.disguisePlayer(p, new Disguise(api.newEntityID(), disguise));
        p.sendMessage(MsgType.SYSTEM + "You have been disguised as a(n) " + disguise.toString().toLowerCase() + "!");
    }

    /**
     * Gets the achievements the player has unlocked.
     */
    public List<Achievement> getAchievements() {
        List<Achievement> achievements = new ArrayList<>();
        for (Achievement achievement : Achievement.values()) if (p.hasPermission(achievement.getPermission())) achievements.add(achievement);
        return achievements;
    }

    /**
     * Sets the achievement for the player.
     */
    public void setAchievement(Achievement achievement) {
//        p.sendMessage("§1" + MsgType.HEADER);
//        p.sendMessage("§1" + MsgType.BODY + "§b§k||| §b§lACHIEVEMENT UNLOCKED! §b§k|||");
//        p.sendMessage("§1" + MsgType.BODY + "§e§l" + achievement.getTitle());
//        p.sendMessage("§1" + MsgType.BODY + "§7§o" + achievement.getSubtitle());
//        p.sendMessage("§1" + MsgType.BODY + "§b+" + achievement.getCredits() + "Credits");
//        p.sendMessage("§1" + MsgType.FOOTER);
        setTitle("§b§lACHIEVEMENT GET!", "§e§l" + achievement.getTitle());
        PermissionsEx.getUser(p).addPermission(achievement.getPermission());
    }

    /**
     * Gets the achievements for the player.
     */
    public boolean hasAchievement(Achievement achievement) {
        return p.hasPermission(achievement.getPermission());
    }
}
