package org.example.plugin.util.auth;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.plugin.util.misc.ColorUtil;

import java.util.logging.Logger;

/**
 * Utility class for handling access control for commands.
 * <p>
 * Provides methods to check permissions and enforce command usage restrictions based on the sender's type.
 *
 * @see <a href="https://github.com/alx-mp4">Aleks' GitHub</a>
 *
 * @author Aleks (@alx-mp4)
 */
public final class AccessUtil {

    private static final Logger logger = Bukkit.getServer().getLogger();

    private AccessUtil() {}

    /**
     * Checks if the sender has the specified permission.
     * <p>
     * If the sender is the console, the method returns {@code true} by default.
     * If the sender does not have the required permission and is not an operator, a message is sent to the sender.
     *
     * @param sender              the entity executing the command, can be a player or console
     * @param permission          the permission node to check
     * @param noPermissionMessage the message to send if the sender lacks the required permission
     *
     * @return {@code true} if the sender has the permission or is an operator; {@code false} otherwise
     */
    public static boolean senderHasPermission(CommandSender sender, String permission, String noPermissionMessage) {
        if (!(sender instanceof Player)) {
            return true;
        }

        boolean hasPermission = sender.hasPermission(permission);
        boolean isOp = sender.isOp();
        if (!(hasPermission || isOp)) {
            sender.sendMessage(ColorUtil.translateColorCodes(String.format(
                    "&c%s", noPermissionMessage
            )));
            return false;
        }

        return true;
    }

    /**
     * Checks if the sender has the specified permission.
     * <p>
     * If the sender is the console, the method returns {@code true} by default.
     * This method does not send any messages if the sender lacks permission.
     *
     * @param sender     the entity executing the command, can be a player or console
     * @param permission the permission node to check
     *
     * @return {@code true} if the sender has the permission or is an operator; {@code false} otherwise
     */
    public static boolean senderHasPermission(CommandSender sender, String permission) {
        if (!(sender instanceof Player)) {
            return true;
        }

        boolean hasPermission = sender.hasPermission(permission);
        boolean isOp = sender.isOp();
        return hasPermission || isOp;
    }

    /**
     * Ensures that the command can only be executed in-game by a player.
     * <p>
     * If the sender is the console, a message is logged indicating that the command must be executed in-game.
     * This method is typically used to prevent console execution of player-only commands.
     *
     * @param sender the entity executing the command, typically the player or console
     * @param plugin the plugin instance to display the plugin name
     *
     * @return {@code true} if the sender is not a player, indicating that the command was blocked;
     *         {@code false} if the sender is a player, allowing the command to proceed
     */
    public static boolean denyIfNotPlayer(CommandSender sender, JavaPlugin plugin) {
        if (!(sender instanceof Player)) {
            logger.info(String.format(
                    "[%s] You must be in-game to run this command.",
                    plugin.getDescription().getName()
            ));
            return true;
        }

        return false;
    }

    /**
     * Ensures that the command can only be executed through the console.
     * <p>
     * If the sender is the player, a message is sent to them indicating that the command can't be executed in-game.
     * This method is typically used to prevent player execution of console-only commands.
     *
     * @param sender the entity executing the command, typically the player or console
     * @param plugin the plugin instance to display the plugin name
     *
     * @return {@code true} if the sender is not the console, indicating that the command was blocked;
     *         {@code false} if the sender is the console, allowing the command to proceed
     */
    public static boolean denyIfNotConsole(CommandSender sender, JavaPlugin plugin) {
        if (sender instanceof Player) {
            sender.sendMessage(ColorUtil.translateColorCodes(String.format(
                    "&c[%s] You can't run this command in-game.",
                    plugin.getDescription().getName()
            )));
            return true;
        }

        return false;
    }
}