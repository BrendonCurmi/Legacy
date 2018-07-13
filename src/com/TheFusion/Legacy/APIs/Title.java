package com.TheFusion.Legacy.APIs;

import com.TheFusion.Legacy.Legacy;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Title extends VariableHandling {

    public static void sendTitle(Player p, String msg, String msg2, Legacy plugin, boolean colors) {
        if (plugin.getConfig().getBoolean(plugin.getDescription().getName() + ".Settings.ColorCodes.Toggle") && colors) {
            if (!msg.isEmpty()) msg = fixVariables(p, msg);
            if (!msg2.isEmpty()) msg2 = fixVariables(p, msg2);
        }

        try {
            Object e, subtitle, etatitle, etasubtitle, ppot, ppot2, ppot3, nmsp, pcon;
            if (!getServerVersion().equalsIgnoreCase("v1_8_R2") && !getServerVersion().equalsIgnoreCase("v1_8_R3")) {
                e = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");//new Object[]{}
                subtitle = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg2 + "\'}");//new Object[]{}
                etatitle = getNmsClass("EnumTitleAction").getField("TITLE").get(null);
                etasubtitle = getNmsClass("EnumTitleAction").getField("SUBTITLE").get(null);
                ppot = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{getNmsClass("EnumTitleAction"), getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{etatitle, e});
                ppot2 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{getNmsClass("EnumTitleAction"), getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{etasubtitle, subtitle});
                ppot3 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(1 * 20), Integer.valueOf(3 * 20), Integer.valueOf(1 * 20)});
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);//new Object[0]
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                if (!msg.isEmpty())
                    pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot);//new Object[]{ppot}
                if (!msg2.isEmpty())
                    pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot2);//new Object[]{ppot2}
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot3);//new Object[]{}
            } else {
                e = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg + "\'}");//new Object[]{"{\'text\': \'" + msg + "\'}"}
                subtitle = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, "{\'text\': \'" + msg2 + "\'}");//new Object[]{"{\'text\': \'" + msg2 + "\'}"}
                etatitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("TITLE").get((Object) null);
                etasubtitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("SUBTITLE").get((Object) null);
                ppot = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{etatitle, e});
                ppot2 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{etasubtitle, subtitle});
                ppot3 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(1 * 20), Integer.valueOf(3 * 20), Integer.valueOf(1 * 20)});
                nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p);//new Object[0]
                pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                if (!msg.isEmpty())
                    pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot);//new Object[]{ppot}
                if (!msg2.isEmpty())
                    pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot2);//new Object[]{ppot2}
                pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, ppot3);//new Object[]{ppot3}
            }
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
