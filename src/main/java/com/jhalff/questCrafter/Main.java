package com.jhalff.questCrafter;

import com.jhalff.questCrafter.commands.BaseCommand;
import com.jhalff.questCrafter.commands.CompassCommand;
import com.jhalff.questCrafter.commands.HelpCommand;
import com.jhalff.questCrafter.commands.MenuCommand;
import com.jhalff.questCrafter.listeners.InventoryListener;
import com.jhalff.questCrafter.listeners.JoinListener;
import com.jhalff.questCrafter.listeners.PlayerInteractionListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static com.jhalff.questCrafter.commands.MenuCommand.openMainMenu;
import static com.jhalff.questCrafter.helpers.ConfigHelper.getBoolFromConfig;
import static com.jhalff.questCrafter.helpers.ConfigHelper.setConfig;

public final class Main extends JavaPlugin {

    private BaseCommand<Main> baseCommand = null;

    @Override
    public void onEnable() {
        setConfig(this.getConfig());
        saveDefaultConfig();

        baseCommand = new BaseCommand<>(this) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                openMainMenu((HumanEntity) sender);
                return true;
            }
        };

        HelpCommand helpCommand = new HelpCommand(this);
        MenuCommand menuCommand = new MenuCommand(this);

        baseCommand.registerSubCommand("help", helpCommand);
        baseCommand.registerSubCommand("menu", menuCommand);

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);

        enableQuests();

        Objects.requireNonNull(getCommand("quests")).setExecutor(baseCommand);
    }

    private void enableQuests() {
        if (getBoolFromConfig("compass.enabled")) {
            CompassCommand compassCommand = new CompassCommand(this);

            baseCommand.registerSubCommand("compass", compassCommand);
            getServer().getPluginManager().registerEvents(new PlayerInteractionListener(), this);

            if (getBoolFromConfig("compass.receive-on-first-join")) {
                getServer().getPluginManager().registerEvents(new JoinListener(), this);
            }
        }
    }
}
