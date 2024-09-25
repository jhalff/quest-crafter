package com.jhalff.questCrafter.commands;

import com.jhalff.questCrafter.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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
        Inventory inv = Bukkit.createInventory(null, 9, "Quests Menu");
        inv.addItem(createGuiItem(Material.BOOK, "§6Random Quests", "§7Daily random quests"));
        return inv;
    }

    protected static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        assert meta != null;

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }
}
