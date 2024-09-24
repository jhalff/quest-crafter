package com.jhalff.questCrafter.commands;

import com.jhalff.questCrafter.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class HelpCommand implements CommandExecutor {

    private final Main plugin;

    public HelpCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = this.plugin.getConfig().getString("prefix");
        assert prefix != null;

        if (!(sender instanceof Player)) return true;
        if (!(command.getName().startsWith(prefix))) return true;
        if (args.length > 0 && !Objects.equals(args[0], "help")) return true;

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Help menu"));

        return true;
    }
}
