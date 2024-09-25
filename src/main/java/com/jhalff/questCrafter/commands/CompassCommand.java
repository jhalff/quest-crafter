package com.jhalff.questCrafter.commands;

import com.jhalff.questCrafter.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CompassCommand extends BaseCommand<Main> {

    public CompassCommand(Main plugin) {
        super(plugin);
    }

    @Override
    public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
        Player player = (Player) sender;

        ItemStack compass = generateCompass();
        player.getInventory().addItem(compass);

        return true;
    }

    public static ItemStack generateCompass() {
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassMeta = compass.getItemMeta();
        assert compassMeta != null;

        List<String> compassLore = new ArrayList<>();
        compassLore.add("Use this to open your quests menu");

        compassMeta.setLore(compassLore);
        compassMeta.setDisplayName(ChatColor.YELLOW + "Quests");
        compassMeta.addEnchant(Enchantment.UNBREAKING, 1, true);

        compass.setItemMeta(compassMeta);

        return compass;
    }
}
