package org.example.plugin.util.misc;

/**
 * Utility class for translating color codes in text to Minecraft's color code format.
 * <p>
 * Provides a method to scan text for color codes prefixed with an ampersand ({@code &}) and replace them with the
 * appropriate Minecraft color code format using the section sign ({@code §}) symbol.
 *
 * @see <a href="https://github.com/alx-mp4">Aleks' GitHub</a>
 *
 * @author Aleks (@alx-mp4)
 */
public final class ColorUtil {

    private ColorUtil() {}

    /**
     * Translates color codes in the given text to Minecraft's color code format.
     * <p>
     * This method scans the input text for the ampersand character ({@code &}) followed by a valid color code character
     * ({@code 0-9}, {@code a-f}, {@code A-F}) and replaces the ampersand with the section sign ({@code §}).
     * The following character is converted to lowercase to ensure proper formatting for Minecraft color codes.
     * <p>
     * <b>Example:</b> A string like {@code "&aHello"} will be converted to {@code "§aHello"}, where {@code §a} is the
     * color code for light green in Minecraft.
     *
     * @param message the message containing color codes to be translated
     *
     * @return the translated message with Minecraft color codes, or the original message if no color codes are found
     */
    public static String translateColorCodes(String message) {
        char[] translation = message.toCharArray();
        for (int i = 0; i < translation.length - 1; ++i) {
            if (translation[i] == '&' && "0123456789AaBbCcDdEeFf".indexOf(translation[i + 1]) > -1) {
                translation[i] = 167;
                translation[i + 1] = Character.toLowerCase(translation[i + 1]);
            }
        }
        return new String(translation);
    }
}