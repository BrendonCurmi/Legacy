package com.TheFusion.Legacy.Exceptions;

import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.MsgType;

public class NoPermissionException extends FusionPlayer {

    public NoPermissionException() {
        p.sendMessage(MsgType.ERROR + "§cYou do not have permission!");
    }
}
