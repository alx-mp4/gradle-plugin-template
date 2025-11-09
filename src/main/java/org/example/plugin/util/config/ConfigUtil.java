package org.example.plugin.util.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

/**
 * Utility class for managing plugin configuration files.
 * <p>
 * Extends {@link Configuration} to provide custom methods for loading, saving, and managing configuration
 * files. It automatically handles the creation of parent directories and copies default configuration files from the
 * plugin's resources if they do not exist.
 *
 * @see <a href="https://github.com/alx-mp4">Aleks' GitHub</a>
 *
 * @author Aleks (@alx-mp4)
 */
public final class ConfigUtil extends Configuration {

    private static final Logger logger = Bukkit.getServer().getLogger();
    private final File configFile;
    private final String pluginName;

    /**
     * Constructs a new instance of {@code ConfigUtil}.
     * <p>
     * This constructor initializes the {@link Configuration} object with a file reference for the plugin's configuration
     * file. It also sets the plugin name for logging purposes.
     *
     * @param plugin   the plugin instance using this configuration utility
     * @param fileName the name of the configuration file to manage (e.g., "config.yml", "settings.yml")
     */
    public ConfigUtil(JavaPlugin plugin, String fileName) {
        super(new File(plugin.getDataFolder(), fileName));
        this.configFile = new File(plugin.getDataFolder(), fileName);
        this.pluginName = plugin.getDescription().getName();
    }

    /**
     * Loads the configuration file.
     * <ul>
     * <li>Creates parent directories if they do not exist.</li>
     * <li>Copies the default configuration file from the plugin's resources if the configuration file does not exist.</li>
     * <li>Attempts to load the configuration by calling the superclass' {@code load()} method.</li>
     * <li>Logs errors if the configuration file cannot be loaded.</li>
     * </ul>
     * <p>
     * This method ensures the configuration file is properly loaded and accessible.
     */
    @Override
    public void load() {
        createParentDirectories();

        if (!configFile.exists()) {
            copyDefaultConfig();
        }

        try {
            super.load();
        } catch (Exception e) {
            logger.severe(String.format("[%s] Failed to load configuration '%s': %s",
                    pluginName, configFile.getName(), e.getMessage()));
        }
    }

    /**
     * Creates the parent directories for the configuration file if they do not exist.
     * <p>
     * Logs an error if the directories cannot be created due to an {@link IOException}.
     * This method ensures the folder structure for the configuration file is created properly.
     */
    private void createParentDirectories() {
        try {
            Files.createDirectories(configFile.getParentFile().toPath());
        } catch (IOException e) {
            logger.severe(String.format("[%s] Failed to create default configuration directory: %s",
                    pluginName, e.getMessage()));
        }
    }

    /**
     * Copies the default configuration file from the plugin's resources to the target location.
     * <p>
     * This method looks for a file in the plugin's resources with the same name as the configuration file being managed.
     * If found, it copies this file to the plugin's data folder. Logs an error if the default configuration file cannot be found
     * or copied due to an {@link IOException}.
     */
    private void copyDefaultConfig() {
        String resourcePath = "/" + configFile.getName();

        try (InputStream input = getClass().getResourceAsStream(resourcePath)) {
            if (input == null) {
                logger.severe(String.format("[%s] Default configuration '%s' wasn't found.",
                        pluginName, configFile.getName()));
                return;
            }

            Files.copy(input, configFile.toPath());
        } catch (IOException e) {
            logger.severe(String.format("[%s] Failed to create default configuration '%s': %s",
                    pluginName, configFile.getName(), e.getMessage()));
        }
    }

    /**
     * Loads the configuration file and logs the result.
     * <p>
     * Calls {@link #load()} to load the configuration file and logs a message indicating whether the configuration
     * was loaded successfully.
     */
    public void loadAndLog() {
        try {
            this.load();
            logger.info(String.format("[%s] Configuration '%s' loaded successfully.",
                    pluginName, configFile.getName()));
        } catch (Exception e) {
            logger.severe(String.format("[%s] Failed to load configuration '%s': %s",
                    pluginName, configFile.getName(), e.getMessage()));
        }
    }

    /**
     * Saves the configuration file and logs the result.
     * <p>
     * Attempts to save the configuration using the superclass' {@code save()} method and logs a message indicating
     * whether the configuration was saved successfully.
     */
    public void saveAndLog() {
        try {
            this.save();
            logger.info(String.format("[%s] Configuration '%s' saved successfully.",
                    pluginName, configFile.getName()));
        } catch (Exception e) {
            logger.severe(String.format("[%s] Failed to save configuration '%s': %s",
                    pluginName, configFile.getName(), e.getMessage()));
        }
    }
}