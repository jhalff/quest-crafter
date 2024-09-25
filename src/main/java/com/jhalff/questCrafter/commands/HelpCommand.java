package com.jhalff.questCrafter.commands;

import com.jhalff.questCrafter.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpCommand extends BaseCommand<Main> {

   public HelpCommand(Main plugin) {
       super(plugin);
   }

    @Override
    public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Help menu"));
        return true;
    }
}
