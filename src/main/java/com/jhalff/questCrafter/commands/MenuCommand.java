package com.jhalff.questCrafter.commands;

import com.jhalff.questCrafter.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import static com.jhalff.questCrafter.helpers.ConfigHelper.getFromConfig;
import static com.jhalff.questCrafter.helpers.ConfigHelper.getIntFromConfig;
import static com.jhalff.questCrafter.helpers.MenuHelper.createGuiItem;

public class MenuCommand extends BaseCommand<Main> implements Listener {

    public static Inventory inv;

    public MenuCommand(Main plugin) {
        super(plugin);
    }

    @Override
    public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
        openMainMenu((HumanEntity) sender);
        return true;
    }

    public static void openMainMenu(HumanEntity playerEntity) {
        inv = createMainMenuPage();
        playerEntity.openInventory(inv);
    }

    private static Inventory createMainMenuPage() {
        Inventory inv = Bukkit.createInventory(
            null,
            getIntFromConfig("main-menu-size"),
            getFromConfig("main-menu-title")
        );

        inv.setItem(
            0,
            createGuiItem(Material.BOOK, "§6Random Quests", "§7Daily random quests")
        );

        return inv;
    }
}
