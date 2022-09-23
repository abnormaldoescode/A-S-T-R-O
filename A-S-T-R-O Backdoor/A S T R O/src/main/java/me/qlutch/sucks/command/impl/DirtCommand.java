package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;

public class DirtCommand 
extends Command{
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE("dirt <player>"));
		} else {
			Player target = Bukkit.getServer().getPlayer(args[1]);
			if (target == null) {
				p.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
			} else {
				if (plugin.dirt.contains(target.getName())) {
					plugin.dirt.remove(p.getName());
					p.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " can now place whatever they like"));
				} else {
					plugin.dirt.add(target.getName());
					p.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " can now only place dirt"));
				}
			}
		}
	}

    @Override
    public boolean isBlatant() {
        return false;
    }
}
