package org.example.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import static org.example.plugin.util.LoggerUtil.logInfo;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        logInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}