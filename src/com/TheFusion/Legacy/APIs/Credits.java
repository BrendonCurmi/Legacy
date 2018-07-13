package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Credits {

    public static Economy econ = null;

    public boolean setupEconomy() {
        if (Legacy.plugin.getServer().getPluginManager().getPlugin("Vault") == null) return false;
        RegisteredServiceProvider<Economy> rsp = Legacy.plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return false;
        econ = rsp.getProvider();
        return econ != null;
    }
}
