package org.example.plugin.util.misc;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Utility class for playing block break (step sound) particle effects with specific block IDs and data values.
 * <p>
 * This class provides a convenient method for spawning visual block break effects at a given location for a player.
 * It allows specifying both the block ID and its data value, enabling colored or variant particle effects such as
 * different wool colors or wood types.
 * <p>
 * The underlying implementation encodes the block ID and data into a single integer value using the format expected
 * by Minecraft Beta 1.7.3 (used by CraftBukkit build 1060), where the lower 8 bits represent the block ID and the upper
 * 8 bits represent the block data value. This is achieved by combining the values as:
 * <pre>{@code
 * encoded = blockId | (blockData << 8);
 * }</pre>
 * This encoding matches the format expected by the {@link Effect#STEP_SOUND} effect in that version of Minecraft.
 * <p>
 *
 * @see <a href="https://github.com/alx-mp4">Aleks' GitHub</a>
 *
 * @author Aleks (@alx-mp4)
 */
public final class EffectUtil {

    private EffectUtil() {}

    /**
     * Plays a block's break particles using the block ID + data value.
     *
     * @param player   the player to send the effect to
     * @param location the location of the block
     * @param id       the block ID (e.g. 35 for wool)
     * @param data     the block data (e.g. 8 for light gray wool, or 0 if the block doesn't have data value)
     */
    public static void playBlockBreakEffect(Player player, Location location, int id, int data) {
        int encoded = id | (data << 8);
        player.getWorld().playEffect(location, Effect.STEP_SOUND, encoded);
    }
}
