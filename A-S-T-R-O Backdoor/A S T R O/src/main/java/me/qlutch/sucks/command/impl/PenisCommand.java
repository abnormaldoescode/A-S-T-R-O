package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PenisCommand
extends Command {
    private static int ID;

	@Override
	public void execute(Core plugin, String msg, String[] args, Player p) {
		if (ID == 0) {
			ID = new BukkitRunnable() {
				@SuppressWarnings("deprecation")
				public void run() {
		              int x = (int)p.getLocation().getX() + (int)(Math.random() * 100.0D) - 50;
		              int y = (int)p.getLocation().getY() + 50;
		              int z = (int)p.getLocation().getZ() + (int)(Math.random() * 100.0D) - 50;
		              for (int i = 0; i < 3; i++) {
		                p.getWorld().spawnFallingBlock(new Location(p.getWorld(), x + i, y, z), Material.WHITE_TERRACOTTA, (byte)6);
		              }
		              for (int i = 1; i < 4; i++) {
		                p.getWorld().spawnFallingBlock(new Location(p.getWorld(), x + 1, y + i, z), Material.WHITE_TERRACOTTA, (byte)6);
		              }
		            }
		          }.runTaskTimer(plugin, 1L, 1L).getTaskId();
		          p.sendMessage(Settings.PREFIX("Started penis rain"));
		          
		} else {
			Bukkit.getScheduler().cancelTask(ID);
			ID = 0;
			p.sendMessage(Settings.PREFIX("Stopped penis rain"));
		}
	}

    @Override
    public boolean isBlatant() {
        return false;
    }
}
