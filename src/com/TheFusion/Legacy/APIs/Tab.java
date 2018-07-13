package com.TheFusion.Legacy.APIs;

import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Tab extends VariableHandling {

    public static void sendTablist(Player p, String msg, String msg2, boolean colors) {
        if (colors) {
            msg = fixVariables(p, msg);
            msg2 = fixVariables(p, msg2);
        }

        try {
            Object e, footer, ppoplhf, nmsp, pcon;
            Field f;
            if (!getServerVersion().equalsIgnoreCase("v1_8_R2") && !getServerVersion().equalsIgnoreCase("v1_8_R3")) {
                e = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");
                footer = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg2 + "\'}");
                ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{getNmsClass("IChatBaseComponent")}).newInstance(e);
                f = ppoplhf.getClass().getDeclaredField("b");
                f.setAccessible(true);
                f.set(ppoplhf, footer);
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppoplhf);
            } else {
                e = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");
                footer = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg2 + "\'}");
                ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{getNmsClass("IChatBaseComponent")}).newInstance(e);
                f = ppoplhf.getClass().getDeclaredField("b");
                f.setAccessible(true);
                f.set(ppoplhf, footer);
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppoplhf);//new Object[]{ppoplhf}
            }
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
