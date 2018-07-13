package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class BungeeAPI {

    public static void sendToServer(Player p, String server) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(arrayOutputStream);
        try {
            outputStream.writeUTF("Connect");
            outputStream.writeUTF(server);
            p.sendPluginMessage(Legacy.plugin, "BungeeCord", arrayOutputStream.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
