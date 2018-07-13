package com.TheFusion.Legacy.APIs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemAPI {

    public static class Saved {
        public static ItemStack getItem(String itemStack) {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();

            switch (itemStack) {
                case "IronBlock":
                    item = new ItemStack(Material.IRON_BLOCK, 1);
                    meta.setDisplayName("1");
                    lore.add("lore 1");
                    break;
                case "GoldBlock":
                    item = new ItemStack(Material.GOLD_BLOCK, 1);
                    meta.setDisplayName("2");
                    lore.add("lores 2");
                    break;
                default:
                    item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                    meta.setDisplayName("§4§lUnknown Item");
                    lore.add("§7This is a bug to be");
                    lore.add("§7fixed in the code!");
                    break;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }

    public static ItemStack createItem(Material m, int amount, int shortNumber, String name) {
        ItemStack item = new ItemStack(m, amount, (short) shortNumber);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(Material m, int amount, int shortNumber, String name, List<String> lore) {
        ItemStack item = new ItemStack(m, amount, (short) shortNumber);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createFusionItem(Material m, int amount, int shortNumber, String name) {
        ItemStack item = new ItemStack(m, amount, (short) shortNumber);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§l" + name.toUpperCase());
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createFusionItem(Material m, int amount, int shortNumber, String name, List<String> lore) {
        ItemStack item = new ItemStack(m, amount, (short) shortNumber);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§l" + name.toUpperCase());
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
