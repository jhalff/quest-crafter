package com.jhalff.questCrafter.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.jhalff.questCrafter.commands.CompassCommand.compass;
import static com.jhalff.questCrafter.commands.MenuCommand.openMainMenu;

public class PlayerInteractionListener implements Listener {

    @EventHandler
    public void getRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().isSimilar(compass)) {
            openMainMenu(player);
        }
    }
}
