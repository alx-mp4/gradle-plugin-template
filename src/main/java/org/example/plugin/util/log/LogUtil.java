package org.example.plugin.util.log;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * Utility class for logging messages to the server console and managing a log file.
 * <p>
 * Provides methods for logging info, warning, and severe messages through the server's logger into the console,
 * simplifying the process of logging by avoiding the need to directly access the logger.
 * Additionally, it allows to manage log files within the plugin's data folder where custom log messages can be written.
 *
 * @see <a href="https://github.com/AleksandarHaralanov">Aleksandar's GitHub</a>
 *
 * @author Aleksandar Haralanov (@AleksandarHaralanov)
 */
public final class LogUtil {

    private static final Logger logger = Bukkit.getServer().getLogger();
    private static File logFile;
    private static String pluginName;

    /**
     * Constructs a LoggerUtil instance.
     * <p>
     * This constructor initializes the LoggerUtil with the plugin's data folder and a specified log file name.
     * It also retrieves the plugin's name from its description for use in log messages.
     *
     * @param plugin      the plugin instance, used to access its data folder and description
     * @param logFileName the name of the log file to be used for logging messages
     */
    public LogUtil(JavaPlugin plugin, String logFileName) {
        logFile = new File(plugin.getDataFolder(), logFileName);
        pluginName = plugin.getDescription().getName();
    }

    /**
     * Initializes the log file.
     * <p>
     * This method checks if the log file exists in the plugin's data folder. If it does not exist, it attempts to
     * create the file. If the file is successfully created, an informational log message is generated. If the file
     * creation fails, a severe log message is logged.
     */
    public void initializeLogFile() {
        if (!logFile.exists()) {
            try {
                if (logFile.createNewFile()) {
                    logger.info(String.format("[%s] Log '%s' created successfully.",
                            pluginName, logFile.getName()));
                }
            } catch (IOException e) {
                logger.severe(String.format("[%s] Failed to create log '%s': %s",
                        pluginName, logFile.getName(), e.getMessage()));
            }
        }
    }

    /**
     * Writes text to the log file with an optional timestamp and a newline at the end.
     * <p>
     * This method appends the provided text to the log file, optionally prepending the current date and time.
     * If the log file does not exist, ensure it has been initialized using {@link #initializeLogFile()} before calling this method.
     *
     * @param text        the text to write to the log file
     * @param logDateTime if {@code true}, prepends the current date and time to the log entry
     */
    public static void writeToLogFile(String text, boolean logDateTime) {
        String logEntry;
        if (logDateTime) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);
            logEntry = String.format("[%s] %s", timestamp, text);
        } else {
            logEntry = text;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            logger.severe(String.format("[%s] Could not write to log '%s': %s",
                    pluginName, logFile.getName(), e.getMessage()));
        }
    }

    /**
     * Logs an informational message to the server console.
     * <p>
     * Use this method to log general information that can help with understanding server or plugin behavior.
     *
     * @param message the message to log
     */
    public static void logConsoleInfo(String message) {
        logger.info(message);
    }

    /**
     * Logs a warning message to the server console.
     * <p>
     * Use this method to log warnings that indicate potential issues or problems that may not cause immediate failures
     * but should be addressed.
     *
     * @param message the message to log
     */
    public static void logConsoleWarning(String message) {
        logger.warning(message);
    }

    /**
     * Logs a severe message to the server console.
     * <p>
     * Use this method to log critical issues that may prevent the server or plugin from functioning correctly.
     *
     * @param message the message to log
     */
    public static void logConsoleSevere(String message) {
        logger.severe(message);
    }
}
