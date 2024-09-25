package com.jhalff.questCrafter.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static com.jhalff.questCrafter.commands.CompassCommand.generateCompass;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        if (e.getPlayer().hasPlayedBefore()) return;

        ItemStack compass = generateCompass();
        e.getPlayer().getInventory().addItem(compass);
    }
}
