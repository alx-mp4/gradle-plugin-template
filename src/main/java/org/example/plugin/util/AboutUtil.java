package org.example.plugin.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Utility class for displaying plugin information to a command sender.
 * <p>
 * Provides methods to display detailed information about a plugin—including its name, version, description, website,
 * author(s), and contributor(s)—to a player or the server console.
 *
 * @see <a href="https://github.com/AleksandarHaralanov">Aleksandar's GitHub</a>
 *
 * @author Aleksandar Haralanov (@AleksandarHaralanov)
 */
public final class AboutUtil {

    private static final Logger logger = Bukkit.getServer().getLogger();

    private AboutUtil() {}

    /**
     * Displays detailed information about the specified plugin to the given command sender.
     * <p>
     * This method formats and sends plugin details such as the name, version, description, website, author(s), and
     * contributor(s) to the specified {@link CommandSender}.
     *
     * @param sender           the command sender who will receive the plugin information; can be a player or console
     * @param plugin           the plugin instance whose information is to be displayed
     * @param contributorsList the list of contributor names; may be {@code null} or empty
     */
    public static void aboutPlugin(CommandSender sender, JavaPlugin plugin, List<String> contributorsList) {
        String name = plugin.getDescription().getName();
        String version = plugin.getDescription().getVersion();
        String website = plugin.getDescription().getWebsite();
        String description = plugin.getDescription().getDescription();
        String authors = formatAuthors(plugin.getDescription().getAuthors());
        String contributors = formatContributors(contributorsList);

        if (sender instanceof Player) {
            sendPlayerInfo((Player) sender, name, version, description, website, authors, contributors);
        } else {
            sendConsoleInfo(name, version, description, website, authors, contributors);
        }
    }

    /**
     * Formats the list of authors into a single string.
     * <p>
     * If the list contains multiple authors, they are joined by commas.
     *
     * @param authorsList the list of authors to format
     *
     * @return a formatted string of authors, or {@code null} if the list is {@code null} or empty
     */
    private static String formatAuthors(List<String> authorsList) {
        if (authorsList == null || authorsList.isEmpty()) {
            return null;
        }

        return authorsList.size() == 1 ? authorsList.get(0) : authorsList.stream()
                .map(author -> "&e" + author)
                .collect(Collectors.joining("&7, &e"));
    }

    /**
     * Formats the list of contributors into a single string.
     * <p>
     * If the list contains multiple contributors, they are joined by commas.
     *
     * @param contributorsList the list of contributors to format
     *
     * @return a formatted string of contributors, or {@code null} if the list is {@code null} or empty
     */
    private static String formatContributors(List<String> contributorsList) {
        if (contributorsList == null || contributorsList.isEmpty()) {
            return null;
        }

        return contributorsList.size() == 1 ? contributorsList.get(0) : contributorsList.stream()
                .map(contributor -> "&e" + contributor)
                .collect(Collectors.joining("&7, &e"));
    }

    /**
     * Sends the plugin information to a player.
     * <p>
     * This method sends formatted information including the plugin's name, version, description, website, author(s),
     * and contributor(s) to the specified player.
     *
     * @param player       the player to receive the plugin information
     * @param name         the name of the plugin
     * @param version      the version of the plugin
     * @param description  the description of the plugin, or {@code null} if not available
     * @param website      the website of the plugin, or {@code null} if not available
     * @param authors      the formatted string of authors, or {@code null} if not available
     * @param contributors the formatted string of contributors, or {@code null} if not available
     */
    private static void sendPlayerInfo(Player player, String name, String version, String description, String website, String authors, String contributors) {
        player.sendMessage(ColorUtil.translateColorCodes(String.format("&b%s &ev%s", name, version)));
        outputMessage(player, "&bDescription: &7", description);
        outputMessage(player, "&bWebsite: &e", website);
        outputMessage(player, "&bAuthor(s): &e", authors);
        if (contributors != null) {
            outputMessage(player, "&bContributor(s): &e", contributors);
        }
    }

    /**
     * Logs the plugin information to the server console.
     * <p>
     * This method logs formatted information including the plugin's name, version, description, website, author(s),
     * and contributor(s) to the server console.
     *
     * @param name         the name of the plugin
     * @param version      the version of the plugin
     * @param description  the description of the plugin, or {@code null} if not available
     * @param website      the website of the plugin, or {@code null} if not available
     * @param authors      the formatted string of authors, or {@code null} if not available
     * @param contributors the formatted string of contributors, or {@code null} if not available
     */
    private static void sendConsoleInfo(String name, String version, String description, String website, String authors, String contributors) {
        logger.info(String.format("%s v%s", name, version));
        outputMessage("Description: ", description);
        outputMessage("Website: ", website);
        outputMessage("Author(s): ", authors != null ? authors.replace("&b", "").replace("&e", "") : null);
        if (contributors != null) {
            outputMessage("Contributor(s): ", contributors.replace("&b", "").replace("&e", ""));
        }
    }

    /**
     * Sends a message to a player if the message is not {@code null}.
     * <p>
     * The message is prefixed with a specified string before being sent.
     *
     * @param player  the player to receive the message
     * @param prefix  the prefix to add to the message
     * @param message the message to send, or {@code null} if no message should be sent
     */
    private static void outputMessage(Player player, String prefix, String message) {
        if (message != null) {
            player.sendMessage(ColorUtil.translateColorCodes(prefix + message));
        }
    }

    /**
     * Logs a message to the server console with a prefix if the message is not {@code null}.
     *
     * @param prefix  the prefix to add to the message
     * @param message the message to log, or {@code null} if no message should be logged
     */
    private static void outputMessage(String prefix, String message) {
        if (message != null) {
            logger.info(prefix + message);
        }
    }
}
