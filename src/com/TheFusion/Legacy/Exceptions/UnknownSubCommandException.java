package com.TheFusion.Legacy.Exceptions;

import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.MsgType;

public class UnknownSubCommandException extends FusionPlayer {

    public UnknownSubCommandException() {
        p.sendMessage(MsgType.ERROR + "§cThat sub command does not exist!");
    }
}
