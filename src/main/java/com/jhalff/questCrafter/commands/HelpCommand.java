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
        sendHelpMenu(sender);
        return true;
    }

    private void sendHelpMenu(final CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', generateHelpMenu()));
    }

    private String generateHelpMenu() {
        return """
                 \n
                §e---------- &fQuestCrafter &e- &fCommand List &e----------
                 \n
                &6/quests menu &7Open quests menu
                &6/quests help &7Open list of available commands
                &6/quests compass&7 Spawn an official quests compass
                 \n
                §e----------------------------------------------
                 \n
                """;
    }
}
