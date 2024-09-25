package com.jhalff.questCrafter;

import com.jhalff.questCrafter.commands.BaseCommand;
import com.jhalff.questCrafter.commands.CompassCommand;
import com.jhalff.questCrafter.commands.HelpCommand;
import com.jhalff.questCrafter.commands.MenuCommand;
import com.jhalff.questCrafter.listeners.InventoryListener;
import com.jhalff.questCrafter.listeners.JoinListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static com.jhalff.questCrafter.commands.MenuCommand.openMainMenu;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

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
        baseCommand.registerSubCommand("compass", compassCommand);
        baseCommand.registerSubCommand("menu", menuCommand);

        Objects.requireNonNull(getCommand("quests")).setExecutor(baseCommand);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
