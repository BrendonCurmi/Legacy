package com.TheFusion.Legacy.APIs;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannerAPI {

    public static void setBanner(Player p, DyeColor primaryColour, DyeColor secondaryColour, boolean hasBorders, DyeColor borderColour, PatternType pattern) {
        ItemStack banner = new ItemStack(Material.BANNER);
        BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();

        bannerMeta.setBaseColor(primaryColour);
        bannerMeta.addPattern(new Pattern(secondaryColour, pattern));
        if (hasBorders) {
            if (borderColour == null) bannerMeta = addBorders(bannerMeta, secondaryColour);
            else bannerMeta = addBorders(bannerMeta, borderColour);
        }
        banner.setItemMeta(bannerMeta);
        p.getInventory().addItem(banner);
    }

    public static ItemStack getBanner(Player p, DyeColor primaryColour, DyeColor secondaryColour, boolean hasBorders, DyeColor borderColour, PatternType pattern) {
        ItemStack banner = new ItemStack(Material.BANNER);
        BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();

        bannerMeta.setBaseColor(primaryColour);
        bannerMeta.addPattern(new Pattern(secondaryColour, pattern));
        if (hasBorders) {
            if (borderColour == null) bannerMeta = addBorders(bannerMeta, secondaryColour);
            else bannerMeta = addBorders(bannerMeta, borderColour);
        }
        banner.setItemMeta(bannerMeta);
        return banner;
    }

    private static BannerMeta addBorders(BannerMeta bannerMeta, DyeColor backGroundColor) {
        bannerMeta.addPattern(new Pattern(backGroundColor, PatternType.BORDER));
        return bannerMeta;
    }
}
