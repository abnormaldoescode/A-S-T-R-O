/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockPlaceEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ForceDirtListener
implements Listener {
    private static Core plugin = Core.getPlugin(Core.class);

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (plugin.dirt.contains(event.getPlayer().getName())) {
            event.getBlock().setType(Material.DIRT);
        }
    }
}

