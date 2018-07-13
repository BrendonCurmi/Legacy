package com.TheFusion.Legacy.Exceptions;

import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.MsgType;

public class ErrorMessageException extends FusionPlayer {

    public ErrorMessageException(String message) {
        p.sendMessage(MsgType.ERROR + "§c" + message);
    }
}
