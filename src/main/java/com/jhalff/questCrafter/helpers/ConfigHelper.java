package com.jhalff.questCrafter.helpers;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHelper {

    public static FileConfiguration config = null;

    public static void setConfig(FileConfiguration configFile) {
        config = configFile;
    }

    public static String getStringFromConfig(String name) {
        return config.getString(name);
    }

    public static Boolean getBoolFromConfig(String name) {
        return config.getBoolean(name);
    }

    public static Integer getIntFromConfig(String name) {
        return config.getInt(name);
    }
}
