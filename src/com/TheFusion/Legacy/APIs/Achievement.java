package com.TheFusion.Legacy.APIs;

public enum Achievement {

    WELCOME(Permissions.ACHIEVEMENT + "hub.welcome", "Welcome!", "Join the server for the first time", 100),
    FRIENDS(Permissions.ACHIEVEMENT + "hub.friends", "Friends", "Click an NPC to talk with them", 50),
    DETECTIVE(Permissions.ACHIEVEMENT + "hub.detective", "Detective", "Find the secret hidden in the source code for server's website", 100),

    FIRST_KILL(Permissions.ACHIEVEMENT + "sg.first_kill", "First Kill", "Kill a player in Survival Games", 5),
    MORE_KILLS(Permissions.ACHIEVEMENT + "sg.more_kills", "More Kills", "Kill 10 players in Survival Games", 10),
    FOR_THE_WINS(Permissions.ACHIEVEMENT + "sg.for_the_wins", "For The Wins", "Kill 20 players in Survival Games", 10),
    BLOOD_LUST(Permissions.ACHIEVEMENT + "sg.blood_lust", "Blood Lust", "Kill 50 players in Survival Games", 50),
    FIRST_WIN(Permissions.ACHIEVEMENT + "sg.first_win", "First Win", "Win a game of Survival Games", 100);

    private String permission;
    private String title;
    private String subtitle;
    private int credits;

    Achievement(String permission, String title, String subtitle, int credits) {
        this.permission = permission;
        this.title = title;
        this.subtitle = subtitle;
        this.credits = credits;
    }

    public String getPermission() {
        return permission;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getCredits() {
        return credits;
    }
}
