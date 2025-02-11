package org.example.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.plugin.util.LogUtil;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LogUtil.logConsoleInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        LogUtil.logConsoleInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}