package com.TheFusion.Legacy.APIs;

public enum Rank {
    DEV(Permissions.RANK + "dev"),
    OWNER(Permissions.RANK + "owner"),
    ADMIN(Permissions.RANK + "admin"),
    MOD(Permissions.RANK + "mod"),
    VIP(Permissions.RANK + "vip"),
    MEMBER(Permissions.RANK + "member");

    private String permission;

    Rank(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
