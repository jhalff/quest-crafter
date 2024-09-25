package com.jhalff.questCrafter;

import com.jhalff.questCrafter.commands.BaseCommand;
import com.jhalff.questCrafter.commands.CompassCommand;
import com.jhalff.questCrafter.commands.HelpCommand;
import com.jhalff.questCrafter.listeners.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        BaseCommand<Main> baseCommand = new BaseCommand<Main>(this) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Help menu"));
                return true;
            }
        };

        HelpCommand helpCommand = new HelpCommand(this);
        baseCommand.registerSubCommand("help", helpCommand);

        CompassCommand compassCommand = new CompassCommand(this);
        baseCommand.registerSubCommand("compass", compassCommand);

        Objects.requireNonNull(getCommand("quests")).setExecutor(baseCommand);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
