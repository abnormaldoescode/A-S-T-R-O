package me.qlutch.sucks.command.impl;

import java.util.ArrayList;

import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.World;

public class SpinCommand 
extends Command {
    private final ArrayList<World> worlds = new ArrayList<>();
	
	public void execute(Core plugin, String msg, String[] args, Player p) {
		if (worlds.contains(p.getWorld())) {
			worlds.remove(p.getWorld());
			p.sendMessage(Settings.PREFIX("The world has stopped spinning!"));
		} else {
			worlds.add(p.getWorld());
			p.sendMessage(Settings.PREFIX("The world is now spinning!"));
			
	        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
	            for (World world : worlds) {
	                world.setTime(world.getTime() + 100);
	            }
	        }, 1L, 1L);
		}
	}

}
