package com.jhalff.questCrafter;

import com.jhalff.questCrafter.commands.BaseCommand;
import com.jhalff.questCrafter.commands.CompassCommand;
import com.jhalff.questCrafter.commands.HelpCommand;
import com.jhalff.questCrafter.commands.MenuCommand;
import com.jhalff.questCrafter.listeners.InventoryListener;
import com.jhalff.questCrafter.listeners.JoinListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static com.jhalff.questCrafter.commands.MenuCommand.openMainMenu;

public final class Main extends JavaPlugin {

    public static FileConfiguration config = null;

    @Override
    public void onEnable() {
        config = this.getConfig();
        saveDefaultConfig();
        setupCommands();
        setupEvents();
    }

    public static String getFromConfig(String name) {
        return config.getString(name);
    }

    public Boolean getBoolFromConfig(String name) {
        return config.getBoolean(name);
    }

    public static Integer getIntFromConfig(String name) {
        return config.getInt(name);
    }

    private void setupCommands() {
        BaseCommand<Main> baseCommand = new BaseCommand<>(this) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                openMainMenu((HumanEntity) sender);
                return true;
            }
        };

        HelpCommand helpCommand = new HelpCommand(this);
        CompassCommand compassCommand = new CompassCommand(this);
        MenuCommand menuCommand = new MenuCommand(this);

        baseCommand.registerSubCommand("help", helpCommand);
        baseCommand.registerSubCommand("menu", menuCommand);

        if (getBoolFromConfig("compass-enabled")) {
            baseCommand.registerSubCommand("compass", compassCommand);
        }

        Objects.requireNonNull(getCommand("quests")).setExecutor(baseCommand);
    }

    private void setupEvents() {
        if (getBoolFromConfig("receive-compass-on-join")) {
            getServer().getPluginManager().registerEvents(new JoinListener(), this);
        }

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }
}
