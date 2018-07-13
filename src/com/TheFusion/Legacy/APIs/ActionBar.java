package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class ActionBar extends VariableHandling {

    public static void sendActionBar(Player p, String msg, Legacy plugin, boolean colors) {
        if (plugin.getConfig().getBoolean(plugin.getDescription().getName() + ".Settings.ColorCodes.Toggle") && colors) {
            msg = fixVariables(p, msg);
        }

        try {
            Object e, ppoc, nmsp, pcon;
            if (!getServerVersion().equalsIgnoreCase("v1_8_R2") && !getServerVersion().equalsIgnoreCase("v1_8_R3")) {
                e = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");
                ppoc = getNmsClass("PacketPlayOutChat").getConstructor(new Class[]{getNmsClass("IChatBaseComponent"), Byte.TYPE}).newInstance(new Object[]{e, Byte.valueOf((byte) 2)});
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppoc);
            } else {
                e = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");
                ppoc = getNmsClass("PacketPlayOutChat").getConstructor(new Class[]{getNmsClass("IChatBaseComponent"), Byte.TYPE}).newInstance(new Object[]{e, Byte.valueOf((byte) 2)});
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppoc);
            }
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
