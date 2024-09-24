package com.jhalff.questCrafter;

import com.jhalff.questCrafter.commands.HelpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("quests").setExecutor(new HelpCommand(this));
    }

    @Override
    public void onDisable() {

    }
}
