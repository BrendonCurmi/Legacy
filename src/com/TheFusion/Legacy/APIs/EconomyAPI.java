package com.TheFusion.Legacy.APIs;

import java.text.DecimalFormat;

public class EconomyAPI {

    public static String fixMoney(double raw) {
        String money = null;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String sum;
        if (raw < 1000) {
            DecimalFormat avoidDecimal = new DecimalFormat("#");
            money = avoidDecimal.format(raw);
        } else if (raw >= 1000 && raw < 1000000) {
            sum = decimalFormat.format(raw / 1000);
            money = sum + "k";
        } else if (raw >= 1000000 && raw < 1000000000) {
            sum = decimalFormat.format(raw / 1000000);
            money = sum + "m";
        } else if (raw >= 1000000000) {
            sum = decimalFormat.format(raw / 1000000000);
            money = sum + "b";
        }
        return money;
    }
}
