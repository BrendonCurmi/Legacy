package com.TheFusion.Legacy.Exceptions;

import com.TheFusion.Legacy.APIs.FusionPlayer;
import com.TheFusion.Legacy.APIs.MsgType;

public class PlayerNoExistException extends FusionPlayer {

    public PlayerNoExistException() {
        p.sendMessage(MsgType.ERROR + "§cThat player does not exist or is not online!");
    }
}
